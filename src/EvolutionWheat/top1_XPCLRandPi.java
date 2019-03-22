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
        this.top1XPCLR(infielS, outfielS);
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
            while((temp = br.readLine()) != null){
                String tem[] = temp.split(" ");
                if(tem[5].equals("inf") | tem[5].equals("-nan")| tem[5].equals("nan") ){    
                }else {
                   A.add(temp);
                }
            }
            for (i=0;i< A.size()*0.05;i++) {
                String temp2 = (String) A.get(i);
                temm2 = temp2.split(" ");
                String pos = temm2[3].split("\\.")[0];
                bw.write(temm2[0] + "\t" + pos + "\t" + temm2[5] + "\n");               
            }
            System.out.println(A.size());
            System.out.println(i);
            System.out.println(temm2[5]);
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
