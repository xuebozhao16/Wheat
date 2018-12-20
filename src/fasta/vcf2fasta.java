/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import format.table.RowTable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class vcf2fasta {
    public vcf2fasta(String infileS,String outfileS){
        this.getBtrgenevcf_noBeagle(infileS, outfileS);
        //this.getBtrgenevcf_Beagle(infileS, outfileS);
        //this.fastatoencodemap(infileS, outfileS);
    }
    public vcf2fasta(String infileS1,String infileS2,String outfileS){
        this.getvcf2fasta(infileS1, infileS2, outfileS);
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

    public void getBtrgenevcf_Beagle(String infileS,String outfileS){
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
                        if(temtem.equals("1|1")){
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
            //BufferedReader brsnpAndindel = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            String fastafirst = brfasta.readLine();
            int startcodon = Integer.valueOf(fastafirst.split(":")[1].split("-")[0]);
            StringBuilder fasta = new StringBuilder();
            Set<Integer> pos = new HashSet();
            HashMap<Integer, String> hashMapfasta = new HashMap<Integer, String>();
            while((temp = brfasta.readLine()) != null){
                fasta.append(temp);         
            }
            //List<String> fastalist = new ArrayList<>();
            for(i=0;i<fasta.length();i++){
                int key = startcodon +i ;
                String value = fasta.substring(i, i+1);
                pos.add(key);
                hashMapfasta.put(key, value);
            }
            
            //String[] firstline2 = brsnpAndindel.readLine().split("\t");
            Set<String> namepos = new HashSet();
//            for(j=5;j<firstline2.length;j++){
//                name.add(firstline2[j]);              
//            }
            RowTable<String> t = new RowTable<>(infileS2);
            //String str[][] = new String[3][4];
            //int aa = t.getColumnNumber();
            //System.out.println(aa);
            List<String> aa = t.getColumn(1);
            for(int bb = 0;bb<aa.size();bb++){
                System.out.println(aa.get(bb));
                namepos.add(aa.get(bb));
            }          
            for(m=5; m<t.getColumnNumber();m++){
                bw.write("\n");
                List<String> l = t.getColumn(m);
                int qq = 0;
                System.out.println(l);
                bw.write(">" + t.getColumnName(m) + "\n");
                for(int p = startcodon;p < fasta.length() + startcodon;p++){
                    if(namepos.add(String.valueOf(p))){
                        namepos.remove(String.valueOf(p));
                        bw.write(hashMapfasta.get(p));
                    }
                    else{
                        //int qq = 0;
                        String aaa = t.getCellAsString(qq, m);                        
                        if(aaa.equals("0")){
                            System.out.println(t.getCellAsString(qq, 3));
                            bw.write(t.getCellAsString(qq, 3));
                        }
                        else{
                            System.out.println(t.getCellAsString(qq, 4));
                            bw.write(t.getCellAsString(qq, 4));
                        }
                        qq++;
                    }
                }              
            }
            bw.flush();
            bw.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

public void fastatoencodemap(String infileS,String outfileS){
    try{
        String temp = null;
            int i;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write(br.readLine() + "\n");
            String barelytemp = br.readLine();
            bw.write(barelytemp);
            HashMap<Integer, String> hashMapB = new HashMap<Integer, String>();
            for(i=0;i<barelytemp.length();i++){
                String value = barelytemp.substring(i, i+1);
                hashMapB.put(i, value);
            }
            while((temp = br.readLine()) != null){
                if(temp.startsWith(">")){
                    bw.write("\n" + temp + "\n");
                }
                else{
                    for(int j=0;j<temp.length();j++){
                        String fa = temp.substring(j, j+1);
                        String favalue = hashMapB.get(j);
                        if(fa.equals(favalue)){
                            bw.write(".");
                        }
                        else{
                            bw.write(fa);
                        }
                    }
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