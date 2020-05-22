/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.IOUtils;
//import pgl.infra.pgl.infra.dna.genotype;

/**
 *
 * @author xuebozhao
 */
public class fd_individual {
    public fd_individual(String infileS1,String infileS2,String outfileS1,String outfileS2){
        this.compareAandAB_fdfile(infileS1, infileS2, outfileS1, outfileS2);
    }
    
    //这个方法做的是比较A和AB的file的fd的值的大小
    public void compareAandAB_fdfile(String infileS1,String infileS2,String outfileS1,String outfileS2){
        try {
            String temp = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            String chr = null;
            Set POS = new HashSet();
            HashMap<String, Double> hashMapfd = new HashMap<String, Double>();
            HashMap<String, String> hashMapAcc = new HashMap<String, String>();
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            //现在开始读A的fd的文件
            String pos1 = null;
            br1.readLine();
            while((temp = br1.readLine())!= null){
                    String tem[] = temp.split("\t");
                    pos1 = tem[0]+"_"+tem[1]+"_"+tem[2];
                    POS.add(pos1);
                    hashMapfd.put(pos1, Double.valueOf(tem[5]));
                    //String tem6[] = tem[6].split(",");
                    if(!tem[6].contains(",")){
                        String a = "A" + tem[6];
                        hashMapAcc.put(pos1,a);
                    }else{
                        String tem6[] = tem[6].split(",");
                        StringBuilder headlineSB = new StringBuilder();
                        String aa = null;
                        for(int i=0;i< tem6.length;i++){
                            aa = "A" + tem6[i] + ",";
                            headlineSB.append(aa);
                        }
                        String aaa = headlineSB.toString();
                        String aaaa = aaa.substring(0, aaa.length()-1);
                        hashMapAcc.put(pos1, aaaa);
                    }      
            }
            //现在开始读AB的fd的文件
            String bb = br2.readLine();
            bw1.write(bb + "\n");
            bw2.write(bb + "\n");//先把第一行写出
            while((temp2 = br2.readLine())!= null){
                String tem2[] = temp2.split("\t");
                String pos2 = tem2[0]+"_"+tem2[1]+"_"+tem2[2];
                if(POS.add(pos2)){
                    bw1.write(temp2 + "\n");
                    POS.remove(pos2);
                }else{
                    //这个是加不进去，要判断fd的大小
                    double fd = Double.valueOf(tem2[5]);
                    if(fd > hashMapfd.get(pos2)){
                        bw1.write(temp2 + "\n");
                    }
                    else if(fd < hashMapfd.get(pos2)){
                        bw1.write(tem2[0] + "\t" + tem2[1] + "\t" + tem2[2] + "\t" + tem2[3] + "\t" + tem2[4] + "\t" 
                                + hashMapfd.get(pos2) + "\t" + hashMapAcc.get(pos2) + "\n");
                        System.out.print(tem2[0] + "\t" + tem2[1] + "\t" + tem2[2] + "\t" + tem2[3] + "\t" + tem2[4] + "\t" + hashMapfd.get(pos2) + "\t" + hashMapAcc.get(pos2) + "\n");
                        bw2.write(tem2[0] + "\t" + tem2[1] + "\t" + tem2[2] + "\t" + tem2[3] + "\t" + tem2[4] + "\t" 
                                + hashMapfd.get(pos2) + "\t" + hashMapAcc.get(pos2) + "\n");
                    }else{
                        String acc = hashMapAcc.get(pos2) + "," + tem2[6];
                        bw1.write(tem2[0] + "\t" + tem2[1] + "\t" + tem2[2] + "\t" + tem2[3] + "\t" + tem2[4] + "\t" 
                                + hashMapfd.get(pos2) + "\t" + acc + "\n");
                    }
                }               
            }        
            bw1.flush();
            bw2.flush();
            bw1.close();
            bw2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //下面的方法是比较IBD distance
    //getDxy(int taxonIndex1, int taxonIndex2, int startSiteIndex, int endSiteIndex)
//    public void fdfile_getDxy(String infileS1,String infileS2,String outfileS1,String outfileS2){
//        try {
//            
//            GenotypeGrid gt = new GenotypeGrid("file", GenoIOFormat.VCF_GZ);
//            gt.sortByTaxa();
//            String taxa1 = null;
//            String taxa2 = null;
//            int taxa1Index = gt.getTaxonIndex(taxa1);
//            int siteStartIndex = gt.getSiteIndex((short)1, 23432);
//            int siteEndIndex = 0;
//            float dxy = gt.getDxy(taxa1Index, 3, siteStartIndex, siteEndIndex);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
