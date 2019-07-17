/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vcf;


/**
 *
 * @author xuebozhao
 */
public class EntranceVcf {
    public static void main(String args[]){
        //String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatScan/hapScanner2/V2_Parameters_hapScanner2_chr1.txt";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatScan/hapScanner2/TaxaRefBam_V11";
        new NewTaxafile(outfileS);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3A/wheat_Btr1_3A.fa";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3B/btr1_3B_all.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3A/wheat_Btr11111.fasta";
//        new vcf2fasta(infileS1,infileS2,outfileS);
        
//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/figures/Btr1/Btr1_all_mega.fas";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/figures/Btr1/Btr1_all_mega1.fas";
//        new vcf2fasta(infileS,outfileS);
          
//        int len = args.length;
//        String infileS = "";
//        String outfileS ="";
//        Integer n = 0; 
//        for (int i = 0; i < len; i++){
//            if (null != args[i])switch (args[i]) {
//                case "--file":
//                    infileS = args[i+1];
//                    i++;
//                    break;
//                case "--num":
//                    n = Integer.valueOf(args[i+1]);
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
//        //new SplitGenome(infileS,outfileS);
//        new RandomLine(infileS,n,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/snp/chr15btr1_5K.heatmap.nobeagle.vcf";
//        int n = 50;
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/snp/111.txt";
//        new RandomLine(infileS,n,outfileS);
    }
}
