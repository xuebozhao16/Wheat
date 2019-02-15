/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo.analysis.data4CandChIA_PET;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 *
 * @author xuebozhao
 */
public class Containing2 {
    Containing2(String infileS1, String infileS2, String outfileS1, String outfileS2) {
        //this.readFileContainQC_emzyme2(infileS1, infileS2, outfileS1, outfileS2);
        //this.readFileNoQC_emzyme2(infileS1, infileS2, outfileS1, outfileS2);
        this.readFileNoQC_emzyme1(infileS1, infileS2, outfileS1, outfileS2);
    }
    //这个方法是对clean data进行过滤，选择包括酶切位点的reads，emzyme2指的是Bgl2和SaqA1的组合，没有做质量控制
    public void readFileNoQC_emzyme1(String infileS1, String infileS2, String outfileS1, String outfileS2) {
        try {
            BufferedReader br1;
            BufferedReader br2;
            if (infileS1.endsWith("gz")) {
                br1 = XueboIOUtils.getTextGzipReader(infileS1);
                br2 = XueboIOUtils.getTextGzipReader(infileS2);
            } else {
                br1 = XueboIOUtils.getTextReader(infileS1);
                br2 = XueboIOUtils.getTextReader(infileS2);
            }
            String temp1 = null;
            String temp2 = null;
            BufferedWriter bw1 = XueboIOUtils.getTextGzipWriter(outfileS1);
            BufferedWriter bw2 = XueboIOUtils.getTextGzipWriter(outfileS2);
            int i = 0;
            String L11 = null,
            L12 = null,
            L13 = null,
            L14 = null; 
            String L21 = null,L22 = null,L23 = null,L24 = null;            
            int L2t = 0;
            int aa = 0;
            int bb = 0;
            int cc = 0;
            int dd = 0;           
            while ((temp1 = br1.readLine()) != null
                    && (temp2 = br2.readLine()) != null) {
                ++i;               
                if (i % 500000 == 0) {
                    System.out.println("Filtering " + i + "....");
                }
                boolean outWrite = false;
                if (i % 4 == 1) {
                    L11 = temp1;
                    L21 = temp2;
                }
                if (i % 4 == 2) {
                    int len = temp1.length();                   
                    aa = temp1.indexOf("TTAA"); //L1里面TTAA的位置
                    bb = temp2.indexOf("AGATCT");   //L2里面AGATCT的位置           
                    cc = temp2.indexOf("TTAA");  //L2里面TTAA的位置
                    dd = temp1.indexOf("AGATCT");  //L1里面AGATCT的位置    
                    String a1, a2, a3, a4;
                    a1 = temp1.substring(72, 78); //这个是AGATCT的位置 
                    a2 = temp2.substring(72, 78);
                    a3 = temp1.substring(79, 83); //这个是TTAA的位置
                    a4 = temp2.substring(79, 83);
                    if (a1.equals("AGATCT") && a4.equals("TTAA")) {                        
                        if(temp1.contains("TTAA") && temp2.contains("AGATCT")){
                            if(aa > 78 && bb>83){
                            L12 = temp1.substring(78, aa);
                            L22 = temp2.substring(83, bb);
                            }
                            if (L12.length() == L22.length() && L12.length() > 30){
                                L2t = 11;                                
                            }                          
                        }
                        else{ 
                            L12 = temp1.substring(78,len);
                            L22 = temp2.substring(83,len);
                            L2t = 1;
                        }
                    } 
                    else if (a2.equals("AGATCT") && a3.equals("TTAA")) {                      
                        if(temp2.contains("TTAA") && temp1.contains("AGATCT")){
                            if(cc > 78 && dd > 83){
                            L12 = temp1.substring(83, dd);
                            L22 = temp2.substring(78, cc);                        
                            }
                            if (L12.length() == L22.length()&& L12.length() > 30){
                                L2t = 13;
                            }                         
                        }
                        else {                        
                            L12 = temp1.substring(83, len);                       
                            L22 = temp2.substring(78, len);
                            L2t = 2;
                        }
                    }
                }
                if (i % 4 == 3) {
                    L13 = temp1;
                    L23 = temp2;
                }
                if (i % 4 == 0) {
                    int l1 = temp1.length();
                    int l2 = temp2.length();
                    if (L2t == 1) {
                        L14 = temp1.substring(78, l1);
                        L24 = temp2.substring(83, l2);
                        outWrite = true;
                    }                  
                    if (L2t == 2) {
                        L14 = temp1.substring(83, l1);
                        L24 = temp2.substring(78, l2);
                        outWrite = true;
                    }                   
                    if (L2t == 11){                     
                        if(aa > 78 && bb > 83){                            
                        L14 = temp1.substring(78, aa);
                        L24 = temp2.substring(83, bb);                       
                        outWrite = true;
                        }
                    }                   
                    if (L2t == 13){
                        if(cc > 78 && dd > 83){                         
                        L14 = temp1.substring(83, dd);
                        L24 = temp2.substring(78, cc);               
                        outWrite = true;
                        }
                    }
                    L2t = 0;                   
                }
                if (outWrite) {
                    bw1.write(L11 + "\n");
                    bw1.write(L12 + "\n");
                    bw1.write(L13 + "\n");
                    bw1.write(L14 + "\n");
                    bw2.write(L21 + "\n");
                    bw2.write(L22 + "\n");
                    bw2.write(L23 + "\n");
                    bw2.write(L24 + "\n");
                    bw1.flush();
                    bw2.flush();
                }
            }
            bw1.close();
            bw2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //这个方法是对clean data进行过滤，选择包括酶切位点的reads，emzyme2指的是Bgl2和Taq1的组合，没有做质量控制
    public void readFileNoQC_emzyme2(String infileS1, String infileS2, String outfileS1, String outfileS2) {
        try {
            BufferedReader br1;
            BufferedReader br2;
            if (infileS1.endsWith("gz")) {
                br1 = XueboIOUtils.getTextGzipReader(infileS1);
                br2 = XueboIOUtils.getTextGzipReader(infileS2);
            } else {
                br1 = XueboIOUtils.getTextReader(infileS1);
                br2 = XueboIOUtils.getTextReader(infileS2);
            }
            String temp1 = null;
            String temp2 = null;
            BufferedWriter bw1 = XueboIOUtils.getTextGzipWriter(outfileS1);
            BufferedWriter bw2 = XueboIOUtils.getTextGzipWriter(outfileS2);
            int i = 0;
            String L11 = null,L12 = null,L13 = null,L14 = null; 
            String L21 = null,L22 = null,L23 = null,L24 = null;            
            int L2t = 0;
            int aa = 0;
            int bb = 0;
            int cc = 0;
            int dd = 0;  
            int IDnum = 0;
            while ((temp1 = br1.readLine()) != null
                    && (temp2 = br2.readLine()) != null) {
                ++i;               
                if (i % 500000 == 0) {
                    System.out.println("Filtering " + i + "....");
                }
                int len = temp1.length();
                boolean outWrite = false;
                if (i % 4 == 1) {
                    L11 = temp1;
                    L21 = temp2;
                }
                if (i % 4 == 2) {                   
                    aa = temp1.indexOf("TCGA"); //L1里面TCGA的位置
                    bb = temp2.indexOf("AGATCT");   //L2里面AGATCT的位置           
                    cc = temp2.indexOf("TCGA");  //L2里面TCGA的位置
                    dd = temp1.indexOf("AGATCT");  //L1里面AGATCT的位置    
                    String a3, a4;
                    //a1 = temp1.substring(72, 78);
                    //a2 = temp2.substring(72, 78);
                    a3 = temp1.substring(83, 87); //L1里面TCGA的位置
                    a4 = temp2.substring(83, 87); //L2里面TCGA的位置
                    if (temp1.contains("AAAAAAAAAAAACTAACAAGATCT") && a4.equals("TCGA")) {  //这是指temp1里面有AGATCT，temp2里面有TCGA
                        if(temp1.contains("TCGA") && temp2.contains("AGATCT")){
                            if(aa > 108 && bb > 117){
                            L12 = temp1.substring(dd, aa);
                            L22 = temp2.substring(83, bb);
                            L2t = 11;
                            }                         
                        }
                        else{ 
                            L12 = temp1.substring(dd,len);
                            L22 = temp2.substring(83,len);
                            L2t = 1;
                        }
                    } 
                    else if (temp2.contains("AAAAAAAAAAAACTAACAAGATCT") && a3.equals("TCGA")) {   //这是指temp2里面有AGATCT，temp1里面有TCGA          
                        if(temp2.contains("TCGA") && temp1.contains("AGATCT")){
                            if(cc > 108 && dd > 117){
                            L12 = temp1.substring(83, dd);
                            L22 = temp2.substring(bb, cc);                           
                            L2t = 13;
                            }                
                        }
                        else {                        
                            L12 = temp1.substring(83, len);                       
                            L22 = temp2.substring(bb, len);
                            L2t = 2;
                        }
                    }
                }
                if (i % 4 == 3) {
                    L13 = temp1;
                    L23 = temp2;
                }
                if (i % 4 == 0) {
                    if (L2t == 1) {
                        L14 = temp1.substring(dd, len);
                        L24 = temp2.substring(83, len);
                        outWrite = true;
                    }                  
                    if (L2t == 2) {
                        L14 = temp1.substring(83, len);
                        L24 = temp2.substring(bb, len);
                        outWrite = true;
                    }                   
                    if (L2t == 11){                                                             
                        L14 = temp1.substring(dd, aa);
                        L24 = temp2.substring(83, bb);                       
                        outWrite = true;
                    }                   
                    if (L2t == 13){
                        L14 = temp1.substring(83, dd);
                        L24 = temp2.substring(bb, cc);                         
                        outWrite = true;
                    }
                    L2t = 0;                   
                }
                if (outWrite) {
                    bw1.write(L11);
                    bw1.newLine();
                    bw1.write(L12 );
                    bw1.newLine();
                    bw1.write(L13 );
                    bw1.newLine();
                    bw1.write(L14 );
                    bw1.newLine();
                    bw2.write(L21);
                    bw2.newLine();
                    bw2.write(L22 );
                    bw2.newLine();
                    bw2.write(L23 );
                    bw2.newLine();
                    bw2.write(L24);
                    bw2.newLine();
                    //System.out.println("@"+IDnum+"\t"+L12.length()+"\t"+L22.length()+"\n");
                }
            }
            bw1.flush();
            bw2.flush();
            bw1.close();
            bw2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //这个方法是对clean data进行过滤，选择包括酶切位点的reads，emzyme2指的是Bgl2和Taq1的组合，做了质量控制
    public void readFileContainQC_emzyme2(String infileS1, String infileS2, String outfileS1, String outfileS2) {
        try {
            BufferedReader br1;
            BufferedReader br2;
            if (infileS1.endsWith("gz")) {
                br1 = XueboIOUtils.getTextGzipReader(infileS1);
                br2 = XueboIOUtils.getTextGzipReader(infileS2);
            } else {
                br1 = XueboIOUtils.getTextReader(infileS1);
                br2 = XueboIOUtils.getTextReader(infileS2);
            }
            String temp1 = null;
            String temp2 = null;
            BufferedWriter bw1 = XueboIOUtils.getTextGzipWriter(outfileS1);
            BufferedWriter bw2 = XueboIOUtils.getTextGzipWriter(outfileS2);
            int i = 0;
            String L11 = null,
            L12 = null,
            L13 = null,
            L14 = null; 
            String L21 = null,
                   L22 = null,
                   L23 = null,
                   L24 = null;            
            int L2t = 0;
            int aa = 0;
            int bb = 0;
            int cc = 0;
            int dd = 0;           
            while ((temp1 = br1.readLine()) != null
                    && (temp2 = br2.readLine()) != null) {
                ++i;               
                if (i % 500000 == 0) {
                    System.out.println("Filtering " + i + "....");
                }
                boolean outWrite = false;
                if (i % 4 == 1) {
                    L11 = temp1;
                    L21 = temp2;
                }
                if (i % 4 == 2) {
                    int len                                                                                                                                                                                                        = temp1.length();                   
                    aa = temp1.indexOf("TCGA"); //L1里面TTAA的位置
                    bb = temp2.indexOf("AGATCT");   //L2里面AGATCT的位置           
                    cc = temp2.indexOf("TCGA");  //L2里面TTAA的位置
                    dd = temp1.indexOf("AGATCT");  //L1里面AGATCT的位置    
                    String a1, a2, a3, a4;
                    //a1 = temp1.substring(72, 78);
                    //a2 = temp2.substring(72, 78);
                    a3 = temp1.substring(83, 87);
                    a4 = temp2.substring(83, 87);
                    if (temp1.contains("AAAAAAAAAAAACTAACAAGATCT") && a4.equals("TCGA")) {  //这是指temp1里面有AGATCT，temp2里面有TCGA
                        if(temp1.contains("TCGA") && temp2.contains("AGATCT")){
                            if(aa > 108 && bb > 117){
                            L12 = temp1.substring(dd, aa);
                            L22 = temp2.substring(83, bb);
                            L2t = 11;
                            }
//                            if (L12.length() == L22.length()){
//                                                                
//                            }                          
                        }
                        else{ 
                            L12 = temp1.substring(dd,len);
                            L22 = temp2.substring(83,len);
                            L2t = 1;
                        }
                    } 
                    else if (temp2.contains("AAAAAAAAAAAACTAACAAGATCT") && a3.equals("TCGA")) {   //这是指temp2里面有AGATCT，temp1里面有TCGA          
                        if(temp2.contains("TCGA") && temp1.contains("AGATCT")){
                            if(cc > 108 && dd > 117){
                            L22 = temp2.substring(bb, cc);
                            L12 = temp1.substring(83, dd);
                            L2t = 13;
                            }
//                            if (L12.length() == L22.length()){
//                                
//                            }                         
                        }
                        else {                        
                            L12 = temp1.substring(83, len);                       
                            L22 = temp2.substring(bb, len);
                            L2t = 2;
                        }
                    }
                }
                if (i % 4 == 3) {
                    L13 = temp1;
                    L23 = temp2;
                }
                if (i % 4 == 0) {
                    int sum1 = 0;
                    int sum2 = 0;
                    int l1 = temp1.length();
                    int l2 = temp2.length();
                    String L140 = null;
                    String L240 = null;
                    if (L2t == 1) {
                        L140 = temp1.substring(dd, l1);
                        L240 = temp2.substring(83, l2);
                        for (int j = 0; j < L140.length() - 1; j++) {
                            sum1 += stringToAscii(L140.substring(j, j + 1));
                        }
                        for (int k = 0; k < L240.length() - 1; k++) {
                            sum2 += stringToAscii(L240.substring(k, k + 1));
                        }
                        long mean1 = 0;
                        long mean2 = 0;
                        mean1 = sum1 / (l1 - dd);
                        mean2 = sum2 / (l2 - 83);
                        if (mean1 > 50 && mean2 > 50) {
                            L14 = L140;
                            L24 = L240;
                            outWrite = true;        
                        }
                    }                  
                    if (L2t == 2) {
                        L140 = temp1.substring(83, l1);
                        L240 = temp2.substring(bb, l2);
                        for (int j = 0; j < L140.length() - 1; j++) {
                            sum1 += stringToAscii(L140.substring(j, j + 1));
                        }
                        for (int k = 0; k < L240.length() - 1; k++) {
                            sum2 += stringToAscii(L240.substring(k, 1 + k));
                        }
                        long mean1 = 0;
                        long mean2 = 0;
                        mean1 = sum1 / (l1 - 83);
                        mean2 = sum1 / (l2 - bb);
                        if (mean1 > 50 && mean2 > 50) {
                            L14 = L140;
                            L24 = L240;
                            outWrite = true;
                        }
                    }                   
                    if (L2t == 11){                                                             
                        L140 = temp1.substring(dd, aa);
                        L240 = temp2.substring(83, bb);                       
                        for (int j = 0; j < L140.length() - 1; j++) {
                            sum1 += stringToAscii(L140.substring(j, j + 1));
                        }
                        for (int k = 0; k < L240.length() - 1; k++) {
                            sum2 += stringToAscii(L240.substring(k, 1 + k));
                        }
                        long mean1 = 0;
                        long mean2 = 0;
                        mean1 = sum1 / (l1 - 83);
                        mean2 = sum1 / (l2 - bb);
                        if (mean1 > 50 && mean2 > 50) {
                            L14 = L140;
                            L24 = L240;
                            outWrite = true;
                        }                                  
                    }                   
                    if (L2t == 13){                        
                        L140 = temp2.substring(bb, cc);
                        L240 = temp1.substring(83, dd);  
                        for (int j = 0; j < L140.length() - 1; j++) {
                            sum1 += stringToAscii(L140.substring(j, j + 1));
                        }
                        for (int k = 0; k < L240.length() - 1; k++) {
                            sum2 += stringToAscii(L240.substring(k, 1 + k));
                        }
                        long mean1 = 0;
                        long mean2 = 0;
                        mean1 = sum1 / (l1 - 83);
                        mean2 = sum1 / (l2 - bb);
                        if (mean1 > 50 && mean2 > 50) {
                            L14 = L140;
                            L24 = L240;
                            outWrite = true;
                        }           
                    }
                    L2t = 0;                   
                }
                if (outWrite) {
                    bw1.write(L11 + "\n");
                    bw1.write(L12 + "\n");
                    bw1.write(L13 + "\n");
                    bw1.write(L14 + "\n");
                    bw2.write(L21 + "\n");
                    bw2.write(L22 + "\n");
                    bw2.write(L23 + "\n");
                    bw2.write(L24 + "\n");
                    bw1.flush();
                    bw2.flush();
                }
            }
            bw1.close();
            bw2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public int stringToAscii(String value) {
        int sbu = 0;
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sbu = (int) chars[i];
        }
        return sbu;
    }
}
