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

//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Redundancy_selection/pi/pi_AB_cul5_gene.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Redundancy_selection/pi/AB_cul5_gene_NoDuplicates_pi.txt";
//        new Redundancy_selection(infileS,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulab1_1onlyGene.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Redundancy_selection/test15.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/Redundancy_selection/xpclr_AB_15_gene.txt";
//        new Redundancy_selection(infileS1,infileS2,outfileS);

        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/readmeByFei_table.txt";
        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/recom_rate/iwgscRefSeqv1RecombinationRate.txt";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/recom_rate/RecombinationRate_1M.txt";
        new RecombinationRate(infileS1,infileS2,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/synteny_site/test/test111111.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/permutation/synteny_site/test/test33333.txt";
//        new Synteny_site(infileS,outfileS);
        
        
        
        
        
        
        
        
    }
}
