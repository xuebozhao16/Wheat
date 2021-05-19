/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class ItolTreeParameters {
    public ItolTreeParameters(String infileS1, String infileS2, String outfileS){
        this.getItolTreeBrabchColor(infileS1, infileS2, outfileS);
        //this.getItolTreelabelColor(infileS1, infileS2, outfileS);
        //this.getItolTreeRangeColor(infileS1, infileS2, outfileS);
        //this.getItolTreeStripColor(infileS1, infileS2, outfileS);
        //this.getItolTreeBinColor(infileS1, infileS2, outfileS);
    }
    public void getItolTreeBrabchColor(String infileS1, String infileS2, String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            int i = 0;
            BufferedReader groupFileS = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("TREE_COLORS" + "\n");
            bw.write("SEPARATOR TAB" + "\n");
            bw.write("DATA" + "\n");
            HashMap<String,String> HashMap1 = new HashMap<String,String>();
            while((temp1 = br1.readLine()) != null){
                HashMap1.put(temp1.split("\t")[0], temp1.split("\t")[1]);
            }
            File f = new File(infileS2);
            File[] fs = IOUtils.listRecursiveFiles(f);
            File[] sub = IOUtils.listFilesEndsWith(fs, ".txt");
            for(File fi:sub){
                i++;
                groupFileS = IOUtils.getTextReader(fi.getAbsolutePath().toString());
                System.out.println(fi.getAbsolutePath().toString());
                String[] pa = fi.getAbsolutePath().toString().split("/");
                String paname = pa[pa.length-1];
                String groupname = paname.split("\\.")[0];
                while((temp2 = groupFileS.readLine()) != null){
                    System.out.println(temp2);
                    bw.write(temp2 + "\t" + "branch" + "\t" + HashMap1.get(groupname) + "\t" + "normal" + "\t" + "2" + "\n");                
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
    
    public void getItolTreelabelColor(String infileS1, String infileS2, String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            int i = 0;
            BufferedReader groupFileS = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("TREE_COLORS" + "\n");
            bw.write("SEPARATOR TAB" + "\n");
            bw.write("DATA" + "\n");
            HashMap<String,String> HashMap1 = new HashMap<String,String>();
            while((temp1 = br1.readLine()) != null){
                HashMap1.put(temp1.split("\t")[0], temp1.split("\t")[1]);
            }
            File f = new File(infileS2);
            File[] fs = IOUtils.listRecursiveFiles(f);
            File[] sub = IOUtils.listFilesEndsWith(fs, ".txt");
            for(File fi:sub){
                i++;
                groupFileS = IOUtils.getTextReader(fi.getAbsolutePath().toString());
                System.out.println(fi.getAbsolutePath().toString());
                String[] pa = fi.getAbsolutePath().toString().split("/");
                String paname = pa[pa.length-1];
                String groupname = paname.split("\\.")[0];
                while((temp2 = groupFileS.readLine()) != null){
                    System.out.println(temp2);
                    bw.write(temp2 + "\t" + "label" + "\t" + HashMap1.get(groupname) + "\t" + "normal" + "\t" + "2" + "\n");                
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
    
    
    public void getItolTreeRangeColor(String infileS1, String infileS2, String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            int i = 0;
            BufferedReader groupFileS = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("TREE_COLORS" + "\n");
            bw.write("SEPARATOR TAB" + "\n");
            bw.write("DATA" + "\n");
            HashMap<String,String> HashMap1 = new HashMap<String,String>();
            while((temp1 = br1.readLine()) != null){
                HashMap1.put(temp1.split("\t")[0], temp1.split("\t")[1]);
            }
            File f = new File(infileS2);
            File[] fs = IOUtils.listRecursiveFiles(f);
            File[] sub = IOUtils.listFilesEndsWith(fs, ".txt");
            for(File fi:sub){
                i++;
                groupFileS = IOUtils.getTextReader(fi.getAbsolutePath().toString());
                System.out.println(fi.getAbsolutePath().toString());
                String[] pa = fi.getAbsolutePath().toString().split("/");
                String paname = pa[pa.length-1];
                String groupname = paname.split("\\.")[0];
                while((temp2 = groupFileS.readLine()) != null){
                    System.out.println(temp2);
                    bw.write(temp2 + "\t" + "range" + "\t" + HashMap1.get(groupname) +  "\n");                
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
    
    public void getItolTreeStripColor(String infileS1, String infileS2, String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            int i = 0;
            BufferedReader groupFileS = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("DATASET_COLORSTRIP" + "\n");
            bw.write("SEPARATOR SPACE" + "\n");
            bw.write("DATASET_LABEL color_strip2" + "\n");
            bw.write("COLOR #ff0000" + "\n");
            bw.write("STRIP_WIDTH 25" + "\n");
            bw.write("DMARGIN 0" + "\n");
            bw.write("BORDER_WIDTH 1" + "\n");
            bw.write("BORDER_COLOR #000" + "\n");
            bw.write("SHOW_INTERNAL 0" + "\n");
            bw.write("DATA" + "\n");
            HashMap<String,String> HashMap1 = new HashMap<String,String>();
            while((temp1 = br1.readLine()) != null){
                HashMap1.put(temp1.split("\t")[0], temp1.split("\t")[1]);
            }
            File f = new File(infileS2);
            File[] fs = IOUtils.listRecursiveFiles(f);
            File[] sub = IOUtils.listFilesEndsWith(fs, ".txt");
            for(File fi:sub){
                i++;
                groupFileS = IOUtils.getTextReader(fi.getAbsolutePath().toString());
                System.out.println(fi.getAbsolutePath().toString());
                String[] pa = fi.getAbsolutePath().toString().split("/");
                String paname = pa[pa.length-1];
                String groupname = paname.split("\\.")[0];
                while((temp2 = groupFileS.readLine()) != null){
                    System.out.println(temp2);
                    bw.write(temp2 + " "  + HashMap1.get(groupname) + " " + "COL"+ HashMap1.get(groupname)  + "\n");                
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
    
    
    public void getItolTreeBinColor(String infileS1, String infileS2, String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            int i = 0;
            BufferedReader groupFileS = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("DATASET_BINARY" + "\n");
            bw.write("SEPARATOR COMMA" + "\n");
            bw.write("DATASET_LABEL,binary_data" + "\n");
            bw.write("COLOR,#ff0000" + "\n");
            bw.write("FIELD_LABELS,rl0,rl1,rl2,rl3,rl4" + "\n");
            bw.write("FIELD_COLORS,#FF0000FF,#0092FFFF,#49FF00FF,#FFDB00FF,#FF00DBFF" + "\n");
            //bw.write("FIELD_COLORS,#FF0000FF,#0000FF,#98FB98F,#FFB90F,#FF69B4" + "\n");
            bw.write("FIELD_SHAPES,2,3,2,1,5" + "\n");
            bw.write("SHOW_INTERNAL,1" + "\n");
            bw.write("MARGIN,0" + "\n");
            bw.write("HEIGHT_FACTOR,1" + "\n");
            bw.write("SYMBOL_SPACING,10" + "\n");
            bw.write("DATA" + "\n");
            HashMap<String,String> HashMap1 = new HashMap<String,String>();
            while((temp1 = br1.readLine()) != null){
                HashMap1.put(temp1.split("\t")[0], temp1.split("\t")[1]);
            }
            File f = new File(infileS2);
            File[] fs = IOUtils.listRecursiveFiles(f);
            File[] sub = IOUtils.listFilesEndsWith(fs, ".txt");
            for(File fi:sub){
                i++;
                groupFileS = IOUtils.getTextReader(fi.getAbsolutePath().toString());
                System.out.println(fi.getAbsolutePath().toString());
                String[] pa = fi.getAbsolutePath().toString().split("/");
                String paname = pa[pa.length-1];
                String groupname = paname.split("\\.")[0];
                while((temp2 = groupFileS.readLine()) != null){
                    System.out.println(temp2);
                    bw.write(temp2 + ","  + HashMap1.get(groupname) + "\n");                
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
}
