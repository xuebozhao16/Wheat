/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Args;

import EvolutionWheat.Countsnp;
import EvolutionWheat.Filefolder_pip;
import EvolutionWheat.ForManhattanPlot;
import EvolutionWheat.Redundancy_selection;
import EvolutionWheat.XPCLR_intersection;
import EvolutionWheat.XPEHHandXPCLRregion;
import EvolutionWheat.fd_individual;
import EvolutionWheat.top1_XPCLRandPi;
import fasta.wheatFastaToAppend;
import fasta.parralleFas;
import fasta.vcf2fasta;
import gff3.wheatkgfTo42map;
import speciation.BWA;
import speciation.GO_analysis;
import speciation.IBS_distance;
import speciation.geneTree;
import speciation.introgression;
import speciation.split_time;
import speciation.syntenic_Sgenome;
import speciation.tree;
import speciation.vcf_QualityControl;
import vcf.CompareTwoVCFfile;
import vcf.RandomLine;

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
        String infileS3 = "";
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
//                case "--file3":
//                    infileS3 = args[i+1];
//                    i++;
//                    break;  
                case "--out":
                    outfileS = args[i+1];
                    i++;
                    break;
                default:
                    break;
            }
        }
        //new Redundancy_selection(infileS1,infileS2,outfileS);   
        //new Filefolder_pip(infileS1,infileS2,outfileS);  
        //new BWA(infileS1,infileS2,outfileS);
        //new syntenic_Sgenome(infileS1,infileS2,outfileS);
        //new syntenic_Sgenome(infileS1,outfileS);
        //new syntenic_Sgenome(infileS1,infileS2,infileS3,outfileS);
        //new tree(infileS1,outfileS);
        //new tree(infileS1,infileS2,infileS3,outfileS);
        //new tree(infileS1,infileS2,outfileS);
        //new CompareTwoVCFfile(infileS1,infileS2,outfileS);
        //new geneTree(infileS1,infileS2,outfileS);
        //new geneTree(infileS1,outfileS);
        //new ForManhattanPlot(infileS1,infileS2,outfileS);
        //new introgression(infileS1,infileS2,outfileS);
        //new top1_XPCLRandPi(infileS1,infileS2,outfileS);
        //new XPEHHandXPCLRregion(infileS1,infileS2,outfileS);
        //new XPCLR_intersection(infileS1,infileS2);
        //new RandomLine(infileS1,infileS2,outfileS);
        //new Countsnp(infileS1,infileS2,outfileS);
        //new fd_individual(infileS1,infileS2,infileS3,outfileS);
        //new vcf_QualityControl(infileS1,infileS2,outfileS);
        //new vcf2fasta(infileS1,outfileS);
        //new split_time (infileS1,infileS2,outfileS);
        //new IBS_distance(infileS1,infileS2,outfileS);
        //new IBS_distance(infileS1,outfileS);
        //new GO_analysis(infileS1,infileS2,outfileS);
        new syntenic_Sgenome(infileS1,infileS2,outfileS);
    }
}
