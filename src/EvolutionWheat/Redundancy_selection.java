/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class Redundancy_selection {
    public Redundancy_selection(String infileS,String outfileS){
        //this.Redundancy_selection_regionForXpclr(infileS, outfileS);
        this.Redundancy_selection_geneRemoveDuplicates_xp(infileS, outfileS);
        //this.Redundancy_selection_geneRemoveDuplicates_pi(infileS, outfileS);
        
    }
    public Redundancy_selection(String infileS1,String infileS2,String outfileS){
        //this.emmer_Redundancy_selection(infileS1, infileS2, outfileS);
        //this.emmer_Redundancy_selection_2(infileS1, infileS2, outfileS);
        this.Redundancy_selection_forRegionGene(infileS1, infileS2, outfileS);
    }
    public void emmer_Redundancy_selection(String infileS1,String infileS2,String outfileS){
        try{
            int i = 0;
            String temp = null;  
            String temp2 = null;
            BufferedReader brAB11 = IOUtils.getTextReader(infileS1);
            BufferedReader bremmer = IOUtils.getTextReader(infileS2);
            BufferedWriter bwemmerAB11 = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> AB11 = new HashMap<String, String>();
            HashMap<String, String> Ain_AB11 = new HashMap<String, String>();
            Set brAB11_A = new HashSet();
            Set bremmer_A = new HashSet();
            Set bremmer_B = new HashSet();
            Set Bin_AB11 = new HashSet();
            while((temp = brAB11.readLine())!= null){
                AB11.put(temp.split("\t")[0], temp.split("\t")[1]);
                brAB11_A.add(temp.split("\t")[0]);
            }
            while((temp2 = bremmer.readLine()) != null){
                String sub = temp2.substring(8, 9);
                if(sub.equals("A")){
                    bremmer_A.add(temp2);
                }
                if(sub.equals("B")){
                    bremmer_B.add(temp2);
                }
            }
            for (Object str : bremmer_A) {
                String Agene = str.toString();
                System.out.println(str);
                if(!brAB11_A.add(Agene)){
                   Ain_AB11.put(AB11.get(Agene),Agene);
                   Bin_AB11.add(AB11.get(Agene));
                }
            }
            for (Object str2 : bremmer_B) {
                String Bgene = str2.toString();
                System.out.println(str2);
                if(!Bin_AB11.add(Bgene)){
                   bwemmerAB11.write(Ain_AB11.get(Bgene) + "\t" + Bgene + "\n");
                }
            }
            bwemmerAB11.flush();
            bwemmerAB11.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void emmer_Redundancy_selection_2(String infileS1,String infileS2,String outfileS){
        try{
            int i = 0;
            int sum = 0;
            String temp = null;  
            String temp2 = null;
            BufferedReader brAB11 = IOUtils.getTextReader(infileS1);
            BufferedReader bremmer = IOUtils.getTextReader(infileS2);
            BufferedWriter bwemmerAB11 = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> AB11 = new HashMap<String, String>();
            Set brAB11_A = new HashSet();
            Set bremmer_A = new HashSet();
            Set bremmer_B = new HashSet();
            while((temp = brAB11.readLine())!= null){
                AB11.put(temp.split("\t")[0], temp.split("\t")[1]);
                brAB11_A.add(temp.split("\t")[0]);
            }
            while((temp2 = bremmer.readLine()) != null){
                String sub = temp2.substring(8, 9);
                if(sub.equals("A")){
                    bremmer_A.add(temp2);
                }
                if(sub.equals("B")){
                    bremmer_B.add(temp2);
                }
            }
            for (Object str : bremmer_A) {               
                String Agene = str.toString();
                System.out.println(str);
                String valueB = AB11.get(Agene);
                if(valueB == null){
                    sum = sum + 1;
                }
                else{
                    if(!bremmer_B.add(valueB)){
                        bwemmerAB11.write(Agene + "\t" + valueB + "\n");
                    }
                }
            }
            System.out.println(sum);
            bwemmerAB11.flush();
            bwemmerAB11.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是给所有的基因加上相似度的值，infileS1指的是redundancy的基因，Alieage的redundancy的基因相似度85-100，不是的0-80
    //Blieage的redundancy的基因相似度100-115，不是的115-200;infileS2指的是XPCLR得出的基因和XPCLR的值
    public void Redundancy_selection_similarity(String infileS1,String infileS2,String outfileS){
        try{
            int i = 0;
            int sum = 0;
            String temp = null;  
            String temp2 = null;
            BufferedReader brAB11 = IOUtils.getTextReader(infileS1);
            BufferedReader bremmer = IOUtils.getTextReader(infileS2);
            BufferedWriter bwemmerAB11 = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> AB11 = new HashMap<String, String>();
            Set brAB11_A = new HashSet();
            Set bremmer_A = new HashSet();
            Set bremmer_B = new HashSet();
            while((temp = brAB11.readLine())!= null){
                AB11.put(temp.split("\t")[0], temp.split("\t")[1]);
                brAB11_A.add(temp.split("\t")[0]);
            }
            while((temp2 = bremmer.readLine()) != null){
                String sub = temp2.substring(8, 9);
                if(sub.equals("A")){
                    bremmer_A.add(temp2);
                }
                if(sub.equals("B")){
                    bremmer_B.add(temp2);
                }
            }
            for (Object str : bremmer_A) {               
                String Agene = str.toString();
                System.out.println(str);
                String valueB = AB11.get(Agene);
                if(valueB == null){
                    sum = sum + 1;
                }
                else{
                    if(!bremmer_B.add(valueB)){
                        bwemmerAB11.write(Agene + "\t" + valueB + "\n");
                    }
                }
            }
            System.out.println(sum);
            bwemmerAB11.flush();
            bwemmerAB11.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是对XPCLR的所有点取region
    public void Redundancy_selection_regionForXpclr(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            int bp = 0;
            while((temp = br.readLine()) != null){
                String[]  tem= temp.split(" ");  
                String pos = tem[3].split("\\.")[0];
                String lastpos = Integer.toString((Integer.valueOf(pos) + 10000 - 1));
                bw.write(tem[0] + "\t" + pos + "\t" + lastpos + "\t" + tem[5] + "\n");
            }
            bw.flush();
            bw.close();         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是对XPCLR的所有region取gene
    public void Redundancy_selection_forRegionGene(String infileS1,String infileS2,String outfileS){
            try{
                String temp = null;
                String temp2 = null;
                //BufferedReader brgene2 =null;
                HashMap<String, String> hashMap1 = new HashMap<String, String>();
                List<Integer> pos = new ArrayList<>();
                Set  gene = new HashSet();
                //HashMap<String, String> gene2 = new HashMap<String, String>();
                BufferedReader brgene = IOUtils.getTextReader(infileS1);
                BufferedReader brregion = IOUtils.getTextReader(infileS2);
                BufferedWriter bw = IOUtils.getTextWriter(outfileS);
                while((temp2 = brgene.readLine()) != null){
                    String tem2[] = temp2.split("\t");
                    String key = tem2[2]+"_"+tem2[3];
                    String value = tem2[1];
                    //String value = tem2[0]+"_"+tem2[1];
                    hashMap1.put(key, value);
                    pos.add(Integer.valueOf(tem2[0]));
                    pos.add(Integer.valueOf(tem2[2]));
                    pos.add(Integer.valueOf(tem2[3]));             
                } 
                System.out.println("read region");
                while((temp = brregion.readLine()) != null){
                    int i;
                    String tem[] = temp.split("\t");
                    String regionchr = tem[0];
                    BigDecimal b1 = new BigDecimal(tem[1]); 
                    BigDecimal b2 = new BigDecimal(tem[2]); 
                    int regionpos1 = b1.intValue();
                    int regionpos2 = b2.intValue();
                    String xpscore = tem[3];
                    //System.out.println(regionpos1);
                    for(i = 0; i < pos.size();i = i+3 ){
                        if(Integer.toString(pos.get(i)).equals(regionchr)){
                            String aa = pos.get(i+1) + "_" + pos.get(i+2);
                            if(pos.get(i+1)<=regionpos2 && pos.get(i+1)>=regionpos1){
                                gene.add(hashMap1.get(aa) + "_" + xpscore);
                            }
                            if(pos.get(i+2)<=regionpos2 && pos.get(i+2)>=regionpos1){
                                gene.add(hashMap1.get(aa) + "_" + xpscore);
                            }
                            if(pos.get(i+2)>regionpos2 && pos.get(i+1) < regionpos1){
                                gene.add(hashMap1.get(aa) + "_" + xpscore);
                            }
                        }
                    }
                }
                //sort(gene);
                for (Object str : gene) {
                    String remgene = str.toString();
                    bw.write(remgene.split("_")[0] + "\t" + remgene.split("_")[1] + "\n");
                    //bw.write(str + "\n") ;
                    //System.out.println(str);
                }
                bw.flush();
                bw.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    
    //这个方法是对XPCLR的所有点取gene之后去重复，若有两个或以上相同的基因都有XPCLR的值，取最大的那一个
    public void Redundancy_selection_geneRemoveDuplicates_xp(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set  gene = new HashSet();
            HashMap<String, String> gene2 = new HashMap<String, String>();
            while((temp = br.readLine()) != null){
                String[]  tem= temp.split("\t");  
                if(tem[1].equals("NA") | tem[1].equals("-nan")){
                        
                }else{
                    if(!gene.add(tem[0])){
                        if(Double.valueOf(tem[1]) > Double.valueOf(gene2.get(tem[0]))){
                            gene2.replace(tem[0], tem[1]);                           
                        }
                    }else{
                        gene2.put(tem[0], tem[1]);
                    }
                }              
            } 
            Iterator iter = gene2.entrySet().iterator(); 
                while (iter.hasNext()) { 
                    Map.Entry entry = (Map.Entry) iter.next(); 
                    Object key = entry.getKey(); 
                    Object val = entry.getValue(); 
                    bw.write(key + "\t" + val + "\n");
                }            
            bw.flush();
            bw.close();         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是对pi的所有点取gene之后去重复，若有两个或以上相同的基因都有pi的值，取最大的那一个
    public void Redundancy_selection_geneRemoveDuplicates_pi(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set  gene = new HashSet();
            HashMap<String, String> gene2 = new HashMap<String, String>();
            while((temp = br.readLine()) != null){
                String[]  tem= temp.split("\t");  
                if(tem[1].equals("NA") | tem[1].equals("-nan")){
                        
                }else{
                    if(!gene.add(tem[0])){
                        if(Double.valueOf(tem[1]) > Double.valueOf(gene2.get(tem[0]))){
                            gene2.replace(tem[0], tem[1]);                           
                        }
                    }else{
                        gene2.put(tem[0], tem[1]);
                    }
                }              
            } 
            Iterator iter = gene2.entrySet().iterator(); 
                while (iter.hasNext()) { 
                    Map.Entry entry = (Map.Entry) iter.next(); 
                    Object key = entry.getKey(); 
                    Object val = entry.getValue(); 
                    bw.write(key + "\t" + val + "\n");
                }            
            bw.flush();
            bw.close();         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
