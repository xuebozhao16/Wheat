/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vcf;

import pgl.infra.utils.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class NewRcode {
    public NewRcode(String infileS,String outfileS){
        this.NewRcode_forpermutation(infileS, outfileS);
    }
    
    public void NewRcode_forpermutation(String infileS,String outfileS){
         try {            
            BufferedWriter bw = null;
            String temp = "";
            String[] te = null;
            
            //int chrA[] = {1,2,7,8,13,14,19,20,25,26,31,32,37,38};
            //int chrA[] = {3,4,9,10,15,16,21,22,27,28,33,34,39,40};
            //int chrA[] = {1,2,7,8,13,14,19,20,25,26,31,32,37,38,3,4,9,10,15,16,21,22,27,28,33,34,39,40};
            //int chrA[] = {1,2,7,8,13,14,19,20,25,26,31,32,37,38,3,4,9,10,15,16,21,22,27,28,33,34,39,40,5,6,11,12,17,18,23,24,29,30,35,36,41,42};
            //int chrA[] = {5,6,11,12,17,18,23,24,29,30,35,36,41,42};
            //int chrA[] = {1,2,7,8,13,14,19,20,25,26,31,32,37,38,5,6,11,12,17,18,23,24,29,30,35,36,41,42};
            
            for(int i = 1; i < 33;i++ ){
                BufferedReader br = IOUtils.getTextReader(infileS);
                int line = 1;
                bw = IOUtils.getTextWriter(outfileS+"/normXp"+ i+".r");
                while((temp = br.readLine())!=null){
                    if(line==2){
                        //bw.write("setwd(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/WD_Einkorn/Xp" + i + "\")");
                        //bw.write("setwd(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/WD_emmer/Xp" + i + "\")");
                        //bw.write("setwd(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/D_durum/Xp" + i + "\")");
                        //bw.write("setwd(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/land1_cul3/Xp" + i + "\")");
                        //bw.write("setwd(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/A_EIEM/Xp" + i + "\")");
                        bw.write("setwd(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/DurumCul/Xp" + i + "\")");
                        bw.newLine();
                    }else if(line==5){
                        //bw.write("for(i in c(1,2,7,8,13,14,19,20,25,26,31,32,37,38)){");
                        bw.write("for(i in c(1,2,7,8,13,14,19,20,25,26,31,32,37,38,3,4,9,10,15,16,21,22,27,28,33,34,39,40)){");
                        //bw.write("for(i in c(1,2,7,8,13,14,19,20,25,26,31,32,37,38,3,4,9,10,15,16,21,22,27,28,33,34,39,40,5,6,11,12,17,18,23,24,29,30,35,36,41,42)){");
                        bw.newLine();
                    }
                    else if(line==6){
                        //bw.write("  file=paste(\"WD_Einkorn_10kchr\",i,\".xpclr.txt\",sep=\"\")");
                        //bw.write("  file=paste(\"WD_emmer_10kchr\",i,\".xpclr.txt\",sep=\"\")");
                        //bw.write("  file=paste(\"D_durum_10kchr\",i,\".xpclr.txt\",sep=\"\")");
                        //bw.write("  file=paste(\"land1_cul3_10kchr\",i,\".xpclr.txt\",sep=\"\")");
                        //bw.write("  file=paste(\"A_EIEM_10kchr\",i,\".xpclr.txt\",sep=\"\")");
                        bw.write("  file=paste(\"Durum_cul3_10kchr\",i,\".xpclr.txt\",sep=\"\")");
                        bw.newLine();
                    }
                    else if(line==16){
//                        bw.write("  outFile=paste(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/WD_Einkorn/normalization_Xp" + i +
//                                "/normXPCLRscore_chr\",i,\".txt\",sep=\"\")");
//                        bw.write("  outFile=paste(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/WD_emmer/normalization_Xp" + i +
//                                "/normXPCLRscore_chr\",i,\".txt\",sep=\"\")");
//                        bw.write("  outFile=paste(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/D_durum/normalization_Xp" + i +
//                                "/normXPCLRscore_chr\",i,\".txt\",sep=\"\")");
//                        bw.write("  outFile=paste(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/land1_cul3/normalization_Xp" + i +
//                                "/normXPCLRscore_chr\",i,\".txt\",sep=\"\")");
//                            bw.write("  outFile=paste(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/A_EIEM/normalization_Xp" + i +
//                                "/normXPCLRscore_chr\",i,\".txt\",sep=\"\")");
                        bw.write("  outFile=paste(\"/data1/home/xuebo/Projects/Evo/permutation_recomRate/DurumCul/normalization_Xp" + i +
                                "/normXPCLRscore_chr\",i,\".txt\",sep=\"\")");
                        bw.newLine();
                    }else{
                        bw.write(temp);
                        bw.newLine();
                    }
                    line++;
                }
                bw.flush();
                bw.close();
            }
        }   
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
