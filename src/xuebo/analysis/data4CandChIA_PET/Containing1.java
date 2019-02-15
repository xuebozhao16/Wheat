/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo.analysis.data4CandChIA_PET;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import utils.IoUtils;

/**
 *
 * @author xuebozhao
 */
public class Containing1 {
    Containing1(String infileS1, String infileS2, String outfileS1, String outfileS2) {
        this.readFile(infileS1, infileS2, outfileS1, outfileS2);
//        this.outputFiles(outfileS1, outfileS2);
    }

    public void readFile(String infileS1, String infileS2, String outfileS1, String outfileS2) {
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
//                System.out.println(temp1.substring(0 ,1)); 
//                System.out.println(i++); 
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
                    aa = temp1.indexOf("TTAA"); //L1里面TTAA的位置
                    bb = temp2.indexOf("AGATCT");   //L2里面AGATCT的位置           
                    cc = temp2.indexOf("TTAA");  //L2里面TTAA的位置
                    dd = temp1.indexOf("AGATCT");  //L1里面AGATCT的位置    
                    String a1, a2, a3, a4;
                    a1 = temp1.substring(72, 78);
                    a2 = temp2.substring(72, 78);
                    a3 = temp1.substring(79, 83);
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
                            L12 = temp2.substring(78, cc);
                            L22 = temp1.substring(83, dd);
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
                    int sum1 = 0;
                    int sum2 = 0;
                    int l1 = temp1.length();
                    int l2 = temp2.length();
                    String L140 = null;
                    String L240 = null;
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
                        L14 = temp2.substring(78, cc);
                        L24 = temp1.substring(83, dd);                        
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
