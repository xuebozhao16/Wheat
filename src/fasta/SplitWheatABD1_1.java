/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class SplitWheatABD1_1 {
    public SplitWheatABD1_1(String infileS,String outfileS1,String outfileS2,String outfileS3){
        this.GetSplitABD(infileS,outfileS1,outfileS2,outfileS3);
    } 
    
    public SplitWheatABD1_1(String infileS,String infileS1,String infileS2,String infileS3,String outfileS1,String outfileS2,String outfileS3){
        this.GetSplitABD_KGF(infileS,infileS1,infileS2,infileS3,outfileS1,outfileS2,outfileS3);
    }
    
    
    //这个方法的目的是把原来的1_1的CDS或是pep文件分成三个部分    
    public void GetSplitABD(String infileS,String outfileS1,String outfileS2,String outfileS3){
        try{
            int i = 0;
            String temp = null;
            String tempAll = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            //BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            BufferedWriter bwA = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bwB = IOUtils.getTextWriter(outfileS2);
            BufferedWriter bwD = IOUtils.getTextWriter(outfileS3);
            String chr = null;
            String chrtemp = null;
            String chrtemptemp =null;  
//            boolean all = false;
            boolean wa = false;
            boolean wb = false;
            boolean wd = false;
            while((tempAll = br.readLine()) != null){
                ++i;
                if(i % 10000 == 0){
                    System.out.println("It's time to" + i);
                }
                if(tempAll.startsWith(">")){
                      chrtemp = tempAll.split(" ")[0];
                      //System.out.println(chrtemp);
                      chrtemptemp = chrtemp.substring(1,chrtemp.length()-2);
                      //System.out.println(chrtemptemp);
                      chr = chrtemptemp.substring(8,9);
                      //bw.write(">" + chrtemptemp + "\n");
                      //all = true;
                      if(chr.equals("A")){
                        bwA.write(">" + chrtemptemp);
                        bwA.newLine();
                        wa = true;
                        wb = false;
                        wd = false;                       
                      }else if(chr.equals("B")){
                         bwB.write(">" + chrtemptemp);
                         bwB.newLine();
                         wa = false;
                         wb = true;                     
                         wd = false;
                      }else if(chr.equals("D")){
                          bwD.write(">" + chrtemptemp);
                          bwD.newLine();
                          wa = false;
                          wb = false;
                          wd = true;
                      }else{
                          System.out.println("chromosome unknown!");
                          wa = false;
                          wb = false;
                          wd = false;
                      }
                }else{
                    //bw.write(tempAll);
                    //bw.newLine();
                    if(wa){
                        bwA.write(tempAll);
                        bwA.newLine();
                    }else if (wb){
                        bwB.write(tempAll);
                        bwB.newLine();
                    }else if(wd){
                        bwD.write(tempAll);
                        bwD.newLine();
                    }else{
                        continue;
                    }
                }
                  
            }
            //bw.flush();
            //bw.close();
            bwA.flush();
            bwB.flush();
            bwD.flush();
            bwA.close();
            bwB.close();
            bwD.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法的目的是把1.1中的KGF分成三个部分，以便知道ABD三个亚基因组分别含有哪些基因，个数是多少
    public void GetSplitABD_KGF(String infileS,String infileS1,String infileS2,String infileS3,String outfileS1,String outfileS2,String outfileS3){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String tempAll = null;
            boolean tempA = false;
            boolean tempB = false;
            boolean tempD = false;
            BufferedReader brA = IOUtils.getTextReader(infileS1);
            BufferedReader brB = IOUtils.getTextReader(infileS2);
            BufferedReader brD = IOUtils.getTextReader(infileS3);
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bwA = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bwB = IOUtils.getTextWriter(outfileS2);
            BufferedWriter bwD = IOUtils.getTextWriter(outfileS3);
            Set A = new HashSet();
            Set B = new HashSet();
            Set D = new HashSet();
            String chr = null;
            String chrtemp = null;
            String chrtemptemp =null;
            while((temp = brA.readLine())!= null){
                A.add(temp);
            }
            while((temp = brB.readLine())!= null){
                B.add(temp);
            }
            while((temp = brD.readLine())!= null){
                D.add(temp);
            }        
            while((tempAll = br.readLine()) != null){
                ++i;
                if(i % 10000 == 0){
                    System.out.println("It's time to" + i);
                }
                chr = tempAll.split(("\t"))[2];
                if(!A.add(chr)){
                    bwA.write(tempAll + "\n");
                }else{
                    A.remove(chr);
                } 
                if(!B.add(chr)){
                    bwB.write(tempAll + "\n");
                }else{
                    B.remove(chr);
                }
                if(!D.add(chr)){
                    bwD.write(tempAll + "\n");
                }else{
                    D.remove(chr);
                }                
            }
            bwA.flush();
            bwB.flush();
            bwD.flush();
            bwA.close();
            bwB.close();
            bwD.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    

}
