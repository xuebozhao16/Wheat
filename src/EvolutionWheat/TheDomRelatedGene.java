/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashSet;
import java.util.Set;
import xuebo.analysis.annotation.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class TheDomRelatedGene {
    public TheDomRelatedGene(String infileS,String outfielS){
        this.forgroupGene(infileS, outfielS);
    }
    public TheDomRelatedGene(String infileS,String outfileS1,String outfileS2){
        this.for6groupGene(infileS, outfileS1, outfileS2);
    }
    public TheDomRelatedGene(String infileS1,String infileS2,String infileS3,String infileS4,String infileS5,
                                        String infileS6,String infileS7,String infileS8,String infileS9,String outfileS1,String outfileS2){
        this.forDomWheatGene_XPCLR(infileS1, infileS2, infileS3, infileS4, infileS5, infileS6, infileS7, infileS8, infileS9, outfileS1, outfileS2);
    }
    public TheDomRelatedGene(String infileS1,String infileS2,String infileS3,String infileS4,String infileS5,
                                        String infileS6,String infileS7,String outfileS1,String outfileS2){
        this.forDomWheatGene_Pi(infileS1, infileS2, infileS3, infileS4, infileS5, infileS6, infileS7,outfileS1, outfileS2);
    }
    //这个方法是对ortholog的基因进行统计，计算得出每一个的分组情况 eg.LOC_Os06g40080.1	TraesCS7A02G375400.1	TraesCS7B02G277000.1	TraesCS7D02G371900.1和驯化相关的基因的小麦的列表
    //文件信息   /Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/dom_related_genes/dom_gene/orth_groups.txt
    //输出文件  /Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/dom_related_genes/dom_gene/Domgene_annotation.txt & Domgene_wheat2.txt
    public void for6groupGene(String infileS,String outfileS1,String outfileS2){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            while((temp = br.readLine()) != null){
                if(temp.startsWith("##")){
                    bw1.write(temp + "\n");
                    //bw2.write(temp + "\n");
                }else{
                    String[]tem  = temp.split(" ");
                    for(int i=1;i<tem.length;i++){
                        System.out.println(tem[i]);
                        String species = tem[i].split("\\|")[0];
                        String orhgene = tem[i].split("\\|")[1];
                        bw1.write(orhgene + "\t");
                        if(species.startsWith("Ta")){
                            bw2.write(orhgene.split("\\.")[0] + "\n");
                        }
                    }
                    bw1.newLine();
                }
            }
            bw1.flush();
            bw2.flush();
            bw1.close();
            bw2.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是找出玉米和水稻在驯化和改良过程中小麦的同源基因，
    //文件夹 /Users/xuebozhao/Documents/LuLab/WheatEpigenome/wheatEvolution/dom_related_genes/maize_rice_ortho/ortho_dom.txt 得出小麦的基因就可以了
    public void forgroupGene(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set orhgeneSet = new HashSet();
            while((temp = br.readLine()) != null){
                String[]tem  = temp.split("\t");
                for(int i=1;i<tem.length;i++){  
                    String species = tem[i].split("\\|")[0];
                    String orhgene = tem[i].split("\\|")[1];
                    if(species.startsWith("Ta")){
                        orhgeneSet.add(orhgene);
                    }
                }
            }
            for (Object str : orhgeneSet) {
                bw.write(str + "\n") ;
                System.out.println(str);
            }
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void forDomWheatGene_XPCLR(String infileS1,String infileS2,String infileS3,String infileS4,String infileS5,
                                        String infileS6,String infileS7,String infileS8,String infileS9,String outfileS1,String outfileS2){
        try{
            String temp = null;
            String temmp = null;
            int count2 = 0;
            int count3 = 0;
            int count4 = 0;
            int count5 = 0;
            int count6 = 0;
            int count7 = 0;
            int count8 = 0;
            int count9 = 0;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedReader br3 = IOUtils.getTextReader(infileS3);
            BufferedReader br4 = IOUtils.getTextReader(infileS4);
            BufferedReader br5 = IOUtils.getTextReader(infileS5);
            BufferedReader br6 = IOUtils.getTextReader(infileS6);
            BufferedReader br7 = IOUtils.getTextReader(infileS7);
            BufferedReader br8 = IOUtils.getTextReader(infileS8);
            BufferedReader br9 = IOUtils.getTextReader(infileS9);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            Set br2gene = new HashSet();
            Set br3gene = new HashSet();
            Set br4gene = new HashSet();
            Set br5gene = new HashSet();
            Set br6gene = new HashSet();
            Set br7gene = new HashSet();
            Set br8gene = new HashSet();
            Set br9gene = new HashSet();
            while((temp = br2.readLine()) != null){
                br2gene.add(temp);
            }
            while((temp = br3.readLine()) != null){
                br3gene.add(temp);
            }
            while((temp = br4.readLine()) != null){
                br4gene.add(temp);
            }
            while((temp = br5.readLine()) != null){
                br5gene.add(temp);
            }
            while((temp = br6.readLine()) != null){
                br6gene.add(temp);
            }
            while((temp = br7.readLine()) != null){
                br7gene.add(temp);
            }
            while((temp = br8.readLine()) != null){
                br8gene.add(temp);
            }
            while((temp = br9.readLine()) != null){
                br9gene.add(temp);
            }
            while((temmp = br.readLine()) != null){
                if(!br2gene.add(temmp)){
                    bw2.write("wild einkron–domesticated einkron" + "\t" + temmp + "\n");
                    count2 = count2 + 1;
                }
                if(!br3gene.add(temmp)){
                    bw2.write("wild emmer–domesticated emmer" + "\t" + temmp + "\n");
                    count3 = count3 + 1;
                }
                if(!br4gene.add(temmp)){
                    bw2.write("domesticated emmer–durum" + "\t" + temmp + "\n");
                    count4 = count4 + 1;
                }
                if(!br5gene.add(temmp)){
                    bw2.write("domesticated emmer–cultivar" + "\t" + temmp + "\n");
                    count5 = count5 + 1;
                }
                if(!br6gene.add(temmp)){
                    bw2.write("domestication pair overlap gene" + "\t" + temmp + "\n");
                    count6 = count6 + 1;
                }
                if(!br7gene.add(temmp)){
                    bw2.write("improvment pair overlap gene" + "\t" + temmp + "\n");
                    count7 = count7 + 1;
                }
                if(!br8gene.add(temmp)){
                    bw2.write("wild emmer–domesticated emmer-durum gene" + "\t" + temmp + "\n");
                    count8 = count8 + 1;
                }
                if(!br9gene.add(temmp)){
                    bw2.write("wild emmer–domesticated emmer-cultivar gene" + "\t" + temmp + "\n");
                    count9 = count9 + 1;
                }
            }
            bw1.write("wild einkron–domesticated einkron" + "\t" + count2 + "\n");
            bw1.write("wild emmer–domesticated emmer" + "\t" + count3 + "\n");
            bw1.write("domesticated emmer–durum" + "\t" + count4 + "\n");
            bw1.write("domesticated emmer–cultivar" + "\t" + count5 + "\n");
            bw1.write("domestication pair overlap gene" + "\t" + count6 + "\n");
            bw1.write("improvment pair overlap gene" + "\t" + count7 + "\n");
            bw1.write("wild emmer–domesticated emmer-durum gene" + "\t" + count8 + "\n");
            bw1.write("wild emmer–domesticated emmer-cultivar gene" + "\t" + count9 + "\n");
            bw1.flush();
            bw2.flush();
            bw2.close();
            bw2.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这是找到XPCLR结果中小麦里面的基因的多少
    public void forDomWheatGene_Pi(String infileS1,String infileS2,String infileS3,String infileS4,String infileS5,
                                        String infileS6,String infileS7,String outfileS1,String outfileS2){
        try{
            String temp = null;
            String temmp = null;
            int count2 = 0;
            int count3 = 0;
            int count4 = 0;
            int count5 = 0;
            int count6 = 0;
            int count7 = 0;
                      
            int countAA = 0;
            int countAABB = 0;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedReader br3 = IOUtils.getTextReader(infileS3);
            BufferedReader br4 = IOUtils.getTextReader(infileS4);
            BufferedReader br5 = IOUtils.getTextReader(infileS5);
            BufferedReader br6 = IOUtils.getTextReader(infileS6);
            BufferedReader br7 = IOUtils.getTextReader(infileS7);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            Set br2gene = new HashSet();
            Set br3gene = new HashSet();
            Set br4gene = new HashSet();
            Set br5gene = new HashSet();
            Set br6gene = new HashSet();
            Set br7gene = new HashSet();
            //Set br8gene = new HashSet();
            //Set br9gene = new HashSet();
            while((temp = br2.readLine()) != null){
                br2gene.add(temp);
            }
            while((temp = br3.readLine()) != null){
                br3gene.add(temp);
            }
            while((temp = br4.readLine()) != null){
                br4gene.add(temp);
            }
            while((temp = br5.readLine()) != null){
                br5gene.add(temp);
            }
            while((temp = br6.readLine()) != null){
                br6gene.add(temp);
            }
            while((temp = br7.readLine()) != null){
                br7gene.add(temp);
            }
            while((temmp = br.readLine()) != null){
                if(!br2gene.add(temmp)){
                    bw2.write("Wild einkorn–Domesticated einkorn" + "\t" + temmp + "\n");
                    count2 = count2 + 1;
                }
                if(!br3gene.add(temmp)){
                    bw2.write("Wild emmer–Domesticated emmer" + "\t" + temmp + "\n");
                    count3 = count3 + 1;
                    if(temmp.substring(8, 9).equals("A")){
                        countAA = countAA + 1;
                    }
                }
                if(!br4gene.add(temmp)){
                    bw2.write("Domesticated emmer–Durum" + "\t" + temmp + "\n");
                    count4 = count4 + 1;
                }
                if(!br5gene.add(temmp)){
                    bw2.write("landrace–cultivar" + "\t" + temmp + "\n");
                    count5 = count5 + 1;
                    if(temmp.substring(8, 9).equals("A") | temmp.substring(8, 9).equals("B")){
                        countAABB = countAABB + 1;
                    }
                }
                if(!br6gene.add(temmp)){
                    bw2.write("Domestication pair overlap gene" + "\t" + temmp + "\n");
                    count6 = count6 + 1;
                }
                if(!br7gene.add(temmp)){
                    bw2.write("Improvment pair overlap gene" + "\t" + temmp + "\n");
                    count7 = count7 + 1;
                }
                br2gene.remove(temmp);
                br3gene.remove(temmp);
                br4gene.remove(temmp);
                br5gene.remove(temmp);
                br6gene.remove(temmp);
                br7gene.remove(temmp);            
            }
            System.out.println(countAA);
            System.out.println(countAABB);
            bw1.write("Wild einkron–Domesticated einkron" + "\t" + count2 + "\n");
            bw1.write("Wild emmer–Domesticated emmer" + "\t" + count3 + "\n");
            bw1.write("Domesticated emmer–Durum" + "\t" + count4 + "\n");
            bw1.write("Landrace–Cultivar" + "\t" + count5 + "\n");
            bw1.write("Domestication pair overlap gene" + "\t" + count6 + "\n");
            bw1.write("Improvment pair overlap gene" + "\t" + count7 + "\n");
            bw1.flush();
            bw2.flush();
            bw2.close();
            bw2.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
