/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheat;

import fasta.Fasta;
import fasta.parralleFas;
import gff3.kgf;

/**
 *
 * @author xuebozhao
 */
public class Wheat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int len = args.length;
        String inFile = "";
        String gffFile ="";
        String outFile ="";
        for (int i = 0; i < len; i++){
            if (null != args[i])switch (args[i]) {
                case "--file":
                    inFile = args[i+1];
                    i++;
                    break;
                case "--gff3":
                    gffFile = args[i+1];   
                    i++;
                    break;
                case "--out":
                    outFile = args[i+1];
                    i++;
                    break;
                default:
                    break;
            }
        }
        if(outFile.equals("")) {
            System.out.println("outFile is missing!");
            outFile = inFile;
        }
//        new kgf().readKgf(gffFile);
        Fasta A = new Fasta(inFile);
        new parralleFas(A).getParralle(outFile, gffFile);
    }
}
