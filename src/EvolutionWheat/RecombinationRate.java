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
import java.util.Iterator;
import java.util.Map;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class RecombinationRate {
    
    public RecombinationRate(String infileS1,String infieS2,String outfileS){
        this.FortheRecombinationRate_1M(infileS1, infieS2, outfileS);
    }
    public RecombinationRate(String infileS,String outfielS){
        //this.Recom_rete_slidewindow_20M(infileS, outfielS);
        //this.Recom_rete_slidewindow_20M_2(infileS, outfielS);
        //this.Recom_rete_slidewindow_50M(infileS, outfielS);
        this.Recom_rete_slidewindow_50M_2(infileS, outfielS);
    }
    
    //这个方法很是把重组率的chr1A转换成1，2,并且把10M的重组率换算成1M的
    public void FortheRecombinationRate_1M(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            String oldChr = "chr1A";
            int oldpos = 0;
            Double oldvalue = 0.0;
            String oldsnp = null;
            int oldmappos1 = 0;
            int oldmappos2 = 0;
            RowTable<String> genometable = new RowTable<>(infileS1); //这是读Chr1A的转换成1和2的bed文件
            HashMap<String, String> HashMap1 = new HashMap<String, String>();
            //HashMap<String, Integer> HashMap2 = new HashMap<String, Integer>();
            for(int i= 0;i< genometable.getRowNumber();i++){
                System.out.println(genometable.getCell(i, 0));
                String key = genometable.getCell(i, 3) + "_" + genometable.getCell(i, 0);
                String value = genometable.getCell(i, 4)+ "_" + genometable.getCell(i, 5);
                HashMap1.put(key, value);
            }
            BufferedReader br = IOUtils.getTextReader(infileS2);
            
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                if(temp.startsWith("chromosome")) continue;
                String[] tem = temp.split("\t");
                Double value = Double.valueOf(tem[4]);
                int pos = Integer.valueOf(tem[1]);
                //int Chr = Integer.valueOf(tem[0].substring(3,4));
                String Chr = tem[0];
                Iterator iter = HashMap1.entrySet().iterator();               
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next(); 
                    Object key = entry.getKey(); 
                    Object val = entry.getValue(); 
                    int mappos1 = Integer.valueOf(val.toString().split("_")[0]);
                    int mappos2 = Integer.valueOf(val.toString().split("_")[1]);
                    int mappos = Integer.valueOf(key.toString().split("_")[1]);
                    if(Chr.equals(key.toString().split("_")[0])){
                        int n=0;
                        if(pos >= mappos1 && pos <= mappos2){
                            if(!Chr.equals(oldChr)){
                                for(n =(oldpos+1000000);(n+1000000) < oldmappos2;n =n+1000000 ){
                                    bw.write((mappos-1) + "\t" + (n-oldmappos1) + "\t" + (n-oldmappos1+1000000) + "\t" + oldsnp + "\t" + oldvalue/10 + "\n");
                                } 
                                bw.write((mappos-1) + "\t" + (n-oldmappos1) + "\t" + (oldmappos2-oldmappos1) + "\t" + oldsnp + "\t" + oldvalue/10 + "\n");
                                bw.write(mappos + "\t" + pos + "\t" + (pos+1000000) + "\t" + tem[3] + "\t" + value/10 + "\n");
                                break;
                            } 
                            if((pos+1000000)<mappos2 && (pos-1000000)>mappos1){
                                if(mappos %2 == 1){
                                    bw.write(mappos + "\t" + pos + "\t" + (pos+1000000) + "\t" + tem[3] + "\t" + value/10 + "\n");
                                }else{
                                    bw.write(mappos + "\t" + (pos-mappos1) + "\t" + (pos-mappos1+1000000) + "\t" + tem[3] + "\t" + value/10 + "\n");
                                    oldmappos1 = mappos1;
                                    oldmappos2 = mappos2;
                                }
                            }
                            if((pos+1000000)<mappos2 && (pos-1000000)<mappos1){
                                if(pos == 1){
                                    bw.write(mappos + "\t" + pos + "\t" + (pos+1000000) + "\t" + tem[3] + "\t" + value/10 + "\n");
                                }else{
                                    bw.write(mappos + "\t" + "1" + "\t" + (pos-mappos1) + "\t" + tem[3] + "\t" + value/10 + "\n");
                                    bw.write(mappos + "\t" + (pos-mappos1) + "\t" + (pos-mappos1+1000000)+ "\t" + tem[3] + "\t" + value/10 + "\n");
                                } 
                            }
                            if((pos+1000000)>mappos2){
                                if(mappos %2 == 1){
                                    bw.write(mappos + "\t" + pos + "\t" + mappos2 + "\t" + tem[3] + "\t" + value/10 + "\n");
                                }else{
                                    bw.write(mappos + "\t" + (pos-mappos1) + "\t" + (mappos2-mappos1) + "\t" + tem[3] + "\t" + value/10 + "\n");
                                }                               
                            }
                        }    
                    }            
                } 
                oldChr = tem[0];
                oldpos = Integer.valueOf(tem[1]);
                oldvalue = Double.valueOf(tem[4]);
                oldsnp = tem[3]; 
            }
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是把上面方法中1M的重组率取20M的slide window
    // 1-20Mb的均值给第1Mb 2-21的均值给第2Mb 到最后的时候  倒数第20 是最后20M的均值  倒数第19给最后19的均值
    public void Recom_rete_slidewindow_20M(String infileS,String outfileS){
        try{
            int i ;
            double sum = 0;
            RowTable<String> recomtable = new RowTable<>(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            for(i=0;i<recomtable.getRowNumber()-21;i++){
                String chr = recomtable.getCell(i, 0);
                String nextchr = recomtable.getCell(i+21, 0);
                String pos1 = recomtable.getCell(i, 1);
                String pos2 = recomtable.getCell(i, 2);
                if(chr.equals(nextchr)){
                    for(int j=0;j<20;j++){
                        sum = sum + Double.valueOf(recomtable.getCell(i+j,4));
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/20) + "\n");
                    //System.out.println(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/20) + "\n");
                    sum = 0;
                }else{
                    int n =0;
                    while(chr.equals(recomtable.getCell(i+n, 0))){
                        //System.out.println(recomtable.getCell(i+n, 0));
                        sum = sum + Double.valueOf(recomtable.getCell(i+n,4));
                        //System.out.println(Double.valueOf(recomtable.getCell(i+n,4)) + "\n");
                        n = n + 1;
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/n) + "\n");
                    sum = 0;
                }       
            } 
            for(int m=recomtable.getRowNumber()-21;m<recomtable.getRowNumber();m++){
                int p = 0;
                while((m+p) != recomtable.getRowNumber()){
                    sum = sum + Double.valueOf(recomtable.getCell(m+p,4));
                    p = p + 1;
                }
                System.out.println(sum + "\n");
                bw.write(recomtable.getCell(m, 0) + "\t" + recomtable.getCell(m, 1) + "\t" + recomtable.getCell(m, 2) + "\t" 
                            + recomtable.getCell(m, 3) + "\t" + (sum/(recomtable.getRowNumber()-m)) + "\n");
                sum = 0;
            }
            bw.flush();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是把上面方法中1M的重组率取20M的slide window
    // 1-10Mb的均值给第1Mb 2-11的均值给第2Mb 1-20的均值给10M，到最后的时候  倒数第10 是最后10M的均值  倒数第9给最后9的均值
    public void Recom_rete_slidewindow_20M_2(String infileS,String outfileS){
        try{
            int i ;
            double sum = 0;
            RowTable<String> recomtable = new RowTable<>(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            for(int ii=0;ii<10;ii++){
                for(int j=0;j<10;j++){
                        sum = sum + Double.valueOf(recomtable.getCell(ii+j,4));
                    }
                    bw.write(recomtable.getCell(ii, 0) + "\t" + recomtable.getCell(ii, 1) + "\t" + recomtable.getCell(ii, 2) + 
                            "\t" + recomtable.getCell(ii, 3) + "\t" + (sum/10) + "\n");
                    sum = 0;
            }
            for(i=10;i<recomtable.getRowNumber()-11;i++){
                String chr = recomtable.getCell(i, 0);
                String lastchr = recomtable.getCell(i-10, 0);
                String nextchr = recomtable.getCell(i+11, 0);
                String pos1 = recomtable.getCell(i, 1);
                String pos2 = recomtable.getCell(i, 2);
                if(chr.equals(lastchr) && chr.equals(nextchr)){
                    for(int j=-10;j<10;j++){
                        sum = sum + Double.valueOf(recomtable.getCell(i+j,4));
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/20) + "\n");
                    sum = 0;
                }else if(chr.equals(lastchr) && !chr.equals(nextchr)){                  
                    int n = -10;
                    while(chr.equals(recomtable.getCell(i+n, 0))){
                        sum = sum + Double.valueOf(recomtable.getCell(i+n,4));
                        n = n + 1;
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/(n+10)) + "\n");
                    sum = 0;
                }else if(!chr.equals(lastchr) && chr.equals(nextchr)){
                    int nn = -10;
                    int q ;
                    while(!chr.equals(recomtable.getCell(i+nn, 0))){
                        nn = nn + 1;
                    }
                    for(q=nn;q<((-nn)+10);q++){
                        sum = sum + Double.valueOf(recomtable.getCell(i+q,4));
                    }
                    //System.out.println(sum + "\n");
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/q) + "\n");   
                    sum = 0;
                }
                else if(!chr.equals(lastchr) && !chr.equals(nextchr)){
                    //System.out.println(recomtable.getRow(i)+ "\n");
                    int nnn = 0;
                    while(chr.equals(recomtable.getCell(i+nnn, 0))){
                        sum = sum + Double.valueOf(recomtable.getCell(i+nnn,4));
                        nnn = nnn + 1;
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/nnn) + "\n");
                    sum = 0;
                }       
            } 
            for(int m=recomtable.getRowNumber()-11;m<recomtable.getRowNumber();m++){
                System.out.println(recomtable.getRow(i)+ "\n");
                int p = 0;
                while((m+p) != recomtable.getRowNumber()){
                    sum = sum + Double.valueOf(recomtable.getCell(m+p,4));
                    p = p + 1;
                }
                //System.out.println(sum + "\n");
                bw.write(recomtable.getCell(m, 0) + "\t" + recomtable.getCell(m, 1) + "\t" + recomtable.getCell(m, 2) + "\t" 
                            + recomtable.getCell(m, 3) + "\t" + (sum/(recomtable.getRowNumber()-m)) + "\n");
                sum = 0;
            }
            bw.flush();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是把上面方法中1M的重组率取50M的slide window
    // 1-50Mb的均值给第1Mb 2-51的均值给第2Mb 到最后的时候 倒数第50 是最后50M的均值  倒数第49给最后49的均值
    public void Recom_rete_slidewindow_50M(String infileS,String outfileS){
        try{
            int i ;
            double sum = 0;
            RowTable<String> recomtable = new RowTable<>(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            for(i=0;i<recomtable.getRowNumber()-51;i++){
                String chr = recomtable.getCell(i, 0);
                String nextchr = recomtable.getCell(i+51, 0);
                String pos1 = recomtable.getCell(i, 1);
                String pos2 = recomtable.getCell(i, 2);
                if(chr.equals(nextchr)){
                    for(int j=0;j<50;j++){
                        sum = sum + Double.valueOf(recomtable.getCell(i+j,4));
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/50) + "\n");
                    //System.out.println(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/20) + "\n");
                    sum = 0;
                }else{
                    int n =0;
                    while(chr.equals(recomtable.getCell(i+n, 0))){
                        //System.out.println(recomtable.getCell(i+n, 0));
                        sum = sum + Double.valueOf(recomtable.getCell(i+n,4));
                        //System.out.println(Double.valueOf(recomtable.getCell(i+n,4)) + "\n");
                        n = n + 1;
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/n) + "\n");
                    sum = 0;
                }       
            } 
            for(int m=recomtable.getRowNumber()-51;m<recomtable.getRowNumber();m++){
                int p = 0;
                while((m+p) != recomtable.getRowNumber()){
                    sum = sum + Double.valueOf(recomtable.getCell(m+p,4));
                    p = p + 1;
                }
                System.out.println(sum + "\n");
                bw.write(recomtable.getCell(m, 0) + "\t" + recomtable.getCell(m, 1) + "\t" + recomtable.getCell(m, 2) + "\t" 
                            + recomtable.getCell(m, 3) + "\t" + (sum/(recomtable.getRowNumber()-m)) + "\n");
                sum = 0;
            }
            bw.flush();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是把上面方法中1M的重组率取50M的slide window
    // 1-25Mb的均值给第1Mb 2-26的均值给第2Mb 1-50的均值给10M，到最后的时候  倒数第24 是最后24M的均值  倒数第23给最后23M的均值
    public void Recom_rete_slidewindow_50M_2(String infileS,String outfileS){
        try{
            int i ;
            double sum = 0;
            RowTable<String> recomtable = new RowTable<>(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            for(int ii=0;ii<25;ii++){
                for(int j=0;j<25;j++){
                        sum = sum + Double.valueOf(recomtable.getCell(ii+j,4));
                    }
                    bw.write(recomtable.getCell(ii, 0) + "\t" + recomtable.getCell(ii, 1) + "\t" + recomtable.getCell(ii, 2) + 
                            "\t" + recomtable.getCell(ii, 3) + "\t" + (sum/25) + "\n");
                    sum = 0;
            }
            for(i=25;i<recomtable.getRowNumber()-26;i++){
                String chr = recomtable.getCell(i, 0);
                String lastchr = recomtable.getCell(i-25, 0);
                String nextchr = recomtable.getCell(i+26, 0);
                String pos1 = recomtable.getCell(i, 1);
                String pos2 = recomtable.getCell(i, 2);
                if(chr.equals(lastchr) && chr.equals(nextchr)){
                    for(int j=-25;j<25;j++){
                        sum = sum + Double.valueOf(recomtable.getCell(i+j,4));
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/50) + "\n");
                    sum = 0;
                }else if(chr.equals(lastchr) && !chr.equals(nextchr)){                  
                    int n = -25;
                    while(chr.equals(recomtable.getCell(i+n, 0))){
                        sum = sum + Double.valueOf(recomtable.getCell(i+n,4));
                        n = n + 1;
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/(n+25)) + "\n");
                    sum = 0;
                }else if(!chr.equals(lastchr) && chr.equals(nextchr)){
                    int nn = -25;
                    int q ;
                    while(!chr.equals(recomtable.getCell(i+nn, 0))){
                        nn = nn + 1;
                    }
                    for(q=nn;q<((-nn)+25);q++){
                        sum = sum + Double.valueOf(recomtable.getCell(i+q,4));
                    }
                    //System.out.println(sum + "\n");
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/q) + "\n");   
                    sum = 0;
                }
                else if(!chr.equals(lastchr) && !chr.equals(nextchr)){
                    //System.out.println(recomtable.getRow(i)+ "\n");
                    int nnn = 0;
                    while(chr.equals(recomtable.getCell(i+nnn, 0))){
                        sum = sum + Double.valueOf(recomtable.getCell(i+nnn,4));
                        nnn = nnn + 1;
                    }
                    bw.write(chr + "\t" + pos1 + "\t" + pos2 + "\t" + recomtable.getCell(i, 3) + "\t" + (sum/nnn) + "\n");
                    sum = 0;
                }       
            } 
            for(int m=recomtable.getRowNumber()-26;m<recomtable.getRowNumber();m++){
                System.out.println(recomtable.getRow(i)+ "\n");
                int p = 0;
                while((m+p) != recomtable.getRowNumber()){
                    sum = sum + Double.valueOf(recomtable.getCell(m+p,4));
                    p = p + 1;
                }
                //System.out.println(sum + "\n");
                bw.write(recomtable.getCell(m, 0) + "\t" + recomtable.getCell(m, 1) + "\t" + recomtable.getCell(m, 2) + "\t" 
                            + recomtable.getCell(m, 3) + "\t" + (sum/(recomtable.getRowNumber()-m)) + "\n");
                sum = 0;
            }
            bw.flush();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
