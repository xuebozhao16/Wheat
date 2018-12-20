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
public class EntranceEvoWheat {
    public static void main(String args[]){
        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/xpclr/figures/AllpeciesA_10k.xpclr.txt";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/xpclr/figures/AllspeciesA_10k.txt";
        new ForVcftoolsGroup(infileS,outfileS);
        
//        String infileS1 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/xpclr/XPCLRresult/xpclrSpeciesAB_45chr26.xpclr.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/xpclr/XPCLRresult/xpclrSpeciesAB_45chr27.xpclr.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/xpclr/figures/SpeciesAB_45_5A.txt";
//        new ForVcftoolsGroup(infileS1,infileS2,outfileS);
    }
}
