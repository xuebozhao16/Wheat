/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pipeline.cpScore.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class top1_XPCLRandPi {
    public top1_XPCLRandPi(String infielS,String outfielS){
        //this.top1XPCLR(infielS, outfielS);
        this.top1normXPCLR(infielS, outfielS);
        //this.top1Pi(infielS, outfielS);
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
            for (i=0;i< A.size()*0.008;i++) {
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
    
    
}
