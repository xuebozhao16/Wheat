/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import pgl.infra.utils.IOUtils;
//import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class Countsnp {
    public Countsnp(String infileS1,String infileS2,String outfileS){
        this.count_1MSNP(infileS1, infileS2, outfileS);
    }
    
    //这个方法是为了找到1M之内有多少个SNP，
    public void count_1MSNP(String infileS1,String infileS2,String outfileS){
        try {
            String temp = null;
            String temp2 = null;
            BufferedReader br1;
            BufferedReader br2;
            int i = 0;
            int count = 0;
            String chr = null;
            if (infileS1.endsWith("gz")) {
                br1 = IOUtils.getTextGzipReader(infileS1);
            } else {
                br1 = IOUtils.getTextReader(infileS1);
            }
            if (infileS2.endsWith("gz")) {
                br2 = IOUtils.getTextGzipReader(infileS2);
            } else {
                br2 = IOUtils.getTextReader(infileS2);
            }
            List<Integer> Pos1List = new ArrayList <>();
            List<Integer> Pos2List = new ArrayList <>();
            List<String> geneIDList = new ArrayList <>();
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //现在开始读1M的注释文件，//文件格式是 1	0	1000000
            int pos = 0;
            int pos2 = 0;
            while((temp = br1.readLine())!= null){
                    String tem[] = temp.split("\t");
                    //pos1 = Integer.valueOf(tem[1]);
                    //pos2 = Integer.valueOf(tem[2]);
                    Pos1List.add(Integer.valueOf(tem[1]));
                    Pos2List.add(Integer.valueOf(tem[2]));
            }
            //现在开始读VCF文件
            while((temp2 = br2.readLine())!= null){
                //String tem2[] = temp2.split("\t");
                if(!temp2.startsWith("#")){
                    chr = temp2.split("\t")[0];
                    pos = Integer.valueOf(temp2.split("\t")[1]);
                    //现在开始做判断
                    //if(pos < Pos1List.get(i)) continue;
                    if (pos >= Pos1List.get(i) && pos <= Pos2List.get(i)){
                        count = count + 1;
                    }
                    else if (pos >= Pos1List.get(i+1) && pos <= Pos2List.get(i+1)){
                        bw.write(chr + "\t" + Pos1List.get(i) + "\t" + Pos2List.get(i) + "\t" + count + "\n");
                        count = 1; //因为这个时候已经是下一个基因了
                        i = i + 1;
                    }
                    else if (pos > Pos2List.get(i+1)){
                        bw.write(chr + "\t" + Pos1List.get(i) + "\t" + Pos2List.get(i) + "\t" + "0" + "\n");
                        i = i + 1;
                    }
                }       
            }
            bw.write(chr + "\t" + Pos1List.get(i) + "\t" + Pos2List.get(i) + "\t" + count + "\n");
            for(int j=0;j<Pos1List.size();j++){
                if(pos< Pos1List.get(j)){
                bw.write(chr + "\t" + Pos1List.get(j) + "\t" + Pos2List.get(j) + "\t" + "0" + "\n");
                }
            }          
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //这个方法是为了得到1M里面有多少个gene，这些基因有多少个是有SNP的
    public void count_1Mgene(String infileS1,String infileS2,String outfileS){
        try {
            String temp = null;
            String temp2 = null;
            BufferedReader br1;
            BufferedReader br2;
            int i = 0;
            int count = 0;
            String chr = null;
            if (infileS1.endsWith("gz")) {
                br1 = IOUtils.getTextGzipReader(infileS1);
            } else {
                br1 = IOUtils.getTextReader(infileS1);
            }
            if (infileS2.endsWith("gz")) {
                br2 = IOUtils.getTextGzipReader(infileS2);
            } else {
                br2 = IOUtils.getTextReader(infileS2);
            }
            List<Integer> Pos1List = new ArrayList <>();
            List<Integer> Pos2List = new ArrayList <>();
            List<String> geneIDList = new ArrayList <>();
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //现在开始读1M的注释文件，//文件格式是 1	0	1000000
            int pos1 = 0;
            int pos2 = 0;
            while((temp = br1.readLine())!= null){
                    String tem[] = temp.split("\t");
                    //pos1 = Integer.valueOf(tem[1]);
                    //pos2 = Integer.valueOf(tem[2]);
                    Pos1List.add(Integer.valueOf(tem[1]));
                    Pos2List.add(Integer.valueOf(tem[2]));
            }
            //现在开始读VCF文件
            while((temp2 = br2.readLine())!= null){
                //String tem2[] = temp2.split("\t");
                if(!temp2.startsWith("#")){
                    chr = temp2.split("\t")[0];
                    int pos = Integer.valueOf(temp2.split("\t")[1]);
                    //现在开始做判断
                    //if(pos < Pos1List.get(i)) continue;
                    if (pos >= Pos1List.get(i) && pos <= Pos2List.get(i)){
                        count = count + 1;
                    }
                    else if (pos >= Pos1List.get(i+1) && pos <= Pos2List.get(i+1)){
                        bw.write(chr + "\t" + Pos1List.get(i) + "\t" + Pos2List.get(i) + "\t" + count + "\n");
                        count = 1; //因为这个时候已经是下一个基因了
                        i = i + 1;
                    }
                    else if (pos > Pos2List.get(i+1)){
                        bw.write(chr + "\t" + Pos1List.get(i) + "\t" + Pos2List.get(i) + "\t" + "0" + "\n");
                        i = i + 1;
                    }
                }       
            }
            bw.write(chr + "\t" + Pos1List.get(i) + "\t" + Pos2List.get(i) + "\t" + count + "\n");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
