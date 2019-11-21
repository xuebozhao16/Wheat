/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import static EvolutionWheat.ForVcftoolsGroup.getTextReader;
import static EvolutionWheat.ForVcftoolsGroup.getTextWriter;
import static EvolutionWheat.ForVcftoolsGroup.listFilesEndsWith;
import static EvolutionWheat.ForVcftoolsGroup.listRecursiveFiles;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class ForDiversityMean {
    public ForDiversityMean(String infileS1,String infileS2,String outfileS){
        //this.for25FileMean(infileS1, infileS2, outfileS);
        //this.forlineagePiMean(infileS1, infileS2, outfileS);
        //this.forallPiFileMerge(infileS1, infileS2, outfileS);
        this.forlineagePiFileMerge(infileS1, infileS2, outfileS);
    }
    
    
    //这个方法是对文件夹中的25个文件的pi值进行均值，输出到一个总的文件里面,这里面是merge好的数据 
    //barplot
    public void for25FileMean(String infileS1,String infileS2,String outfileS){
         try{    
            String temp = null; 
            String temporder = null;
            BufferedReader xpclrFile = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, Double> hashMapMean = new HashMap<String, Double>();
            bw.write("taxa" + "\t" + "pi" + "\n");
            File f = new File(infileS2);
            File[] fs = listRecursiveFiles(f);
            File[] sub = listFilesEndsWith(fs, "pi");
            for(File fi:sub){
                int i = 0;
                double sum = 0;
                xpclrFile = getTextReader(fi.toString());
                String taxaNamelist[] = fi.toString().split("/");
                String taxaName = taxaNamelist[taxaNamelist.length-1].split("\\.")[0];
                System.out.print("It's " + taxaName + "\n");
                while((temp = xpclrFile.readLine()) != null){
                    String[] tem = temp.split("\t");
                    if(tem[3].equals("NA")){
                        
                    }
                    else{
                        i = i+1;
                        sum = sum + Double.valueOf(tem[3]); 
                    }                                      
                }
                //bw.write(taxaName + "\t" + sum/i + "\n");
                hashMapMean.put(taxaName, sum/i);
            } 
            while((temporder = br.readLine()) != null){
                String[] temorder = temporder.split("\t");
                bw.write(temorder[1] + "\t" + hashMapMean.get(temorder[0]) + "\n");
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //这个方法是对文件夹中的文件的pi值进行求均值，输出到一个总的文件里面,这里面是lineage的数据
    //barplot
    public void forlineagePiMean(String infileS1,String infileS2,String outfileS){
         try{    
            String temp = null; 
            String temporder = null;
            BufferedReader xpclrFile = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, Double> hashMapMean = new HashMap<String, Double>();
            bw.write("taxa" + "\t" + "pi" + "\n");
            File f = new File(infileS2);
            File[] fs = listRecursiveFiles(f);
            File[] sub = listFilesEndsWith(fs, "pi");
            for(File fi:sub){
                int i = 0;
                double sum = 0;
                xpclrFile = getTextReader(fi.toString());
                String taxaNamelist[] = fi.toString().split("/");
                String taxaName = taxaNamelist[taxaNamelist.length-1].split("\\.")[1].split("_")[1];
                System.out.print("It's " + taxaName + "\n");
                while((temp = xpclrFile.readLine()) != null){
                    String[] tem = temp.split("\t");
                    if(tem[3].equals("NA")){
                        
                    }
                    else{
                        i = i+1;
                        sum = sum + Double.valueOf(tem[3]); 
                    }                                      
                }
                //bw.write(taxaName + "\t" + sum/i + "\n");
                hashMapMean.put(taxaName, sum/i);
            } 
            while((temporder = br.readLine()) != null){
                String[] temorder = temporder.split("\t");
                bw.write(temorder[1] + "\t" + hashMapMean.get(temorder[0]) + "\n");
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是对文件夹中的文件的pi值合并，最后一列加上这个文件的名字，输出到一个总的文件里面,这里面是总的的数据
    //boxplot
    public void forallPiFileMerge(String infileS1,String infileS2,String outfileS){
         try{    
            String temp = null; 
            String temporder = null;
            BufferedReader xpclrFile = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //HashMap<String, String> hashMaporder = new HashMap<String, String>();
            HashMap<String, String> hashMapMerge = new HashMap<String, String>();
            bw.write("chr" + "\t" + "start" + "\t" + "end" + "\t" + "pi" + "\t" + "species" + "\n");
            File f = new File(infileS2);
            File[] fs = listRecursiveFiles(f);
            File[] sub = listFilesEndsWith(fs, "pi");
            for(File fi:sub){
                xpclrFile = getTextReader(fi.toString());
                String taxaNamelist[] = fi.toString().split("/");
                String taxaName = taxaNamelist[taxaNamelist.length-1].split("\\.")[0];
                System.out.print("It's " + taxaName + "\n");
                while((temp = xpclrFile.readLine()) != null){
                    String[] tem = temp.split("\t");
                    if(tem[3].equals("NA")){
                        
                    }
                    else{
                        hashMapMerge.put(temp, taxaName);
                        //System.out.println(temp);
                    }                                      
                }
            }       
            while((temporder = br.readLine()) != null){
                String[] temorder = temporder.split("\t");
                Iterator iter = hashMapMerge.entrySet().iterator(); 
                while (iter.hasNext()) {    
                    Map.Entry entry = (Map.Entry) iter.next(); 
                    Object key = entry.getKey(); 
                    Object val = entry.getValue();
                    if(val.equals(temorder[0])){
                        bw.write(key + "\t" + temorder[1] + "\n");
                    }
                }                
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是对文件夹中的文件的pi值合并，最后一列加上这个文件的名字，输出到一个总的文件里面,这里面是lineage的数据
    //boxplot
    public void forlineagePiFileMerge(String infileS1,String infileS2,String outfileS){
         try{    
            String temp = null; 
            String temporder = null;
            BufferedReader xpclrFile = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //HashMap<String, String> hashMaporder = new HashMap<String, String>();
            HashMap<String, String> hashMapMerge = new HashMap<String, String>();
            bw.write("chr" + "\t" + "start" + "\t" + "end" + "\t" + "pi" + "\t" + "species" + "\n");
            File f = new File(infileS2);
            File[] fs = listRecursiveFiles(f);
            File[] sub = listFilesEndsWith(fs, "pi");
            for(File fi:sub){
                xpclrFile = getTextReader(fi.toString());
                String taxaNamelist[] = fi.toString().split("/");
                String taxaName = taxaNamelist[taxaNamelist.length-1].split("\\.")[1].split("_")[1];
                System.out.print("It's " + taxaName + "\n");
                while((temp = xpclrFile.readLine()) != null){
                    String[] tem = temp.split("\t");
                    if(tem[3].equals("NA")){
                        
                    }
                    else{
                        hashMapMerge.put(temp, taxaName);
                        //System.out.println(temp);
                    }                                      
                }
            }       
            while((temporder = br.readLine()) != null){
                String[] temorder = temporder.split("\t");
                Iterator iter = hashMapMerge.entrySet().iterator(); 
                while (iter.hasNext()) {    
                    Map.Entry entry = (Map.Entry) iter.next(); 
                    Object key = entry.getKey(); 
                    Object val = entry.getValue();
                    if(val.equals(temorder[0])){
                        bw.write(key + "\t" + temorder[1] + "\n");
                    }
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
