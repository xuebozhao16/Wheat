/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class geneTree {
    public geneTree(String infileS1,String infileS2,String outfileS){
        //this.C20_countgeneSNP(infileS1, infileS2, outfileS);
        this.C21_getgeneSNP(infileS1, infileS2, outfileS);
    }
    
    //现在这个方法是统计每个基因里面有多少个SNP //染色体已经分好,这里不用再去判断染色体 //重叠的gene算，但是包含的基因不算
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulab1_1onlyGene/chr36_GeneLulab1_1.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/test/chr36.allgenic.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/test/chr36_Genecount.txt";
//        new geneTree(infileS1,infileS2,outfileS);
    // 输出文件格式 36	22460	24375	TraesCS6D02G355900	8
    public void C20_countgeneSNP(String infileS1,String infileS2,String outfileS){
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
            //现在开始读gene注释文件，//文件格式是 1	40098	70338	TraesCS1A02G000100
            int pos1 = 0;
            int pos2 = 0;
            while((temp = br1.readLine())!= null){
                String tem[] = temp.split("\t");
                //现在要判断重叠和包含的基因
                if(Integer.valueOf(tem[1])<= pos2 && Integer.valueOf(tem[2])>=pos2){//这个是交叉的情况
                    Pos1List.add(Integer.valueOf(tem[1]));
                    Pos2List.add(Integer.valueOf(tem[2]));
                    geneIDList.add(tem[3]);
                    pos1 = Integer.valueOf(tem[1]); //输出之后要赋值
                    pos2 = Integer.valueOf(tem[2]);
                }
                else if(Integer.valueOf(tem[1])<= pos2 && Integer.valueOf(tem[2])<=pos2) continue;//这个是上一个包含这个
                else if(Integer.valueOf(tem[1])>= pos2) {
                    Pos1List.add(Integer.valueOf(tem[1]));
                    Pos2List.add(Integer.valueOf(tem[2]));
                    geneIDList.add(tem[3]);
                    pos1 = Integer.valueOf(tem[1]); //输出之后要赋值
                    pos2 = Integer.valueOf(tem[2]);
                }
            }
            System.out.println(Pos1List.size() + "\n");
            //System.out.println(Pos2List.size() + "\n");
            //System.out.println(geneIDList.size() + "\n");
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
                        bw.write(chr + "\t" + Pos1List.get(i) + "\t" + Pos2List.get(i) + "\t" + geneIDList.get(i) + "\t" + count + "\n");
                        count = 1; //因为这个时候已经是下一个基因了
                        i = i + 1;
                    }
                }       
            }
            bw.write(chr + "\t" + Pos1List.get(i) + "\t" + Pos2List.get(i) + "\t" + geneIDList.get(i) + "\t" + count + "\n");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //这个方法是为了得到几万个gene的SNP文件
    
    // 输入文件格式 36	22460	24375	TraesCS6D02G355900	8
    public void C21_getgeneSNP(String infileS1,String infileS2,String outfileS){
        try {
            String temp = null;
            String temp2 = null;
            BufferedReader br1;
            BufferedReader br2;
            int i = 0;
            //StringBuilder pergeneSNP = null;
            String headline = null;
            String geneID = null;
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
            List<String> geneSNP = new ArrayList <>();
            BufferedWriter bw = null;
            //现在开始读gene注释文件，//文件格式是 1	40098	70338	TraesCS1A02G000100  8
            while((temp = br1.readLine())!= null){
                String tem[] = temp.split("\t");
                Pos1List.add(Integer.valueOf(tem[1]));
                Pos2List.add(Integer.valueOf(tem[2]));
                geneIDList.add(tem[3]);
            }
            System.out.println(Pos1List.size() + "\n");
            //System.out.println(Pos2List.size() + "\n");
            //System.out.println(geneIDList.size() + "\n");
            //现在开始读VCF文件
            while((temp2 = br2.readLine())!= null){
                //String tem2[] = temp2.split("\t");
                if(temp2.startsWith("#C")){
                    headline = temp2;
                }
                if(!temp2.startsWith("#")){
                    //chr = temp2.split("\t")[0];
                    int pos = Integer.valueOf(temp2.split("\t")[1]);
                    //现在开始做判断
                    //if(pos < Pos1List.get(i)) continue;
                    if (pos >= Pos1List.get(i) && pos <= Pos2List.get(i)){
                        //System.out.println(pergeneSNP);
                        geneSNP.add(temp2);
                    }
                    else if (pos >= Pos1List.get(i+1) && pos <= Pos2List.get(i+1)) {
                        //因为这个时候SNP已经是下一个Pos了
                        geneID = geneIDList.get(i) ;
                        bw = IOUtils.getTextWriter(outfileS+"/"+ geneID +".vcf");
                        bw.write(headline + "\n");
                        for(int j=0;j<geneSNP.size();j++){
                            bw.write(geneSNP.get(j) + "\n");
                        }
                        bw.flush();
                        bw.close();
                        //现在要清空geneSNP啦  List<String> geneSNP = new ArrayList <>();
                        geneSNP.clear();
                        geneSNP.add(temp2);
                        i = i + 1;
                    }
                }   
            }
            geneID = geneIDList.get(i) ;
            bw = IOUtils.getTextWriter(outfileS+"/"+ geneID +".vcf");
            bw.write(headline + "\n");
            for(int j=0;j<geneSNP.size();j++){
                bw.write(geneSNP.get(j) + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
