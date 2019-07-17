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
//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/perimask/perimask5/positiveK5_hits_allNoadjusted001.bed";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/perimask/perimask5/K5Noadjusted001ForCircos.bed";       
//        new GetCircosBed (infileS,outfileS);
        



//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K9_K12/rangeblank.txt";       
//        new ForDensityPlot (outfileS);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K5_K8/rangeblank.txt";   
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K5_K8/K8/positiveK8_hits_allNoadjusted.bed";   
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K5_K8/K8/DebsityRange_8.txt";       
//        new ForDensityPlot (infileS1, infileS2, outfileS);
//        
   
//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K9_K12/bait_around/K12_100k.txt";   
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K9_K12/bait_around/K12_100k_site.txt";       
//        new ForDensityPlot (infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/TAIR10_GFF3_genes.gff";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/TAIR10_GFF3_onlyGene.txt";
//        new Tair10_gff3(infileS,outfileS);
        
        String infileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/TAIR10_GFF3_onlyGene.txt";
        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K5_K8/K8/positiveK8_hits_allNoadjusted.bed";
        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K5_K8/K8/positiveK8_allNoadjusted_gene.txt";
        new Tair10_gff3(infileS,outfileS1,outfileS2);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/TAIRGenome/TAIR10_GFF3_onlyGene.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K5_K8/K8/positiveK8_hits_allNoadjusted.bed";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/4C/4Cdata/Library/realproduct/K5_K8/K8/positiveK8_allNoadjusted_gene.txt";
//        new Tair10_gff3(infileS1,infileS2,outfileS);
        
    }
}
