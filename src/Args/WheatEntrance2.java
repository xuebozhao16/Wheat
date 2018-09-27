/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Args;

import fasta.RNAseqDataCompare;
import fasta.SplitWheatABD1_1;
import gff3.LabNumChrGFF31_1;

/**
 *
 * @author xuebozhao
 */
public class WheatEntrance2 {
    public static void main(String args[]){
//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatRNA_seq/DataFromScience/TestDevelopment/Development_tpm.tsv";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatRNA_seq/DataFromScience/TestDevelopment/TPMfromScience209.txt";
//        new RNAseqDataCompare(infileS,outfileS);
      
//        String infileS1 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/TheABD.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/kallisto/TPMfromScience209.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/kallisto/Gene111209.txt";
//        new RNAseqDataCompare(infileS1,infileS2,outfileS);
        
//        String infileS1 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/TheAB0olny_AB.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/TheA0Dolny_AD.txt";
//        String infileS3 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/The0BDolny_BD.txt";
//        String infileS4 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/kallisto/TPMfromScience209.txt";      
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/kallisto/GeneAdd0209.txt";
//        new RNAseqDataCompare(infileS1, infileS2, infileS3, infileS4, outfileS);
        
//        String infileS1 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/ABD1To1ToN_AN.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/ABD1To1ToN_BN.txt";
//        String infileS3 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/ABD1ToNTo1_AN.txt";
//        String infileS4 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/ABD1ToNTo1_DN.txt";
//        String infileS5 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/ABDNTo1To1_BN.txt";
//        String infileS6 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/ABDNTo1To1_DN.txt";   
//        String infileS7 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/kallisto/TPMfromScience209.txt";      
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/DiffgroupRNA_seq/kallisto/GeneAddNNN209.txt";
//        new RNAseqDataCompare(infileS1, infileS2, infileS3, infileS4, infileS5, infileS6, infileS7, outfileS);
        
//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/IWGSC_v1.1_HC_20170706.gtf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulabNoUn1_1.gtf";
//        new LabNumChrGFF31_1(infileS,outfileS);

        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/IWGSC1_1/IWGSC_v1.1_HC_20170706_pep.fasta";
        //String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/CDSAll1_1.fasta";
        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/pep1_1SplitA.fasta";
        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/pep1_1SplitB.fasta";
        String outfileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/pep1_1SplitD.fasta";
        new SplitWheatABD1_1(infileS,outfileS1,outfileS2,outfileS3);

    }
}
