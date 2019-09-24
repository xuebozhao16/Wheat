/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import xuebo.analysis.annotation.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class TheCrispr_312genelist {
    public TheCrispr_312genelist(String infileS1,String infileS2,String infileS3,String outfileS){
        this.get312gene_XPCLR(infileS1, infileS2, infileS3, outfileS);
    }
    public TheCrispr_312genelist(String infileS1,String infileS2,String outfileS){
        //this.get312gene_BestBLASTHitgene(infileS1, infileS2, outfileS);
        this.get312gene_ricemaizegene(infileS1, infileS2, outfileS);
    }
    
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/allgeneXPCLRscore/xp_A_geneScore.sort.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/allgeneXPCLRscore/xp_AB_15_geneScore.sort.txt";
//        String infileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/top5/overlap/dom_pair_gene.txt";        
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_xpclr.txt";
//这个方法是为了得到312个基因的XPCLR的值
    public void get312gene_XPCLR(String infileS1,String infileS2,String infileS3,String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            String temp = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedReader br312gene = IOUtils.getTextReader(infileS3);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, Double> hashMap1 = new HashMap<String, Double>();
            HashMap<String, Double> hashMap2 = new HashMap<String, Double>();
            Set br312geneSet = new HashSet();
            while((temp1 = br1.readLine()) != null){
                String[]tem  = temp1.split("\t");
                hashMap1.put(tem[0], Double.valueOf(tem[1]));             
            }
            while((temp2 = br2.readLine()) != null){
                String[]tem  = temp2.split("\t");
                hashMap2.put(tem[0], Double.valueOf(tem[1]));             
            }
            while((temp = br312gene.readLine()) != null){
                Double xp = (hashMap1.get(temp)+ hashMap2.get(temp))/2;
                br312geneSet.add(temp + "\t" + xp);
            }
            
            
            for (Object str : br312geneSet) {
                bw.write(str + "\n") ;
                System.out.println(str);
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/TheABD.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_xpclr.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_BestBLASTHitgene.txt";
//这个方法是为了得到312个基因的是否是1：1：1的基因
    public void get312gene_BestBLASTHitgene(String infileS1,String infileS2,String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br312gene = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            Set Set1 = new HashSet();
            Set Set2 = new HashSet();
            Set br312geneSet = new HashSet();
            while((temp1 = br1.readLine()) != null){
                String[]tem  = temp1.split("\t");
                String key = tem[0];
                String value = tem[1] + "\t" + tem[2];
                hashMap1.put(key, value);      
                Set1.add(key);
            }
            while((temp2 = br312gene.readLine()) != null){
                String[] temm = temp2.split("\t");
                if(!Set1.add(temm[0])){
                    br312geneSet.add(temm[0] + "\t" + hashMap1.get(temm[0]) + "\t" + temm[1]);
                }else{
                    Set1.remove(temm[0]);
                }
            }          
            for (Object str : br312geneSet) {
                bw.write(str + "\n") ;
                System.out.println(str);
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //这个方法是为了得到312个基因的是否在玉米和水稻有同源基因
    public void get312gene_ricemaizegene(String infileS1,String infileS2,String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br312gene = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set Set1 = new HashSet();
            Set br312geneSet = new HashSet();
            while((temp1 = br1.readLine()) != null){
                Set1.add(temp1);
            }
            while((temp2 = br312gene.readLine()) != null){
                String[] temm = temp2.split("\t");
                if(!Set1.add(temm[0])){
                    br312geneSet.add(temp2);
                }else{
                    Set1.remove(temm[0]);
                }
            }          
            for (Object str : br312geneSet) {
                bw.write(str + "\n") ;
                System.out.println(str);
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}