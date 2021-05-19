/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class RNAseqDataCompare {
    public RNAseqDataCompare(String infileS,String outfileS){
        //this.getTPMfromKallisto(infileS, outfileS);   
        //this.getTPMfromScience209(infileS, outfileS);
    } 
    public RNAseqDataCompare(String infileS1,String infileS2,String outfileS){
        //this.getTPMfrom111(infileS1, infileS2, outfileS);
    }
    public RNAseqDataCompare(String infileS1,String infileS2,String infileS3,String infileS4,String outfileS){
        //this.getTPMfromAdd0(infileS1, infileS2, infileS3, infileS4, outfileS);
        //this.getTPMfromAddN(infileS1, infileS2, infileS3, infileS4, outfileS);
    }
    public RNAseqDataCompare(String infileS1,String infileS2,String infileS3,String infileS4,String infileS5,String infileS6,String infileS7,String outfileS){
        this.getTPMfromAddNNN(infileS1, infileS2, infileS3, infileS4, infileS5, infileS6, infileS7, outfileS);
    }
    //kallisto做出来的是1_58508_58769_TraesCS1A01G000100	261	81.3797	8.65425	4.01143
    //只想要基因和第五列
    public void getTPMfromKallisto(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            br.readLine();
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t");
                String [] temtem = tem[0].split("_");
                bw.write(temtem[3] + "\t" + tem[4] + "\n");
            }           
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //输入文件是science 文章中的文件，209个组织，有表头，没有LC和叶绿体线粒体,现在的目的是只要一个转录本，就是.1的那一个
    public void getTPMfromScience209(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write(br.readLine()+ "\n");
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t");
                String [] temtem = tem[0].split("\\.");
                if(temtem[1].equals("1")){
                    String temp2 = temp.replace(tem[0], temtem[0]);
                    bw.write(temp2 + "\n");
                }                
            }           
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //计算1:1:1基因的TPM的值，br1指的是1：1：1的文件，br2是所有基因的TPM
    public void getTPMfrom111(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
            String tempAll = null;
            int i =0;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set RecoprocalGene111 = new HashSet();
            while((temp = br1.readLine())!= null){
                String[] tem = temp.split("\t");
                RecoprocalGene111.add(tem[0]);
                RecoprocalGene111.add(tem[1]);
                RecoprocalGene111.add(tem[2]);
            }
            br2.readLine();
            while((tempAll = br2.readLine()) != null){
                ++i;
                if(i % 10000 == 0){
                    System.out.println("It's time to" + i);
                }
                String[] temtem = tempAll.split("\t");
                String tt = temtem[0].replace("2G","1G");
                if(!RecoprocalGene111.add(tt)){
                     bw.write(tempAll + "\n");
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //计算1:1:0,1:0:1,0:1:1基因的TPM的值，br1指的是1：1：0的文件，br2指的是1：0：1的文件,br3指的是0：1：1的文件，br4是所有基因的TPM
    public void getTPMfromAdd0(String infileS1,String infileS2,String infileS3,String infileS4,String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            String temp3 = null;
            String tempAll = null;
            int i =0;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedReader br3 = IOUtils.getTextReader(infileS3);
            BufferedReader br4 = IOUtils.getTextReader(infileS4);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set RecoprocalGeneAdd0 = new HashSet();
            while((temp1 = br1.readLine())!= null){
                String[] tem1 = temp1.split("\t");
                RecoprocalGeneAdd0.add(tem1[0]);
                RecoprocalGeneAdd0.add(tem1[1]);
            }
             while((temp2 = br2.readLine())!= null){
                String[] tem2 = temp2.split("\t");
                RecoprocalGeneAdd0.add(tem2[0]);
                RecoprocalGeneAdd0.add(tem2[1]);
            }
            while((temp3 = br3.readLine())!= null){
                String[] tem3 = temp3.split("\t");
                RecoprocalGeneAdd0.add(tem3[0]);
                RecoprocalGeneAdd0.add(tem3[1]);
            }
            while((tempAll = br4.readLine()) != null){
                ++i;
                if(i % 10000 == 0){
                    System.out.println("It's time to" + i);
                }
                String[] temtem = tempAll.split("\t");
                String tt = temtem[0].replace("2G","1G");
                if(!RecoprocalGeneAdd0.add(tt)){
                     bw.write(tempAll + "\n");
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //计算1:1:N,1:N:1,N:1:1基因的TPM的值，br1指的是1：1：N的文件，br2指的是1：N：1的文件,br3指的是N：1：1的文件，br4是所有基因的TPM
    public void getTPMfromAddN(String infileS1,String infileS2,String infileS3,String infileS4,String outfileS){
        try{
            String temp1 = null;
            String temp2 = null;
            String temp3 = null;
            String tempAll = null;
            int i =0;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedReader br3 = IOUtils.getTextReader(infileS3);
            BufferedReader br4 = IOUtils.getTextReader(infileS4);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set RecoprocalGeneAdd0 = new HashSet();
            while((temp1 = br1.readLine())!= null){
                String[] tem1 = temp1.split("\t");
                RecoprocalGeneAdd0.add(tem1[0]);
                RecoprocalGeneAdd0.add(tem1[1]);
            }
             while((temp2 = br2.readLine())!= null){
                String[] tem2 = temp2.split("\t");
                RecoprocalGeneAdd0.add(tem2[0]);
                RecoprocalGeneAdd0.add(tem2[1]);
            }
            while((temp3 = br3.readLine())!= null){
                String[] tem3 = temp3.split("\t");
                RecoprocalGeneAdd0.add(tem3[0]);
                RecoprocalGeneAdd0.add(tem3[1]);
            }
            while((tempAll = br4.readLine()) != null){
                ++i;
                if(i % 10000 == 0){
                    System.out.println("It's time to" + i);
                }
                String[] temtem = tempAll.split("\t");
                String tt = temtem[0].replace("2G","1G");
                if(!RecoprocalGeneAdd0.add(tt)){
                     bw.write(tempAll + "\n");
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //计算1:1:N,1:N:1,N:1:1基因的中的N的TPM的值，br1指的是1：1：N的文件中的AN，br2指的是1：1：N的文件中的BN,
    //br3指的是1：N：1的文件中的AN，br4指的是1：N：1的文件中的DN
    //br5指的是N：1：1的文件中的BN，br6指的是N：1：1的文件中的DN
    //br7是所有基因的TPM
    public void getTPMfromAddNNN(String infileS1,String infileS2,String infileS3,String infileS4,String infileS5,String infileS6,String infileS7,String outfileS
                                 ){
        try{
            String temp1 = null;
            String temp2 = null;
            String temp3 = null;
            String temp4 = null;
            String temp5 = null;
            String temp6 = null;
            String tempAll = null;
            int i =0;
            BufferedReader br1 = IOUtils.getTextReader(infileS1);
            BufferedReader br2 = IOUtils.getTextReader(infileS2);
            BufferedReader br3 = IOUtils.getTextReader(infileS3);
            BufferedReader br4 = IOUtils.getTextReader(infileS4);
            BufferedReader br5 = IOUtils.getTextReader(infileS5);
            BufferedReader br6 = IOUtils.getTextReader(infileS6);
            BufferedReader br7 = IOUtils.getTextReader(infileS7);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            Set RecoprocalGeneAdd0 = new HashSet();
            while((temp1 = br1.readLine())!= null){
                String[] tem1 = temp1.split("\t");
                RecoprocalGeneAdd0.add(tem1[1]);
            }
             while((temp2 = br2.readLine())!= null){
                String[] tem2 = temp2.split("\t");
                RecoprocalGeneAdd0.add(tem2[1]);
            }
            while((temp3 = br3.readLine())!= null){
                String[] tem3 = temp3.split("\t");
                RecoprocalGeneAdd0.add(tem3[1]);
            }
            while((temp4 = br4.readLine())!= null){
                String[] tem4 = temp4.split("\t");
                RecoprocalGeneAdd0.add(tem4[1]);
            }
            while((temp5 = br5.readLine())!= null){
                String[] tem5 = temp5.split("\t");
                RecoprocalGeneAdd0.add(tem5[1]);
            }
            while((temp6 = br6.readLine())!= null){
                String[] tem6 = temp6.split("\t");
                RecoprocalGeneAdd0.add(tem6[1]);
            }
            while((tempAll = br7.readLine()) != null){
                ++i;
                if(i % 10000 == 0){
                    System.out.println("It's time to" + i);
                }
                String[] temtem = tempAll.split("\t");
                String tt = temtem[0].replace("2G","1G");
                if(!RecoprocalGeneAdd0.add(tt)){
                     bw.write(tempAll + "\n");
                }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
