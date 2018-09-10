/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline.cpScore;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import static java.lang.Integer.sum;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import utils.IOUtils;

/**
 *
 * @author Xuebo Zhao
 */
public class Test1 {
    private static String outFolder;
    public static void main(String[] args) throws IOException{
        File file1 = new File("D:\\zxb\\UniquenessScore\\temp\\Extract_chr10\\test\\test1");
        File file2 = new File("D:\\zxb\\UniquenessScore\\temp\\Extract_chr10\\test\\test2");
            BufferedReader aFile = IOUtils.getTextReader(file1);
            BufferedReader bFile = IOUtils.getTextReader(file2);

        BufferedWriter bw = IOUtils.getTextWriter(outFolder);
        while(true){
            String acontent = aFile.readLine();
            String bcontent = bFile.readLine();
                
            if (acontent == null){
                    break;
                }
            try{
                    if ("CpScore".equals(acontent)){
                        bw.write("CpScore\n");
                    }else if("NA".equals(acontent)|"NA".equals(bcontent))
                            {
                        bw.write("NA\n");
                    }else{
                        double meanScore = Double.parseDouble(acontent) + Double.parseDouble(bcontent)  ;
                        meanScore = meanScore/2;
                        bw.write(Double.toString(meanScore)+"\n");
                    }
                    bw.write("D:\\zxb\\UniquenessScore\\temp\\Extract_chr10\\test\\learing");
                    bw.flush();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
             } 
             bw.close();
        }
}   
   

