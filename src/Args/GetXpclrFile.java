/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Args;

import EvolutionWheat.Filefolder_pip;
import EvolutionWheat.ForVcftoolsGroup;
import EvolutionWheat.Redundancy_selection;
import EvolutionWheat.Synteny_site;
import EvolutionWheat.fd_individual;
import fasta.wheatFastaToAppend;
import fasta.parralleFas;
import gff3.wheatkgfTo42map;
import speciation.syntenic_Sgenome;
import speciation.vcf_QualityControl;

/**
 *
 * @author xuebozhao
 */
public class GetXpclrFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int len = args.length;
        String infileS1 = "";
        String infileS2 = "";
        String outfileS1 ="";
        //String ref = "";
        String outfileS2 ="";
        for (int i = 0; i < len; i++){
            if (null != args[i])switch (args[i]) {
                case "--file":
                    infileS1 = args[i+1];
                    i++;
                    break;
//                case "--file2":
//                    infileS2 = args[i+1];
//                    i++;
//                    break;    
                case "--out":
                    outfileS1 = args[i+1];
                    i++;
                    break;
                case "--out2":
                    outfileS2 = args[i+1];
                    i++;
                default:
                    break;
            }
        }
        //new ForVcftoolsGroup(infileS, outfileS);
        //new Redundancy_selection(infileS, outfileS);
        //new Synteny_site(infileS,outfileS);
        //new Filefolder_pip(infileS,outfileS);
        //new syntenic_Sgenome(infileS1, outfileS1, outfileS2);
        //new fd_individual(infileS1,infileS2,outfileS1,outfileS2);
        new vcf_QualityControl(infileS1, outfileS1, outfileS2);
    }
}
