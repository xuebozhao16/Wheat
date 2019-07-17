/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Args;

import EvolutionWheat.Filefolder_pip;
import EvolutionWheat.Redundancy_selection;
import EvolutionWheat.XPEHHandXPCLRregion;
import fasta.wheatFastaToAppend;
import fasta.parralleFas;
import gff3.wheatkgfTo42map;

/**
 *
 * @author xuebozhao
 */
public class GetWheatCDSsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int len = args.length;
//        String inFile = "";
//        String gffFile ="";
//        String outFile ="";
//        for (int i = 0; i < len; i++){
//            if (null != args[i])switch (args[i]) {
//                case "--file":
//                    inFile = args[i+1];
//                    i++;
//                    break;
//                case "--gff3":
//                    gffFile = args[i+1];   
//                    i++;
//                    break;
//                case "--out":
//                    outFile = args[i+1];
//                    i++;
//                    break;
//                default:
//                    break;
//            }
//        }
//        if(outFile.equals("")) {
//            System.out.println("outFile is missing!");
//            outFile = inFile;
//        }
////        new kgf().readKgf(gffFile);
//        wheatFastaToAppend A = new wheatFastaToAppend(inFile);
//        new parralleFas(A).getParralle(outFile, gffFile);


        int len = args.length;
        String infileS1 = "";
        String infileS2 = "";
        String outfileS = "";
        for (int i = 0; i < len; i++){
            if (null != args[i])switch (args[i]) {
                case "--file1":
                    infileS1 = args[i+1];
                    i++;
                    break;
                case "--file2":
                    infileS2 = args[i+1];
                    i++;
                    break;   
                case "--out":
                    outfileS = args[i+1];
                    i++;
                    break;
                default:
                    break;
            }
        }
        new Redundancy_selection(infileS1,infileS2,outfileS);   
        //new Filefolder_pip(infileS1,infileS2,outfileS);  
    }
}
