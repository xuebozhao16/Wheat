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
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class ForXpehh_bin {
    public ForXpehh_bin(String infileS,String outfileS){
        //this.getXpehh_bin(infileS, outfileS);
        //this.getQgeneHeatmap(infileS, outfileS);
        this.getQgeneHeatmap_noBeagle(infileS, outfileS);
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
    
//    public void getQgeneHeatmap_noBeagle(String infileS,String outfileS){
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
}
