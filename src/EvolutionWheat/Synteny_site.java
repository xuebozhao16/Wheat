/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class Synteny_site {
    public Synteny_site(String infiles,String outfileS){
        //this.getSynteny_site_1000snp(infiles, outfileS);
        this.reference_allele_frequency(infiles, outfileS);
    }
    //这个方法是对Synteny_site每1000个记录下开始的位置，和1000个的最后的位置
    public void getSynteny_site_1000snp(String infileS,String outfileS){
        try{
            String temp = null;
            int count = 2; 
            String oldpos = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            String[] firstline = br.readLine().split("\t");
            String oldchr = firstline[0]; 
            String firstpos= firstline[1]; 
            while((temp = br.readLine()) !=null){
                String[] tem = temp.split("\t");
                if(count == 1){
                    firstpos = tem[1];
                }
                if(tem[0].equals(oldchr)){
                    if(count == 1000){
                        bw.write(tem[0] + "\t" + firstpos + "\t" + tem[1] + "\t" + count + "\n");
                        //System.out.print(tem[0] + "\t" + firstpos + "\t" + tem[1] + "\t" + count + "\n");
                        count=1;
                    }else{
                        count = count + 1;
                    }
                }
                if(!tem[0].equals(oldchr)){
                    System.out.print(tem[0] + "\n");
                    bw.write(oldchr + "\t" + firstpos + "\t" + oldpos + "\t" +  (count-1) + "\n");
                    firstpos = tem[1];
                    count=2;
                }
                oldchr = tem[0];
                oldpos = tem[1];
            }
            bw.write(oldchr + "\t" + firstpos + "\t" + oldpos + "\t" + (count-1) + "\n");
            bw.flush();
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //这个方法是对VCF文件求参考基因组的等位基因频率
    public void reference_allele_frequency(String infileS,String outfileS){
        try{
            String temp = null;
            int i;
            BufferedReader br = null;
            if (infileS.endsWith("gz")) {
                br = IOUtils.getTextGzipReader(infileS);
            } else {
                br = IOUtils.getTextReader(infileS);

            }
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            //bw.write("CHROM" + "\t" + "POS" + "\t" + "reference_allele_frequency" + "\n");
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                String prefix = tem[0].substring(0, 1);
                if(prefix.equals("#")){
                    
                }
                else {
                    //System.out.println(temp);
                    Double countallele = 0.0;
                    Double count0 = 0.0;
                    for(i=9; i<tem.length;i++){
                        String temtem = tem[i].split(":")[0];
                        if(temtem.equals("0/0")){
                            count0 = count0 + 2;
                            countallele = countallele + 2;
                        }
                        if(temtem.equals("1/0")){
                            count0 = count0 + 1;
                            countallele = countallele + 2;
                        }
                        if(temtem.equals("0/1")){
                            count0 = count0 + 1;
                            countallele = countallele + 2;
                        }
                        if(temtem.equals("1/1")){
                            countallele = countallele + 2;
                        }
                        if(temtem.equals("./.")){

                        }
                    }
                    //System.out.println(count0 + "\n");
                    //System.out.println(countallele + "\n");
                    if(countallele == 0){
                        
                    }else{
                        bw.write(tem[0] + "\t" + tem[1] + "\t" + (count0/countallele) + "\n");
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
}
