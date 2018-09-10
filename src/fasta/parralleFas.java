/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasta;

import gff3.kgf;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class parralleFas {
    Fasta A;
    Map<String,List> gff3 = new HashMap<String,List>();
    public parralleFas(Fasta A){
        this.A = A;
    }
    public void getParralle(String output,String gff3){
        kgf g = new kgf();
        g.readKgf(gff3);
        Map<String, List<String>> cds = g.returnMap();
        A.chr
            .parallelStream()
            .forEach(e -> subFas(e,cds,output));
    }
    public void subFas(String chr,Map<String, List<String>> cds,String outputs){
        System.out.println("Processing chromosome " + chr+ "...");
        File out = new File(outputs);
        if(!out.exists()) out.mkdirs();
        String output = outputs+"/"+chr+".fa";
        BufferedWriter bw = IOUtils.getTextWriter(output);
        StringBuilder CDSsequense = new StringBuilder();
        List seq = cds.get(chr);
        for(int i = 0; i < seq.size()/3;i++){
            String[] CDSline = seq.get(i*3+1).toString().split(";");
            String strand =  seq.get(i*3+2).toString();
            String  geneName = seq.get(i*3).toString();
            int CDSnum = CDSline.length;
            for(int j = 0;j < CDSnum;j++){
                String [] CDSpos = CDSline[j].split(":");   
                                    //String CDSsequencetemp = getCDSsequense(CDSpos[0],CDSpos[1],temp2);                
                CDSsequense.append(getCDSsequense(CDSpos[0],CDSpos[1],A.fas.get(chr)));
                
            }
            if(strand.equals("0")){
                CDSsequense = getReverseComplementarySeq(CDSsequense.toString());
            }
            writeCDSsequence(chr,geneName,CDSsequense,output);
            CDSsequense.delete(0, CDSsequense.length());
        }
        
    }
        
     public String getCDSsequense(String pos1, String pos2, StringBuilder fastaAll){
        String cuttergene = null;
        String headcutter = null;      
            cuttergene = fastaAll.substring(Integer.valueOf(pos1),Integer.valueOf(pos2));                
            //getWriteStreamAppend(outfileS1,cuttergene+"\n")  
        return cuttergene;
    }
     public StringBuilder getReverseComplementarySeq (String CDSsequence) {
        StringBuilder sb = new StringBuilder();
        int sequencelegth = CDSsequence.length();
        for (int i = 0; i < sequencelegth; i++) {         
            sb.append(baseCompleMap.get(String.valueOf(CDSsequence.charAt(i))));
        }
        return sb.reverse();
    }
    
   public static final HashMap<String, String> baseCompleMap = new HashMap();
    static {
        baseCompleMap.put("A", "T");
        baseCompleMap.put("T", "A");
        baseCompleMap.put("G", "C");
        baseCompleMap.put("C", "G");
        baseCompleMap.put("N", "N");
        baseCompleMap.put("a", "t");
        baseCompleMap.put("t", "a");
        baseCompleMap.put("g", "c");
        baseCompleMap.put("c", "g");
        baseCompleMap.put("n", "n");
    }
    
    public void writeCDSsequence(String Chr,String gene,StringBuilder fastaAll, String outfileS1){
        try{
        String headcutter = null;                  
                headcutter =  ">" + Chr +  "\t" + gene + "\n";   
                getWriteStreamAppend(outfileS1,headcutter);
                getWriteStreamAppend(outfileS1,fastaAll + "\n");
        }
        catch (Exception e){
            e.printStackTrace();
        }     
    }
     public static void getWriteStreamAppend(String file, String conent) {                         
        BufferedWriter out = null;                                                   
        try {                                                                        
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));                              
            out.write(conent);                                                      
        } 
        catch (Exception e) {                                                     
            e.printStackTrace();                                                    
        } 
        finally {                                                                 
            try {                                                                    
                out.close();                                                        
            } catch (Exception e) {                                               
                e.printStackTrace();                                                
            }                                                                       
        }                                                                           
    }    
}
