/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
        //this.get312gene_orthologRiceGENE(infileS1, infileS2, outfileS);
        this.getlongitude_latitude(infileS1, infileS2, outfileS);
    }
    
    public TheCrispr_312genelist(String outfileS){
        //this.longitude_latitude(outfileS);
    }

    TheCrispr_312genelist(String infileS, String outfileS) {
        this.FortheSNP2fasta(infileS, outfileS);
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
    
    //这个方法是为了得到相隔5度的地理位置信息的文件
    //经度0°——180°（东行，标注E）0°——180°（西行，标注W）
    //纬度0°——90°N、0°——90°S 这里维度的阈值可以表示为-70~70
//    String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/cooperation_fu/OTUB1/haplogroup/longitude_latitude.txt";    
//        new TheCrispr_312genelist(outfileS);
    public void longitude_latitude(String outfileS){
        try{
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String,StringBuilder> HashMAp1 = new HashMap<String,StringBuilder>();
            //Set Set1 = new HashSet();
            //bw.write(outfileS);
            for(int i=-180;i<=180;i=i+10){
                for(int j=-70;j<=70;j=j+5){
                    bw.write(j + "\t" + i + "\n");
                }
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //这个方法是为了得到四倍体和六倍体的经纬度落在哪一个格子里面
    //
    public void getlongitude_latitude(String infileS1,String infileS2,String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String,StringBuilder> HashMAp1 = new HashMap<String,StringBuilder>();
            Set Set1 = new HashSet();
            List<Double> list1 = new ArrayList<Double> ();  
            List<Double> list2 = new ArrayList<Double> ();  
            while((temp1 = br1.readLine()) != null){
                String tem[] = temp1.split("\t");
                list1.add(Double.valueOf(tem[0]));
                list2.add(Double.valueOf(tem[1]));
            }
            bw.write(br2.readLine());
            bw.newLine();
            while((temp2 = br2.readLine()) != null){
                String tem[] = temp2.split(",");
                if(!tem[0].equals("NA") && !tem[2].equals("NA")){
                    double Lat = Double.valueOf(tem[0]);
                    double Long = Double.valueOf(tem[1]);
                    for(int n=0;n<list1.size();n++){                        
                        if(Lat>=list1.get(n) && Lat<(list1.get(n)+5)){
                            if(Long>=list2.get(n) && Long<(list2.get(n)+10)){
                                bw.write(list1.get(n) + "\t" + list2.get(n) + "\t" + tem[2] + "\t" + tem[3] + "\n");
                            }                           
                        }
                    }
                }
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //现在这个方法是对换成0，1，2的VCF文件进一步处理，
    //输入文件：CHROM	POS	REF	ALT	A009	A010	A011	A012	A013	A016
    //25	449255023	C	A	2	2	NA	NA	NA
    //25	449255055	A	G	2	2	0	0	0
    //输出文件： A009 AG
    //         A010 AG  A011 CA
    public void FortheSNP2fasta(String infileS1,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //br.readLine();
            //System.out.print(genometable.getCell(1, 1)+ "\t");
            for(int i=4;i<genometable.getColumnNumber();i++){
                bw.write("\n");
                System.out.print(genometable.getHeader().get(i));
                bw.write(genometable.getHeader().get(i) + "\t");
                for(int j=1;j<genometable.getRowNumber()+1;j++){
                    if(genometable.getCell(j-1, i).equals("2")){
                        bw.write(genometable.getCell(j-1, 3));
                    }else{
                        bw.write(genometable.getCell(j-1, 2));
                    }
                }
            }
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}