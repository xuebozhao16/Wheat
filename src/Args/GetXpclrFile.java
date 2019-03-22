/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Args;

import EvolutionWheat.ForVcftoolsGroup;
import EvolutionWheat.Redundancy_selection;
import fasta.wheatFastaToAppend;
import fasta.parralleFas;
import gff3.wheatkgfTo42map;

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
        String infileS = "";
        String outfileS ="";
        for (int i = 0; i < len; i++){
            if (null != args[i])switch (args[i]) {
                case "--file":
                    infileS = args[i+1];
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
        //new ForVcftoolsGroup(infileS, outfileS);
        new Redundancy_selection(infileS, outfileS);
        
    }
}
