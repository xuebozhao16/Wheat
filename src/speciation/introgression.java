/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciation;

import static EvolutionWheat.ForVcftoolsGroup.getTextReader;
import static EvolutionWheat.ForVcftoolsGroup.listFilesEndsWith;
import static EvolutionWheat.ForVcftoolsGroup.listRecursiveFiles;
import gnu.trove.list.array.TDoubleArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class introgression {
    public introgression(String infileS1,String infileS2,String outfileS){
        this.C27_mergeTwoVCFbycol(infileS1, infileS2, outfileS);
    }
    
    //这个方法是为了合并两个列相同的VCF的文件
    public void C27_mergeTwoVCFbycol(String infileS1,String infileS2,String outfileS){
        try {
            String temp = null;
            String temp2 = null;
            BufferedReader br1;
            BufferedReader br2;
            if (infileS1.endsWith("gz")) {
                br1 = IOUtils.getTextGzipReader(infileS1);
            } else {
                br1 = IOUtils.getTextReader(infileS1);
            }
            if (infileS2.endsWith("gz")) {
                br2 = IOUtils.getTextGzipReader(infileS2);
            } else {
                br2 = IOUtils.getTextReader(infileS2);
            }
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //开始读要加在后面的那个VCF的文件
            List<String> AE = new ArrayList<>();
            while((temp = br1.readLine())!= null){
                if(temp.startsWith("#")){
                    
                }else{
                   //System.out.println(temp);
                   String tem[] = temp.split("\t");
                   AE.add(tem[tem.length-1]);                          
                }
            }
            //开始读前面的那个VCF的文件
            int i = 0;
            while((temp2 = br2.readLine())!= null){
                if(temp2.startsWith("##")){
                    bw.write(temp2 + "\n");
                }
                else if (temp2.startsWith("#C")){
                   bw.write(temp2 + "\t" + "Ae" + "\n");             
                }
                else{
                    String AEhaplo = AE.get(i);
                    bw.write(temp2 + "\t" + AEhaplo + "\n");  
                    i = i+1;
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
