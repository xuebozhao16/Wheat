/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

/**
 *
 * @author xuebozhao
 */
public class Entrancefasta {
    public static void main(String args[]){
        String infileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3A/btr1_3A.nobeagle.vcf";
        String outfileS = "/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/Brgene/haplotypeNet/Btr1_3A/btr1_3A.snp.txt";
        new vcf2fasta(infileS,outfileS);
    }
}
