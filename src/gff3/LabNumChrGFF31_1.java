/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gff3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class LabNumChrGFF31_1 {
    public LabNumChrGFF31_1(String infileS,String outfileS){
        this.ReplaceGFF3ToNum1_1(infileS,outfileS);
    }
    public LabNumChrGFF31_1(String infileS){
        this.SumAandBandDgene(infileS);
    }
    public void ReplaceGFF3ToNum1_1(String infileS,String outfileS){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            //String tem = null;  
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                ++i;
                if(i % 10000 == 0){
                    System.out.println("It's time to" + i);
                }
                String[] tem = temp.split("\t");
                if(temp.startsWith("chrUn")){
                    temp = temp.replaceAll("chrUn", "0");
                    bw.write(temp + "\n");
                    //System.out.println(temp.split("\t")[2]);
                }
                else if(temp.startsWith("chr1A"))  {
                    if(Integer.valueOf(tem[4]) < 471304005){
                        temp = temp.replaceAll("chr1A", "1");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 471304005;
                        int bb = Integer.valueOf(tem[4]) - 471304005;
                        temp = "2" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr1B"))  {
                    if(Integer.valueOf(tem[4]) < 438720154){
                        temp = temp.replaceAll("chr1B", "3");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 438720154;
                        int bb = Integer.valueOf(tem[4]) - 438720154;
                        temp = "4" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr1D"))  {
                    if(Integer.valueOf(tem[4]) < 452179604){
                        temp = temp.replaceAll("chr1D", "5");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 452179604;
                        int bb = Integer.valueOf(tem[4]) - 452179604;
                        temp = "6" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr2A"))  {
                    if(Integer.valueOf(tem[4]) < 462376173){
                        temp = temp.replaceAll("chr2A", "7");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 462376173;
                        int bb = Integer.valueOf(tem[4]) - 462376173;
                        temp = "8" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr2B"))  {
                    if(Integer.valueOf(tem[4]) < 453218924){
                        temp = temp.replaceAll("chr2B", "9");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 453218924;
                        int bb = Integer.valueOf(tem[4]) - 453218924;
                        temp = "10" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr2D"))  {
                    if(Integer.valueOf(tem[4]) < 462216879){
                        temp = temp.replaceAll("chr2D", "11");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 462216879;
                        int bb = Integer.valueOf(tem[4]) - 462216879;
                        temp = "12" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr3A"))  {
                    if(Integer.valueOf(tem[4]) < 454103970){
                        temp = temp.replaceAll("chr3A", "13");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 454103970;
                        int bb = Integer.valueOf(tem[4]) - 454103970;
                        temp = "14" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr3B"))  {
                    if(Integer.valueOf(tem[4]) < 448155269){
                        temp = temp.replaceAll("chr3B", "15");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 448155269;
                        int bb = Integer.valueOf(tem[4]) - 448155269;
                        temp = "16" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr3D"))  {
                    if(Integer.valueOf(tem[4]) < 476235359){
                        temp = temp.replaceAll("chr3D", "17");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 476235359;
                        int bb = Integer.valueOf(tem[4]) - 476235359;
                        temp = "18" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr4A"))  {
                    if(Integer.valueOf(tem[4]) < 452555092){
                        temp = temp.replaceAll("chr4A", "19");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 452555092;
                        int bb = Integer.valueOf(tem[4]) - 452555092;
                        temp = "20" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr4B"))  {
                    if(Integer.valueOf(tem[4]) < 451014251){
                        temp = temp.replaceAll("chr4B", "21");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 451014251;
                        int bb = Integer.valueOf(tem[4]) - 451014251;
                        temp = "22" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr4D"))  {
                    if(Integer.valueOf(tem[4]) < 451004620){
                        temp = temp.replaceAll("chr4D", "23");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 451004620;
                        int bb = Integer.valueOf(tem[4]) - 451004620;
                        temp = "24" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr5A"))  {
                    if(Integer.valueOf(tem[4]) < 453230519){
                        temp = temp.replaceAll("chr5A", "25");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 453230519;
                        int bb = Integer.valueOf(tem[4]) - 453230519;
                        temp = "26" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr5B"))  {
                    if(Integer.valueOf(tem[4]) < 451372872){
                        temp = temp.replaceAll("chr5B", "27");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 451372872;
                        int bb = Integer.valueOf(tem[4]) - 451372872;
                        temp = "28" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr5D"))  {
                    if(Integer.valueOf(tem[4]) < 451901030){
                        temp = temp.replaceAll("chr5D", "29");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 451901030;
                        int bb = Integer.valueOf(tem[4]) - 451901030;
                        temp = "30" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr6A"))  {
                    if(Integer.valueOf(tem[4]) < 452440856){
                        temp = temp.replaceAll("chr6A", "31");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 452440856;
                        int bb = Integer.valueOf(tem[4]) - 452440856;
                        temp = "32" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr6B"))  {
                    if(Integer.valueOf(tem[4]) < 452077197){
                        temp = temp.replaceAll("chr6B", "33");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 452077197;
                        int bb = Integer.valueOf(tem[4]) - 452077197;
                        temp = "34" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr6D"))  {
                    if(Integer.valueOf(tem[4]) < 450509124){
                        temp = temp.replaceAll("chr6D", "35");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 450509124;
                        int bb = Integer.valueOf(tem[4]) - 450509124;
                        temp = "36" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr7A"))  {
                    if(Integer.valueOf(tem[4]) < 450046986){
                        temp = temp.replaceAll("chr7A", "37");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 450046986;
                        int bb = Integer.valueOf(tem[4]) - 450046986;
                        temp = "38" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr7B"))  {
                    if(Integer.valueOf(tem[4]) < 453822637){
                        temp = temp.replaceAll("chr7B", "39");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 453822637;
                        int bb = Integer.valueOf(tem[4]) - 453822637;
                        temp = "40" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                } 
                else if(temp.startsWith("chr7D"))  {
                    if(Integer.valueOf(tem[4]) < 453812268){
                        temp = temp.replaceAll("chr7D", "41");
                    }else{
                        int aa = Integer.valueOf(tem[3]) - 453812268;
                        int bb = Integer.valueOf(tem[4]) - 453812268;
                        temp = "42" + "\t" + tem[1] + "\t" + tem[2] + "\t" + aa + "\t" + bb + "\t" + tem[5] + "\t" + tem[6] + "\t" + tem[7] + "\t" + tem[8];
                    }
                    bw.write(temp + "\n");
                }  
//                else if(temp.startsWith("chrUn"))  {
//                    
//                } 
                else {
                    //System.out.println(temp);
                    bw.write(temp + "\n");
                    System.out.println(temp);
                } 
                //bw.write(temp + "\n");
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是统计A B D 基因组各含有多少基因
    //A  35345
    //B  35643
    //D  34212
    public void SumAandBandDgene(String infileS){
        try{
            String temp = null;
            int Acount = 0;
            int Bcount = 0;
            int Dcount = 0;
            BufferedReader br = IOUtils.getTextReader(infileS);
            //BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String chr = temp.split("\t")[0];
                if(chr.equals("1")|chr.equals("2")|chr.equals("7")|chr.equals("8")|chr.equals("13")|chr.equals("14")|chr.equals("19")|chr.equals("20")|chr.equals("25")|chr.equals("26")|
                        chr.equals("31")|chr.equals("32")|chr.equals("37")|chr.equals("38")){
                        Acount = Acount+1;
                }
                if(chr.equals("3")|chr.equals("4")|chr.equals("9")|chr.equals("10")|chr.equals("15")|chr.equals("16")|chr.equals("21")|chr.equals("22")|chr.equals("27")|chr.equals("28")|
                        chr.equals("33")|chr.equals("34")|chr.equals("39")|chr.equals("40")){
                        Bcount = Bcount+1;
                }
                if(chr.equals("5")|chr.equals("6")|chr.equals("11")|chr.equals("12")|chr.equals("17")|chr.equals("18")|chr.equals("23")|chr.equals("24")|chr.equals("29")|chr.equals("30")|
                        chr.equals("35")|chr.equals("36")|chr.equals("41")|chr.equals("42")){
                        Dcount = Dcount+1;
                }
            }
            System.out.println(Acount);
            System.out.println(Bcount);
            System.out.println(Dcount);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
