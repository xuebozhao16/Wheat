/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import com.google.common.collect.Sets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import static java.lang.Math.abs;
import java.util.HashSet;
import java.util.Set;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class XPCLR_intersection {
//    public XPCLR_intersection(String infileS1,String infileS2){
//        //this.XPCLR_intersection_dompair(infileS1, infileS2);
//        this.XPCLR_intersection_impropair(infileS1, infileS2);
//    }
    public XPCLR_intersection(String infileS,String outfileS){
        //this.XPCLR_intersection_after(infileS, outfileS);
        this.XPCLR_intersection_after2(infileS, outfileS);
    }
    
    //这个方法是计算WD_einkorn ---- WD_emmer的交集的基因
    public void XPCLR_intersection_dompair(String infileS1,String infileS2){
        try{
            String temp = null;
            String temp2 = null;
            int i = 0;
            Set  AAgene = new HashSet();
            Set  AABBgene = new HashSet();
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            //BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp=br1.readLine()) != null){
                AAgene.add(temp);                
            }
            while((temp2=br2.readLine()) != null){
                AABBgene.add(temp2);         
                if(temp2.substring(8, 9).equals("B")){
                    i = i + 1;
                }
            }
            Sets.SetView<Integer> set11 = Sets.intersection(AAgene, AABBgene);
            int partA = AAgene.size() - set11.size();
            int partB = set11.size();
            int partC = AABBgene.size() - set11.size() -i;
            System.out.println(partA + "\t" + partB + "\t" + partC);
        }
        catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    //这个方法是计算DDurum ---- ABD的交集的基因
    public void XPCLR_intersection_impropair(String infileS1,String infileS2){
        try{
            String temp = null;
            String temp2 = null;
            int i = 0;
            Set  AAgene = new HashSet();
            Set  AABBgene = new HashSet();
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            //BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp=br1.readLine()) != null){
                AAgene.add(temp);                
            }
            while((temp2=br2.readLine()) != null){
                AABBgene.add(temp2);         
                if(temp2.substring(8, 9).equals("D")){
                    i = i + 1;
                }
            }
            Sets.SetView<Integer> set11 = Sets.intersection(AAgene, AABBgene);
            int partA = AAgene.size() - set11.size();
            int partB = set11.size();
            int partC = AABBgene.size() - set11.size() -i;
            System.out.println(partA + "\t" + partB + "\t" + partC);
        }
        catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    
    //这个方法是对10*10的进行统计
    public void XPCLR_intersection_after(String infileS,String outfileS){
        try{
            String temp = null;
            String AA = null;
            int nn = 0;
            double sum = 0;
            int count = 0;
            Set  AAgene = new HashSet();
            Set  AABBgene = new HashSet();
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            temp=br.readLine();
            bw.write("section" + "\t" + "list1" + "\t" + "intersection" + "\t" + "list2" + "\n" );
            while((temp=br.readLine()) != null){
                String tem[] = temp.split("\t");
                if(temp.startsWith("X")){
                    AA = tem[0] + "_" + tem[1];
                    
                }else{
                    //nn = Integer.valueOf(tem[1]) -155;
                    //nn = Integer.valueOf(tem[1]) -14;
                    //nn = Integer.valueOf(tem[1]) - 5;
//                    if(Integer.valueOf(tem[1])>2){
//                        nn = 0;
//                    }else{
//                        nn = Integer.valueOf(tem[1]);
//                    }                
///////////////////////////////
                    //nn = Integer.valueOf(tem[1]) -155;
                    //nn = Integer.valueOf(tem[1]) -16;
                    //nn = Integer.valueOf(tem[1]) -10;
                    if(Integer.valueOf(tem[1])>2){
                        nn = 0;
                    }else if(Integer.valueOf(tem[1])==2 && count%4==0){
                        nn = 0;
                    }
                    else{
                        nn = Integer.valueOf(tem[1]);
                    }    
//////////////////////////////
                    //nn = Integer.valueOf(tem[1]) -87;
                    //nn = Integer.valueOf(tem[1]) -11;
                    //nn = Integer.valueOf(tem[1]) -4;
//                    if(Integer.valueOf(tem[1])>2){
//                        nn = 0;
//                    }
////                    else if(Integer.valueOf(tem[1])==2 && count%2==1){
////                        nn = 0;
////                    }
//                    else{
//                        nn = Integer.valueOf(tem[1]);
//                    }    
//////////////////////////////
                    //nn = Integer.valueOf(tem[1]) -332;
//                    if(Integer.valueOf(tem[1])>18){
//                        nn = 3;
//                    }else{
//                        nn = Integer.valueOf(tem[1]) - 14;
//                    }     
//                    if(Integer.valueOf(tem[1])>1){
//                        nn = 0;
//                    }else if(Integer.valueOf(tem[1])==1 && count%4==1){
//                        nn = 0;
//                    }
//                    else{
//                        nn = Integer.valueOf(tem[1]);
//                    }    
                    //bw.write(AA + "\t" + tem[0] + "\t" + abs(nn)  + "\t" + tem[2] + "\n");
                    bw.write(AA + "\t" + tem[2] + "\t" + abs(nn)  + "\t" + tem[0] + "\n");
                    sum = sum + abs(nn);
                    count = count +1;                    
                }                    
            }
            System.out.println(sum/count);
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    //这个方法是对32*32 的neg3,4进行统计
    public void XPCLR_intersection_after2(String infileS,String outfileS){
        try{
            String temp = null;
            String AA = null;
            int nn = 0;
            double sum = 0;
            int count = 0;
            Set  AAgene = new HashSet();
            Set  AABBgene = new HashSet();
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            temp=br.readLine();
            bw.write("section" + "\t" + "list1" + "\t" + "intersection" + "\t" + "list2" + "\n" );
            while((temp=br.readLine()) != null){
                String tem[] = temp.split("\t");
                if(temp.startsWith("X")){
                    AA = tem[0] + "_" + tem[1];
                    
                }else{
                    nn = Integer.valueOf(tem[1]);
                    //nn = Integer.valueOf(tem[1]);
                    //nn = Integer.valueOf(tem[1]);
//                    if(Integer.valueOf(tem[1])>2){
//                        nn = 0;
//                    }else{
//                        nn = Integer.valueOf(tem[1]);
//                    }                
                    bw.write(AA + "\t" + tem[2] + "\t" + abs(nn)  + "\t" + tem[0] + "\n");
                    sum = sum + abs(nn);
                    count = count +1;                    
                }                    
            }
            System.out.println(sum/count);
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }   
    }
    
}
