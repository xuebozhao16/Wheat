/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashSet;
import java.util.Set;
//import utils.IOUtils;
import xuebo.analysis.annotation.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class GO_analysis {
    public GO_analysis(String infileS1,String infileS2, String outfileS){
        //this.forGOandGENEforspecifiedGene(infileS1, infileS2, outfileS);
        //this.forGOandGENE_forcloned271(infileS1, infileS2, outfileS);
        this.forGOandGENE_forcloned271_redu(infileS1, infileS2, outfileS);;
    }
    

    //这个方法是进行GO分析，得到文件1：基因号和GO对应的文件 文件2：GO和GO的注释信息
    public void forGOandGENEforspecifiedGene(String infileS1,String infileS2, String outfileS){
        try{
            String tempgene = null;
            String temp = null;
            BufferedReader brspecifiedGene = IOUtils.getTextReader(infileS1);
            BufferedReader brGoFile = IOUtils.getTextReader(infileS2);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS);
            //BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            //BufferedWriter bw3 = IOUtils.getTextWriter(outfileS3);
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
                    //GoAnnotation1.add(tem[4] + "_" + tem[0]);
                    GoAnnotation11.add(tem[0]);
                    GoAnnotation2.add(tem[2]+"_" +tem[3]);
                    //GoAnnotation2.add(tem[4]+"_" +tem[5]);
                }else{
                    specifiedGene.remove(tem[0]);
                }
            }
            for (Object str1 : GoAnnotation1) {
                String GOgene = str1.toString();
                //bw1.write(GOgene.split("_")[0] + "," + GOgene.split("_")[1] + "\n");
                bw1.write(GOgene.split("_")[1] + "\t" + GOgene.split("_")[0] + "\n");
            }           
            bw1.flush();
            //bw2.flush();
            //bw3.flush();
            bw1.close();
            //bw2.close();
            //bw3.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //这个方法是进行GO分析，得到文件1：基因号和GO对应的文件 文件2：GO和GO的注释信息
    public void forGOandGENE_forcloned271(String infileS1,String infileS2, String outfileS){
        try{
            String tempgene = null;
            String temp = null;
            BufferedReader brspecifiedGene = IOUtils.getTextReader(infileS1);
            BufferedReader brGoFile = IOUtils.getTextReader(infileS2);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS);
            //BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            //BufferedWriter bw3 = IOUtils.getTextWriter(outfileS3);
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
                if(!specifiedGene.add(tem[0])){ //这里是表明GO里面的基因在有我们想要的基因
                    GoAnnotation1.add(tem[0] + "_" + tem[2] + "_"  +  tem[3] + "_" + tem[4] + "_" + tem[5]);
                }else{
                    specifiedGene.remove(tem[0]);
                }
            }
            bw1.write("geneID\tGO_trem\tGO_term_Description\tGOA_trem\tGOA_term_Description\n");
            for (Object str1 : GoAnnotation1) {
                String GOgene = str1.toString();
                //System.out.println(GOgene);
                bw1.write(GOgene.split("_")[0] + "\t" + GOgene.split("_")[1] + "\t" + GOgene.split("_")[2]+ "\t" +
                        GOgene.split("_")[3] + "\t" + GOgene.split("_")[4]+ "\n");
            }
            bw1.flush();
            bw1.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //这个方法是进行GO分析，得到文件1：基因号和GO对应的文件 文件2：GO和GO的注释信息，现在是要把相同的基因号的基因合并
    public void forGOandGENE_forcloned271_redu(String infileS1,String infileS2, String outfileS){
        try{
            String geneIDtempgene = null;
            String temp = null;
            BufferedReader brspecifiedGene = IOUtils.getTextReader(infileS1);
            BufferedReader brGoFile = IOUtils.getTextReader(infileS2);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS);
            Set GoAnnotation1 = new HashSet();
            while((temp = brGoFile.readLine()) !=null){
                GoAnnotation1.add(temp);
            }
            while((geneIDtempgene = brspecifiedGene.readLine()) != null){//现在是读271个文件进去了
                //StringBuilder GO = new StringBuilder();
                Set GOA = new HashSet();
                StringBuilder GOAA = new StringBuilder();
                for (Object str1 : GoAnnotation1) {
                    String aa[] = str1.toString().split("\t");
                    if(aa[0].equals(geneIDtempgene)){
                        System.out.println(GOA.toString());
                        //GO.append(temp.split("\t")[2]).append(";");
                        //GOA.append(aa[2]).append(";");
                        GOA.add(aa[4]);
                    }else{

                    }
                }
                for (Object str2 : GOA) {
                    String GOgene = str2.toString();
                    GOAA.append(GOgene).append(";");
                }
                String bb =  GOAA.toString();
                bw1.write(geneIDtempgene+ "\t" + bb + "\n");
            }
            bw1.flush();
            bw1.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
