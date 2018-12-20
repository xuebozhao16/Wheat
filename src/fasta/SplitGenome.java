/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */

public class SplitGenome {
    public SplitGenome(String infileS,String outfileS){
        this.getTheHeadLine(infileS, outfileS);
    }
    public void getTheHeadLine(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = null;
            if(infileS.endsWith(".gz")){
                br = IOUtils.getTextGzipReader(infileS);
            }else{
                br = IOUtils.getTextReader(infileS);
            }
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            boolean aa = false;
            StringBuilder tempp = new StringBuilder();
            while((temp = br.readLine()) != null){               
                if(temp.startsWith(">CM")){
                    aa = true;
                    bw.write(temp + "\n");
                }
                if(temp.startsWith(">N")){
                    aa = false;
                }
                if(aa){
                    tempp = tempp.append(temp);                   
                }
            }
            System.out.println(tempp.length());
            bw.flush();
            bw.close();          
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    } 
}
