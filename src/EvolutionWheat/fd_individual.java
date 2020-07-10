/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import format.table.RowTable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pgl.infra.dna.genot.GenoIOFormat;
import pgl.infra.dna.genot.GenotypeGrid;
import static pgl.infra.utils.IOUtils.getTextReader;
import static pgl.infra.utils.IOUtils.listFilesEndsWith;
import static pgl.infra.utils.IOUtils.listRecursiveFiles;
import utils.IOUtils;
//import pgl.infra.pgl.infra.dna.genotype;

/**
 *
 * @author xuebozhao
 */
public class fd_individual {
//    public fd_individual(String infileS1,String infileS2,String outfileS1,String outfileS2){
//        this.compareAandAB_fdfile(infileS1, infileS2, outfileS1, outfileS2);
//    }
    public fd_individual(String infileS1,String infileS2,String infileS3,String outfileS){
        this.fdfile_count(infileS1, infileS2, infileS3, outfileS);
        //this.fdfile_count2(infileS1, infileS2, infileS3, outfileS);
    }
    public fd_individual(String infileS,String outfileS){
        this.individual_contribution(infileS, outfileS);
    }
    public fd_individual(String infileS1,String infileS2,String outfileS){
        //this.individual_distance(infileS1, infileS2, outfileS);
        this.individual_distanceD_file(infileS1, infileS2, outfileS);
    }
    public fd_individual(String infileS1,String infileS2,String infileS3,String infileS4,String outfileS){
        this.individual_distance_file(infileS1, infileS2, infileS3, infileS4, outfileS);
    }
    
