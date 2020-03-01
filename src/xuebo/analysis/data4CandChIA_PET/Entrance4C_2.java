/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo.analysis.data4CandChIA_PET;

/**
 *
 * @author xuebozhao
 */
public class Entrance4C_2{
    public static void main (String[] args) {
//        
//        String infileS = "/Users/xuebozhao/Documents/4Cdata/Library/addL23567.sorted.bed";
//        String outfileS = "/Users/xuebozhao/Documents/4Cdata/Library/addL23567_Filtering.txt";
////        new FirstStatistics(infileS,outfileS);
//        new FilteringBed(infileS,outfileS);
////        new BedUnSorted(infileS,outfileS);
//      

//        String infileS = "/Users/xuebozhao/Documents/4Cdata/Library/C4_L7.bed";
//        String outfileS = "/Users/xuebozhao/Documents/4Cdata/Library/C4_L7_BedUnSorted.txt";
////        new FirstStatistics(infileS,outfileS);
////        new FilteringBed(infileS,outfileS);
//        new BedUnSorted(infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIR10_chr_all.fas";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/SplitTAIR10chr4.fas";
////        new FirstStatistics(infileS,outfileS);
//        new Cheakdata (infileS,outfileS);
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/Chr5_rm.long.fas";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/Chr5ReplacePericentromere_rm.long.fas";
////        new FirstStatistics(infileS,outfileS);
//        new GetArabMaskedGenome (infileS,outfileS);
//        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K5_K8/K5/positiveK5_hits_allFdr01.bed";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/circos/K5link.txt";       
//        new GetCircosBed (infileS,outfileS);
//        



//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K9_K12/rangeblank.txt";       
//        new ForDensityPlot (outfileS);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K5_K8/rangeblank.txt";   
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K13_K16/K16/positiveK16_hits_allNoadjusted.bed";   
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K13_K16/K16/DebsityRange_16.txt";       
//        new ForDensityPlot (infileS1, infileS2, outfileS);
//        
   
//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K9_K12/bait_around/K12_100k.txt";   
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K9_K12/bait_around/K12_100k_site.txt";       
//        new ForDensityPlot (infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/Arabidopsis_thaliana.TAIR10.44.gff3";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/Arabidopsis_thaliana.TAIR10.44.onlyGene.gff3";
//        new Tair10_gff3(infileS,outfileS);
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/TAIR10_GFF3_onlyGene.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/TAIR10_GFF3_upstream2K.txt";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/TAIR10_GFF3_downstream2K.txt";
//        new Tair10_gff3(infileS,outfileS1,outfileS2);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/TAIR10_GFF3_onlyGene.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K13_K16/K13/positiveK13_hits_allNoadjusted.bed";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K13_K16/K13/Gene_K13.txt";
//        new Tair10_gff3(infileS1,infileS2,outfileS);
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/coverage/C_all.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/chromosomal_architecture/Distance_chr2WUS.txt";
//        new DistancsReads(infileS,outfileS);

        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K13_K16/K16/positiveK16_hits_allFdr01.bed";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/Draft/interact_site/leaf/leafD_Fdr01.txt";       
        new GetCircosBed (infileS,outfileS);
    }
}
