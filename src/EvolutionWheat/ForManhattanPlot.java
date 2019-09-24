/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import format.table.RowTable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
// 这是对XPCLR的直接结果进行转换染色体的操作，去掉inf,nan的值，之后进行染色体转换，输入文件1：染色体对应信息 输入文件2：XPCLR结果
public class ForManhattanPlot {
    public ForManhattanPlot(String infileS1,String infileS2,String outfileS){
        //this.FortheRealPosFromXPCLR(infileS1, infileS2, outfileS);
        this.FortheRealPosFromNomXPCLR(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromPi(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromPi2(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromFst(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromTajimaD(infileS1, infileS2, outfileS);
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
}
