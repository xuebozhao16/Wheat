/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import utils.IOUtils;
import static utils.IOUtils.getTextReader;
import static utils.IOUtils.getTextWriter;
import static utils.IOUtils.listFilesEndsWith;
import static utils.IOUtils.listRecursiveFiles;

/**
 *
 * @author xuebozhao
 */
public class BWA {
    public BWA(String infileS1,String infileS2,String outfileS){
        this.bwa_file(infileS1, infileS2, outfileS);
    }
    
    //这个方法是生成run bwa所需要的文件
    // GetWheatCDSsequence  new BWA(infileS1,infileS2,outfileS);
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/bwamap/bwa_file1.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/bwamap/test/AT19767A";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/bwamap/test/bwatest.txt";
//        new BWA(infileS1,infileS2,outfileS);
    public void bwa_file(String infileS1,String infileS2,String outfileS){
        try{    
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS1); 
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            while((temp = br.readLine()) != null){
                    String[] tem = temp.split("\t");
                    String key = tem[0] + "A";
                    String value = tem[1] + "__" + tem[2];
                    hashMap1.put(key, value);
                    
            }
            //BufferedReader NGSFile = null;
            File f = new File(infileS2);
            String infileS2name = infileS2.substring(infileS2.length()-8, infileS2.length());
            System.out.println(infileS2name + "\n");
            File[] fs = listRecursiveFiles(f);
            File[] sub = listFilesEndsWith(fs, ".clean.fq.gz");
            for(File fi:sub){  
                String out = fi.toString();
                if (out.endsWith("_1.clean.fq.gz")){
                    System.out.println(out + "\n");
                    bw.write(out + "\t");
                }
                if (out.endsWith("_2.clean.fq.gz")){
                    bw.write(out + "\t" + hashMap1.get(infileS2name).split("__")[0] + "\t" 
                        + hashMap1.get(infileS2name).split("__")[1] + "\n");
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
