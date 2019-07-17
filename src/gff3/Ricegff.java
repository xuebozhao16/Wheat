/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gff3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class Ricegff {
    public Ricegff(String infileS,String outfileS){
        //this.getRiceOnlygene(infileS, outfileS);
        this.getRiceGeneSub(infileS, outfileS);
    }
    //这个方法是得到水稻的only gene
    public void getRiceOnlygene(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(tem[2].equals("predicted_gene")){
                    String chr = tem[0].split("r")[1];
                    String geneid = tem[8].split(" ")[1];
                    String gene = geneid.substring(1, 13);
                    bw.write(chr + "\t" +gene + "\t" +  tem[3] + "\t" + tem[4] + "\t" + tem[6] + "\n");
                }
                
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是得到水稻的A 
    public void getRiceGeneSub(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                if(temp.substring(8, 9).equals("A")){
                    bw.write(temp + "\n");
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
