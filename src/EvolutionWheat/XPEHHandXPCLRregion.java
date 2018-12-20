/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import static EvolutionWheat.ForXpehh_bin.getMaxValue;
import static EvolutionWheat.ForXpehh_bin.getMinValue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class XPEHHandXPCLRregion {

    public XPEHHandXPCLRregion(String infileS,String outfileS){
        //this.regionForXpehh(infileS, outfileS);
        //this.forxpclrFileSForR(infileS, outfileS);
        this.regionForXpclr(infileS, outfileS);
        //this.forGFF3gene(infileS, outfileS);
    }
    public XPEHHandXPCLRregion(String infileS1,String infileS2,String outfileS){
        //this.getReciprocalRiceToA(infileS1, infileS2, outfileS);
        this.forRegionGene(infileS1, infileS2, outfileS);
    }
    
//    public XPEHHandXPCLRregion(String infileS,String outfileS1,String outfileS2){
//       this.forGOandGENE(infileS, outfileS1, outfileS2);
//    }
//    public XPEHHandXPCLRregion(String infileS1,String infileS2, String outfileS1,String outfileS2,String outfileS3){
//        this.forGOandGENEforspecifiedGene(infileS1, infileS2, outfileS1, outfileS2,outfileS3);
//    }
    public XPEHHandXPCLRregion(String infileS1,String infileS2, String infileS3,String outfileS1,String outfileS2){
        this.forKEGGforspecifiedGene(infileS1, infileS2, infileS3, outfileS1, outfileS2);
    }
 
    //对0.01的Xpehh的结果取region
    public void regionForXpehh(String infileS,String outfileS){
        try{
            String temp = null;
            //int i =0;
            HashMap<String, Double> hashMap1 = new HashMap<String, Double>();
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            String firstline = br.readLine();
            String startchr = (firstline.split("\t")[0]).split("-")[0];
            String pos = (firstline.split("\t")[0]).split("-")[1];
            String lastpos = (firstline.split("\t")[0]).split("-")[1];
            String previouspos= null;
            boolean nn = true;
            int bp = 0;
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");        
                String chr = tem[0].split("-")[0];
                String tempos = tem[0].split("-")[1];
                if(startchr.equals(chr) && nn){
                    if((Integer.valueOf(tempos)-Integer.valueOf(lastpos)) > 50000){
                       // System.out.println(chr + "\t" + pos + "\t" + lastpos);
                       bw.write(chr + "\t" + pos + "\t" + lastpos + "\n");
                       bp = Integer.valueOf(lastpos)-Integer.valueOf(pos) + bp;
                       startchr = chr;
                       previouspos = tempos;
                       nn = false;
                    }else{
                        lastpos = tempos;
                        nn = true;
                    }                   
                }else if(!startchr.equals(chr)){
                    if((Integer.valueOf(tempos)-Integer.valueOf(lastpos)) < 0){
                        bw.write(Integer.valueOf(chr)-1 + "\t" + pos + "\t" + lastpos + "\n");
                    }
                    startchr = chr;
                    pos = tempos;
                    lastpos = tempos;                                      
                    nn = true;
                }else if(!nn && startchr.equals(chr)) {
                    pos = previouspos;
                    lastpos = tempos;
                    nn = true;
                }       
            }
            System.out.println(bp);
            bw.flush();
            bw.close();         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
     //对0.01的Xpclr的结果取region
    public void regionForXpclr(String infileS,String outfileS){
        try{
            String temp = null;
            //int i =0;
            HashMap<String, Double> hashMap1 = new HashMap<String, Double>();
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            int bp = 0;
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");        
                String lastpos = Integer.toString((Integer.valueOf(tem[1]) - 10000 + 1));
                bw.write(tem[0] + "\t" + lastpos + "\t" + tem[1] + "\n");
                bp = Integer.valueOf(tem[1]) - Integer.valueOf(lastpos) + bp;
            }
            System.out.println(bp);
            bw.flush();
            bw.close();         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //这个方法做的是把xpclr结果中的Inf等值去掉，这样就可以用R去做统计了
    public void forxpclrFileSForR(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String tem[] = temp.split(" ");
                //System.out.println(tem[5]);
                if(tem[5].equals("inf") | tem[5].equals("-0.000000") | tem[5].equals("0.000000") | tem[5].equals("-nan")){
                    
                }else {
                    //double q = Math.pow(10,-Double.valueOf(tem[5]));
                    //String p = formatDouble(q);
                    String pos = tem[3].split("\\.")[0];
                    bw.write(tem[0] + "\t" + pos + "\t" + tem[5] + "\n");
                }              
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //这个方法是输入小麦的gff3的文件，得到chr + geneID + region + strand
    public void forGFF3gene(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                if(!temp.startsWith("#")){
                    if(tem[2].equals("gene")){
                        String geneID = (tem[8].split(";")[0]).split("=")[1];
                        bw.write(tem[0] + "\t" + geneID + "\t" + tem[3] + "\t" + tem[4] + "\t" + tem [6] + "\n");
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
   
    //这个方法输入小麦的region信息，得到这个region的基因，输入文件：region信息和基因信息；输出文件：基因
    public void forRegionGene(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            String temp2 = null;
            //BufferedReader brgene2 =null;
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            List<Integer> pos = new ArrayList<>();
            Set  gene = new HashSet();
            BufferedReader brgene = IOUtils.getTextReader(infileS1);
            BufferedReader brregion = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
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
                        if(pos.get(i+1)<regionpos2 && pos.get(i+1)>regionpos1){
                            gene.add(hashMap1.get(aa));
                        }
                        if(pos.get(i+2)<regionpos2 && pos.get(i+2)>regionpos1){
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
    //这是rice和小麦A基因组的比较，先放在这个class里面吧
    public void getReciprocalRiceToA(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
//            BufferedReader br1AB = IOUtils.getTextReader("‎/Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatHomology/Rice_subA/crb_blastA_rice.tsv");
            BufferedReader br1AB = IOUtils.getTextReader(infileS1);
            BufferedReader br2BA = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            HashMap<String, String> hashMap2 = new HashMap<String, String>();
            Set<String> A1 = new HashSet();
            while((temp = br1AB.readLine())!= null){
                String [] tem = temp.split("\t");    
                hashMap1.put(tem[0],tem[1]);
                A1.add(tem[0]);
            }
            while((temp = br2BA.readLine())!= null){
                String [] tem = temp.split("\t");    
                hashMap2.put(tem[0],tem[1]);
            }      
            Set A11 = new HashSet();
            A11.addAll(A1);
            for (String a1 : A1){
                System.out.println(a1);
                String B = hashMap1.get(a1);
                String AA = hashMap2.get(hashMap1.get(a1));           
                if(AA==null) continue;
                if(AA!=null && A11.add(AA)){
                    A11.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                }else if(AA == null){
                    System.out.println("Not the Reciprocal Best");
                }else{
                    bw.write(a1 + "\t" + B.split("\\.")[0]  + "\n");
                }
            }    
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //这个方法是进行GO分析，得到文件1：基因号和GO对应的文件 文件2：GO和GO的注释信息
    public void forGOandGENE(String infileS,String outfileS1,String outfileS2){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            Set GoAnnotation = new HashSet();
            Set GoAnnotation1 = new HashSet();
            br.readLine();
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                //bw1.write(tem[2] + "," + tem[0] + "\n");
                GoAnnotation1.add(tem[2] + "_" + tem[0]);
                GoAnnotation1.add(tem[4] + "_" + tem[0]);
                GoAnnotation.add(tem[2]+"_"+tem[3]); 
                GoAnnotation.add(tem[4]+"_" +tem[5]);
            }
            for (Object str1 : GoAnnotation1) {
                String GOgene = str1.toString();
                bw1.write(GOgene.split("_")[0] + "," + GOgene.split("_")[1] + "\n");
            }      
            for (Object str : GoAnnotation) {
                String Go = str.toString();
                bw2.write(Go.split("_")[0] + "," + Go.split("_")[1] + "\n");
                //bw.write(str + "\n") ;
                System.out.println(str);
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
   
    //这个方法是进行GO分析，得到文件1：基因号和GO对应的文件 文件2：GO和GO的注释信息
    public void forGOandGENEforspecifiedGene(String infileS1,String infileS2, String outfileS1,String outfileS2,String outfileS3){
        try{
            String tempgene = null;
            String temp = null;
            BufferedReader brspecifiedGene = IOUtils.getTextReader(infileS1);
            BufferedReader brGoFile = IOUtils.getTextReader(infileS2);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            BufferedWriter bw3 = IOUtils.getTextWriter(outfileS3);
            Set specifiedGene = new HashSet();
            Set GoAnnotation1 = new HashSet();
            Set GoAnnotation11 = new HashSet();
            Set GoAnnotation2 = new HashSet();
            while((tempgene = brspecifiedGene.readLine()) != null){
                specifiedGene.add(tempgene);               
            }
            brGoFile.readLine();
            while((temp = brGoFile.readLine()) !=null){
                String[] tem = temp.split("\t");
                if(!specifiedGene.add(tem[0])){
                    GoAnnotation1.add(tem[2] + "_" + tem[0]);
                    GoAnnotation1.add(tem[4] + "_" + tem[0]);
                    GoAnnotation11.add(tem[0]);
                    GoAnnotation2.add(tem[2]+"_" +tem[3]);
                    GoAnnotation2.add(tem[4]+"_" +tem[5]);
                }else{
                    specifiedGene.remove(tem[0]);
                }
            }
            for (Object strgo : GoAnnotation11) {
                bw3.write(strgo + "\n");
            }  
            for (Object str1 : GoAnnotation1) {
                String GOgene = str1.toString();
                //bw1.write(GOgene.split("_")[0] + "," + GOgene.split("_")[1] + "\n");
                bw1.write(GOgene.split("_")[1] + "\t" + GOgene.split("_")[0] + "\n");
            }           
            for (Object str : GoAnnotation2) {
                String Go = str.toString();
                bw2.write(Go.split("_")[0] + "," + Go.split("_")[1] + "\n");
                //bw.write(str + "\n") ;
                System.out.println(str);
            }
            bw1.flush();
            bw2.flush();
            bw3.flush();
            bw1.close();
            bw2.close();
            bw3.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是进行找到和水稻基因组相对应的基因
    public void forKEGGforspecifiedGene(String infileS1,String infileS2, String infileS3,String outfileS1,String outfileS2){
        try{
            String tempgene = null;
            String temp = null;
            String tempID  = null;
            BufferedReader brspecifiedGene = IOUtils.getTextReader(infileS1);
            BufferedReader brRiceFile = IOUtils.getTextReader(infileS2);
            BufferedReader brRiceIDFile = IOUtils.getTextReader(infileS3);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            Set specifiedGene = new HashSet();
            Set GoAnnotation1 = new HashSet();
            Set GoAnnotation2 = new HashSet();
            while((tempgene = brspecifiedGene.readLine()) != null){
                specifiedGene.add(tempgene);               
            }
            while((temp = brRiceFile.readLine()) !=null){
                String[] tem = temp.split("\t");
                if(!specifiedGene.add(tem[0])){
                    GoAnnotation1.add(tem[1]+".1");
                    bw1.write(tem[1] + ".1"+ "\n");
                }else{
                    specifiedGene.remove(tem[0]);
                }
            } 
            String tempIDp = null;
            while((tempIDp = brRiceIDFile.readLine()) !=null){
                if(!tempIDp.startsWith("\t")){
                    //System.out.println(tempIDp);
                    String[] temID = tempIDp.split("\t");
                    for(int i =0;i<temID.length;i++){
                        if(temID[i].startsWith("LOC")){
                            System.out.println(temID[i]);
                            if(!GoAnnotation1.add(temID[i])){
                                bw2.write(temID[1] + "\n");
                            }else{
                                GoAnnotation1.remove(temID[i]);
                            }
                        }
                    }
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
}
