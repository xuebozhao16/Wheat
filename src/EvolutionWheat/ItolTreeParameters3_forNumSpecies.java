/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class ItolTreeParameters3_forNumSpecies {
    public ItolTreeParameters3_forNumSpecies(String infileS1,String infileS2,String outfileS){
        //this.forNumSpecies(infileS1, infileS2, outfileS);
        //this.getItolTreeBin_location(infileS1, infileS2, outfileS);
        this.getItolTreeBin_location2(infileS1, infileS2, outfileS);
    }
    public ItolTreeParameters3_forNumSpecies(String infileS,String outfileS){
        this.getBrabchColor_forNumSpecies(infileS, outfileS);
    }
     
    
    //这个方法是改变系统发生树的名称，把原来的编号换成1，2，3，4，5，6，7，9等，这样有助于去标识系统发生树
    public void forNumSpecies(String infileS1,String infileS2,String outfileS){
        try{
            String temp1 = null;
            String tem = null;
            String temp2 = null;
            int i = 0;
            BufferedReader groupFileS = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String,String> HashMap1 = new HashMap<String,String>();
            while((temp1 = br1.readLine()) != null){
                tem = temp1;
            }
            File f = new File(infileS2);
            File[] fs = IOUtils.listRecursiveFiles(f);
            File[] sub = IOUtils.listFilesEndsWith(fs, ".txt");
            for(File fi:sub){
                i++;
                groupFileS = IOUtils.getTextReader(fi.getAbsolutePath().toString());
                //System.out.println(fi.getAbsolutePath().toString());
                String[] pa = fi.getAbsolutePath().toString().split("/");
                String paname = pa[pa.length-1];
                String groupnum = paname.split("_")[0];
                String groupname = paname.split("_")[1];
                while((temp2 = groupFileS.readLine()) != null){
                    //System.out.println(groupname + "\n");
                    //System.out.println(temp2);
                    String aa = temp2;
//                    if(aa.equals("B073")){
//                        System.out.println("aaaaaa"+ "\n");
//                    }
                    if(tem.contains("(" + aa + ":") || tem.contains("," + aa + ":")){
                        System.out.println("yes" + "\n");                       
                        tem = tem.replaceAll(aa, groupnum); 
                    }               
                }
            }
            tem = tem.replaceAll("188H", "19"); 
            tem = tem.replaceAll("18B", "18"); 
            tem = tem.replaceAll("CY18", "18"); 
            tem = tem.replaceAll("BDH18", "18"); 
            tem = tem.replaceAll("DXHK18", "18"); 
            tem = tem.replaceAll("Jin18", "18"); 
            System.out.println(tem + "\n");
            bw.write(tem + "\n");
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
    
    //这个方法是把系统发生树的Brabch找到替代 eg:B023    1
    public void getBrabchColor_forNumSpecies(String infileS, String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            int i = 0;
            BufferedReader groupFileS = null;
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("LABELS" + "\n");
            bw.write("SEPARATOR TAB" + "\n");
            bw.write("DATA" + "\n");
            File f = new File(infileS);
            File[] fs = IOUtils.listRecursiveFiles(f);
            File[] sub = IOUtils.listFilesEndsWith(fs, ".txt");
            for(File fi:sub){
                i++;
                groupFileS = IOUtils.getTextReader(fi.getAbsolutePath().toString());
                System.out.println(fi.getAbsolutePath().toString());
                String[] pa = fi.getAbsolutePath().toString().split("/");
                String paname = pa[pa.length-1];
                String groupnum = paname.split("_")[0];
                String groupname = paname.split("_")[1];
                while((temp2 = groupFileS.readLine()) != null){
                    System.out.println(temp2);
                    bw.write(temp2 + "\t" + (Integer.valueOf(groupnum) + 3) + "\n");                
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
    
    //这个方法是地理位置信息 这是分类是6个的
    public void getItolTreeBin_location(String infileS1, String infileS2, String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            int i = 0;
            BufferedReader groupFileS = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("DATASET_BINARY" + "\n");
            bw.write("SEPARATOR COMMA" + "\n");
            bw.write("DATASET_LABEL,binary_data" + "\n");
            bw.write("COLOR,#ff0000" + "\n");
            bw.write("FIELD_LABELS,rl0,rl1,rl2,rl3,rl4,rl5" + "\n");
            //"#FF0000","#00F5FF","#FDB462","#FFC0CB","#696969","#CDC9A5"
            bw.write("FIELD_COLORS,#FF0000,#00F5FF,#FDB462,#FFC0CB,#696969,#CDC9A5" + "\n");
            //bw.write("FIELD_COLORS,#FF0000FF,#0000FF,#98FB98F,#FFB90F,#FF69B4" + "\n");
            bw.write("FIELD_SHAPES,2,2,2,2,2,2" + "\n");
            bw.write("SHOW_INTERNAL,1" + "\n");
            bw.write("MARGIN,0" + "\n");
            bw.write("HEIGHT_FACTOR,1" + "\n");
            bw.write("SYMBOL_SPACING,10" + "\n");
            bw.write("DATA" + "\n");
            HashMap<String,String> HashMap1 = new HashMap<String,String>();
            while((temp1 = br1.readLine()) != null){
                HashMap1.put(temp1.split("\t")[0], temp1.split("\t")[1]);
            }
            while((temp2 = br2.readLine()) != null){
                String [] tem = temp2.split("\t");
                String binlocation = HashMap1.get(tem[1]);
                bw.write(tem[0] + "," + binlocation + "\n");
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
    
    //这个方法是地理位置信息 这是分类是4个的
    public void getItolTreeBin_location2(String infileS1, String infileS2, String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            int i = 0;
            BufferedReader groupFileS = null;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("DATASET_BINARY" + "\n");
            bw.write("SEPARATOR COMMA" + "\n");
            bw.write("DATASET_LABEL,binary_data" + "\n");
            bw.write("COLOR,#ff0000" + "\n");
            bw.write("FIELD_LABELS,rl0,rl1,rl2,rl3,rl4" + "\n");
            //"#FF0000","#00F5FF","#FDB462","#FFC0CB","#696969","#CDC9A5"
            //bw.write("FIELD_COLORS,#FF0000,#00F5FF,#FDB462,#556B2F" + "\n");
            bw.write("FIELD_COLORS,#FF0000,#00F5FF,#fdd662,#556B2F,#808080" + "\n");
            //bw.write("FIELD_COLORS,#FF0000FF,#0000FF,#98FB98F,#FFB90F,#FF69B4" + "\n");
            bw.write("FIELD_SHAPES,2,2,2,2,2" + "\n");
            bw.write("SHOW_INTERNAL,1" + "\n");
            bw.write("MARGIN,0" + "\n");
            bw.write("HEIGHT_FACTOR,1" + "\n");
            bw.write("SYMBOL_SPACING,10" + "\n");
            bw.write("DATA" + "\n");
            HashMap<String,String> HashMap1 = new HashMap<String,String>();
            while((temp1 = br1.readLine()) != null){
                HashMap1.put(temp1.split("\t")[0], temp1.split("\t")[1]);
            }
            while((temp2 = br2.readLine()) != null){
                String [] tem = temp2.split("\t");
                String binlocation = HashMap1.get(tem[1]);
                bw.write(tem[0] + "," + binlocation + "\n");
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
}
