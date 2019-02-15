/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo.analysis.data4CandChIA_PET;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author xuebozhao
 */
public class ForDensityPlot {
    public ForDensityPlot(String outfileS){
        this.getRange(outfileS);
    }
    public ForDensityPlot(String infileS,String outfileS){
        this.getTheDensitySiteAroundBait(infileS, outfileS);
    }
    public ForDensityPlot(String infileS1,String infileS2,String outfileS){
        this.getTheDensityRange(infileS1, infileS2, outfileS);
    }
    public void getRange(String outfileS){
        try{
            BufferedWriter bw = XueboIOUtils.getTextWriter(outfileS);
            int range = 10000;
            for(int i =1;i*range < 30440000;i++){
                bw.write("chr1" + "\t" + i*range + "\n");
            }
            for(int i =1;i*range < 19700000;i++){
                bw.write("chr2" + "\t" + i*range + "\n");
            }
            for(int i =1;i*range < 23470000;i++){
                bw.write("chr3" + "\t" + i*range + "\n");
            }
            for(int i =1;i*range < 18600000;i++){
                bw.write("chr4" + "\t" + i*range + "\n");
            }
            for(int i =1;i*range < 26990000;i++){
                bw.write("chr5" + "\t" + i*range + "\n");
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void getTheDensityRange(String infileS1,String infileS2,String outfileS){
        try{
            BufferedReader br1 = XueboIOUtils.getTextReader(infileS1);
            BufferedReader br2 = XueboIOUtils.getTextReader(infileS2);
            BufferedWriter bw = XueboIOUtils.getTextWriter(outfileS);
            String temp1 = null;
            String temp2 = null;
            int count = 0;
            List<String> listtemp = new ArrayList<>();
            while((temp2 = br2.readLine()) !=null){
                listtemp.add(temp2);
            }
            while((temp1 = br1.readLine()) != null){
                String tem[] = temp1.split("\t");  
                String chr = tem[0].substring(tem[0].length()-1, tem[0].length());
                int pos1 = Integer.valueOf(tem[1])-10000;
                int pos2 = Integer.valueOf(tem[1]) + 1;
                for (int j = 0; j < listtemp.size(); j++){
                    String temp22 = listtemp.get(j);
                    if(temp22.split("\t")[0].equals(chr)){
                        int cutterPos = Integer.valueOf(temp22.split("\t")[1]);
                        if(cutterPos < pos2 && cutterPos > pos1){
                           count= count+1;
                        }     
                    }
                }
                double aa = (count*1.0)/10;
                bw.write(tem[0] + "\t" + tem[1] + "\t" + count + "\t" + aa + "\n");
                count = 0;
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getTheDensitySiteAroundBait(String infileS,String outfileS){
        try{
            BufferedReader br1 = XueboIOUtils.getTextReader(infileS);
            BufferedWriter bw = XueboIOUtils.getTextWriter(outfileS);
            String temp1 = null;
            HashMap<Integer, Integer> hashMap1 = new HashMap<Integer, Integer>();
            Set Site = new HashSet();
            int i;
            while((temp1 = br1.readLine()) != null){
                String tem[] = temp1.split("\t");
                int aa = Integer.valueOf(tem[1]);
                int n = 150;
                for(int j = aa;j< aa+101;j++){
                    hashMap1.put(j,n);
                    Site.add(j);
                    n = n-1;
                }
                
            }     
            for(i = 7758871;i<7860812;i++){  
                int bb  = i-7758871;
                if(!Site.add(i)){  
                    bw.write("chr2" + "\t" + bb + "\t" + hashMap1.get(i) + "\t" + hashMap1.get(i)/10 + "\n");
                }
                else{
                    bw.write("chr2" + "\t" + bb + "\t" + "1" + "\t" + "1" + "\n");
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
