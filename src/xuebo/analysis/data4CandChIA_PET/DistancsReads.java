/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo.analysis.data4CandChIA_PET;

import static EvolutionWheat.ForHeatmap.getMaxValue;
import static EvolutionWheat.ForHeatmap.getMinValue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import static java.lang.Math.abs;
import pgl.infra.utils.IOUtils;
import pgl.infra.utils.PArrayUtils;


/**
 *
 * @author xuebozhao
 */
public class DistancsReads {
    public DistancsReads(String infileS,String outfileS){
        //this.getcentromereDis(infileS, outfileS);
        this.getWUSDis(infileS, outfileS);
    }
    
    //这个方法是为了得到12个库（3个分组）的reads的和
    //第一列是染色体，第二列是和着丝粒之间的距离，第三列是inflo1的和，第四列是inflo2的和，第五列是leaf的和
    //chr	start	end	centromere
    //chr1	15.04	15.15	15000000
    //chr2	3.56	3.66	3600000
    //chr3	13.75	14.01	14000000
    //chr4	4.91	4.01	4000000
    //chr5	11.68	11.78	11600000
    public void getcentromereDis(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            br.readLine();
            bw.write("chr" + "\t" + "distance" + "\t" + "inflo1" + "\t" + "inflo2" + "\t" + "leaf" + "\n");
            int pos = 0;
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                double inflo1 = (Integer.valueOf(tem[3]) + Integer.valueOf(tem[4]) + Integer.valueOf(tem[5]) + Integer.valueOf(tem[6]))/3;
                double inflo2 = (Integer.valueOf(tem[7]) + Integer.valueOf(tem[8]) + Integer.valueOf(tem[9]) + Integer.valueOf(tem[10]))/3;
                double leaf = (Integer.valueOf(tem[11]) + Integer.valueOf(tem[12]) + Integer.valueOf(tem[13]) + Integer.valueOf(tem[14]))/3;
                if(tem[0].equals("1")){
                    pos = abs(Integer.valueOf(tem[1]) - 15000000);
                    bw.write(tem[0] + "\t" + pos + "\t" + inflo1 + "\t" + inflo2 + "\t" + leaf + "\n");
                }
                if(tem[0].equals("2")){
                    pos = abs(Integer.valueOf(tem[1]) - 3600000);
                    bw.write(tem[0] + "\t" + pos + "\t" + inflo1 + "\t" + inflo2 + "\t" + leaf + "\n");
                }
                if(tem[0].equals("3")){
                    pos = abs(Integer.valueOf(tem[1]) - 14000000);
                    bw.write(tem[0] + "\t" + pos + "\t" + inflo1 + "\t" + inflo2 + "\t" + leaf + "\n");
                }
                if(tem[0].equals("4")){
                    pos = abs(Integer.valueOf(tem[1]) - 4000000);
                    bw.write(tem[0] + "\t" + pos + "\t" + inflo1 + "\t" + inflo2 + "\t" + leaf + "\n");
                }
                if(tem[0].equals("5")){
                    pos = abs(Integer.valueOf(tem[1]) - 11600000);
                    bw.write(tem[0] + "\t" + pos + "\t" + inflo1 + "\t" + inflo2 + "\t" + leaf + "\n");
                }
            }
            bw.flush();
            bw.close();         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //chr2	7808871	7810811
    public void getWUSDis(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            br.readLine();
            bw.write("chr" + "\t" + "distance" + "\t" + "inflo1" + "\t" + "inflo2" + "\t" + "leaf" + "\n");
            int pos = 0;
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                double inflo1 = (Integer.valueOf(tem[3]) + Integer.valueOf(tem[4]) + Integer.valueOf(tem[5]) + Integer.valueOf(tem[6]))/3;
                double inflo2 = (Integer.valueOf(tem[7]) + Integer.valueOf(tem[8]) + Integer.valueOf(tem[9]) + Integer.valueOf(tem[10]))/3;
                double leaf = (Integer.valueOf(tem[11]) + Integer.valueOf(tem[12]) + Integer.valueOf(tem[13]) + Integer.valueOf(tem[14]))/3;
                if(tem[0].equals("2")){
                    pos = abs(Integer.valueOf(tem[1]) - 7808871);
                    bw.write(tem[0] + "\t" + pos + "\t" + inflo1 + "\t" + inflo2 + "\t" + leaf + "\n");
                }
            }
            bw.flush();
            bw.close();         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}  
