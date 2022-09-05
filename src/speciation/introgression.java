/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciation;

import static EvolutionWheat.ForVcftoolsGroup.getTextReader;
import static EvolutionWheat.ForVcftoolsGroup.listFilesEndsWith;
import static EvolutionWheat.ForVcftoolsGroup.listRecursiveFiles;
//import format.table.RowTable;
//import gnu.trove.list.array.TDoubleArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import utils.IOUtils;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class introgression {
    public introgression(String infileS1,String infileS2,String outfileS){
        this.C27_mergeTwoVCFbycol(infileS1, infileS2, outfileS);
        this.E3_FortheRealPosFromFd(infileS1, infileS2, outfileS);
    }
    public introgression(String infileS1,String infileS2){
        //this.individualNe_contribution(infileS1, infileS2);
        this.individualNe_contribution2(infileS1, infileS2);
    }
    
    //这个方法是为了合并两个列相同的VCF的文件
    public void C27_mergeTwoVCFbycol(String infileS1,String infileS2,String outfileS){
        try {
            String temp = null;
            String temp2 = null;
            BufferedReader br1;
            BufferedReader br2;
            if (infileS1.endsWith("gz")) {
                br1 = IOUtils.getTextGzipReader(infileS1);
            } else {
                br1 = IOUtils.getTextReader(infileS1);
            }
            if (infileS2.endsWith("gz")) {
                br2 = IOUtils.getTextGzipReader(infileS2);
            } else {
                br2 = IOUtils.getTextReader(infileS2);
            }
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //开始读要加在后面的那个VCF的文件
            List<String> AE = new ArrayList<>();
            while((temp = br1.readLine())!= null){
                if(temp.startsWith("#")){
                    
                }else{
                   //System.out.println(temp);
                   String tem[] = temp.split("\t");
                   AE.add(tem[tem.length-1]);                          
                }
            }
            //开始读前面的那个VCF的文件
            int i = 0;
            while((temp2 = br2.readLine())!= null){
                if(temp2.startsWith("##")){
                    bw.write(temp2 + "\n");
                }
                else if (temp2.startsWith("#C")){
                   bw.write(temp2 + "\t" + "Ae" + "\n");             
                }
                else{
                    String AEhaplo = AE.get(i);
                    bw.write(temp2 + "\t" + AEhaplo + "\n");  
                    i = i+1;
                }
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //fd算出来的文件转染色体的真实位置
    public void E3_FortheRealPosFromFd(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            RowTable<String> genometable = new RowTable<>(infileS1);
            BufferedReader br = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            br.readLine();
            while((temp = br.readLine()) != null){
                String[] tem = temp.split(",");
                System.out.println(tem[8]);
                if(tem[8].equals("nan")){
                    
                }
                else if(tem[9].equals("-Inf") || tem[9].equals("nan")|| tem[9].equals("NA")){
                    
                }
                else {
                    if(Double.valueOf(tem[8])>=0){
                        int chr = Integer.valueOf(tem[0]);
                        //Double value = getDoubleNumber(tem[7]);
                        String value = tem[9];
                        String pos = tem[1];
                        if (Double.valueOf(tem[9]) < 0){
                          value = "0";
                        }
    //                    if (value.contains("e")){
    //                      value = "0";
    //                    }
                        if (Double.valueOf(tem[9]) > 1){
                          value = "0";
                        }
                        if(chr % 2 == 1){
                            String outchr = genometable.getCell(chr-1, 3);
                            //System.out.println(outchr);
                            bw.write(outchr + "\t" + pos + "\t" + value + "\n");
                        }else{
                            String outchr = genometable.getCell(chr-1, 3);
                            //System.out.println(outchr);
                            int outpos = Integer.valueOf(genometable.getCell(chr-1, 4)) + Integer.valueOf(pos);
                            bw.write(outchr + "\t" + outpos + "\t" + value + "\n");
                        }
                    }
                    
                }
            }
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //现在要做的是对individual_contribution.txt这个文件进行改造
    public void individualNe_contribution(String infileS1,String outfileS2){
        try {
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS2);
            bw.write("Time" + "\t" + "Subspecies" + "\t" + "Contribution" + "\n");
            br.readLine();
            while((temp = br.readLine())!= null){
                String tem[] = temp.split("\t");
                bw.write(tem[0] + "\t" + "wild_einkorn" + "\t" + tem[1] + "\n");
                bw.write(tem[0] + "\t" + "dom_einkorn" + "\t" + tem[2] + "\n");
                bw.write(tem[0] + "\t" + "Urartu" + "\t" + tem[3] + "\n");
                bw.write(tem[0] + "\t" + "Speltoilds" + "\t" + tem[4] + "\n");
                bw.write(tem[0] + "\t" + "tauschii" + "\t" + tem[5] + "\n");
                bw.write(tem[0] + "\t" + "Strangulata" + "\t" + tem[6] + "\n");
                bw.write(tem[0] + "\t" + "Wild_emmer" + "\t" + tem[7] + "\n");
                bw.write(tem[0] + "\t" + "Domesticated_emmer" + "\t" + tem[8] + "\n");
                bw.write(tem[0] + "\t" + "Free_threshing" + "\t" + tem[9] + "\n");
                bw.write(tem[0] + "\t" + "Bread_wheat" + "\t" + tem[10] + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //现在要做的是对individual_contribution.txt这个文件进行改造
    public void individualNe_contribution2 (String infileS1,String outfileS2){
        try {
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS2);
            bw.write("Time" + "\t" + "Subspecies" + "\t" + "Contribution" + "\n");
            br.readLine();
            while((temp = br.readLine())!= null){
                String tem[] = temp.split("\t");
                bw.write(tem[0] + "\t" + "wild_einkorn" + "\t" + tem[1] + "\n");
                bw.write(tem[0] + "\t" + "dom_einkorn" + "\t" + tem[2] + "\n");
                bw.write(tem[0] + "\t" + "Urartu" + "\t" + tem[3] + "\n");
//                bw.write(tem[0] + "\t" + "Speltoilds" + "\t" + tem[4] + "\n");
//                bw.write(tem[0] + "\t" + "tauschii" + "\t" + tem[5] + "\n");
//                bw.write(tem[0] + "\t" + "Strangulata" + "\t" + tem[6] + "\n");bw
                bw.write(tem[0] + "\t" + "Wild_emmer" + "\t" + tem[4] + "\n");
                bw.write(tem[0] + "\t" + "Domesticated_emmer" + "\t" + tem[5] + "\n");
                bw.write(tem[0] + "\t" + "Free_threshing" + "\t" + tem[6] + "\n");
                bw.write(tem[0] + "\t" + "Bread_wheat" + "\t" + tem[7] + "\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
