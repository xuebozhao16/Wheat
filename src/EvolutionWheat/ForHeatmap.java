/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import static java.lang.Math.abs;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class ForHeatmap {
    public ForHeatmap(String infileS,String outfileS){
        //this.getXpehh_bin(infileS, outfileS);
        //this.getQgeneHeatmap(infileS, outfileS);
        //this.getQgeneHeatmap_noBeagle(infileS, outfileS);
        //this.getgeneHeatmap_noBeagle_SNP(infileS, outfileS);
        //this.getgeneHeatmap_noBeagle_indel(infileS, outfileS);
        this.getgeneHeatmap_Beagle_SNP(infileS, outfileS);
    }
    public ForHeatmap(String infileS1,String infileS2,String outfileS){
        this.getgeneHeatmap_noBeagle_merge(infileS1, infileS2, outfileS);
    }
    public void getXpehh_bin(String infileS,String outfileS){
        try{
            String temp = null;
            int i =0;
            HashMap<String, Double> hashMap1 = new HashMap<String, Double>();
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String tem[] = temp.split(" ");
                //System.out.println(tem[1]);
//                String AA = "-0.24238";
//                int BB = Integer.valueOf(AA);
//                System.out.println(BB);
                double temvalue =  Double.valueOf(tem[1]);
                String chr = tem[0].split("-")[0];
                String tempos = tem[0].split("-")[1];
                hashMap1.put(tempos,temvalue);
                if(i%100 == 0){
//                    Object max = getMaxValue(hashMap1);
//                    Object min = getMinValue(hashMap1);
                    double max = (Double) getMaxValue(hashMap1);                
                    double min = (Double) getMinValue(hashMap1); 
                    if(abs(max)> abs(min)){
                        bw.write(chr + "\t" + tempos + "\t" + max + "\n");
                    }else{
                        bw.write(chr + "\t" + tempos + "\t" + min + "\n");
                    }
                    hashMap1.clear();
                }
                i++;
            }
            bw.flush();
            bw.close();         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Object getMaxValue(HashMap<String, Double> HashMap) {
        // if (map == null) return null;
        Collection<Double> c = HashMap.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return obj[obj.length -1 ];
    }
    
    public static Object getMinValue(HashMap<String, Double> HashMap) {
        // if (map == null) return null;
        Collection<Double> c = HashMap.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return obj[0];
    }
    
    public void getQgeneHeatmap(String infileS,String outfileS){
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
                    bw.write(headtem[0].substring(1,headtem[0].length()) + "\t" + headtem[1] + "\t" + headlineSB + "\n");
                }
                else {
                    StringBuilder haplo = new StringBuilder();
                    for(i=9; i<tem.length;i++){
                        if(tem[i].equals("0|0")){
                            tem[i] = "0";
                        }
                        if(tem[i].equals("1|0")){
                            tem[i] = "1";
                        }
                        if(tem[i].equals("0|1")){
                            tem[i] = "1";
                        }
                        if(tem[i].equals("1|1")){
                            tem[i] = "2";
                        }
                        haplo.append(tem[i]).append("\t");
                    }
                    bw.write(tem[0] + "\t" + tem[1] + "\t" + haplo + "\n");
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getQgeneHeatmap_noBeagle(String infileS,String outfileS){
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
                    bw.write(headtem[0].substring(1,headtem[0].length()) + "\t" + headtem[1] + "\t" + headlineSB + "\n");
                }
                else {
                    //String tem[] = temp.split("\t");
                    StringBuilder haplo = new StringBuilder();
                    for(i=9; i<tem.length;i++){
                        String temtem = tem[i].split(":")[0];
                        if(temtem.equals("0/0")){
                            tem[i] = "0";
                        }
                        if(temtem.equals("1/0")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("0/1")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("0/2")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("1/1")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("2/2")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("1/2")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("3/3")){
                            tem[i] = "2";
                        } 
                        if(temtem.equals("4/4")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("5/5")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("./.")){
                            tem[i] = "NA";
                        }
                        haplo.append(tem[i]).append("\t");
                    }
                    bw.write(tem[0] + "\t" + tem[1] + "\t" + haplo + "\n");
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
//    public void getgeneHeatmap_noBeagleQ(String infileS,String outfileS){
//        try{
//            String temp = null;
//            int i;
//            BufferedReader br = IOUtils.getTextReader(infileS);
//            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
//            String headline = br.readLine();
//            String headtem[] = headline.split("\t");
//            StringBuilder headlineSB = new StringBuilder();
//            for(int j=9; j<headtem.length;j++){
//                headlineSB.append(headtem[j]).append("\t");
//            }
//            bw.write(headtem[0] + "\t" + headtem[1] + "\t" + headlineSB + "\n");
//            while((temp = br.readLine()) != null){
//                String tem[] = temp.split("\t");
//                StringBuilder haplo = new StringBuilder();
//                for(i=9; i<tem.length;i++){
//                    String temtem = tem[i].split(":")[0];
//                    if(temtem.equals("0/0")){
//                        tem[i] = "0";
//                    }
//                    if(temtem.equals("1/0")){
//                        tem[i] = "1";
//                    }
//                    if(temtem.equals("0/1")){
//                        tem[i] = "1";
//                    }
//                    if(temtem.equals("1/1")){
//                        tem[i] = "2";
//                    }
//                    if(temtem.equals("./.")){
//                        tem[i] = "NA";
//                    }
//                    haplo.append(tem[i]).append("\t");
//                }
//                bw.write(tem[0] + "\t" + tem[1] + "\t" + haplo + "\n");
//            }
//            bw.flush();
//            bw.close();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    
    
    
    //这个方法是为了把vcf的信息装换成0，1，2，NA的信息，
    //这个方法的第二个作用是为了把vcf文件中在指定群体中分离的SNP位点找出来，要是在指定群体中不分离，则这个位点不输出
//    String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/TraesCS5A02G233700/SNP/chr25_TraesCS5A02G233700.vcf";
//    String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/TraesCS5A02G233700/SNP/chr25_TraesCS5A02G233700.txt";
//    new ForHeatmap(infileS,outfileS);
    
    public void getgeneHeatmap_noBeagle_SNP(String infileS,String outfileS){
        try{
            String temp = null;
            String prefix = null;
            int i;
            //BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedReader br = null;
            if (infileS.endsWith("gz")) {
                br = IOUtils.getTextGzipReader(infileS);
            } else {
                br = IOUtils.getTextReader(infileS);
            }
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                if(temp.startsWith("#")){
                    prefix = tem[0].substring(0, 2);
                    if(prefix.equals("##")){

                    }
                    else if(prefix.equals("#C")){
                        //String headline = br.readLine();
                        String headtem[] = temp.split("\t");
                        StringBuilder headlineSB = new StringBuilder();
                        for(int j=9; j<headtem.length;j++){
                            headlineSB.append(headtem[j]).append("\t");
                        }
                        bw.write(headtem[0].substring(1,headtem[0].length()) + "\t" + headtem[1] + "\t" + headtem[3] + "\t" + headtem[4] + "\t" + headlineSB + "\n");
                    }
                }           
                else {
                    //String tem[] = temp.split("\t");
                    StringBuilder haplo = new StringBuilder();
                    for(i=9; i<tem.length;i++){
                        String temtem = tem[i].split(":")[0];
                        if(temtem.equals("0/0")){
                            tem[i] = "0";
                        }
                        if(temtem.equals("1/0")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("0/1")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("1/1")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("./.")){
                            tem[i] = "NA";
                        }
                        haplo.append(tem[i]).append("\t");
                    }
                    String Str_haplo = haplo.toString();
                    System.out.println(Str_haplo);
                    if(Str_haplo.contains("1") | Str_haplo.contains("2")){
                        bw.write(tem[0] + "\t" + tem[1] + "\t" + tem[3] + "\t" + tem[4] + "\t" + haplo + "\n");
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
    
    
//     String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/TraesCS5A02G233700/indel/chr25_TraesCS5A02G233700_110K_indelA.vcf";
//     String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/TraesCS5A02G233700/indel/chr25_TraesCS5A02G233700_110K_indelAB.vcf";
//     String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/TraesCS5A02G233700/indel/chr25_TraesCS5A02G233700_110K_indelmmerge.vcf";
//     new ForHeatmap(infileS1,infileS2,outfileS);
    //这个方法是为了把两个vcf文件合并，A和AB的合成一个vcf文件，使用的是AB的表头
    public void getgeneHeatmap_noBeagle_merge(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            String temp2 = null;
            int Alength = 0;
            int Blength = 0;
            StringBuilder headlineSB1 = new StringBuilder();
            StringBuilder headlineSB2 = new StringBuilder();
            HashMap<Integer, String> hashMap1 = new HashMap<Integer, String>();
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br1.readLine()) != null){
                String tem1[] = temp.split("\t");
                Alength = tem1.length - 9;
                String prefix = tem1[0].substring(0, 2);
                if(prefix.equals("##")){
                    
                }
                else if(prefix.equals("#C")){
                    //String headline = br.readLine();
                    String headtem[] = temp.split("\t");
                    for(int j=0; j<headtem.length;j++){
                        //这里是保存一下A的vcf的表头
                        headlineSB1.append(headtem[j]).append("\t");
                    }
                }
                else {
                    hashMap1.put(Integer.valueOf(tem1[1]), temp);
                }
            }
            while((temp2 = br2.readLine()) != null){
                String tem[] = temp2.split("\t");
                Blength = tem.length - 9;
                String prefix = tem[0].substring(0, 2);
                if(prefix.equals("##")){
                    bw.write(temp2 + "\n");
                }
                else if(prefix.equals("#C")){
                    //String headline = br.readLine();
                    String headtem[] = temp2.split("\t");
                    for(int j=9; j<headtem.length;j++){
                        //这里是保存一下A的vcf的表头
                        headlineSB2.append(headtem[j]).append("\t");
                    }
                    //System.out.println(headlineSB1.toString() + headlineSB2.toString() + "\n");
                    bw.write(headlineSB1.toString() + headlineSB2.toString() + "\n");
                }
                else {
                    int PosAB = Integer.valueOf(tem[1]);
                    if(hashMap1.get(PosAB) == null){
                        StringBuilder headlineABhead = new StringBuilder();
                        StringBuilder headlineAB = new StringBuilder();
                        for(int i=0;i<8;i++){
                            headlineABhead.append(tem[i] + "\t");
                        }
                        headlineABhead.append(tem[8]);
                        for(int i=9;i<(tem.length-1);i++){
                            headlineAB.append(tem[i] + "\t");
                        }
                        headlineAB.append(tem[tem.length-1]);
                        String valueNew = headlineABhead.toString() + "\t" + getNA(Alength) + "\t" + headlineAB.toString();
                        hashMap1.put(Integer.valueOf(tem[1]), valueNew);
                    }else{
                        StringBuilder headlineAB = new StringBuilder();
                        for(int i=9;i<(tem.length-1);i++){
                            headlineAB.append(tem[i] + "\t");
                        }
                        headlineAB.append(tem[tem.length-1]);
                        String valueNew = hashMap1.get(Integer.valueOf(tem[1])) + "\t" + headlineAB.toString();
                        hashMap1.replace(Integer.valueOf(tem[1]), valueNew);
                    }                   
                }
            }
            //hashMap按照key值进行排序
            Object[] keyall = hashMap1.keySet().toArray();   
            Arrays.sort(keyall);  
            for (int n = 0; n < keyall.length; n++) {   
                String valueall[] = hashMap1.get(keyall[n]).split("\t");
                if(valueall.length == Alength + Blength + 9){
                    bw.write(hashMap1.get(keyall[n]) + "\n");
                }else {
                    String valueNew = hashMap1.get(keyall[n]) + "\t" + getNA(Blength);
                    System.out.println(valueNew);
                    bw.write(valueNew + "\n");
                }               
            }   
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // 这个方法是产生指定个数的NA
    private String getNA(Integer Alength){
        StringBuilder StringNA = new StringBuilder();
        for(int j = 0; j< Alength-1; j++){
            StringNA.append("NA" + "\t");
        }
        StringNA.append("NA");
        return StringNA.toString();
    }
    
    
    //这个方法是为了把indel的信息装换成0，1，2，NA的信息，
    //这个方法的第二个作用是为了把vcf文件中在指定群体中分离的indel位点找出来，要是在指定群体中不分离，则这个位点不输出
//    String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/TraesCS5A02G233700/indel/chr25_TraesCS5A02G233700_110K_indelmmerge.vcf";
//    String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/TraesCS5A02G233700/indel/TraesCS5A02G233700_110K_indel.txt";
//    new ForHeatmap(infileS,outfileS);
    
//    String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/TraesCS5A02G233700/indel/chr25_TraesCS5A02G233700_indelmmerge.vcf";
//    String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Crispr_gene/TraesCS5A02G233700/indel/TraesCS5A02G233700_indel.txt";
//    new ForHeatmap(infileS,outfileS);
    
    public void getgeneHeatmap_noBeagle_indel(String infileS,String outfileS){
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
                    bw.write(headtem[0].substring(1,headtem[0].length()) + "\t" + headtem[1] + "\t" + headtem[3] + "\t" + headtem[4] + "\t" + headlineSB + "\n");
                }
                else {
                    //String tem[] = temp.split("\t");
                    StringBuilder haplo = new StringBuilder();
                    for(i=9; i<tem.length;i++){
                        String temtem = tem[i].split(":")[0];
                        if(temtem.equals("0/0")){
                            tem[i] = "0";
                        }
                        if(temtem.equals("1/0")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("0/1")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("0/2")){
                            tem[i] = "1";
                        }
                         if(temtem.equals("0/3")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("1/2")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("1/3")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("1/1")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("2/2")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("3/3")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("4/4")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("5/5")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("6/6")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("7/7")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("8/8")){
                            tem[i] = "2";
                        }
                        if(temtem.equals("./.")){
                            tem[i] = "NA";
                        }
                        haplo.append(tem[i]).append("\t");
                    }
                    String Str_haplo = haplo.toString();
                    System.out.println(Str_haplo);
                    if(Str_haplo.contains("1") | Str_haplo.contains("2")){
                        bw.write(tem[0] + "\t" + tem[1] + "\t" + tem[3] + "\t" + tem[4] + "\t" + haplo + "\n");
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

        //这个方法是为了把vcf的信息装换成0，1，2，NA的信息，
    public void getgeneHeatmap_Beagle_SNP(String infileS,String outfileS){
        try{
            String temp = null;
            String prefix = null;
            int i;
            //BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedReader br = null;
            if (infileS.endsWith("gz")) {
                br = IOUtils.getTextGzipReader(infileS);
            } else {
                br = IOUtils.getTextReader(infileS);
            }
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                if(temp.startsWith("#")){
                    prefix = tem[0].substring(0, 2);
                    if(prefix.equals("##")){

                    }
                    else if(prefix.equals("#C")){
                        //String headline = br.readLine();
                        String headtem[] = temp.split("\t");
                        StringBuilder headlineSB = new StringBuilder();
                        for(int j=9; j<headtem.length;j++){
                            headlineSB.append(headtem[j]).append("\t");
                        }
                        bw.write(headtem[0].substring(1,headtem[0].length()) + "\t" + headtem[1] + "\t" + headtem[3] + "\t" + headtem[4] + "\t" + headlineSB + "\n");
                    }
                }           
                else {
                    //String tem[] = temp.split("\t");
                    StringBuilder haplo = new StringBuilder();
                    for(i=9; i<tem.length;i++){
                        String temtem = tem[i].split(":")[0];
                        if(temtem.equals("0|0")){
                            tem[i] = "0";
                        }
                        if(temtem.equals("1|0")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("0|1")){
                            tem[i] = "1";
                        }
                        if(temtem.equals("1|1")){
                            tem[i] = "2";
                        }
                        if(temtem.equals(".|.")){
                            tem[i] = "NA";
                        }
                        haplo.append(tem[i]).append("\t");
                    }
                    String Str_haplo = haplo.toString();
                    System.out.println(Str_haplo);
                    if(Str_haplo.contains("1") | Str_haplo.contains("2")){
                        bw.write(tem[0] + "\t" + tem[1] + "\t" + tem[3] + "\t" + tem[4] + "\t" + haplo + "\n");
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
