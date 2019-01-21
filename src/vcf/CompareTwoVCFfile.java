/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vcf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class CompareTwoVCFfile {
    public CompareTwoVCFfile(String infileS1,String infileS2,String outfileS){
        this.getCompare(infileS1,infileS2,outfileS);
    }
    public void getCompare(String infileS1,String infileS2,String outfileS){
        try{
            BufferedReader br1;
            BufferedReader br2;
            String temp1,temp2;
            int i = 0,j = 0;
            List<String> headerName1 = new ArrayList<String>();
            List<String> headerName2 = new ArrayList<String>();
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            if (infileS1.endsWith("gz")) {
                br1 = IOUtils.getTextGzipReader(infileS1);
                br2 = IOUtils.getTextGzipReader(infileS2);
            } else {
                br1 = IOUtils.getTextReader(infileS1);
                br2 = IOUtils.getTextReader(infileS2);
            }
            while((temp1 = br1.readLine()) != null){
                if(temp1.startsWith("##")){
                    
                }
                else if (temp1.startsWith("#")){
                    String [] temheader = temp1.split("\t");                   
                    for(int k = 9; k<temheader.length;k++){
                        headerName1.add(temheader[k]);
                    }
                }
                else{
                    String [] tembody = temp1.split("\t");                   
                    String marker =  tembody[1];
                    for(int n = 9;n<tembody.length;n++){
                        String key = headerName1.get(n-9) + "_" + marker;
                        String value = tembody[n].split(":")[0];
                        hashMap1.put(key, tembody[n]);
                    }
                }
                System.out.println(hashMap1.size());                
            }
            while((temp2 = br2.readLine()) != null){
                if(temp2.startsWith("##")){
                    
                }
                else if (temp2.startsWith("#")){
                    String [] temheader = temp2.split("\t");                   
                    for(int k = 9; k<temheader.length;k++){
                        headerName2.add(temheader[k]);
                    }
                }
                else{
                    String [] tembody = temp2.split("\t");                   
                    String marker =  tembody[1];
                    for(int n = 9;n<tembody.length;n++){
                        String key = headerName1.get(n-9) + "_" + marker;
                        hashMap1.put(key, tembody[n]);
                    }
                }                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
