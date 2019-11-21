/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciation;

import EvolutionWheat.ForDiversityMean;
import com.google.common.collect.Sets;
import java.util.Set;
import speciation.syntenic_Sgenome;

/**
 *
 * @author xuebozhao
 */
public class speciationEntrace {
    public static void main(String args[]){
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatOrigin/bwamap/bwa_file1.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatOrigin/bwamap/test/AT19767A";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatOrigin/bwamap/test/bwatest.txt";
//        new BWA(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/testmerge/testSgenome.vcf.gz";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/testmerge/testBlineag.vcf.gz";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/testmerge/testmerge.vcf";
//        new syntenic_Sgenome(infileS1,infileS2,outfileS);
//        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/testBlineag.vcf";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/hapPos.txt";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/posAllele.txt";
//        new syntenic_Sgenome(infileS1,outfileS1,outfileS2);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatScan/hapScanner2/Parameters_hapScanner2_chr1.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/tree/parameters_file";
//        new syntenic_Sgenome(infileS,outfileS);
//        
//        Set<Integer> AAset = Sets.newHashSet(1, 2, 3, 4, 5, 6);
//        Set<Integer> AABBset = Sets.newHashSet(3, 4, 5, 6, 7, 8, 9);
//        Set<Integer> AABBDDset = Sets.newHashSet(1, 5, 7, 10, 12, 13);
//        syntenic_Sgenome a = new syntenic_Sgenome();
//        Set a1 = a.SetOperations_111(AAset,AABBset,AABBDDset);
//        System.out.println(a1 + "\n");
//        Set a2 = a.SetOperations_110(AAset,AABBset,AABBDDset);
//        System.out.println(a2 + "\n");
//        Set a3 = a.SetOperations_101(AAset,AABBset,AABBDDset);
//        System.out.println(a3 + "\n");
//        Set a4 = a.SetOperations_011(AAset,AABBset,AABBDDset);
//        System.out.println(a4 + "\n");
//        Set a5 = a.SetOperations_001(AAset,AABBset,AABBDDset);
//        System.out.println(a5 + "\n");
//        Set a6 = a.SetOperations_100(AAset,AABBset,AABBDDset);
//        System.out.println(a6 + "\n");
//        Set a7 = a.SetOperations_010(AAset,AABBset,AABBDDset);
//        System.out.println(a7 + "\n");

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/testBlineag.vcf.gz";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/testsite11.vcf.gz";
//        String infileS3 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/test.vcf.gz";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/count2.txt";
//        new syntenic_Sgenome(infileS1,infileS2,infileS3,outfileS);

//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/tree/outgroup";
//        new tree(outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test.chr4.all.vcf.gz";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test.chr4.all2.vcf";
//        new tree(infileS,outfileS);

        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/test/count5_chr36_gene_1.txt";
        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/test/chr36.test27_1.vcf";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/test/count5_chr36_gene_2.txt";
        new geneTree(infileS1,infileS2,outfileS);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/pi/oder_barAndboxPlot_addS.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/wheatSpeciation/pi/Blineage";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/pi/Blineage/BlineagePiFileMerge_addS.txt";
//        new ForDiversityMean(infileS1,infileS2,outfileS);
    }
}
