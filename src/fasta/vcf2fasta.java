/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class vcf2fasta {
    public vcf2fasta(String infileS,String outfileS){
        this.getBtrgenevcf_noBeagle(infileS, outfileS);
    }

public void getBtrgenevcf_noBeagle(String infileS,String outfileS){
        try{
            String temp = null;
            int i;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                String prefix = tem[0].substring(0, 2);
                if(prefix.equals("##")){
                    
                }
                else if(prefix.equals("#C")){
                    //String headline = br.readLine();
                    String headtem[] = temp.split("\t");
                    StringBuilder headlineSB = new StringBuilder();
                    for(int j=9; j<headtem.length;j++){
                        headlineSB.append(headtem[j]).append("\t");
                    }
                    bw.write(headtem[0].substring(1,headtem[0].length()) + "\t" + headtem[1] + "\t" + headtem[2] + "\t" 
                             + headtem[3] + "\t" + headtem[4] + "\t" + headlineSB + "\n");
                }
                else {
                    //String tem[] = temp.split("\t");
                    StringBuilder haplo = new StringBuilder();
                    for(i=9; i<tem.length;i++){
                        String temtem = tem[i].split(":")[0];
                        if(temtem.equals("1/1")){
                            tem[i] = "1";
                        }
                        else{
                            tem[i] = "0";
                        }                       
                        haplo.append(tem[i]).append("\t");
                    }
                    bw.write(tem[0] + "\t" + tem[1] + "\t" + tem[2] + "\t" + tem[3]+ "\t" +  tem[4]+ "\t" + haplo + "\n");
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
public void getvcf2fasta(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            String temp2 = null;
            int i,j,m;
            BufferedReader brfasta = IOUtils.getTextReader(infileS1);
            BufferedReader brsnpAndindel = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            String fastafirst = brfasta.readLine();
            int startcodon = Integer.valueOf(fastafirst.split(":")[1].split("-")[0]);
            StringBuilder fasta = new StringBuilder();
            Set<Integer> pos = new HashSet();
            HashMap<Integer, String> hashMapfasta = new HashMap<Integer, String>();
            while((temp = brfasta.readLine()) != null){
                fasta.append(temp);         
            }
            for(i=0;i<fasta.length();i++){
                int key = startcodon +i ;
                String value = fasta.substring(i, i+1);
                pos.add(key);
                hashMapfasta.put(key, value);
                
            }
            
            String[] firstline2 = brsnpAndindel.readLine().split("\t");
            Set<String> name = new HashSet();
            for(j=5;j<firstline2.length;j++){
                name.add(firstline2[j]);              
            }
            //String str[][] = new String[3][4];
            while((temp2 = brsnpAndindel.readLine()) != null){
                String[] tem = temp2.split("\t");
                for(m=0;m<pos.size();m++){
                    
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