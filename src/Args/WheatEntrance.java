/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Args;

import fasta.OneToManyInWheat;
import fasta.SplitWheatABD;
import fasta.TheReciprocalBestBLASTHit;
import gff3.LabNumChrGFF31_1;
import gff3.WheatNewGeneFeature;

/**
 *
 * @author xuebozhao
 */
public class WheatEntrance {
    public static void main(String args[]) {
        String infile = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/IWGSC1_1/IWGSC_v1.1_HC_20170706.gtf";
        String outfile = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulab1_1.gtf";
        new LabNumChrGFF31_1(infile, outfile);
        
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/GeneFeature/AllCDSsequence.fa";
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/SplitABD_pseudogenome/SplitSubGenomeA.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/SplitABD_pseudogenome/SplitSubGenomeB.txt";
//        String infileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/SplitABD_pseudogenome/SplitSubGenomeD.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/GeneFeature/SplitCDSA.fa";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/GeneFeature/SplitCDSB.fa";
//        String outfileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/GeneFeature/SplitCDSD.fa";
//        new SplitWheatABD(infileS,infileS1,infileS2,infileS3,outfileS1,outfileS2,outfileS3);
        
//        String infile = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/crb_blastBD.tsv";
//        String outfile = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/";
//        new OneToManyInWheat(infile, outfile);
        
        
//        String infile = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterSortN/sortfilterDB_N.txt";
//        String outfile = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterSortN/DB_N.txt";
//        new OneToManyInWheat(infile, outfile);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterAB_1.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterBA_1.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/ReciprocalABBA.txt";
//        new OneToManyInWheat(infileS1, infileS2, outfileS);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/ReciprocalABBA.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/ReciprocalADDA.txt";
//        String infileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/ReciprocalBDDB.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/TheA0D.txt";
//        new TheReciprocalBestBLASTHit(infileS1,infileS2,infileS3,outfileS1);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/ReciprocalADDA.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterSortN/BA_N.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterSortN/get1ToNTo1step1gene.txt";
//        new OneToManyInWheat(infileS1,infileS2,outfileS1);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterSortN/get1ToNTo1step1gene.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterSortN/BD_N.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterSortN/get1ToNTo1step2.txt";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/filterSortN/get1ToNTo1step2gene.txt";
//        new OneToManyInWheat(infileS1,infileS2,outfileS1,outfileS2);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/WheatHomeologousGenes.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/NumNoUnKGF1_1.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/lineD.txt";
//        new TheReciprocalBestBLASTHit(infileS1,infileS2,outfileS);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/ABDN11/ABDNTo1To1.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/The0BD.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/The0BDolny.txt";
//        new OneToManyInWheat(infileS1,infileS2,outfileS1);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulabNoUn1_1.gff3";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/NumNoUnKGF1_1.txt";
//        new WheatNewGeneFeature (infileS ,outfileS);
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/ABDNTo1To1gene.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/ABDNTo1To1gene2.txt";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/ABDNTo1To1_AN.txt";
//        String outfileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/ABDNTo1To1_BN.txt";
//        new OneToManyInWheat(infileS, outfileS1, outfileS2, outfileS3);
         
    }
}
