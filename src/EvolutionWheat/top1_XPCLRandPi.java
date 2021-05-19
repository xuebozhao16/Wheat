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
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class top1_XPCLRandPi {
    public top1_XPCLRandPi(String infielS,String outfielS){
        //this.top1XPCLR(infielS, outfielS);
        this.top1normXPCLR(infielS, outfielS);
        //this.top1Pi(infielS, outfielS);
        //this.top5_gene(infielS, outfielS);
    }
//    public top1_XPCLRandPi(String infileS1,String infileS2,String outfileS){
//        //this.signal_2M_overlap(infileS1, infileS2, outfileS);
//        
//    }
    public top1_XPCLRandPi(String infileS,String percentage,String outfielS){
        this.topnormXPCLR_forallper(infileS, percentage, outfielS);
    }
    
    //这个方法是对xpclr的结果取0.01
    public void top1XPCLR(String infileS,String outfielS){
        try{
            String temp = null;
            int i;
            String[] temm2 = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfielS);
            List A = new ArrayList();
            List AA = new ArrayList();
            while((temp = br.readLine()) != null){
                String tem[] = temp.split(" ");
                AA.add(temp);
                if(tem[5].equals("inf") | tem[5].equals("-nan")| tem[5].equals("nan") ){    
                }else {
                   A.add(temp);
                }
            }
            for (i=0;i< AA.size()*0.05;i++) {
                String temp2 = (String) AA.get(i);
                temm2 = temp2.split(" ");
                String pos = temm2[3].split("\\.")[0];
                bw.write(temm2[0] + "\t" + pos + "\t" + temm2[5] + "\n");               
            }
            System.out.println(A.size());
            System.out.println(AA.size());
            System.out.println(i);
            System.out.println(temm2[5]);
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是对normalization的xpclr的结果取0.05
     public void top1normXPCLR(String infileS,String outfielS){
        try{
            String temp = null;
            int i;
            int sum = 0;
            String[] temm2 = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfielS);
            List A = new ArrayList();
            List AA = new ArrayList();
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                AA.add(temp);
                if(tem[3].equals("NA") | tem[3].equals("-nan")| tem[3].equals("nan") ){    
                }else {
                   A.add(temp);
                }
            }
            for (i=0;i< A.size()*0.001;i++) {
                String temp2 = (String) AA.get(i);
                temm2 = temp2.split("\t");
                sum = sum + Integer.valueOf(temm2[2]) - Integer.valueOf(temm2[1]);
                //String pos = temm2[3].split("\\.")[0];
                //bw.write(temm2[0] + "\t" + pos + "\t" + temm2[5] + "\n");     
                bw.write(temp2 + "\n");
                //bw.write(temm2[0] + "\t" + temm2[1] + "\t" + temm2[2] + "\n");
            }
            System.out.println(A.size());
            System.out.println(AA.size());
            System.out.println(i);
            System.out.println(temm2[3]);
            System.out.println(sum);
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
     //这个方法是对normalization的xpclr的结果取0.05,0.01,0.005,0.001,在服务器上面使用
     public void topnormXPCLR_forallper(String infileS,String percentage,String outfielS){
        try{
            String temp = null;
            int i;
            int sum = 0;
            String[] temm2 = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfielS);
            List A = new ArrayList();
            List AA = new ArrayList();
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                AA.add(temp);
                if(tem[3].equals("NA") | tem[3].equals("-nan")| tem[3].equals("nan") ){    
                }else {
                   A.add(temp);
                }
            }
            double nn = Double.valueOf(percentage);
            for (i=0;i< A.size()*nn;i++) {
                String temp2 = (String) AA.get(i);
                temm2 = temp2.split("\t");
                sum = sum + Integer.valueOf(temm2[2]) - Integer.valueOf(temm2[1]);
                //String pos = temm2[3].split("\\.")[0];
                //bw.write(temm2[0] + "\t" + pos + "\t" + temm2[5] + "\n");     
                bw.write(temp2 + "\n");
                //bw.write(temm2[0] + "\t" + temm2[1] + "\t" + temm2[2] + "\n");
            }        
            System.out.println(A.size() + "\t" + AA.size() + "\t" + i + "\t" + temm2[3] + "\t" + sum + "\n");
//            System.out.println(AA.size());
//            System.out.println(i);
//            System.out.println(temm2[3]);
//            System.out.println(sum);
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是对Pi的结果取0.01
    public void top1Pi(String infileS,String outfielS){
        try{
            String temp = null;
            int i;
            String[] temm2 = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfielS);
            List A = new ArrayList();
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                if(tem[3].equals("NA") ){    
                }else {
                   A.add(temp);
                }
            }
            for (i=0;i< A.size()*0.05;i++) {
                String temp2 = (String) A.get(i);
                temm2 = temp2.split("\t");
                bw.write(temp2 +  "\n");               
            }
            System.out.println(A.size());
            System.out.println(i);
            System.out.println(temm2[3]);
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是获得top5%的基因
    public void top5_gene(String infileS,String outfielS){
        try{
            String temp = null;
            int i;
            String[] temm2 = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfielS);
            List A = new ArrayList();
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                if(tem[1].equals("NA") ){    
                }else {
                   A.add(temp);
                }
            }
            for (i=0;i< A.size()*0.05;i++) {
                String temp2 = (String) A.get(i);
                temm2 = temp2.split("\t");
                bw.write(temm2[0] +  "\n");               
            }
            System.out.println(A.size());
            System.out.println(i);
            System.out.println(temm2[1]);
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是得到top5%的signal的两组在上下游2M的overlap情况
    public void signal_2M_overlap(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            String temp2 = null;
            //BufferedReader brgene2 =null;
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            List<Integer> pos = new ArrayList<>();
            Set  gene = new HashSet();
            BufferedReader brregion1 = IOUtils.getTextReader(infileS1);
            BufferedReader brregion2 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp2 = brregion1.readLine()) != null){
                String tem2[] = temp2.split("\t");
                pos.add(Integer.valueOf(tem2[0]));
                pos.add(Integer.valueOf(tem2[1]) + 2000000);
                pos.add(Integer.valueOf(tem2[2]) + 2000000);             
            } 
            while((temp = brregion2.readLine()) != null){
                int i;
                String tem[] = temp.split("\t");
                String regionchr = tem[0];
                int regionpos1 = Integer.valueOf(tem[1]) + 2000000;
                int regionpos2 = Integer.valueOf(tem[2]) + 2000000;
                //int aa = pos.size();
                for(i = 0; i < pos.size();i = i+3 ){
                    if(Integer.toString(pos.get(i)).equals(regionchr)){
                        String aa = pos.get(i+1) + "_" + pos.get(i+2);
                        if(pos.get(i+1)<regionpos2 && pos.get(i+1)>regionpos1){
                            gene.add(pos.get(i) + "_" + pos.get(i+1) + "_" + pos.get(i+2));
                        }
                        if(pos.get(i+2)<regionpos2 && pos.get(i+2)>regionpos1){
                            gene.add(pos.get(i) + "_" + pos.get(i+1) + "_" + pos.get(i+2));
                        }
                        if(pos.get(i+2)>regionpos2 && pos.get(i+1) < regionpos1){
                            gene.add(pos.get(i) + "_" + pos.get(i+1) + "_" + pos.get(i+2));
                        }
                    }
                }
                
            }
            System.out.println(pos.size()/3);
            System.out.println(gene.size());
            //sort(gene);
            for (Object str : gene) {
                String remgene = str.toString();
                //bw.write(remgene.split("_")[0] + "\t" + remgene.split("_")[1] + "\n");
                bw.write(str + "\n") ;
                //System.out.println(str);
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }   
        
}
