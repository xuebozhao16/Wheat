/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysis.wheat.GBS;

import analysis.pipeline.libgbs.LibGBSGo;
import analysis.pipeline.libgbs.TagCount;
import format.dna.FastaBit;
import format.table.RowTable;
import gnu.trove.list.array.TIntArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import utils.IOUtils;

/**
 *
 * @author feilu
 */
public class WheatGBSGo {
    
    public WheatGBSGo () {
        //this.testPipe();
        this.gbsPipe();
    }
    
    public void gbsPipe () {
        //new DataPreprocess();
        this.productionPipe();
    }
    
    public void productionPipe () {
        String parameterFileS = "/Users/feilu/Documents/analysisL/production/wheatGBS/gbs_parameter.txt";
        //new LibGBSGo(parameterFileS);
        
        new QualityCheck();
    }
    
    public void testPipe () {
        //this.cutsiteEstimate();
        //this.testLibraryUniformity();
        //this.testBarcodeDiff();
        
    }
    
    
    public void testBarcodeDiff () {
        String infileS = "/Users/feilu/Documents/analysisL/pipelineTest/Lib_GBS/source/20180601_GBSLibrarybarcode.txt";
        RowTable<String> t = new RowTable(infileS);
        List<String> barList = t.getColumn(3);
        String[] bars = barList.toArray(new String[barList.size()]);
        Arrays.sort(bars);
        List<Integer> diffList = new ArrayList();
        for (int i = 0; i < bars.length-1; i++) {
            for (int j = i+1; j < bars.length; j++) {
                int l1 = bars[i].length();
                int l2 = bars[j].length();
                int l = 0;
                if (l1 < l2) l = l1;
                else l = l2;
                int cnt = 0;
                for (int k = 0; k < l; k++) {
                    if (bars[i].charAt(k) != bars[j].charAt(k)) cnt++;
                }
                if (cnt == 1) System.out.println(bars[i]+"\t"+bars[j]);
                diffList.add(cnt);
            }
        }
        Collections.sort(diffList);
        System.out.println(diffList.get(0));
    }
    
    public void testLibraryUniformity () {
        String barcodeFileS = "/Users/feilu/Documents/analysisL/pipelineTest/Lib_GBS/source/20180601_GBSLibrarybarcode.txt";
        String r1FileS = "/Users/feilu/Documents/analysisL/pipelineTest/Lib_GBS/source/sample/20180601-51-NEB12_TKD180600155_1.clean.fq";
        String r2FileS = "/Users/feilu/Documents/analysisL/pipelineTest/Lib_GBS/source/sample/20180601-51-NEB12_TKD180600155_2.clean.fq";
        String outFileS = "/Users/feilu/Documents/analysisL/pipelineTest/Lib_GBS/testResult/uniformity.txt";
        
        PEBarcodeParser pbp = new PEBarcodeParser(barcodeFileS);
        String[] taxa = pbp.getTaxa();
        int[] taxaCnt = new int[taxa.length];
        int nullCnt = 0;
        try {
            BufferedReader br1 = IOUtils.getTextReader(r1FileS);
            BufferedReader br2 = IOUtils.getTextReader(r2FileS);
            String temp1 = null;
            String temp2 = null;
            while ((temp1 = br1.readLine()) != null) {
                temp2 = br2.readLine();
                String taxon = pbp.getTaxonFromReads(br1.readLine(), br2.readLine());
                br1.readLine();br1.readLine();
                br2.readLine();br2.readLine();
                if (taxon == null) {
                    nullCnt++;
                }
                else {
                    int index = Arrays.binarySearch(taxa, taxon);
                    taxaCnt[index]++;
                }
            }
            br1.close();
            br2.close();
            BufferedWriter bw = IOUtils.getTextWriter(outFileS);
            bw.write("Taxa\tCount");
            bw.newLine();
            for (int i = 0; i < taxa.length; i++) {
                bw.write(taxa[i]+"\t"+String.valueOf(taxaCnt[i]));
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void cutsiteEstimate () {
        String genomeDirS = "/Users/feilu/Documents/database/wheat/reference/v1.0/byChr/";
        String outputFileS = "/Users/feilu/Documents/analysisL/pipelineTest/Lib_GBS/testResult/cutsiteEstimate.txt";
        String bamH1Cut = "GGATCC";
        String msp1Cut = "CCGG";
        File[] files = new File(genomeDirS).listFiles();
        files = IOUtils.listFilesEndsWith(files, ".gz");
        List<File> fList = Arrays.asList(files);
        int minLength = 200;
        int maxLength = 500;
        ConcurrentHashMap<String, Integer> chromSiteMap = new ConcurrentHashMap();
        ConcurrentHashMap<String, Integer> chromBamH1SiteMap = new ConcurrentHashMap();
        ConcurrentHashMap<String, Integer> chromMsp1SiteMap = new ConcurrentHashMap();
        fList.parallelStream().forEach(f -> {
            int cutCnt = 0;
            TIntArrayList bamH1List = new TIntArrayList();
            TIntArrayList msp1List = new TIntArrayList();
            FastaBit fa = new FastaBit(f.getAbsolutePath());
            String s = fa.getSeq(0);
            int index = -1;
            int currentIndex = -1;
            for (int i = 0; i < s.length(); i++) {
                index = s.indexOf(bamH1Cut, i);
                if (index == -1) break;
                currentIndex = index+1;
                bamH1List.add(currentIndex);
                i = currentIndex;
            }
            for (int i = 0; i < s.length(); i++) {
                index = s.indexOf(msp1Cut, i);
                if (index == -1) break;
                currentIndex = index+1;
                msp1List.add(currentIndex);
                i = currentIndex;
            }
            int[] bamH1Array = bamH1List.toArray();
            int[] msp1Array = msp1List.toArray();
            int distance = 0;
            for (int i = 0; i < bamH1Array.length; i++) {
                index = Arrays.binarySearch(msp1Array, bamH1Array[i]);
                index = -index-1;
                if (index > -1 && index < msp1Array.length) {
                    distance = msp1Array[index] - bamH1Array[i];
                    if (distance > minLength && distance < maxLength) {
                        if (i != (bamH1Array.length - 1) && bamH1Array[i+1] > msp1Array[index]) {
                            cutCnt++;
                        }
                    }
                }
                index--;
                if (index > -1 && index < msp1Array.length) {
                    distance = bamH1Array[i] - msp1Array[index];
                    if (distance > minLength && distance < maxLength) {
                        if (i != 0 && bamH1Array[i-1] < msp1Array[index]) {
                            cutCnt++;
                        }
                    }
                }
            }
            chromSiteMap.put(f.getName(), cutCnt);
            chromBamH1SiteMap.put(f.getName(), bamH1Array.length);
            chromMsp1SiteMap.put(f.getName(), msp1Array.length);
        });
        BufferedWriter bw = IOUtils.getTextWriter(outputFileS);
        try {
            bw.write("Chromosome\tcutPairNumber\tBamH1Number\tMsp1Number");
            bw.newLine();
            for (int i = 0; i < files.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(files[i].getName()).append("\t").append(chromSiteMap.get(files[i].getName()));
                sb.append("\t").append(chromBamH1SiteMap.get(files[i].getName()));
                sb.append("\t").append(chromMsp1SiteMap.get(files[i].getName()));
                bw.write(sb.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main (String[] args) {
        new WheatGBSGo ();
    }
    
}
