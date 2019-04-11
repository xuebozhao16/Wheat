/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import static EvolutionWheat.ForVcftoolsGroup.getTextReader;
import static EvolutionWheat.ForVcftoolsGroup.listFilesEndsWith;
import static EvolutionWheat.ForVcftoolsGroup.listRecursiveFiles;
import format.table.RowTable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import utils.IOUtils;
import static utils.IOUtils.getTextWriter;

/**
 *
 * @author xuebozhao
 */
public class Filefolder_pip {
    public Filefolder_pip(String infileS1,String infileS2,String outfileS){
        this.getSlideGenome_chrMeanPi(infileS1, infileS2, outfileS);
    }
  
    //这个方法是对两个文件夹中数据求比值
    //这是求的slide genome的信息，第一个文件夹是总的Pi的值，第二个文件夹是基因的数目
    public void getSlideGenome_chrMeanPi(String infileS1,String infileS2,String outfileS){      
         try{    
            String temp = null; 
            int i;
            RowTable<String> pivalue = new RowTable<>(infileS1);
            RowTable<String> pigenecount = new RowTable<>(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //String filename = infileS1.toString();
            String taxaNamelist[] = infileS1.toString().split("/");
            String filechrname = taxaNamelist[taxaNamelist.length-1].split("\\.")[0];
            String filename = taxaNamelist[taxaNamelist.length-1].split("\\.")[1];
            System.out.print("It's " + filechrname + "\t" + filename + "\n");
            for(i=0;i<pivalue.getRowNumber();i++){
                Double aa = Double.valueOf(pivalue.getCell(i, 1));
                Double bb = Double.valueOf(pigenecount.getCell(i, 1));
                String cc = pivalue.getCell(i, 0);
                bw.write(filechrname + "\t" + (aa/bb) + "\t" + cc + "\n");
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //对文件夹中所有以.summary为结尾的文件求10K的bin,均值
    //文件夹位置/data1/home/yaozhou/Projects/EVO/data/lineage/final/V11/LDdecay/1M
    public void forAllFile10Kbin(String infileS,String suffix,String outfileS){
        try{    
            String temp = null;
            BufferedReader ldFile = null;
            File f = new File(infileS);
            File[] fs = listRecursiveFiles(f);
            File[] sub = listFilesEndsWith(fs, suffix);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            double a[][] = new double[10000][3]; //这个取决于bin的大小，10M/1000=10000
            for(File fi:sub){
                int i = 0;
                while((temp = ldFile.readLine()) != null){
                    i=i+1;
                    String[] tem = temp.split("\t");
                    int rownum = (int) Math.ceil(i / 1000);	
                    a[rownum][0] = rownum;                  
                    a[rownum][1] = a[rownum][1] + Double.valueOf(tem[1]);
                    a[rownum][2] = a[rownum][2] + 1;  
                }                
            }
            for(int j=0;j<a.length;j++){
                double ratio = a[j][1]/a[j][2];
                bw.write(a[j][1] + "\t" + a[j][2] + "\t" + ratio + "\n");
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
