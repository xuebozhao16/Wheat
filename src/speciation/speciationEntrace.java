/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciation;

import EvolutionWheat.ForDiversityMean;
import EvolutionWheat.ForHeatmap;
import EvolutionWheat.ForManhattanPlot;
import com.google.common.collect.Sets;
import java.util.Set;

import gnu.trove.list.array.TIntArrayList;
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

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/bwamap/11.faq";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/bwamap/22.faq";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/bwamap/t_11.faq";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/bwamap/t_22.faq";
//        new BWA(infileS1,infileS2,outfileS1,outfileS2);


//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/testmerge/testSgenome.vcf.gz";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/testmerge/testBlineag.vcf.gz";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/testmerge/testmerge.vcf";
//        new syntenic_Sgenome(infileS1,infileS2,outfileS);
//        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/testsite11.vcf.gz";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/hapPos.txt";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/posAllele.txt";
//        new syntenic_Sgenome(infileS1,outfileS1,outfileS2);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatScan/hapScanner2/Parameters_hapScanner2_chr1.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/scanTu/parameters_file";
//        new syntenic_Sgenome(infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/bwamap/test/depth11.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/bwamap/test/all.depth";
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
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/";
//        new syntenic_Sgenome(infileS1,infileS2,infileS3,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/info3_Dlineage_chr11";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test/info3_Dlineage_chr11_chr";
//        new syntenic_Sgenome(infileS,outfileS);

//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/scanTu/TaxaRefBam";
//        new tree(outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test.chr4.all.vcf.gz";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/test.chr4.all2.vcf";
//        new tree(infileS,outfileS);
//
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/tree/Blineage_ segregate/mac_chr3.AB.vcf";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/tree/Blineage_ segregate/chr3.genictree.vcf";
//        //String infileS3 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/tree/Blineage_ segregate/chr3.genictree.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/tree/Blineage_ segregate/chr3.segregatetree.vcf";
//        new tree(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/testAAAA/chr20_1M.bed";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/testAAAA/chr20.genic.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/testAAAA/outgenevcf";
//        new geneTree(infileS1,infileS2,outfileS);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/pi/emmer/name.txt";
//        String infileS2 ="/Users/xuebozhao/Documents/LuLab/wheatSpeciation/pi/emmer";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/pi/emmer/emmerPi.txt";
//        new ForDiversityMean(infileS1,infileS2,outfileS);


//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/tree/random/Btree.fasta";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/tree/random/Btree.phy";
//        new geneTree(infileS,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/group/subspecies/all_subspecies.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/group/subspecies/name_subspecies.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/group/subspecies";
//        new geneTree(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/name_num_AandB.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/tree/A_best.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/tree/A_best_addline.txt";
//        new geneTree(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/TheReciprocalBestBLAST1_1/TheReciprocalAll/TheABD.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulab1_1onlyGene.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/assembly/A_best_Synteny_150bp.bed";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/assembly/B_best_Synteny_150bp.bed";
//        String outfileS3 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/assembly/D_best_Synteny_150bp.bed";
//        new geneTree(infileS1,infileS2,outfileS1,outfileS2,outfileS3);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/phyloNet/phyloNet_10M/B/B_bipartition_10Mtree_part2.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/phyloNet/phyloNet_10M/B/B2_bipartition_10MphyloNet.txt";
//        new phyloNet(infileS,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/assembly/musclename.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/assembly/B/TraesCS2B02G175600.phy";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/assembly/B/TraesCS2B02G175600.phy2";
//        new geneTree(infileS1,infileS2,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/mac3_10M/Btree_10M_sort.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/mac3_10M/Btree_10M_topology.txt";
//        new geneTree(infileS,outfileS);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/mac3_10M/numall.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/mac3_10M/Btree_10M_topology.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/majorAllele/mac3_10M/Btree_10M_topologyNUM.txt";
//        new geneTree(infileS1,infileS2,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/genomebed/10M_tree";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/geneTree/genomebed/10M_tree/AAA.txt";
//        new geneTree(infileS,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/Cytoscape/B/BInvariantSite.phy";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/Cytoscape/B/BInvariantSite.phy2";
//        new Cytoscape(infileS,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/E3_QC/chr1.1K.vcf";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/E3_QC/siteQCfileS.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/vcfE1/E3_QC/taxaQCFileS.txt";
//        new vcf_QualityControl(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/more_accessions/test.fa";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/more_accessions/testseq.bed";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/more_accessions/testseq.txt";
//        new vcf_QualityControl(infileS1,infileS2,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/singlecopygene1_1.gene100D.bed";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/singlecopygene1_1.gene100D";
//        new split_time(infileS,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/singlecopygene1_1.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/V1_1/GeneLulab1_1onlyGene.txt";
//        String outfileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/singlecopygene1_1.A.bed";
//        String outfileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/singlecopygene1_1.B.bed";
//        String outfileS3 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/singlecopygene1_1.D.bed";
//        new split_time(infileS1,infileS2,outfileS1,outfileS2,outfileS3);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/A_1.alin.fa";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/A_2.xml";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/test_mcmc/A_1.xml";
//        new split_time(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/readmeByFei_table.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/singlecopygene1_1.D.bed";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/singlecopygene1_1.D_Chr.bed";
//        new split_time(infileS1,infileS2,outfileS);
        
//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/IBS_dis/test_ibs_file1.vcf";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/IBS_dis/test_ibs_file2.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/IBS_dis/test_ibs.txt";
//        new IBS_distance(infileS1,infileS2,outfileS);

//        String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/IBS_dis/test_ibs_file1.vcf";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/IBS_dis/test_ibs2.txt";
//        new IBS_distance(infileS,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/single_copy_gene/singlecopygene1_1_more1000.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/assembly_gene/test";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/assembly_gene/test1.txt";
//        new split_time(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/assembly_gene/D/D_1line_204.alin.fa";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/assembly_gene/D/D_1line_4963.xml";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/species_split_time/assembly_gene/D/D_1line_204.xml";
//        new split_time(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/volcanofinder/GO/Yunan_wheat.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/mart_export.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/volcanofinder/GO/Yunan_wheat_gene_Go.csv";
//        new GO_analysis(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/volcanofinder/GO/Yunan_wheat.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/mart_export.txt";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/volcanofinder/GO/Yunan_wheat_gene_Go.csv";
//        new GO_analysis(infileS1,infileS2,outfileS);

//        String infileS1 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatgenome/readmeByFei_table.txt";
//        String infileS2 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/Speltoides/fd_Speltoides_domemmer.csv";
//        String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/Speltoides/fd_Speltoides_domemmer.txt";
//        new introgression(infileS1,infileS2,outfileS);

        //String infileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/Speltoides/fd_1B_1M.vcf";
        //String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/introgression/Speltoides/fd_1B_1M.txt";
        //new ForHeatmap(infileS,outfileS);

         String infileS1 = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/climate_change/gene/window_region_gene/North_top1_A.txt";
         String infileS2 = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/convergentEvo/mart_export.txt";
         String outfileS = "/Users/xuebozhao/Documents/LuLab/wheatSpeciation/climate_change/gene/window_region_gene/North_top1_A_GO.txt";
         new GO_analysis(infileS1,infileS2,outfileS);

        //IntArrayList tIntArrayList=new TIntArrayList();
        //System.out.println(tIntArrayList.size());
    }
}