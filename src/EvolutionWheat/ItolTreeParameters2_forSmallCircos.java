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
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class ItolTreeParameters2_forSmallCircos {
    public ItolTreeParameters2_forSmallCircos(String infileS1, String infileS2, String outfileS){
        this.getItolTreeBrabchColor(infileS1, infileS2, outfileS);
        //this.getItolTreelabelColor(infileS1, infileS2, outfileS);
        //this.getItolTreeRangeColor(infileS1, infileS2, outfileS);
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
    
    
}
