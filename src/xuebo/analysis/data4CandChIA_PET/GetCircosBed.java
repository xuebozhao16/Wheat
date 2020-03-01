/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo.analysis.data4CandChIA_PET;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import static java.lang.Math.abs;

/**
 *
 * @author xuebozhao
 */
public class GetCircosBed {
    
    GetCircosBed(String infileS,String outfileS) {
        //this.readBed(infileS, outfileS);
        //this.readBed2_nocent(infileS, outfileS);
        //this.sum(infileS,outfileS);
        this.positiveKX_hits_allFdr_nocent(infileS, outfileS);
        
    }
    
    public void readBed (String infileS,String outfileS){
        try{
            
            BufferedReader br;            
            br = XueboIOUtils.getTextReader(infileS);
            BufferedWriter bw = XueboIOUtils.getTextWriter(outfileS);
            
            String temp = null;
            String L1 = null;
            String L2 = null;
            int i = 0;

            while (( temp = br.readLine()) != null) {
                
                    ++i;
                    
                    if (i % 100 == 0) {

                        System.out.println("Filtering " + i + "....");

                    }

                    String[] tem = temp.split("\t");
                    
                    int aa = Integer.valueOf(tem[2]) + 10 ;
                    
                    L1 = "chr" + tem[0] + "\t" + tem[1] + "\t" + aa + "\t" + "chr2" + "\t" + "7808877" + "\t" + "7810811";
                    
                    bw.write(L1 + "\n"); 
            }
            
            bw.flush(); 
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    //这个方法为了去掉centromere附近的互作位点
    //chr	start	end	centromere
    //chr1	15.04	15.15	15000000
    //chr2	3.56	3.66	3600000
    //chr3	13.75	14.01	14000000
    //chr4	4.91	4.01	4000000
    //chr5	11.68	11.78	11600000
    public void readBed2_nocent (String infileS,String outfileS){
        try{
            
            BufferedReader br;            
            br = XueboIOUtils.getTextReader(infileS);
            BufferedWriter bw = XueboIOUtils.getTextWriter(outfileS);      
            String temp = null;
            String L1 = null;
            //String L2 = null;
            int i = 0;
            while (( temp = br.readLine()) != null) {               
                    ++i;
                    if (i % 100 == 0) {
                        System.out.println("Filtering " + i + "....");
                    }
                    String[] tem = temp.split("\t");
                    int pos = Integer.valueOf(tem[2]);
                    int aa = Integer.valueOf(tem[2]) + 100 ;
                    if(tem[0].equals("1")){
                        if(pos >= 16000000 || pos <= 14000000){
                            bw.write("chr" + tem[0] + "\t" + tem[1] + "\t" + aa + "\t" + "chr2" + "\t" + "7808877" + "\t" + "7810811" + "\n");
                        }   
                    }
                    if(tem[0].equals("2")){
                        bw.write("chr" + tem[0] + "\t" + tem[1] + "\t" + aa + "\t" + "chr2" + "\t" + "7808877" + "\t" + "7810811" + "\n");
                    }
                    if(tem[0].equals("3")){
                        if(pos >= 15000000 || pos <= 13000000){
                            bw.write("chr" + tem[0] + "\t" + tem[1] + "\t" + aa + "\t" + "chr2" + "\t" + "7808877" + "\t" + "7810811" + "\n");
                        }                       
                    }
                    if(tem[0].equals("4")){
                        if(pos >= 5000000 || pos <= 3000000){
                            bw.write("chr" + tem[0] + "\t" + tem[1] + "\t" + aa + "\t" + "chr2" + "\t" + "7808877" + "\t" + "7810811" + "\n");
                        }
                    }
                    if(tem[0].equals("5")){
                        if(pos >= 12600000 || pos <= 10600000)
                        bw.write("chr" + tem[0] + "\t" + tem[1] + "\t" + aa + "\t" + "chr2" + "\t" + "7808877" + "\t" + "7810811" + "\n");
                    }       
            }           
            bw.flush(); 
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void sum (String infileS,String outfileS){
        try{
            
            BufferedReader br;            
            br = XueboIOUtils.getTextReader(infileS);
            BufferedWriter bw = XueboIOUtils.getTextWriter(outfileS);
            
            String temp = null;
            int L1 = 0;
            int L2 = 0;
            int i = 0;

            while (( temp = br.readLine()) != null) {
                
                    ++i;
                    
                    if (i % 2 == 0) {

                        System.out.println("Filtering " + i + "....");

                    }

                    if (temp.startsWith("CHROM"))
                        continue;
                    String[] tem = temp.split("\t");
                    
                    int aa = Integer.valueOf(tem[1]);
                    
                    L1 = L1 + aa;
                    
                    
                    //bw.write(L1 + "\n"); 
            }
            bw.write(L1 + "\n");
            bw.flush(); 
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法为了去掉centromere附近的互作位点
    //chr	start	end	centromere
    //chr1	15.04	15.15	15000000
    //chr2	3.56	3.66	3600000
    //chr3	13.75	14.01	14000000
    //chr4	4.91	4.01	4000000
    //chr5	11.68	11.78	11600000
    
    public void positiveKX_hits_allFdr_nocent (String infileS,String outfileS){
        try{
            
            BufferedReader br;            
            br = XueboIOUtils.getTextReader(infileS);
            BufferedWriter bw = XueboIOUtils.getTextWriter(outfileS);      
            String temp = null;
            //String L2 = null;
            int i = 0;
            while (( temp = br.readLine()) != null) {               
                    ++i;
                    if (i % 100 == 0) {
                        System.out.println("Filtering " + i + "....");
                    }
                    String[] tem = temp.split("\t");
                    int pos = Integer.valueOf(tem[2]);
                    int aa = Integer.valueOf(tem[2]) + 100 ;
                    if(tem[0].equals("1")){
                        if(pos >= 16000000 || pos <= 14000000){
                            bw.write(temp + "\n");
                        }   
                    }
                    if(tem[0].equals("2")){
                        bw.write(temp + "\n");
                    }
                    if(tem[0].equals("3")){
                        if(pos >= 15000000 || pos <= 13000000){
                            bw.write(temp + "\n");
                        }                       
                    }
                    if(tem[0].equals("4")){
                        if(pos >= 5000000 || pos <= 3000000){
                            bw.write(temp + "\n");
                        }
                    }
                    if(tem[0].equals("5")){
                        if(pos >= 12600000 || pos <= 10600000)
                        bw.write(temp + "\n");
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
