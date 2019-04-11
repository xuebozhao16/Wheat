/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import format.table.RowTable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        this.FortheRealPosFromPi(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromFst(infileS1, infileS2, outfileS);
        //this.FortheRealPosFromTajimaD(infileS1, infileS2, outfileS);
    }
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
}
