/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.Spliterators.iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.commons.lang.time.DateUtils.iterator;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class OneToManyInWheat {
    
    public OneToManyInWheat(String infile,String outfile){
        //this.filterAToB(infile, outfile);
        this.filterAToB_N(infile, outfile);
    }
    public OneToManyInWheat(String infileS1,String infileS2,String outfileS){
        //this.getReciprocalBest1To1(infileS1, infileS2, outfileS);
        //this.get1To1ToNstep1(infileS1, infileS2, outfileS);
        //this.getNTo1To1step1(infileS1, infileS2, outfileS);
        //this.get1ToNTo1step1(infileS1, infileS2, outfileS);
        //this.getAB0andN(infileS1, infileS2, outfileS);
        //this.getA0DandN(infileS1, infileS2, outfileS);
        this.get0BDandN(infileS1, infileS2, outfileS);
        
    }
    
//    public OneToManyInWheat(String infileS1,String infileS2,String outfileS1,String outfileS2){
//        //this.get1To1ToNstep2(infileS1, infileS2, outfileS1, outfileS2);
//        //this.getNTo1To1step2(infileS1, infileS2, outfileS1, outfileS2);
//        //this.get1ToNTo1step2(infileS1, infileS2, outfileS1, outfileS2);       
//    }
    
    public OneToManyInWheat(String infileS,String outfileS1,String outfileS2,String outfileS3){
        //this.getABD1To1ToNgene2(infileS, outfileS1, outfileS2, outfileS3);
        //this.getABD1ToNTo1gene2(infileS, outfileS1, outfileS2, outfileS3);
        //this.getABDNTo1To1gene2(infileS, outfileS1, outfileS2, outfileS3);
    }
    
//    public void filterAToB(String infile,String outfile1,String outfile2){
//        try{
//            BufferedReader br = IOUtils.getTextReader(infile);
//            BufferedWriter bw1 = IOUtils.getTextWriter(outfile1);
//            BufferedWriter bw2 = IOUtils.getTextWriter(outfile2);
//            String temp  = null;
//            Set <String> filterAB_nocp = new HashSet();
//            Set <String> filterAB_cp = new HashSet();
//            HashMap<String, String> hashMapAB = new HashMap<String, String>();
//            while((temp = br.readLine())!= null){
//                String [] tem = temp.split("\t");
//                String [] temtem0 = tem[0].split("_");
//                String [] temtem1 = tem[1].split("_");
//                if(filterAB_nocp.add(temtem1[1])){
//                    
//                }else{
//                    filterAB_cp.add(temtem1[1]);
//                    filterAB_nocp.remove(temtem1[1]);
//                }                   
//            }
////            for(Map.Entry<String, String> entry : hashMapAB.entrySet()){
////                bw1.write(entry.getValue()+ "\t" + entry.getKey() + "\n");
////            }
//            
//            bw1.flush();
//            bw2.flush();
//            bw1.close();
//            bw2.close();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    //找到crb-blast中没有排序的文件中重复和非重复的
        public void filterAToB(String inFile,String outFile){
            BufferedReader br = IOUtils.getTextReader(inFile);
            BufferedWriter bw1 = IOUtils.getTextWriter(outFile+"/filterBD_N.txt");
            BufferedWriter bw2 = IOUtils.getTextWriter(outFile+"/filterBD_1.txt");
            Set dup = new HashSet();
            Set gene1 = new HashSet();
            List <String> geneList = new ArrayList<String>();
            List <String> gene = new ArrayList<String> ();
            try {
                String temp = "";
                String[] te = null;
                String[] te1 = null;
                String[] tee = null;
                while ((temp = br.readLine())!=null){
                    //geneList.add(temp);
                    te = temp.split("\t");
                    //te1 = te[0].split("_");
                    //tee = te[1].split("_");
                    geneList.add(te[0]  + "\t" + te[1]);
                    gene.add(te[1]);
                    if(!gene1.add(te[1])){
                        dup.add(te[1]);
                    };
                }
                int i=0;
                for (String g : gene){
                    if(!dup.add(g)){
                        //bw1.write(geneList.get(i));
                        String[] temmp = geneList.get(i).split("\t");
                        bw1.write(temmp[1] + "\t" + temmp[0]);
                        bw1.newLine();
                    }else{
                        bw2.write(geneList.get(i));
                        bw2.newLine();
                    }
                    i++;
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
//    public void filterAToB_N(String infile,String outfile){
//        try{
//            BufferedReader br = IOUtils.getTextReader(infile);
//            BufferedWriter bw1 = IOUtils.getTextWriter(outfile);
//            String temp  = null;
//            Set <String> filterAB_BToA = new HashSet();
//            List<String> listAB = new ArrayList();
//            String tempp = null;
//            HashMap<String, String> hashMapAB = new HashMap<String, String>();
//            while((temp = br.readLine())!= null){
//                String [] tem = temp.split("\t");
//                    listAB.add(tem[0]);
//                    hashMapAB.put(tem[0],tem[1]);        
//            }
//            Collections.sort(listAB);
//            for(int i =0 ;i <listAB.size();i++){
//                if(listAB.get(i).equals(tempp)){
//                    tempp = tempp + "\t" + 
//                }
//            }
//            bw1.flush();
//            bw2.flush();
//            bw1.close();
//            bw2.close();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    
    //找到重复的比对（已经排序）把1 to N 往后排，之间用；分开
    public void filterAToB_N(String infile,String outfile){
        try{
            BufferedReader br = IOUtils.getTextReader(infile);
            BufferedWriter bw = IOUtils.getTextWriter(outfile);
            String temp  = null;
            StringBuilder temmp = new StringBuilder();
            temp = br.readLine();
            String [] tem = temp.split("\t");
            String tempstore = tem[0];
            temmp = new StringBuilder(tem[1]);
            //Set <String> filterAB_N = new HashSet();
            while((temp = br.readLine())!= null){
                tem = temp.split("\t");              
                if(tem[0].equals(tempstore)){
                    temmp = temmp.append(";").append(tem[1]);
                    tempstore = tem[0];
                }else{                   
                    bw.write(tempstore + "\t" + temmp + "\n");
                    tempstore = tem[0];
                    temmp = new StringBuilder(tem[1]);
                    System.out.println(temmp);
                }                   
            }  
            bw.write(tempstore + "\t" + temmp + "\n");
//                if(tem[0].equals(tempstore)){
//                    temmp = temmp.append(";").append(tem[1]);
//                    tempstore = tem[0];
//                }else{                   
//                    bw.write(tempstore + "\t" + temmp + "\n");
//                    tempstore = tem[0];
//                    temmp = new StringBuilder(tem[1]);
//                    System.out.println(temmp);
//                }  
            bw.flush();
            bw.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
       
    //对唯一比对的两个文件进行处理，找到AB和BA都可以哒，即the reciprocal map
    public void getReciprocalBest1To1(String infileS1,String infileS2,String outfileS){
        try{
            String temp = null;
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
//                String AA = "";
//                try{
//                     AA = hashMap2.get(hashMap3.get(hashMap1.get(a1)));
//                }finally{
//                    
//                }                 
                if(AA==null) continue;
                if(AA!=null && A11.add(AA)){
                    A11.remove(AA);
                    System.out.println("Not the Reciprocal Best");
                }else if(AA == null){
                    System.out.println("Not the Reciprocal Best");
                }else{
                    bw.write(a1 + "\t" + B  + "\n");
                }
            }    
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //得到1：1：N 的数据，输入的是DA_N，的出来的是一个有完整信息的文件
    //以下是第一步，对比第一列的数据，infileS1是之前AB唯一比对的数据，infileS2是DA_N
    public void get1To1ToNstep1 (String infileS1,String infileS2,String outfileS1){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedReader brDA = IOUtils.getTextReader(infileS2);
            //BufferedReader brDB = IOUtils.getTextReader(infileS3);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            //BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            Set<String> A = new HashSet();
            Set<String> B = new HashSet();
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t");    
                hashMap1.put(tem[0],tem[1]);
                A.add(tem[0]);
                //B.add(tem[1]);
            }
            while((temp = brDA.readLine())!= null){
                String [] tem = temp.split("\t");
                if(!A.add(tem[0])){
                    //bw1.write(tem[0] + "\t" + hashMap1.get(tem[0]) + "\n");
                    bw1.write(tem[0] + "\t" + hashMap1.get(tem[0])+ "\t" + tem[1] + "\n");
                }
            }              
            bw1.flush();
            bw1.close();
//            bw2.flush();
//            bw2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
    //得到1：1：N 的数据
    //以下是第二步，对比第二列的数据，把上一次比对的结果放进去当做infileS1，infileS2是 DB_N.txt
    public void get1To1ToNstep2 (String infileS1,String infileS2,String outfileS1,String outfileS2){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedReader brDA = IOUtils.getTextReader(infileS2);
            //BufferedReader brDB = IOUtils.getTextReader(infileS3);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            Set<String> A = new HashSet();
            Set<String> B = new HashSet();
            int CalDD = 0;
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t");    
                String line13 = tem[0]+"_"+tem[2];
                hashMap1.put(tem[1],line13);
                A.add(tem[1]);
                //B.add(tem[1]);
            }
            while((temp = brDA.readLine())!= null){
                String [] tem = temp.split("\t");
                if(!A.add(tem[0])){
                    String[] line = hashMap1.get(tem[0]).split("_");                  
                    bw1.write(line[0] + "\t" + tem[0] + "\t" + "N" + "\n");
                    bw2.write(line[0] + "\t" + tem[0] +  "\t" + line[1]+";"+tem[1]  + "\n");
                    String[] DD = (line[1]+";"+tem[1]).split(";");                    
                    CalDD = CalDD + DD.length;     
                }
            }             
            System.out.println(CalDD);
            bw1.flush();
            bw1.close();
            bw2.flush();
            bw2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //得到N：1：1 的数据，输入的是AB_N，的出来的是一个是有完整信息的文件
    //以下是第一步，对比第一列的数据，infileS1是之前BD唯一比对的数据，infileS2是AB_N
    public void getNTo1To1step1 (String infileS1,String infileS2,String outfileS1){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedReader brDA = IOUtils.getTextReader(infileS2);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            Set<String> A = new HashSet();
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t");    
                hashMap1.put(tem[0],tem[1]);
                A.add(tem[0]);
            }
            while((temp = brDA.readLine())!= null){
                String [] tem = temp.split("\t");
                if(!A.add(tem[0])){
                    bw1.write(tem[1] + "\t" + tem[0] + "\t" + hashMap1.get(tem[0]) + "\n");
                }
            }              
            bw1.flush();
            bw1.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
    //得到N：1：1 的数据
    //以下是第二步，对比第三列的数据，把上一次比对的结果放进去当做infileS1，infileS2是AD_N.txt
    public void getNTo1To1step2 (String infileS1,String infileS2,String outfileS1,String outfileS2){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedReader brDA = IOUtils.getTextReader(infileS2);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            Set<String> A = new HashSet();
            int CalDD = 0;
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t");    
                String line12 = tem[0]+"_"+tem[1];
                hashMap1.put(tem[2],line12);
                A.add(tem[2]);
            }
            while((temp = brDA.readLine())!= null){
                String [] tem = temp.split("\t");
                if(!A.add(tem[0])){
                    String[] line = hashMap1.get(tem[0]).split("_");                  
                    bw1.write("N" + "\t" + line[1] + "\t" + tem[0] + "\n");
                    bw2.write(line[0]+";"+tem[1] + "\t" + line[1] +  "\t" + tem[0]  + "\n");
                    String[] DD = (line[0]+";"+tem[1]).split(";");                    
                    CalDD = CalDD + DD.length;     
                }
            }             
            System.out.println(CalDD);
            bw1.flush();
            bw1.close();
            bw2.flush();
            bw2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //得到1：N：1 的数据，输入的是BA_N，的出来的是一个是有完整信息的文件
    //以下是第一步，对比第一列的数据，infileS1是之前AD唯一比对的数据，infileS2是BA_N
    public void get1ToNTo1step1 (String infileS1,String infileS2,String outfileS1){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedReader brDA = IOUtils.getTextReader(infileS2);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            Set<String> A = new HashSet();
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t");    
                hashMap1.put(tem[0],tem[1]);
                A.add(tem[0]);
            }
            while((temp = brDA.readLine())!= null){
                String [] tem = temp.split("\t");
                if(!A.add(tem[0])){
                    bw1.write(tem[0] + "\t" + tem[1] + "\t" + hashMap1.get(tem[0]) + "\n");
                }
            }              
            bw1.flush();
            bw1.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
    //得到N：1：1 的数据
    //以下是第二步，对比第三列的数据，把上一次比对的结果放进去当做infileS1，infileS2是BD_N.txt
    public void get1ToNTo1step2 (String infileS1,String infileS2,String outfileS1,String outfileS2){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS1);
            BufferedReader brDA = IOUtils.getTextReader(infileS2);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            HashMap<String, String> hashMap1 = new HashMap<String, String>();
            Set<String> A = new HashSet();
            int CalDD = 0;
            while((temp = br.readLine())!= null){
                String [] tem = temp.split("\t");    
                String line12 = tem[0]+"_"+tem[1];
                hashMap1.put(tem[2],line12);
                A.add(tem[2]);
            }
            while((temp = brDA.readLine())!= null){
                String [] tem = temp.split("\t");
                if(!A.add(tem[0])){
                    String[] line = hashMap1.get(tem[0]).split("_");                  
                    bw1.write(line[0] + "\t" + "N" + "\t" + tem[0] + "\n");
                    bw2.write(line[0] + "\t" + line[1]+";"+tem[1] +  "\t" + tem[0]  + "\n");
                    String[] DD = (line[1]+";"+tem[1]).split(";");                    
                    CalDD = CalDD + DD.length;     
                }
            }             
            System.out.println(CalDD);
            bw1.flush();
            bw1.close();
            bw2.flush();
            bw2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //当时AOB是包含N的情况的，现在将其合并在一起,S1是带N的文件，S2是ABO的文件
    public void getAB0andN(String infileS1,String infileS2,String outfileS){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String temp2 = null;
            BufferedReader brABD1To1ToN = IOUtils.getTextReader(infileS1);
            BufferedReader brAB0 = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMapfirstline = new HashMap<String, String>();
            Set<String> Aline = new HashSet();
            Set<String> allGene = new HashSet();
            while((temp = brABD1To1ToN.readLine())!= null){
                String [] tem = temp.split("\t");
                Aline.add(tem[1]);                        
            }
            while((temp2 = brAB0.readLine())!= null){
                    String [] temtem = temp2.split("\t");
                    if(Aline.add(temtem[1])){
                        Aline.remove(temtem[1]);
                        bw.write(temp2 + "\n");                        
                    }else{
                        //bw.write(temtem[0] + "\t" +  temtem[1] + "\t" +"N" + "\n");                         
                        Aline.remove(temtem[1]);
                    }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getA0DandN(String infileS1,String infileS2,String outfileS){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String temp2 = null;
            BufferedReader brABD1ToNTo1 = IOUtils.getTextReader(infileS1);
            BufferedReader brA0D = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMapfirstline = new HashMap<String, String>();
            Set<String> Aline = new HashSet();
            Set<String> allGene = new HashSet();
            while((temp = brABD1ToNTo1.readLine())!= null){
                String [] tem = temp.split("\t");
                Aline.add(tem[0]);                        
            }
            while((temp2 = brA0D.readLine())!= null){
                    String [] temtem = temp2.split("\t");
                    if(Aline.add(temtem[0])){
                        Aline.remove(temtem[0]);
                        bw.write(temp2 + "\n");                        
                    }else{
                        //bw.write(temtem[0] + "\t" +  "N" + "\t" +temtem[2] + "\n");                         
                        //Aline.remove(temtem[1]);
                    }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void get0BDandN(String infileS1,String infileS2,String outfileS){
        try{
            int chrNum = 0;
            int i = 0;
            String temp = null;
            String temp2 = null;
            BufferedReader brABD1ToNTo1 = IOUtils.getTextReader(infileS1);
            BufferedReader brA0D = IOUtils.getTextReader(infileS2);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            HashMap<String, String> hashMapfirstline = new HashMap<String, String>();
            Set<String> Aline = new HashSet();
            Set<String> allGene = new HashSet();
            while((temp = brABD1ToNTo1.readLine())!= null){
                String [] tem = temp.split("\t");
                Aline.add(tem[1]);                        
            }
            while((temp2 = brA0D.readLine())!= null){
                    String [] temtem = temp2.split("\t");
                    if(Aline.add(temtem[1])){
                        Aline.remove(temtem[1]);
                        bw.write(temp2 + "\n");                        
                    }else{
                        //bw.write("N" + "\t" +  temtem[1] + "\t" +temtem[2] + "\n");                         
                        //Aline.remove(temtem[1]);
                    }
            }
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //之前的ABD1To1ToNgene.txt文件基因是有重复的，这次的目的是把重复去掉，而且把A:N和B:N的所有分别输出到一个文件里
    public void getABD1To1ToNgene2(String infileS,String outfileS1,String outfileS2,String outfileS3){
        try{
            String temp = null;
            String temp2 = null;
            int ddnum = 0;
            BufferedReader brABD1ToNTo1 = IOUtils.getTextReader(infileS);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            BufferedWriter bw3 = IOUtils.getTextWriter(outfileS3);
            Set<String> Dgene = new HashSet();
            StringBuilder Dvalue = new StringBuilder();
            while((temp = brABD1ToNTo1.readLine())!= null){
                String [] tem = temp.split("\t");
                String [] temtem = tem[2].split(";");
                for(int i = 0; i < temtem.length;i++){
                    Dgene.add(temtem[i]);
                }
//                for(int j=0;j < Dgene.size();j++) {
//                    System.out.println(Dgene.get(j));
//                    bw2.write("\n" + tem[0] + "\t" + tem [1] + "\t" + Dgene[j]);
//                }    
                Iterator iter = Dgene.iterator();
                while (iter.hasNext()) {
                    Object DD = iter.next();
                    bw2.write(tem[0] + "\t" + DD + "\n");      
                    bw3.write(tem[1] + "\t" + DD + "\n"); 
                    Dvalue.append(DD+";");
                    //Dgene.remove(DD);
                }
                Dgene = new HashSet();
                String DDvalue = Dvalue.substring(0, Dvalue.length()-1);
                String [] DDnum = DDvalue.split(";");
                ddnum = ddnum + DDnum.length;
                bw1.write(tem[0] + "\t" + tem[1] + "\t" + DDvalue + "\n");
                Dvalue = new StringBuilder();
            }
            System.out.println(ddnum);
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
    
    //之前的ABD1ToNTo1gene.txt文件基因是有重复的，这次的目的是把重复去掉，而且把A:N和D:N的所有分别输出到一个文件里
    public void getABD1ToNTo1gene2(String infileS,String outfileS1,String outfileS2,String outfileS3){
        try{
            String temp = null;
            String temp2 = null;
            int ddnum = 0;
            BufferedReader brABD1ToNTo1 = IOUtils.getTextReader(infileS);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            BufferedWriter bw3 = IOUtils.getTextWriter(outfileS3);
            Set<String> Dgene = new HashSet();
            StringBuilder Dvalue = new StringBuilder();
            while((temp = brABD1ToNTo1.readLine())!= null){
                String [] tem = temp.split("\t");
                String [] temtem = tem[1].split(";");
                for(int i = 0; i < temtem.length;i++){
                    Dgene.add(temtem[i]);
                }
//                for(int j=0;j < Dgene.size();j++) {
//                    System.out.println(Dgene.get(j));
//                    bw2.write("\n" + tem[0] + "\t" + tem [1] + "\t" + Dgene[j]);
//                }    
                Iterator iter = Dgene.iterator();
                while (iter.hasNext()) {
                    Object DD = iter.next();
                    bw2.write(tem[0] + "\t" + DD + "\n");      
                    bw3.write(tem[2] + "\t" + DD + "\n"); 
                    Dvalue.append(DD+";");
                    //Dgene.remove(DD);
                }
                Dgene = new HashSet();
                String DDvalue = Dvalue.substring(0, Dvalue.length()-1);
                String [] DDnum = DDvalue.split(";");
                ddnum = ddnum + DDnum.length;
                bw1.write(tem[0] + "\t" + DDvalue + "\t" + tem[2] + "\n");
                Dvalue = new StringBuilder();
            }
            System.out.println(ddnum);
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
    
    //之前的ABDNTo1To1gene.txt文件基因是有重复的，这次的目的是把重复去掉，而且把B:N和D:N的所有分别输出到一个文件里
    public void getABDNTo1To1gene2(String infileS,String outfileS1,String outfileS2,String outfileS3){
        try{
            String temp = null;
            String temp2 = null;
            int ddnum = 0;
            BufferedReader brABD1ToNTo1 = IOUtils.getTextReader(infileS);
            BufferedWriter bw1 = IOUtils.getTextWriter(outfileS1);
            BufferedWriter bw2 = IOUtils.getTextWriter(outfileS2);
            BufferedWriter bw3 = IOUtils.getTextWriter(outfileS3);
            Set<String> Dgene = new HashSet();
            StringBuilder Dvalue = new StringBuilder();
            while((temp = brABD1ToNTo1.readLine())!= null){
                String [] tem = temp.split("\t");
                String [] temtem = tem[0].split(";");
                for(int i = 0; i < temtem.length;i++){
                    Dgene.add(temtem[i]);
                }
//                for(int j=0;j < Dgene.size();j++) {
//                    System.out.println(Dgene.get(j));
//                    bw2.write("\n" + tem[0] + "\t" + tem [1] + "\t" + Dgene[j]);
//                }    
                Iterator iter = Dgene.iterator();
                while (iter.hasNext()) {
                    Object DD = iter.next();
                    bw2.write(tem[1] + "\t" + DD + "\n");      
                    bw3.write(tem[2] + "\t" + DD + "\n"); 
                    Dvalue.append(DD+";");
                    //Dgene.remove(DD);
                }
                Dgene = new HashSet();
                String DDvalue = Dvalue.substring(0, Dvalue.length()-1);
                String [] DDnum = DDvalue.split(";");
                ddnum = ddnum + DDnum.length;
                bw1.write(DDvalue + "\t" + tem[1] + "\t" + tem[2] + "\n");
                Dvalue = new StringBuilder();
            }
            System.out.println(ddnum);
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
}
