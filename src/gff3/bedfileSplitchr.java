/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gff3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;
import vcf.NewTaxafile;

/**
 *
 * @author xuebozhao
 */
public class bedfileSplitchr {
    public bedfileSplitchr(String infileS,String outfileS){
        this.getfileSplitchr(infileS, outfileS);
    }
    public void getfileSplitchr(String infileS,String outfileS){
        try {            
            BufferedWriter bw = null;
            String temp = null;
            String tempold = null;
            String[] te = null; 
            StringBuilder line  = new StringBuilder();
            BufferedReader br = IOUtils.getTextReader(infileS);
            //bw = IOUtils.getTextWriter(outfileS+"/chr"+i+"_10M.txt");
            while((temp = br.readLine())!=null){
                String tem[] = temp.split("\t");
                if(tem[0].equals(tempold)){
                    line.append(temp + "\n");
                    tempold = tem[0];
                }else{
                    bw = IOUtils.getTextWriter(outfileS+"/chr"+ tempold +"_10M.txt");
                    //bw = IOUtils.getTextWriter(outfileS+"/chr"+ tempold +"_1M.txt");
                    bw.write(line.toString());
                    System.out.println(line.toString());
                    line.delete(0, line.length());
                    line.append(temp + "\n");
                    tempold = tem[0];
                    bw.flush();
                    bw.close();
                } 
            } 
            bw = IOUtils.getTextWriter(outfileS+"/chr"+ tempold +"_10M.txt");
            //bw = IOUtils.getTextWriter(outfileS+"/chr"+ tempold +"_1M.txt");
            bw.write(line.toString());
            bw.flush();
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
        
}
