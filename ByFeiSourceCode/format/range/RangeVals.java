/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package format.range;

import cern.colt.GenericSorting;
import cern.colt.Swapper;
import cern.colt.function.IntComparator;
import com.koloboke.collect.set.hash.HashIntSet;
import com.koloboke.collect.set.hash.HashIntSets;
import gnu.trove.list.array.TIntArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import utils.IOFileFormat;
import utils.IOUtils;
import utils.PStringUtils;

/**
 * Data structure for a list of {@link format.range.RangeVal}
 * @author feilu
 */
public class RangeVals extends RangesAbstract {
    protected List<RangeVal> ranges = null;
    
    /**
     * Constructs a {@link format.range.RangeVals} object from a list of {@link format.range.Range}
     * @param ranges 
     */
    public RangeVals (List<RangeVal> ranges) {
        this.ranges = ranges;
    }
    
    /**
     * Constructs a {@link format.range.RangeVals} object with custom parameters
     * @param infileS
     * @param format
     */
    public RangeVals (String infileS, IOFileFormat format) {
        this.readRangeFile(infileS, format);
    }
    
    /**
     * Constructs a {@link format.range.RangeVals} object with default, txt file or file ending with ".gz", with a header
     * @param infileS 
     */
    public RangeVals (String infileS) {
        if (infileS.endsWith(".gz")) {
            this.readRangeFile(infileS, IOFileFormat.TextGzip);
        }
        else {
            this.readRangeFile(infileS, IOFileFormat.Text);
        }
    }
    
    protected void readRangeFile (String infileS, IOFileFormat format) {
        try {
            BufferedReader br = null;
            if (format == IOFileFormat.Text) {
                br = IOUtils.getTextReader(infileS);
            }
            else if (format == IOFileFormat.TextGzip) {
                br = IOUtils.getTextGzipReader(infileS);
            }
            else {
                throw new UnsupportedOperationException("Unsupported format for input");
            }
            String temp = null;
            List<String> current = null;
            temp = br.readLine();
            ranges = new ArrayList<>();
            while ((temp = br.readLine()) != null) {
                current = PStringUtils.fastSplit(temp);
                RangeVal r = new RangeVal(Short.parseShort(current.get(0)), Integer.parseInt(current.get(1)), Integer.parseInt(current.get(2)), Double.parseDouble(current.get(3)));
                ranges.add(r);
            }
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    /**
     * Write to a {@link format.range.RangeVals} file of specified format
     * @param outfileS
     * @param format 
     */
    public void writeTextFile (String outfileS, IOFileFormat format) {
        try {
            BufferedWriter bw = null;
            if (format == IOFileFormat.Text) {
                bw = IOUtils.getTextWriter(outfileS);
            }
            else if (format == IOFileFormat.TextGzip) {
                bw = IOUtils.getTextGzipWriter(outfileS);
            }
            else {
                throw new UnsupportedOperationException("Unsupported format for input");
            }
            bw.write("Chr\tStart\tEnd\tValue");
            bw.newLine();
            for (int i = 0; i < this.getRangeNumber(); i++) {
                bw.write(this.getRange(i).getInfoString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Table is written to " + outfileS);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    /**
     * Select ranges and write to a {@link format.range.Ranges} file with specified format
     * @param outfileS
     * @param format
     * @param ifOut 
     */
    public void writeTextFile (String outfileS, IOFileFormat format, boolean[] ifOut) {
        try {
            BufferedWriter bw = null;
            if (format == IOFileFormat.Text) {
                bw = IOUtils.getTextWriter(outfileS);
            }
            else if (format == IOFileFormat.TextGzip) {
                bw = IOUtils.getTextGzipWriter(outfileS);
            }
            else {
                throw new UnsupportedOperationException("Unsupported format for input");
            }
            bw.write("Chr\tStart\tEnd\tValue");
            bw.newLine();
            for (int i = 0; i < this.getRangeNumber(); i++) {
                if (!ifOut[i]) continue;
                bw.write(this.getRange(i).getInfoString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Table is written to " + outfileS);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void removeRange (int rangeIndex) {
        ranges.remove(rangeIndex);
        this.chrs = null;
    }

    @Override
    public <T extends Range> boolean insertRange(int rangeIndex, T r) {
        if (r instanceof RangeVal) {
            ranges.add(rangeIndex, (RangeVal) r);
            this.resetStatistics();
            return true;
        }
        return false;
    }

    @Override
    public <T extends Range> boolean setRange(int rangeIndex, T r) {
        if (r instanceof RangeVal) {
            ranges.set(rangeIndex, (RangeVal) r);
            this.resetStatistics();
            return true;
        }
        return false;
    }

    @Override
    public RangeVal getRange(int rangeIndex) {
        return ranges.get(rangeIndex);
    }
    
    @Override
    public int getRangeNumber() {
        return ranges.size();
    }

    @Override
    public RangeVals getRangesByChromosome(int chr) {
        int startIndex = this.getStartIndexOfChromosome(chr);
        if (startIndex == -1) return null;
        int endIndex = this.getEndIndexOfChromosome(chr);
        if (endIndex == -1) return null;
        List<RangeVal> l = new ArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            l.add(this.getRange(i));
        }
        return new RangeVals(l);
    }

    @Override
    public RangeVals getRangesContainsPosition(int chr, int pos) {
        int[] indices = this.getRangesIndicesContainsPosition(chr, pos);
        List<RangeVal> l = new ArrayList();
        for (int i = 0; i < indices.length; i++) {
            l.add(this.getRange(indices[i]));
        }
        return new RangeVals(l);
    }

    @Override
    public <T extends Range> boolean addRange (T r) {
        if (r instanceof RangeVal) {
            ranges.add((RangeVal) r);
            this.resetStatistics();
            return true;
        }
        return false;
    }

    @Override
    public <T extends RangesInterface> boolean addRanges (T rs) {
        if (rs instanceof RangeVals) {
            for (int i = 0; i < rs.getRangeNumber(); i++) {
                ranges.add(rs.getRange(i));
            }
            this.resetStatistics();
            return true;
        }
        return false;
    }

     @Override
    public <T extends RangesInterface> T getMergedRanges(T rs) {
        List<RangeVal> newList = new ArrayList<>(getRangeList());
        for (int i = 0; i < rs.getRangeNumber(); i++) {
            newList.add(rs.getRange(i));
        }
        RangeVals s = new RangeVals(newList);
        return (T) s;
    }
    
    @Override
    public List<RangeVal> getRangeList() {
        return this.ranges;
    }

}