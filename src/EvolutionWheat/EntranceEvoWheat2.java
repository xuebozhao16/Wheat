/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

/**
 *
 * @author xuebozhao
 */
public class EntranceEvoWheat2 {
    public static void main(String args[]){
//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/AB_cul5_10k.Sortxpclr.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Redundancy_selection/xpclr_recom_rate/xpclr_AB_cul5_region.txt";
//        new Redundancy_selection(infileS,outfileS);

//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/allgeneXPCLRscore/recom20Mxp_ABD_gene.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/allgeneXPCLRscore/xp_ABD_geneScore.txt";
//        new Redundancy_selection(infileS,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulab1_1onlyGene.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/top5/ABD_small_top5.xpclr.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/XPCLR_recom_rate/norm20M_10k/top5/XPscore_ABD_small.txt";
//        new Redundancy_selection(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/readmeByFei_table.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/recom_rate/iwgscRefSeqv1RecombinationRate.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/recom_rate/RecombinationRate_1M.txt";
//        new RecombinationRate(infileS1,infileS2,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/recom_rate/RecombinationRate_1M_head.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/recom_rate/slidewindow_recomrate_updown_50M.txt";
//        new RecombinationRate(infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/synteny_site/test/test111111.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/synteny_site/test/test33333.txt";
//        new Synteny_site(infileS,outfileS);
        
        
        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/tree/Treefigures/itol/setcolor/bin_lacation1/location2_5.txt";
        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/group/germplasm/location_420.txt";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/tree/Treefigures/itol/setcolor/bin_lacation1/set_location3.txt";
        new ItolTreeParameters3_forNumSpecies(infileS1,infileS2,outfileS);
//        
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/group/group_tree2";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/tree/Treefigures/itol/setcolor/color3_Numcircos/setbranch_add3.txt";
//        new ItolTreeParameters3_forNumSpecies(infileS,outfileS);
        
        
    }
}
