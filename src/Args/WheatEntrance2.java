/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Args;

import EvolutionWheat.ForVcftoolsGroup;
import EvolutionWheat.ForHeatmap;
import EvolutionWheat.XPCLR_intersection;
import EvolutionWheat.XPEHHandXPCLRregion;
import fasta.RNAseqDataCompare;
import fasta.SplitWheatABD1_1;
import gff3.LabNumChrGFF31_1;
import xuebo.analysis.data4CandChIA_PET.Tair10_gff3;

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
        

//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/NumNoUnKGF1_1.txt";
//        //String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/CDSAll1_1.fasta";
//        String infileS1 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/SplitSubGenomeA.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/SplitSubGenomeB.txt";
//        String infileS3 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/SplitSubGenomeD.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/NumNoUnKGF1_1_A.txt";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/NumNoUnKGF1_1_B.txt";
//        String outfileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/NumNoUnKGF1_1_D.txt";
//        new SplitWheatABD1_1(infileS,infileS1,infileS2,infileS3,outfileS1,outfileS2,outfileS3);


//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/top5/AB_cul5_top5.xpclr.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/top5/AB_cul5_top5_region.txt";
//        new XPEHHandXPCLRregion(infileS,outfileS);
        
//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR/max_milli/AB_cul5_milli.xpclr.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR/max_milli/AB_cul5_milli.txt";
//        new XPEHHandXPCLRregion(infileS,outfileS);

//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/tb1gene/snp_V10/chr23_tb1_D.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/tb1gene/snp_V10/tb1_D.txt";
//        new ForHeatmap(infileS,outfileS);
//        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/cooperation_fu/OTUB1/haplogroup/mac_chr39_TraesCS7B02G161900_2K_4_6.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/cooperation_fu/OTUB1/haplogroup/chr39_TraesCS7B02G161900_2K_4_6.txt";
//        new ForHeatmap(infileS,outfileS);
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/cooperation_fu/Crispr_gene/TraesCS5A02G233700/indel/mac_WD_ABinel.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/cooperation_fu/Crispr_gene/TraesCS5A02G233700/indel/mac_WD_ABinel.txt";
//        new ForHeatmap(infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/6A/260M_430M_200_sort.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/6A/260M_430M_200_sort.txt";
//        new ForHeatmap(infileS,outfileS);
     
        //String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/xpclr_region/textgene.txt";
        /////////region to gene *********************************
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulab1_1onlyGene.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/negative_control_A_AB/A_AB_top5.xpclr.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/negative_control_A_AB/top5_A_AB_gene.txt";
//        new XPEHHandXPCLRregion(infileS1,infileS2,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/mart_export.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/top5/GO/Go_gene_G0slim.csv";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/top5/GO/Go_annotation_GOslim.csv";
//        new XPEHHandXPCLRregion(infileS,outfileS1,outfileS2);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/dom_related_genes/maize_rice_ortho/rice/rice_TaA.genes";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/mart_export.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/dom_related_genes/maize_rice_ortho/rice/dom_rice_Go_gene_onlyGO.csv";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/dom_related_genes/maize_rice_ortho/rice/dom_rice_Go_annotation_onlyGO.csv";
//        String outfileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/dom_related_genes/maize_rice_ortho/rice/dom_rice_gene_onlyGO.csv";
//        new XPEHHandXPCLRregion(infileS1,infileS2,outfileS1,outfileS2,outfileS3);
        
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/xpclr_region/2kNew/A_gene.csv";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/Rice_subA/Rice_subA.txt";
//        String infileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/xpclr_region/KEGG/rice_id_20140620174522.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/xpclr_region/2kNew/A_Rice_gene.txt";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/xpclr_region/2kNew/A_Rice_ID.txt";
//        new XPEHHandXPCLRregion(infileS1,infileS2,infileS3,outfileS1,outfileS2);
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/mart_export.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/pi/functional_pi/bioticgene.txt";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/pi/functional_pi/abioticgene.txt";
//        String outfileS3 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/pi/functional_pi/backgroudgene.txt";
//        new XPEHHandXPCLRregion(infileS,outfileS1,outfileS2,outfileS3);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulab1_1onlyGene.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/negative_control_DurumCul/DurumCul_topmili_1.xpclr.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/negative_control_DurumCul/topmili_1_DurumCul_gene.txt";
//        new XPEHHandXPCLRregion(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/NoOverlap/top5/top5_AB_45_gene_NoOverlap.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/NoOverlap/top5/top5_ABD_small_gene_NoOverlap.txt";
//        new XPCLR_intersection(infileS1,infileS2);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/per_gene/neg3_DurumCul1024/nohupneg3_top1";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/per_gene/neg3_DurumCul1024/neg3_DurumCul_top1.txt";
//        new XPCLR_intersection(infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/per_gene/neg2_WW_WDemmer/nohupneg2_topmili_1";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/per_gene/neg2_WW_WDemmer/neg2_WW_WDemmer_topmili_1.txt";
//        new XPCLR_intersection(infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/lostruct/test_block/Haplo_chr5_104_105M_ABD.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/lostruct/test_block/Haplo_chr5_104_105M_ABD.txt";
//        new ForHeatmap(infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/cooperation_fu/Rht/mac_chr23_TraesCS4D02G040400_2K_2_6.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/cooperation_fu/Rht/mac_chr23_TraesCS4D02G040400_2K_2_6.txt";
//        new ForHeatmap(infileS,outfileS);

        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/emmer_intro/fd_4B_emmer1_200_350M_shuf5000.vcf";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/emmer_intro/fd_4B_emmer1_200_350M_shuf5000.txt";
        new ForHeatmap(infileS,outfileS);

    }
}