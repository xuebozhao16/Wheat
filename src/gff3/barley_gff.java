package gff3;

import utils.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;

public class barley_gff {
    public barley_gff(String infileS,String outfileS){
        this.getbarley_Onlygene(infileS, outfileS);
    }
    public barley_gff(String infileS1,String infileS2,String outfileS){
        this.getbarley_addWheat(infileS1,infileS2,outfileS);
    }
    //这个方法是得到大麦的only gene
    public void getbarley_Onlygene(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                if(!temp.startsWith("#")){
                    String[] tem = temp.split("\t");
                    if(tem[2].equals("gene")){
                        String chr = tem[0];
                        String geneid = tem[8].split(";")[0].split(":")[1];
                        bw.write(chr + "\t" +geneid + "\t" +  tem[3] + "\t" + tem[4] + "\t" + tem[6] + "\n");
                    }
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //现在是为了得到1_1文件的list里面有barley的信息
    public void getbarley_addWheat(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String,String> hashmap1 = new HashMap<String,String>();
            while((temp = br1.readLine()) != null){
                String value = temp.split("\t")[0] + "_" + temp.split("\t")[2] + "_" + temp.split("\t")[3];
                hashmap1.put(temp.split("\t")[1],value);
            }
            while((temp2 = br2.readLine())!= null){
                String Hv = temp2.split("\t")[1].split("\\|")[1];
                String TaA = temp2.split("\t")[2].split("\\|")[1];
                String TaB = temp2.split("\t")[3].split("\\|")[1];
                String TaD = temp2.split("\t")[4].split("\\|")[1];
                String Hv_bed = hashmap1.get(Hv);
                bw.write(Hv_bed.split("_")[0] + "\t" + (Integer.valueOf(Hv_bed.split("_")[1])-1) + "\t" + Hv_bed.split("_")[2] + "\t" +
                        Hv + "\t" + TaA + "\t" + TaB + "\t" + TaD + "\n" );
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }











}
