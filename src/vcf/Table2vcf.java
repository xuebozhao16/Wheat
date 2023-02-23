package vcf;

import pgl.infra.utils.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashSet;
import java.util.Set;

public class Table2vcf {
    public Table2vcf(String infileS,String outfileS){
        this.Taxa_table2vcf(infileS, outfileS);
    }
    //这个代码是为了转换傅老师组的那个师兄提供的狗屎格式
    public void Taxa_table2vcf(String infileS,String outfileS){
        try {
            String temp1 = null;
            String temp2 = null;
            int i = 0;
            BufferedReader br1 = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("##fileformat=VCFv4.1\n" +
                    "##FILTER=<ID=PASS,Description=\"All filters passed\">\n" +
                    "##FORMAT=<ID=GT,Number=1,Type=String,Description=\"Genotype\">\n" +
                    "##FORMAT=<ID=AD,Number=.,Type=Integer,Description=\"Allelic depths for the reference and alternate alleles in the order listed\">\n" +
                    "##FORMAT=<ID=GL,Number=.,Type=Integer,Description=\"Genotype likelihoods for 0/0, 0/1, 1/1, or  0/0, 0/1, 0/2, 1/1, 1/2, 2/2 if 2 alt alleles\">\n" +
                    "##INFO=<ID=DP,Number=1,Type=Integer,Description=\"Total Depth\">\n" +
                    "##INFO=<ID=NZ,Number=1,Type=Integer,Description=\"Number of taxa with called genotypes\">\n" +
                    "##INFO=<ID=AD,Number=.,Type=Integer,Description=\"Total allelelic depths in order listed starting with REF\">\n" +
                    "##INFO=<ID=AC,Number=.,Type=Integer,Description=\"Numbers of ALT alleles in order listed\">\n" +
                    "##INFO=<ID=GN,Number=.,Type=Integer,Description=\"Number of taxa with genotypes AA,AB,BB or AA,AB,AC,BB,BC,CC if 2 alt alleles\">\n" +
                    "##INFO=<ID=HT,Number=1,Type=Integer,Description=\"Number of heterozygotes\">\n" +
                    "##INFO=<ID=MAF,Number=1,Type=Float,Description=\"Minor allele frequency\">\n" +
                    "##ALT=<ID=DEL,Description=\"Deletion\">\n" +
                    "##ALT=<ID=INS,Description=\"Insertion\">\n" +
                    "##contig=<ID=1>" + "\n");
            while((temp1 = br1.readLine())!= null){
                String tem[] = temp1.split("\t");
                StringBuilder header = new StringBuilder();
                if(i==0){
                    for(int j=11;i<(tem.length);j++){
                        header.append(tem[i] + "\t");
                    }
                    bw.write("#CHROM\tPOS\tID\tREF\tALT\tQUAL\tFILTER\tINFO\tFORMAT" + "\t"+ header + "\n");
                }else{
                    
                }
                i++;


            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
