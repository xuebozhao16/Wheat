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
//        String infileS ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/xpclr/figures/AllpeciesA_10k.xpclr.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/xpclr/figures/AllspeciesA_10k.txt";
//        new ForVcftoolsGroup(infileS,outfileS);

        String infileS1 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/readmeByFei_table.txt";
        String infileS2 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/xpclr/figures/ABD_23_10k.xpclr.txt";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/xpclr/figures/ABD_23_10k.txt";
        new ForManhattanPlot(infileS1,infileS2,outfileS);
        
//        String infileS1 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/tree/Treefigures/itol/setcolor/color2/color2.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/group/group_tree";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/tree/Treefigures/itol/setcolor/color2/setrange.txt";
//        new ItolTreeParameters(infileS1,infileS2,outfileS);

//        String infileS1 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/tree/Treefigures/itol/setcolor/bincolor1/bincolor1.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/group/group_ABDsplit";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/tree/Treefigures/itol/setcolor/bincolor1/setbin1.txt";
//        new ItolTreeParameters(infileS1,infileS2,outfileS);



//        int len = args.length;
//        String infileS1 = "";
//        String infileS2 = "";
//        String outfileS = "";
//        for (int i = 0; i < len; i++){
//            if (null != args[i])switch (args[i]) {
//                case "--file1":
//                    infileS1 = args[i+1];
//                    i++;
//                    break;
//                case "--file2":
//                    infileS2 = args[i+1];
//                    i++;
//                    break;   
//                case "--out":
//                    outfileS = args[i+1];
//                    i++;
//                    break;
//                default:
//                    break;
//            }
//        }
//        new ItolTreeParameters(infileS1,infileS2,outfileS);     
    }
}
