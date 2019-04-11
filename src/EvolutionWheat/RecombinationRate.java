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
}
