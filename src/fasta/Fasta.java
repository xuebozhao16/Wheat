/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class Fasta {
    List<String> chr = new ArrayList();
    Map<String,StringBuilder> fas = new HashMap();
    public Fasta(String inFile){
        this.readFasta(inFile);
    }
    public void readFasta(String inFile){
        
        BufferedReader br;
        if(inFile.endsWith("gz")){
            br = IOUtils.getTextGzipReader(inFile);
        }else{
            br = IOUtils.getTextReader(inFile);
        }
        String temp = "";
        String key = null;
        StringBuilder value = new StringBuilder();   
        try {
            while((temp = br.readLine())!=null){
                if(temp.startsWith(">0")|temp.startsWith(">43")|temp.startsWith(">44")){
                    
                }
                else{
                    if(temp.startsWith(">")){
                        if(key!=null) fas.put(key,value);
                        key = temp.replace(">","");
                        chr.add(key);
                        value = new StringBuilder();
                    }else{
                        value.append(temp);
                    }
                }
            }
            fas.put(key, value);
        } catch (IOException ex) {
            Logger.getLogger(Fasta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public void getParralle(String input,String gff3){
//        chr
//            .parallelStream()
//            .forEach(e -> subFas(e,gff3,input));
//    }
//    public void subFas(String chr, String gff3,String input){
//        String output = input.replace("fasta",chr+".fasta");
//        BufferedWriter bw = IOUtils.getTextGzipWriter(output);
//    }
}
