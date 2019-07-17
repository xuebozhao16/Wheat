/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vcf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class NewTaxafile {
    public NewTaxafile(String infileS,String outfielS){
        //this.getNewTaxafile(infileS, outfielS);
        //this.getNewTaxafileV2(infileS, outfielS);
        //this.getNewTaxafileV12(infileS, outfielS);
        this.getNewTaxafileV11(infileS, outfielS);
    }
    public NewTaxafile(String outfielS){
        this.getNewTaxafile_TaxaRefBam(outfielS);
    }
    public void getNewTaxafile(String infileS,String outfileS){
        try {            
            BufferedWriter bw = null;
            String temp = "";
            String[] te = null;          
            for(int i = 1; i < 43;i++ ){
                BufferedReader br = IOUtils.getTextReader(infileS);
                int line = 1;
                bw = IOUtils.getTextWriter(outfileS+"/parameters_hapScanner2_chr"+i+".txt");
                while((temp = br.readLine())!=null){
                    if(line==9){
                        bw.write("/data2/yaozhou/bam/TaxaRefBam/TaxaRefBamChr"+i);
                        bw.newLine();
                    }else if(line==11){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V7/posAllele/chr"+i+".allele.txt");
                        bw.newLine();
                    }
                    else if(line==13){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V7/hapPos/chr"+i+".pos.txt");
                        bw.newLine();
                    }
                    else if(line==15){
                        bw.write(Integer.toString(i));
                        bw.newLine();
                    }else if(line==21){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V7/outchr"+i);
                        bw.newLine();
                    }else{
                        bw.write(temp);
                        bw.newLine();
                    }
                    line++;
                }
                bw.flush();
                bw.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NewTaxafile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //这是对V2进行的操作
    public void getNewTaxafileV2(String infileS,String outfileS){
        try {            
            BufferedWriter bw = null;
            String temp = "";
            String[] te = null;          
            for(int i = 1; i < 43;i++ ){
                BufferedReader br = IOUtils.getTextReader(infileS);
                int line = 1;
                bw = IOUtils.getTextWriter(outfileS+"/parameters_hapScanner2_chr"+i+".txt");
                while((temp = br.readLine())!=null){
                    if(line==9){
                        bw.write("/data2/yaozhou/bam/TaxaRefBam/TaxaRefBamChr"+i);
                        bw.newLine();
                    }else if(line==11){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V2/hapScan/posAllele/chr"+i+".allele.txt");
                        bw.newLine();
                    }
                    else if(line==13){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V2/hapScan/hapPos/chr"+i+".pos.txt");
                        bw.newLine();
                    }
                    else if(line==15){
                        bw.write(Integer.toString(i));
                        bw.newLine();
                    }else if(line==21){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V2/hapScan/outchr"+i);
                        bw.newLine();
                    }else{
                        bw.write(temp);
                        bw.newLine();
                    }
                    line++;
                }
                bw.flush();
                bw.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NewTaxafile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //这是Scanner对V12进行的操作
    public void getNewTaxafileV12(String infileS,String outfileS){
        try {            
            BufferedWriter bw = null;
            String temp = "";
            String[] te = null;          
            for(int i = 1; i < 43;i++ ){
                BufferedReader br = IOUtils.getTextReader(infileS);
                int line = 1;
                bw = IOUtils.getTextWriter(outfileS+"/parameters_hapScanner12_chr"+i+".txt");
                while((temp = br.readLine())!=null){
                    if(line==9){
                        bw.write("/data2/yaozhou/bam/TaxaRefBam/TaxaRefBamChr"+i);
                        bw.newLine();
                    }else if(line==11){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V12/hapScan/posAllele/chr"+i+".allele.txt");
                        bw.newLine();
                    }
                    else if(line==13){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V12/hapScan/hapPos/chr"+i+".pos.txt");
                        bw.newLine();
                    }
                    else if(line==15){
                        bw.write(Integer.toString(i));
                        bw.newLine();
                    }else if(line==21){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V12/hapScan/outchr"+i);
                        bw.newLine();
                    }else{
                        bw.write(temp);
                        bw.newLine();
                    }
                    line++;
                }
                bw.flush();
                bw.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NewTaxafile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //这是Scanner对V1进行的操作
    public void getNewTaxafileV11(String infileS,String outfileS){
        try {            
            BufferedWriter bw = null;
            String temp = "";
            String[] te = null;          
            for(int i = 1; i < 43;i++ ){
                BufferedReader br = IOUtils.getTextReader(infileS);
                int line = 1;
                bw = IOUtils.getTextWriter(outfileS+"/parameters_hapScanner11_chr"+i+".txt");
                while((temp = br.readLine())!=null){
                    if(line==9){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V11/ori/hapScan/TaxaRefBam/TaxaRefBamChr"+i);
                        bw.newLine();
                    }else if(line==11){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V11/ori/hapScan/posAllele/chr"+i+".allele.txt");
                        bw.newLine();
                    }
                    else if(line==13){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V11/ori/hapScan/hapPos/chr"+i+".pos.txt");
                        bw.newLine();
                    }
                    else if(line==15){
                        bw.write(Integer.toString(i));
                        bw.newLine();
                    }else if(line==21){
                        bw.write("/data1/home/yaozhou/Projects/EVO/data/lineage/final/V11/ori/hapScan/outchr"+i);
                        bw.newLine();
                    }else{
                        bw.write(temp);
                        bw.newLine();
                    }
                    line++;
                }
                bw.flush();
                bw.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NewTaxafile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //这是Scanner产生taxa文件进行的操作
    public void getNewTaxafile_TaxaRefBam(String outfileS){
        try {            
            BufferedWriter bw = null;
            String temp = "";
            String[] te = null;          
            for(int i = 1; i < 43;i++ ){                
                bw = IOUtils.getTextWriter(outfileS+"/TaxaRefBamChr"+i);
                bw.write("Taxa" + "\t" + "Reference" + "\t" + "BamPath" + "\n");
                bw.write("barley" + "\t" + "/data1/home/yaozhou/data/ref/wheat/genome/num/abd_iwgscV1.fa" + "\t" + 
                                "/data1/home/yaozhou/data/ref/wheat/genome/outgroup/bwa/barley/chr"+i+".sorted.bam" + "\n");
                bw.write("Ae" + "\t" + "/data1/home/yaozhou/data/ref/wheat/genome/num/abd_iwgscV1.fa" + "\t" + 
                                "/data1/home/yaozhou/data/ref/wheat/genome/outgroup/bwa/Ae/chr"+i+".sorted.bam" + "\n");
                bw.write("Tu" + "\t" + "/data1/home/yaozhou/data/ref/wheat/genome/num/abd_iwgscV1.fa" + "\t" + 
                                "/data1/home/yaozhou/data/ref/wheat/genome/outgroup/bwa/Tu/chr"+i+".sorted.bam" + "\n");
                bw.flush();
                bw.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NewTaxafile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
