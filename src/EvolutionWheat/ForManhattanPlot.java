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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author xuebozhao
 */
// 这是对XPCLR的直接结果进行转换染色体的操作，去掉inf,nan的值，之后进行染色体转换，输入文件1：染色体对应信息 输入文件2：XPCLR结果
public class ForManhattanPlot {
    public ForManhattanPlot(String infileS1,String infileS2,String outfileS){
        //this.FortheRealPosFromXPCLR(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromNomXPCLR(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromPi(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromPi2(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromFst(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromTajimaD(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromFd(infileS1, infileS2, outfileS);
        this.FortheRealPosFromFd2(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromFd_smooth(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromTree(infileS1, infileS2, outfileS);
        //this.FortheRealPosSNPdensi(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromVCF(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromIBS(infileS1, infileS2, outfileS);
    }
    //这个是对XPCLR出来的直接结果进行染色体的转换
    public void FortheRealPosFromXPCLR(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String[] tem = temp.split(" ");
                int chr = Integer.valueOf(tem[0]);
                String value = tem[5];
                //System.out.println(chr);
                //System.out.println(genometable.getRow(chr-1));
                String pos = tem[3].split("\\.")[0];
//                if(tem[5].equals("inf") | tem[5].equals("-nan") | tem[5].equals("0.000000") | tem[5].equals("-0.000000")){
                if(tem[5].equals("inf") | tem[5].equals("-nan")){
                    
                }
                else if(tem[5].equals("-0.000000")){
                    value = "0.000000";
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                        bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
                    }
                }
                else {
                    if (Double.valueOf(value) >= 500){
                    System.out.println(temp);
                    }
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                        bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
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
    
    //这个是对GenWIn标准化之后的XPCLR结果进行染色体的转换
    public void FortheRealPosFromNomXPCLR(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(tem[3].equals("NA")){
                    
                }
//                else if(Double.valueOf(tem[3])<0){
//                    
//                }
                else {
                    int chr = Integer.valueOf(tem[0]);
                    String value = tem[3];
                    String pos1 = tem[1];
                    String pos2 = tem[2];
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        bw.write(outchr + "\t" + pos1 + "\t" + pos2 + "\t" + value + "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        double outpos1 = Double.valueOf(genometable.getCell(chr-1, 4)) + Double.valueOf(pos1);
                        double outpos2 = Double.valueOf(genometable.getCell(chr-1, 4)) + Double.valueOf(pos2);
                        bw.write(outchr + "\t" + outpos1 + "\t" + outpos2 + "\t" + value + "\n");
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
    
    
    public void FortheRealPosFromPi(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                int chr = Integer.valueOf(tem[0]);
                String value = tem[3];
                String pos = tem[1];
                if(tem[3].equals("NA") | tem[3].equals("-nan")){
                    
                }
                else {
//                    if (Double.valueOf(value) >= 10000){
//                        System.out.println(value);
//                        value = String.valueOf(Double.valueOf(value)/200);                       
//                    }
//                    if (Double.valueOf(value) >= 5000){
//                        System.out.println(value);
//                        value = String.valueOf(Double.valueOf(value)/50);
//                    }
//                    if (Double.valueOf(value) >= 800){
//                        System.out.println(value);
//                        value = String.valueOf(Double.valueOf(value)/20);
//                    }
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                        bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
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
    
    //为了行数统一，把NA换成0
//    String infileS1 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/readmeByFei_table.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/pi/pi_allchr/urartu.bed.pi";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/pi/pi_allchr/allchrpi_urartu.txt";
//        new ForManhattanPlot(infileS1,infileS2,outfileS);     
    public void FortheRealPosFromPi2(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                int chr = Integer.valueOf(tem[0]);
                String value = tem[3];
                String pos = tem[1];
                if(chr % 2 == 1){
                    String outchr = genometable.getCell(chr-1, 3);
                    if(tem[3].equals("NA") | tem[3].equals("-nan")){
                        bw.write(outchr + "\t" + pos + "\t" + "0" + "\n");
                    }else{
                        bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                    }
                    
                }else{
                    String outchr = genometable.getCell(chr-1, 3);
                    int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                    if(tem[3].equals("NA") | tem[3].equals("-nan")){
                        bw.write(outchr + "\t" + outpos + "\t" + "0" + "\n");
                    }else{
                        bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
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
    
    
    public void FortheRealPosFromFst(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(tem[3].equals("NA")){
                    
                }
                else {
                    int chr = Integer.valueOf(tem[0]);
                    String value = tem[3];
                    String pos = tem[1];
                    if (Double.valueOf(value) < 0){
                      value = "0";
                    }
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                        bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
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
    
    public void FortheRealPosFromTajimaD(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(!tem[0].endsWith("CHROM")){
                    int chr = Integer.valueOf(tem[0]);
                    String value = tem[3];
                    String pos = tem[1];
                    if(tem[3].equals("nan")){
                        
                    }
                    else {
                        if(chr % 2 == 1){
                            String outchr = genometable.getCell(chr-1, 3);
                            //System.out.println(outchr);
                            bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                        }else{
                            String outchr = genometable.getCell(chr-1, 3);
                            //System.out.println(outchr);
                            int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                            bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
                        }
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
    
    //这个方法是把在水稻，大麦，玉米中，小麦里面的同源基因找到之后，使用最原始的GFF3文件（Chr1A），找到基因的位置
    public void FortheDOMgeneSiteinWholeGenome(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            //RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            HashMap<String,String> hashmap1 = new HashMap<String,String>();
            Set br1gene = new HashSet();
            BufferedReader br2 = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br1.readLine()) != null){
                if(!temp.startsWith("#")){
                    String[] tem = temp.split("\t");
                    if(tem[2].equals("gene")){
                        String key = tem[8].split(";")[0].split("=")[1];
                        String value = tem[4] + "_" + tem[5];
                        br1gene.add(key);
                        hashmap1.put(key, value);
                    }
                }              
            }
            while((temp = br2.readLine()) != null){
                  
            }
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void FortheRealPosFromFd(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            br.readLine();
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(tem[6].equals("NA")){
                    
                }
                else if(tem[7].equals("-Inf") || tem[7].equals("nan")|| tem[7].equals("NA")){
                    
                }
//                else if(Double.valueOf(tem[7]) < 0 || Double.valueOf(tem[7]) >1){
//                    
//                }
                else {
                    int chr = Integer.valueOf(tem[0]);
                    //Double value = getDoubleNumber(tem[7]);
                    String value = tem[7];
                    String pos = tem[1];
                    if (Double.valueOf(tem[7]) < 0){
                      value = "0";
                    }
//                    if (value.contains("e")){
//                      value = "0";
//                    }
                    if (Double.valueOf(tem[7]) > 1){
                      value = "0";
                    }
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                        bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
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
    
    //输入文件是.gz
    public void FortheRealPosFromFd2(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextGzipReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            br.readLine();
            while((temp = br.readLine()) != null){
                String[] tem = temp.split(",");
                System.out.println(tem[8]);
                if(tem[8].equals("nan")){
                    
                }
                else if(tem[9].equals("-Inf") || tem[9].equals("nan")|| tem[9].equals("NA")){
                    
                }
                else {
                    if(Double.valueOf(tem[8])>=0){
                        int chr = Integer.valueOf(tem[0]);
                        //Double value = getDoubleNumber(tem[7]);
                        String value = tem[9];
                        String pos = tem[1];
                        if (Double.valueOf(tem[9]) < 0){
                          value = "0";
                        }
    //                    if (value.contains("e")){
    //                      value = "0";
    //                    }
                        if (Double.valueOf(tem[9]) > 1){
                          value = "0";
                        }
                        if(chr % 2 == 1){
                            String outchr = genometable.getCell(chr-1, 3);
                            //System.out.println(outchr);
                            bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                        }else{
                            String outchr = genometable.getCell(chr-1, 3);
                            //System.out.println(outchr);
                            int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                            bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
                        }
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
    
        private double getDoubleNumber(String str){
            double number = 0;
            BigDecimal bd = new BigDecimal(str);  
	    number =  Double.parseDouble(bd.toPlainString());
            return number;
	}

        
        //这个方法是对fd的结果进行smooth,这样的时候画出来的图比较平缓，1M--10M的smooth都有
        public void FortheRealPosFromFd_smooth(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            List<String> poschr = new ArrayList<>();
            List<Integer> pos = new ArrayList<>();
            List<Double> posvalue = new ArrayList<>();
            //现在开始读的是fd的文件
            while((temp = br1.readLine()) != null){
                String[] tem = temp.split("\t");
                poschr.add(tem[0]);
                pos.add(Integer.valueOf(tem[1]));
                posvalue.add(Double.valueOf(tem[2]));
            }
            //现在读的是bed文件
            while((temp = br2.readLine()) != null){
                int i;
                int n = 0;
                //double mean = 0;
                double sum = 0;
                String tem[] = temp.split("\t");
                String regionchr = tem[0];
//                if(regionchr.substring(4, 5).endsWith("D")){
//                    
//                }
                int regionpos1 = Integer.valueOf(tem[1]);
                int regionpos2 = Integer.valueOf(tem[2]);
                //int aa = pos.size();
                for(i = 0; i < poschr.size();i = i+1){
                    if(poschr.get(i).equals(regionchr)){
                        if(pos.get(i)>=regionpos1 && pos.get(i)<regionpos2){
                            sum = sum + posvalue.get(i);
                            n = n+1;
                        }
                    }
                }
                if(n==0){
                    //bw.write(regionchr + "\t" + regionpos1 + "\t" + "0" + "\n");
                }
                else if (sum == 0 && n != 0){
                    bw.write(regionchr + "\t" + regionpos1 + "\t" + "0" + "\n");
                }
                else if ((sum != 0 && n != 0)){
                    bw.write(regionchr + "\t" + regionpos1 + "\t" + sum/n + "\n");
                }
            }
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    

        public void FortheRealPosFromTree(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(tem[3].equals("NA")){
                    
                }
                else {
                    int chr = Integer.valueOf(tem[0]);
                    String value = tem[3];
                    String pos = tem[1];
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                        bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
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
        
        
        
        public void FortheRealPosSNPdensi(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write(br.readLine() + "\n");
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(tem[3].equals("NA")){
                    
                }
                else {
                    int chr = Integer.valueOf(tem[0]);
                    String value1 = tem[2];
                    String value2 = tem[3];
                    String pos = tem[1];
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        bw.write(outchr + "\t" + pos + "\t" + value1 + "\t" + value2 +  "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                        bw.write(outchr + "\t" + outpos + "\t" + value1 + "\t" + value2 +  "\n");
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
        
    //这个方法是为了得到VCF的真正的位置,这是为了转V11，转成可以发表的版本
    public void FortheRealPosFromVCF(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            BufferedReader br;
            String vcfID = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            if (infileS2.endsWith("gz")) {
                br = IOUtils.getTextGzipReader(infileS2);
            } else {
                br = IOUtils.getTextReader(infileS2);
            }
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                if(temp.startsWith("#")){
                    if(temp.startsWith("#C")){
                         bw.write(temp + "\n");
                    }                  
                }else{
                    StringBuilder headlineSB = new StringBuilder();
                    String[] tem = temp.split("\t");
                    int chr = Integer.valueOf(tem[0]);
                    for(int i = 3;i<tem.length;i++){
                        headlineSB.append(tem[i]).append("\t");
                    }
                    //String value = tem[3];
                    String pos = tem[1];
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        vcfID = outchr + "-" + pos;
                        bw.write(outchr + "\t" + pos + "\t" + vcfID + "\t"+ headlineSB + "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                        vcfID = outchr + "-" + String.valueOf(outpos);
                        bw.write(outchr + "\t" + outpos + "\t" + vcfID + "\t"+ headlineSB + "\n");
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

    //这是群体IBS的数据转换染色体
    public void FortheRealPosFromIBS(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            br.readLine();
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(tem[3].equals("NA")){

                }
                else {
                    int chr = Integer.valueOf(tem[0]);
                    String value = tem[3];
                    String pos = tem[1];
                    if (Double.valueOf(value) < 0){
                        value = "0";
                    }
                    if(chr % 2 == 1){
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                    }else{
                        String outchr = genometable.getCell(chr-1, 3);
                        //System.out.println(outchr);
                        int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                        bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
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



