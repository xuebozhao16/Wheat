/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline.cpScore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import utils.IOUtils;

/**
 *
 * @author Xuebo Zhao
 */
public class Test2 {
        private static String outFolder;
        public static void main(String[] args) throws IOException {
                  File file1 = new File("D:\\zxb\\UniquenessScore\\temp\\Extract_chr10\\test.txt");
                  BufferedReader br1 = new BufferedReader(new FileReader(file1));
                  BufferedWriter bw = IOUtils.getTextWriter(outFolder);
                  String str1 = null;
                  str1 = br1.readLine();
                    char[] a = new char[str1.length()];
                    a = str1.toCharArray();
                try{
                while(true){
                    if (str1 == null){
                    break;
                    }
                    if ("CpScore".equals(str1)){
                        bw.write("CpScore\n");
                    }else if("NA".equals(str1)){
                        bw.write("NA\n");
                    }else{
                    for(int j = 1; j < str1.length(); j++){
                         if(a[j] > 0.8 && a[j] <1.2)
                    
                         System.out.println(j);
                         System.out.println(a[j]);
                    }
                    }
                }
        String outfileS = null;
        bw.write("D:\\zxb\\UniquenessScore\\data\\maize.test");
        bw.flush();
        bw.close();
        }
        catch (Exception e) {
        e.printStackTrace();
	}
    }
}


