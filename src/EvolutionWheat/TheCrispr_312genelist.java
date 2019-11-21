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
        //this.get312gene_XPCLR(infileS1, infileS2, infileS3, outfileS);
        this.get312gene_XPCLR_2(infileS1, infileS2, infileS3, outfileS);
    }
    public TheCrispr_312genelist(String infileS1,String infileS2,String outfileS){
        //this.get312gene_BestBLASTHitgene(infileS1, infileS2, outfileS);
        //this.get312gene_BestBLASTHitgene_2(infileS1, infileS2, outfileS);
        //this.get312gene_ricemaizegene(infileS1, infileS2, outfileS);
        //this.get312gene_ricemaizegene_2(infileS1, infileS2, outfileS);
        this.get312gene_orthologRiceGENE(infileS1, infileS2, outfileS);
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
    
    
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/allgeneXPCLRscore/xp_A_geneScore.sort.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/allgeneXPCLRscore/xp_AB_15_geneScore.sort.txt";
//        String infileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/top5/overlap/dom_pair_gene.txt";        
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_xpclr_2.txt";
//这个方法是为了得到312个基因的XPCLR的值,和上面的方法不同的是，这里的XPCLR的值的输出不是均值，而是两列的值
    public void get312gene_XPCLR_2(String infileS1,String infileS2,String infileS3,String outfileS){
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
                //Double xp = (hashMap1.get(temp)+ hashMap2.get(temp))/2;
                br312geneSet.add(temp + "\t" + hashMap1.get(temp) + "\t" + hashMap2.get(temp));
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
    
    
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/TheABD.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_xpclr_2.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_BestBLASTHitgene_2.txt";
//这个方法是为了得到312个基因的是否是1：1：1的基因,和上面的方法不同的是，没有1：1：1的使用NA表示，使得输出文件还是有312行，
    public void get312gene_BestBLASTHitgene_2(String infileS1,String infileS2,String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br312gene = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            Set Set1 = new HashSet();
            //Set Set2 = new HashSet();
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
                    br312geneSet.add(temm[0] + "\t" + temm[1] + "\t" + temm[2] + "\t" + hashMap1.get(temm[0]));
                }else{
                    br312geneSet.add(temm[0] + "\t" + temm[1] + "\t" + temm[2] + "\t" + "NA" + "\t" + "NA");
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
    
    
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/Rice_Maize_gene.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_BestBLASTHitgene.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_orthologGene.txt";    
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
    
    
    
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/Rice_Maize_gene.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_BestBLASTHitgene_2.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_orthologGene_2.txt";    
    //这个方法是为了得到312个基因的是否在玉米和水稻有同源基因,和上面的方法不同的是，有的使用YES表示，没有的使用NA表示，使得输出文件还是有312行，
    public void get312gene_ricemaizegene_2(String infileS1,String infileS2,String outfileS){
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
                    br312geneSet.add(temp2 + "\t" + "YES");
                }else{
                    br312geneSet.add(temp2 + "\t" + "NA");
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
    
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/rice.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_orthologGene_2.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/dom312_list.txt";    
    //这个方法是为了得到312个基因在水稻有同源基因,有的输出基因的名字，没有的使用NA表示，使得输出文件还是有312行，
    public void get312gene_orthologRiceGENE(String infileS1,String infileS2,String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br312gene = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String,StringBuilder> HashMAp1 = new HashMap<String,StringBuilder>();
            Set Set1 = new HashSet();
            Set br312geneSet = new HashSet();
            while((temp1 = br1.readLine()) != null){
                StringBuilder ricgeneSB = new StringBuilder();
                String tem[] = temp1.split("\t");
                String wheatgene = tem[0].substring(4, 22);
                String ricgene = tem[1].substring(4, 16);              
                if(!Set1.add(wheatgene)){
                    StringBuilder oldValue = HashMAp1.get(wheatgene);
                    ricgeneSB.append(oldValue).append(ricgene).append(";");
                    HashMAp1.replace(wheatgene, oldValue, ricgeneSB);
                }else{
                    ricgeneSB.append(ricgene).append(";");
                    HashMAp1.put(wheatgene, ricgeneSB);
                }               
                
            }
            while((temp2 = br312gene.readLine()) != null){
                String[] temm = temp2.split("\t");
                if(!Set1.add(temm[0])){
                    br312geneSet.add(temp2 + "\t" + HashMAp1.get(temm[0]));
                }else{
                    br312geneSet.add(temp2 + "\t" + "NA");
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