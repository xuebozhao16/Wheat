/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */ //这个代码是为了处理画树的代码
public class tree {
    public tree(String outfile){
        this.gethapScan_barley_taxaBAMfile(outfile);
    }
    
    public tree(String infileS,String outfileS){
        //this.getwithBarleyVCF(infileS, outfileS);
        this.cutALTblank(infileS, outfileS);
    }
    
    //这个代码是为了获得barley做outgroup，把barley做scan,得到barley的VCF文件，之后使用BCFtools合并起来
    //barley的bam文件是分染色体的
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatScan/hapScanner2/Parameters_hapScanner2_chr1.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/tree/parameters_file";
//        new syntenic_Sgenome(infileS,outfileS);
    
    public void gethapScan_barley_taxaBAMfile(String outfileS){
        try {            
            BufferedWriter bw = null;
            String[] te = null;          
            for(int i = 1; i < 43;i++ ){                
                bw = IOUtils.getTextWriter(outfileS+"/TaxaRefBamChr"+i);
                bw.write("Taxa" + "\t" + "Reference" + "\t" + "BamPath" + "\n");
                bw.write("barley" + "\t" + "/data1/home/xuebo/Project/reference/abd_iwgscV1.fa.gz" + "\t" + 
                                "/data2/xuebo/Projects/Speciation/tree/barleybam/chr"+i+".sorted.bam" + "\n");
                bw.flush();
                bw.close();
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是为了row_chr.withBarley.vcf里面barley是./.的去掉
    public void getwithBarleyVCF(String infileS,String outfileS){
        try {
            String temp = null;
            BufferedReader br;
            if (infileS.endsWith("gz")) {
                br = IOUtils.getTextGzipReader(infileS);
            } else {
                br = IOUtils.getTextReader(infileS);
            }
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //现在开始读VCF文件
            while((temp = br.readLine())!= null){
                if(temp.startsWith("#")){
                    bw.write(temp + "\n");
                }else{
                   String tem[] = temp.split("\t");
                   String barleyhaplo = tem[tem.length-1].split(":")[0];
                   if(barleyhaplo.equals("./.")){
                       
                   }else{
                       bw.write(temp + "\n");
                   }                             
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //这个方法的目的是去掉/data2/xuebo/Projects/Speciation/tree/barleybam/scan_barley_vcf 里面的一个空格，这里面原来是两个空格的
    ///data2/xuebo/Projects/Speciation/E2_all/chr${chr}.all.vcf.gz 因为这个里面是有一个空格的，这样都有一个空格才可以merge起来
    public void cutALTblank(String infileS,String outfileS){
        try {
            String temp = null;
            BufferedReader br;
            if (infileS.endsWith("gz")) {
                br = IOUtils.getTextGzipReader(infileS);
            } else {
                br = IOUtils.getTextReader(infileS);
            }
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //现在开始读VCF文件
            while((temp = br.readLine())!= null){
                if(temp.startsWith("#")){
                    bw.write(temp + "\n");
                }else{
                   String tem[] = temp.split("\t");
                   //String cutALTblank = tem[4].substring(0, 2); //这个方法的目的是去掉/data2/xuebo/Projects/Speciation/tree/barleybam/scan_barley_vcf 里面的一个空格，这里面原来是两个空格的
                   String cutALTblank = tem[4].substring(0, 1); //这个方法的目的是去掉/data2/xuebo/Projects/Speciation/E3/haveBlank 里面的空格，得到标准的E3文件
                   temp = temp.replace(tem[4], cutALTblank);
                   bw.write(temp + "\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
