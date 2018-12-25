/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolyploidWheat;

/**
 *
 * @author xuebozhao
 */
public class ArgPolyploidWheat {
    
    public static void main(String[] args) {
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
        new RepaceNaneAndSeq(infileS1,infileS2,outfileS);     
    }
}
