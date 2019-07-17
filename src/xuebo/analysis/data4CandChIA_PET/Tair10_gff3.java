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
public class Tair10_gff3 {
    public Tair10_gff3(String infileS,String outfileS){
        this.getTair10_gff3_onlyGene(infileS, outfileS);
    }
    public Tair10_gff3(String infileS,String outfileS1,String outfileS2){
        this.getTair10_gff3_updownStream(infileS, outfileS1, outfileS2);
    }
//    public Tair10_gff3(String infileS1, String infileS2, String outfileS) {
//        this.forRegionGene(infileS1, infileS2, outfileS);
//    }
    
    //转换小麦的gff3文件，每个基因放在一个一列
    public void getTair10_gff3_onlyGene(String infileS,String outfileS){
        try{
            BufferedReader br = XueboIOUtils.getTextReader(infileS);
            BufferedWriter bw = XueboIOUtils.getTextWriter(outfileS);
            String temp = null;
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(tem[2].equals("gene")){
                    String geneName = (tem[8].split(";")[0]).split("=")[1];
                    bw.write(tem[0].substring(tem[0].length()-1, tem[0].length()) + "\t" + geneName + "\t" + tem[3] + "\t" + tem[4] + "\t" + tem[6] + "\n" );
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //转换小麦的gff3文件，每个基因放在一个一列的文件是输入文件，输出文件是上游2K的文件和下游2K的文件
    public void getTair10_gff3_updownStream(String infileS,String outfileS1,String outfileS2){
        try{
            BufferedReader br = XueboIOUtils.getTextReader(infileS);
            BufferedWriter bw1 = XueboIOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = XueboIOUtils.getTextWriter(outfileS2);
            String temp = null;
            while((temp = br.readLine()) != null){
                String[] tem = temp.split("\t");
                if(tem[4].equals("+")){
                    bw1.write(tem[0] + "\t" + tem[1] + "\t" +(Integer.valueOf(tem[2])-2000) + "\t" + tem[2] + "\n" );
                    bw2.write(tem[0] + "\t" + tem[1] + "\t" + tem[3]+  "\t" + (Integer.valueOf(tem[3])+2000) + "\n" );
                }
                if(tem[4].equals("-")){
                    bw1.write(tem[0] + "\t" + tem[1] + "\t" + tem[3]+  "\t" + (Integer.valueOf(tem[3])+2000) + "\n" );
                    bw2.write(tem[0] + "\t" + tem[1] + "\t" +(Integer.valueOf(tem[2])-2000) + "\t" + tem[2] + "\n" );
                }
            }
            bw1.flush();
            bw2.flush();
            bw1.close();
            bw2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //这个方法输入拟南芥的显著的酶切位点region信息，得到这个region的基因，输入文件：region信息和基因信息；输出文件：基因
    public void forRegionGene(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            String temp2 = null;
            //BufferedReader brgene2 =null;
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            List<Integer> pos = new ArrayList<>();
            Set  gene = new HashSet();
            BufferedReader brgene = XueboIOUtils.getTextReader(infileS1);
            BufferedReader brregion = XueboIOUtils.getTextReader(infileS2);
            BufferedWriter bw = XueboIOUtils.getTextWriter(outfileS);
            while((temp2 = brgene.readLine()) != null){
                String tem2[] = temp2.split("\t");
                String key = tem2[2]+"_"+tem2[3];
                String value = tem2[1];
                //String value = tem2[0]+"_"+tem2[1];
                hashMap1.put(key, value);
                pos.add(Integer.valueOf(tem2[0]));
                pos.add(Integer.valueOf(tem2[2]));
                pos.add(Integer.valueOf(tem2[3]));             
            } 
            while((temp = brregion.readLine()) != null){
                int i;
                String tem[] = temp.split("\t");
                String regionchr = tem[0];
                int regionpos1 = Integer.valueOf(tem[1]);
                int regionpos2 = Integer.valueOf(tem[2]);
                //int aa = pos.size();
                for(i = 0; i < pos.size();i = i+3 ){
                    if(Integer.toString(pos.get(i)).equals(regionchr)){
                        String aa = pos.get(i+1) + "_" + pos.get(i+2);
                        if(pos.get(i+1)<=regionpos2 && pos.get(i+1)>=regionpos1){
                            gene.add(hashMap1.get(aa));
                        }
                        if(pos.get(i+2)<=regionpos2 && pos.get(i+2)>=regionpos1){
                            gene.add(hashMap1.get(aa));
                        }
                        if(pos.get(i+2)>regionpos2 && pos.get(i+1) < regionpos1){
                            gene.add(hashMap1.get(aa));
                        }
                    }
                }
                
            }
            //sort(gene);
            for (Object str : gene) {
                String remgene = str.toString();
                //bw.write(remgene.split("_")[0] + "\t" + remgene.split("_")[1] + "\n");
                bw.write(str + "\n") ;
                System.out.println(str);
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
