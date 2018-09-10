/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline.cpScore;
import java.io.BufferedReader;
import utils.IOUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 *
 * @author Xuebo Zhao
 */
public class MeanScore {
    public static void main(String args[]) { 
        String outfileS = "D:\\zxb\\UniquenessScore\\temp\\Extract_chr10\\maizeAGOv4chr010_CpScore.txt";
        try {
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("D:\\zxb\\UniquenessScore\\temp\\Extract_chr10\\maize.txt");
            bw.flush();
            bw.close();
        }
        catch(Exception e) {
            e.printStackTrace(); 
        }  
    }  
}