    //这个方法做的是比较A和AB的file的fd的值的大小
    public void compareAandAB_fdfile(String infileS1,String infileS2,String outfileS1,String outfileS2){
        try {
            String temp = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            String chr = null;
            Set POS = new HashSet();
            HashMap<String, Double> hashMapfd = new HashMap<String, Double>();
            HashMap<String, String> hashMapAcc = new HashMap<String, String>();
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            //现在开始读A的fd的文件
            String pos1 = null;
            br1.readLine();
            while((temp = br1.readLine())!= null){
                    String tem[] = temp.split("\t");
                    pos1 = tem[0]+"_"+tem[1]+"_"+tem[2];
                    POS.add(pos1);
                    hashMapfd.put(pos1, Double.valueOf(tem[5]));
                    //String tem6[] = tem[6].split(",");
                    if(!tem[6].contains(",")){
                        String a = "A" + tem[6];
                        hashMapAcc.put(pos1,a);
                    }else{
                        String tem6[] = tem[6].split(",");
                        StringBuilder headlineSB = new StringBuilder();
                        String aa = null;
                        for(int i=0;i< tem6.length;i++){
                            aa = "A" + tem6[i] + ",";
                            headlineSB.append(aa);
                        }
                        String aaa = headlineSB.toString();
                        String aaaa = aaa.substring(0, aaa.length()-1);
                        hashMapAcc.put(pos1, aaaa);
                    }      
            }
            //现在开始读AB的fd的文件
            String bb = br2.readLine();
            bw1.write(bb + "\n");
            bw2.write(bb + "\n");//先把第一行写出
            while((temp2 = br2.readLine())!= null){
                String tem2[] = temp2.split("\t");
                String pos2 = tem2[0]+"_"+tem2[1]+"_"+tem2[2];
                if(POS.add(pos2)){
                    bw1.write(temp2 + "\n");
                    POS.remove(pos2);
                }else{
                    //这个是加不进去，要判断fd的大小
                    double fd = Double.valueOf(tem2[5]);
                    if(fd > hashMapfd.get(pos2)){
                        bw1.write(temp2 + "\n");
                    }
                    else if(fd < hashMapfd.get(pos2)){
                        bw1.write(tem2[0] + "\t" + tem2[1] + "\t" + tem2[2] + "\t" + tem2[3] + "\t" + tem2[4] + "\t" 
                                + hashMapfd.get(pos2) + "\t" + hashMapAcc.get(pos2) + "\n");
                        System.out.print(tem2[0] + "\t" + tem2[1] + "\t" + tem2[2] + "\t" + tem2[3] + "\t" + tem2[4] + "\t" + hashMapfd.get(pos2) + "\t" + hashMapAcc.get(pos2) + "\n");
                        bw2.write(tem2[0] + "\t" + tem2[1] + "\t" + tem2[2] + "\t" + tem2[3] + "\t" + tem2[4] + "\t" 
                                + hashMapfd.get(pos2) + "\t" + hashMapAcc.get(pos2) + "\n");
                    }else{
                        String acc = hashMapAcc.get(pos2) + "," + tem2[6];
                        bw1.write(tem2[0] + "\t" + tem2[1] + "\t" + tem2[2] + "\t" + tem2[3] + "\t" + tem2[4] + "\t" 
                                + hashMapfd.get(pos2) + "\t" + acc + "\n");
                    }
                }               
            }        
            bw1.flush();
            bw2.flush();
            bw1.close();
            bw2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    //下面的方法是比较IBD distance
//    //getDxy(int taxonIndex1, int taxonIndex2, int startSiteIndex, int endSiteIndex)
//    public void fdfile_getDxy(String infileS1,String infileS2,String outfileS1,String outfileS2){
//        try {
//            
//            GenotypeGrid gt = new GenotypeGrid("file", GenoIOFormat.VCF_GZ);
//            gt.sortByTaxa();
//            String taxa1 = null;
//            String taxa2 = null;
//            int taxa1Index = gt.getTaxonIndex(taxa1);
//            int siteStartIndex = gt.getSiteIndex((short)1, 23432);
//            int siteEndIndex = 0;
//            float dxy = gt.getDxy(taxa1Index, 3, siteStartIndex, siteEndIndex);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    //这个方法做的是对dxy的结果进行统计
    //输入文件：1.AB的dxy文件 2.D的dxy文件
    //3.编号的对应文件 
    public void fdfile_count(String infileS1,String infileS2,String infileS3,String outfileS){
        try {
            String temp = null;
            String temp1 = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedReader br3 = IOUtils.getTextReader(infileS3);
            Set wildemmer = new HashSet();
            Set domemmer = new HashSet();
            Set free = new HashSet();
            int Dline = 0;
            int ABline = 0;
            String taxaNamelist[] = infileS1.toString().split("/");
            String taxaName = taxaNamelist[taxaNamelist.length-1].split("\\.")[0];
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //现在开始读D的fd的文件
            while((temp = br2.readLine())!= null){
                if(!temp.split("\t")[6].startsWith("NA")){
                    Dline = Dline + 1; 
                }    
            }
            //现在开始读编号的对应文件
            while((temp2 = br3.readLine())!= null){
                String tem2[] = temp2.split("\t");
                hashMap1.put(tem2[0], tem2[1]);   
                ABline = ABline + 1;
                if((ABline>=30 && ABline<52) || (ABline>=80 && ABline<90) || (ABline>=119 && ABline<141)){
                    free.add(tem2[1]);
                }
                if(ABline>=52 && ABline<80){
                    wildemmer.add(tem2[1]);
                }
                if(ABline>=90 && ABline<119){
                    domemmer.add(tem2[1]);
                }
            }  
            //现在开始读AB的dxy文件
            int countA  = 0;
            int countwildemmer  = 0;
            int countdomemmer  = 0;
            int countfree  = 0;
            while((temp1 = br1.readLine())!= null){
                String tem1[] = temp1.split("\t");
                if(!tem1[6].equals("NA")){
                    String ID = hashMap1.get(tem1[6]);
                    if(ID.startsWith("A")){
                        countA = countA + 1;
                    }else{
                        int num = Integer.valueOf(tem1[6]);
                        if(num>=23 && num<51){
                            countwildemmer = countwildemmer + 1;
                        }
                        if(num>=61 && num<90){
                            countdomemmer = countdomemmer + 1;
                        }
                        if((num>=1 && num<23) || (num>=51 && num<61) || (num>=90 && num<112)){
                            countfree = countfree + 1;
                        }
                    }             
                }
            }
            double all = countA + countwildemmer + countdomemmer + countfree + Dline;
            bw.write(taxaName + "\t" + countA + "\t" + countwildemmer + "\t" + countdomemmer + "\t" + countfree + "\t" + Dline + "\t"
                    + countA/all + "\t" + countwildemmer/all + "\t" + countdomemmer/all + "\t" + countfree/all + "\t" + Dline/all + "\n");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //这个方法做的是对dxy的结果进行统计，这是第二种表现方式，这里是计算长度
    //输入文件：1.AB的dxy文件 2.D的dxy文件
    //3.编号的对应文件 
    public void fdfile_count2(String infileS1,String infileS2,String infileS3,String outfileS){
        try {
            String temp = null;
            String temp1 = null;
            String temp2 = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedReader br3 = IOUtils.getTextReader(infileS3);
            Set wildemmer = new HashSet();
            Set domemmer = new HashSet();
            Set free = new HashSet();
            int Dline = 0;
            int ABline = 0;
            String taxaNamelist[] = infileS1.toString().split("/");
            String taxaName = taxaNamelist[taxaNamelist.length-1].split("\\.")[0];
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //现在开始读D的fd的文件
            while((temp = br2.readLine())!= null){
                if(!temp.split("\t")[6].startsWith("NA")){
                    Dline = Dline + 1; 
                }    
            }
            //现在开始读编号的对应文件
            while((temp2 = br3.readLine())!= null){
                String tem2[] = temp2.split("\t");
                hashMap1.put(tem2[0], tem2[1]);   
                ABline = ABline + 1;
                if((ABline>=30 && ABline<52) || (ABline>=80 && ABline<90) || (ABline>=119 && ABline<141)){
                    free.add(tem2[1]);
                }
                if(ABline>=52 && ABline<80){
                    wildemmer.add(tem2[1]);
                }
                if(ABline>=90 && ABline<119){
                    domemmer.add(tem2[1]);
                }
            }  
            //现在开始读AB的dxy文件
            //现在开始读AB的dxy文件
            int countA  = 0;
            int countwildemmer  = 0;
            int countdomemmer  = 0;
            int countfree  = 0;
            while((temp1 = br1.readLine())!= null){
                String tem1[] = temp1.split("\t");
                if(!tem1[6].equals("NA")){
                    String ID = hashMap1.get(tem1[6]);
                    if(ID.startsWith("A")){
                        countA = countA + 1;
                    }else{
                        int num = Integer.valueOf(tem1[6]);
                        if(num>=23 && num<51){
                            countwildemmer = countwildemmer + 1;
                        }
                        if(num>=61 && num<90){
                            countdomemmer = countdomemmer + 1;
                        }
                        if((num>=1 && num<23) || (num>=51 && num<61) || (num>=90 && num<112)){
                            countfree = countfree + 1;
                        }
                    }             
                }
            }
            bw.write(taxaName + "\t" + "urartu" + "\t" + countA + "\n");
            bw.write(taxaName + "\t" + "wildemmer" + "\t" + countwildemmer + "\n");
            bw.write(taxaName + "\t" + "domemmer" + "\t" + countdomemmer + "\n");
            bw.write(taxaName + "\t" + "free_threshing" + "\t" + countfree + "\n");
            bw.write(taxaName + "\t" + "strangulata" + "\t" + Dline + "\n");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //现在要做的是对individual_contribution.txt这个文件进行改造
    public void individual_contribution(String infileS,String outfileS){
        try {
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS); 
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);           
            bw.write("Taxa" + "\t" + "Subspecies" + "\t" + "Contribution" + "\n");
            br.readLine();
            while((temp = br.readLine())!= null){
               String tem[] = temp.split("\t");
               bw.write(tem[1] + "\t" + "Urartu" + "\t" + tem[6] + "\n");
               bw.write(tem[1] + "\t" + "Wild_emmer" + "\t" + tem[7] + "\n");
               bw.write(tem[1] + "\t" + "Domesticated_emmer" + "\t" + tem[3] + "\n");
               bw.write(tem[1] + "\t" + "Free_threshing" + "\t" + tem[4] + "\n");
               bw.write(tem[1] + "\t" + "Strangulata" + "\t" + tem[5] + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //现在要做的是得到每个个体的遗传距离和地理距离
    public void individual_distance(String infileS1,String infileS2,String outfileS){
        try {
            String temp = null;
            RowTable<String> distable = new RowTable<>(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2); 
            BufferedWriter bw = null;  
            int line = 0;
            //Set taxa = new HashSet();
            while((temp = br2.readLine())!= null){
               //taxa.add(temp);
               line = line + 1;
               bw = IOUtils.getTextWriter(outfileS + "/land" + line + "_" + temp + ".txt"); 
               //bw.write("distance" + "\n");
               for(int i = 0;i<distable.getRowNumber();i++){
                   //System.out.println(distable.getCell(i, 0) + "\n");
                   if(temp.equals(distable.getCell(i, 0))){
                       bw.write(distable.getCell(i, 0) + "\t"  + distable.getCell(i, 1) +  "\t"  +
                               distable.getCell(i, 2) +  "\t"  + distable.getCell(i, 3) + "\n");
                   }
                   if(temp.equals(distable.getCell(i, 1))){
                       bw.write(distable.getCell(i, 1) +  "\t"  + distable.getCell(i, 0) +  "\t"  + 
                               distable.getCell(i, 2) +  "\t"  + distable.getCell(i, 3) + "\n");
                   }
               }
               bw.flush();
               bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //现在要做的是得到每个个体的遗传距离和地理距离的文件之后，按照三个pool合并，得到一行的数据，99个数据放在一起，
    //infileS2 wildemmer
    //infileS3 domemmer
    //infileS4 free-threshing
    public void individual_distance_file(String infileS1,String infileS2,String infileS3,String infileS4,String outfileS){
        try{   
            String temp = null;
            String temp2 = null; 
            String temp3 = null;
            String temp4 = null;
            BufferedReader disfile = null;
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedReader br3 = IOUtils.getTextReader(infileS3);
            BufferedReader br4 = IOUtils.getTextReader(infileS4);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set WE = new HashSet();
            Set DE = new HashSet();
            Set FT = new HashSet();
            while((temp2 = br2.readLine())!= null){
                WE.add(temp2);
            }
            while((temp3 = br3.readLine())!= null){
                DE.add(temp3);
            }
            while((temp4 = br4.readLine())!= null){
                FT.add(temp4);
            }       
            HashMap<String, Double> hashMapMean = new HashMap<String, Double>();
            bw.write("taxa" + "\t" + "IBSdis_wildemmer" + "\t" + "IBSdis_domemmer" + "\t" + "IBSdis_free" + "\t" + 
                    "GEOdis_wildemmer" + "\t" + "GEOdis_domemmer" + "\t" + "GEOdis_free" +"\n");
            File f = new File(infileS1);
            File[] fs = listRecursiveFiles(f);
            File[] sub = listFilesEndsWith(fs, "txt");
            for(File fi:sub){
                disfile = getTextReader(fi.toString());
                String taxaNamelist[] = fi.toString().split("/");
                String taxaName = taxaNamelist[taxaNamelist.length-1].split("\\.")[0].split("_")[1];
                System.out.print("It's " + taxaName + "\n");
                int linewild = 0;
                int linedom = 0;
                int linefree = 0;
                double IBS_wild = 0;
                double IBS_dom = 0;
                double IBS_free = 0;
                double GEO_wild = 0;
                double GEO_dom = 0;
                double GEO_free = 0;
                while((temp = disfile.readLine()) != null){
                    String[] tem = temp.split("\t");
                    if(WE.add(tem[1])){
                        WE.remove(tem[1]);
                        if(DE.add(tem[1])){
                            DE.remove(tem[1]);
                            if(FT.add(tem[1])){
                                FT.remove(tem[1]);
                            }else{
                                linefree = linefree +1;
                                IBS_free = IBS_free + Double.valueOf(tem[2]);
                                GEO_free = GEO_free + Double.valueOf(tem[3]);
                            }
                        }else{
                            linedom = linedom +1;
                            IBS_dom = IBS_dom + Double.valueOf(tem[2]);
                            GEO_dom = GEO_dom + Double.valueOf(tem[3]);
                        }
                    }else{
                        linewild = linewild +1;
                        IBS_wild = IBS_wild + Double.valueOf(tem[2]);
                        GEO_wild = GEO_wild + Double.valueOf(tem[3]);
                    }
                }
                bw.write(taxaName + "\t" + IBS_wild/linewild + "\t" + IBS_dom/linedom + "\t" +  IBS_free/linefree + "\t" +
                        GEO_wild/linewild + "\t" + GEO_dom/linedom + "\t" +  GEO_free/linefree + "\n");
            } 
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //现在要做的是得到每个个体的遗传距离和地理距离的文件之后，按照三个pool合并，得到一行的数据，99个数据放在一起，
    //infileS2 Strangulata
    public void individual_distanceD_file(String infileS1,String infileS2,String outfileS){
        try{   
            String temp = null;
            String temp2 = null; 
            String temp3 = null;
            String temp4 = null;
            BufferedReader disfile = null;
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set WE = new HashSet();
            while((temp2 = br2.readLine())!= null){
                WE.add(temp2);
            }
            HashMap<String, Double> hashMapMean = new HashMap<String, Double>();
            bw.write("taxa" + "\t" + "IBSdis_Strangulata" + "\t" + "GEOdis_Strangulata" +"\n");
            File f = new File(infileS1);
            File[] fs = listRecursiveFiles(f);
            File[] sub = listFilesEndsWith(fs, "txt");
            for(File fi:sub){
                disfile = getTextReader(fi.toString());
                String taxaNamelist[] = fi.toString().split("/");
                String taxaName = taxaNamelist[taxaNamelist.length-1].split("\\.")[0].split("_")[1];
                System.out.print("It's " + taxaName + "\n");
                int lineDD = 0;
                double IBS_DD = 0;
                double GEO_DD = 0;
                while((temp = disfile.readLine()) != null){
                    String[] tem = temp.split("\t");
                    if(WE.add(tem[1])){
                        WE.remove(tem[1]);
                    }else{
                        lineDD = lineDD +1;
                        IBS_DD = IBS_DD + Double.valueOf(tem[2]);
                        GEO_DD = GEO_DD + Double.valueOf(tem[3]);
                    }
                }
                bw.write(taxaName + "\t" + IBS_DD/lineDD + "\t"  +  GEO_DD/lineDD + "\n");
            } 
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
