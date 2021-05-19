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
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */

//这个方法是比较两个VCF文件的差异，只是比较两个文件的REF和ALT，看一下合并之后的基因组和合并之前的基因组的差别
//	java -jar -Xms40g -Xmx70g /data1/home/xuebo/Projects/Speciation/javaCode/CompareTwoVCFfile.jar --file1 /data1/home/xuebo/Projects/Speciation/syntenic_Sgenome/mergedVCF_withV11/E1.chr${chr}.vcf \
//	--file2 /data1/home/xuebo/Projects/Evo/xpclr/lineage/V11/chr${chr}.vcf.gz --out /data1/home/xuebo/Projects/Speciation/syntenic_Sgenome/mergedVCF_withV11/diff_chr${chr}.txt &

public class CompareTwoVCFfile {
    public CompareTwoVCFfile(String infileS1,String infileS2,String outfileS){
        this.getCompare(infileS1,infileS2,outfileS);
    }
    public void getCompare(String infileS1,String infileS2,String outfileS){
        try{
            BufferedReader br1;
            BufferedReader br2;
            String temp1,temp2;
            int countNOmatch = 0;
            int countMiss = 0;
            String chr = null;
            //List<String> headerName1 = new ArrayList<String>();
            //List<String> headerName2 = new ArrayList<String>();
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            if (infileS1.endsWith("gz")) {
                br1 = IOUtils.getTextGzipReader(infileS1);
                //br2 = IOUtils.getTextGzipReader(infileS2);
            } else {
                br1 = IOUtils.getTextReader(infileS1);
                //br2 = IOUtils.getTextReader(infileS2);
            }
            if (infileS2.endsWith("gz")) {
                br2 = IOUtils.getTextGzipReader(infileS2);
                //br2 = IOUtils.getTextGzipReader(infileS2);
            } else {
                br2 = IOUtils.getTextReader(infileS2);
                //br2 = IOUtils.getTextReader(infileS2);
            }
            //现在读的是合并之后的vcf文件
            while((temp1 = br1.readLine()) != null){
                if(temp1.startsWith("#")){
                    
                }else{
                    String [] tem = temp1.split("\t");         
                    chr = tem[0];
                    String value = tem[3]+ "_" + tem[4].substring(0, 1);
                    hashMap1.put(tem[1], value);      
                }                          
            }
            System.out.println(hashMap1.size());
            //现在读的是V11里面的SNP信息
            while((temp2 = br2.readLine()) != null){
                if(temp2.startsWith("#")){
                    
                }else{
                    String [] temm = temp2.split("\t");                   
                    String site = temm[1];
                    String Info = temm[3]+ "_" + temm[4];
                    if(hashMap1.get(site) != null){
                        String oriInfo = hashMap1.get(site);
                        if(Info.equals(oriInfo)){
                            
                        }else{
                            countNOmatch = countNOmatch + 1;
                            System.out.println(site + "\t" + Info + "\n");
                        }
                    }else{
                        countMiss = countMiss + 1;
                    }
                }                
            }
            bw.write(chr + "\t" + countNOmatch + "\t" + countMiss + "\n");
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
