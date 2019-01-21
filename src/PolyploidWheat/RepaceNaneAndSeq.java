/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolyploidWheat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import utils.IOUtils;

/**
 * 这个方法是为了重复science的文章，使用BEAST计算每个保守基因的进化时间，BEAST会产生一个xml的文件，用这个一个文件为模板，对一个文件夹内的所有比对文件进行操作
 * @author xuebozhao
 */
public class RepaceNaneAndSeq {
    public RepaceNaneAndSeq (String infileS1,String infileS2,String outfileS){
        this.forAlignmentFileS(infileS1,infileS2, outfileS);
    }  
    public void forAlignmentFileS(String infileS1,String infileS2,String outfileS){
        try{    
            int i = 0;
            String temp = null;
            String temp2 = null;
            BufferedWriter bw = null;
            BufferedReader AlignmentFileS = null;
            System.out.println(infileS1);
            File f = new File(infileS1);
            File[] fs = IOUtils.listRecursiveFiles(f);
            File[] sub = IOUtils.listFilesEndsWith(fs, ".fa");
            for(File fi:sub){
                i++;
                AlignmentFileS = IOUtils.getTextReader(fi.getAbsolutePath().toString());
                String[] pa = fi.getAbsolutePath().toString().split("/");
                String paname = pa[pa.length-1];
                String xmlname = paname.split("_")[2];
                String editfile  = paname.split("_")[4];
                String out = null;
                if(editfile.equals("NoGaps.fa")){
                    out = fi.toString().replace(paname, i + "_" + xmlname + "_" + "ReNameandSeq.xml");
                }else{
                    out = fi.toString().replace(paname, i + "_" + xmlname + "_" + "ReNameandSeq.xml");
                }
                bw = IOUtils.getTextWriter(out);
                System.out.println("Now analyzing " + i + "_" + xmlname);
                HashMap<String, String> hashMap1 = new HashMap<String, String>();
                while((temp = AlignmentFileS.readLine()) != null){
                    if(temp.startsWith(">AEG")){
                        String key = "At";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">Ash")){
                        String key = "Ash";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">Asp")){
                        String key = "Asp";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">Brad")){
                        String key = "Bd";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">Hv")){
                        String key = "Hv";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">LOC")){
                        String key = "Os";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">Ta1a") || temp.startsWith(">Ta2a") || temp.startsWith(">Ta3a") || temp.startsWith(">Ta4a") ||
                            temp.startsWith(">Ta5a") || temp.startsWith(">Ta6a") || temp.startsWith(">Ta7a")){
                        String key = "TaA";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">Ta1b") || temp.startsWith(">Ta2b") || temp.startsWith(">Ta3b") || temp.startsWith(">Ta4b") ||
                            temp.startsWith(">Ta5b") || temp.startsWith(">Ta6b") || temp.startsWith(">Ta7b")){
                        String key = "TaB";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">Ta1d") || temp.startsWith(">Ta2d") || temp.startsWith(">Ta3d") || temp.startsWith(">Ta4d") ||
                            temp.startsWith(">Ta5d") || temp.startsWith(">Ta6d") || temp.startsWith(">Ta7d")){
                        String key = "TaD";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">Tm")){
                        String key = "Tm";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                    else if(temp.startsWith(">Tu")){
                        String key = "Tu";
                        String tem = AlignmentFileS.readLine();
                        hashMap1.put(key, tem);
                    }
                }
            BufferedReader br = IOUtils.getTextReader(infileS2);
                String seqNew = null;
                String temp2New = null;
                    while((temp2 = br.readLine()) != null){                   
    //                    if(temp2.startsWith("                    <sequence")){
    //                        String ID = temp2.split(" ")[1];
    //                        if(ID.equals("id=\"seq_Ash\"")){
    //                            
    //                        }
    //                    }
                        if(temp2.contains("sequence")){
                            String IDold = temp2.split("id=")[1].split(" ")[0];
                            String ID  = IDold.substring(1, IDold.length()-1);
                            String seqold = temp2.split("value=")[1].split("/>")[0];
                            String seq = seqold.substring(1, seqold.length()-1);
                            if(seq!=null){   
                                if("seq_Ash".equals(ID)){
                                    seqNew = hashMap1.get("Ash") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_Asp".equals(ID)){
                                    seqNew = hashMap1.get("Asp") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_At".equals(ID)){
                                    seqNew = hashMap1.get("At") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_Bd".equals(ID)){
                                    seqNew = hashMap1.get("Bd") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_Hv".equals(ID)){
                                    seqNew = hashMap1.get("Hv") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_Os".equals(ID)){
                                    seqNew = hashMap1.get("Os") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_TaA".equals(ID)){
                                    seqNew = hashMap1.get("TaA") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_TaB".equals(ID)){
                                    seqNew = hashMap1.get("TaB") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_TaD".equals(ID)){
                                    seqNew = hashMap1.get("TaD") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_Tm".equals(ID)){
                                    seqNew = hashMap1.get("Tm") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                }else
                                if("seq_Tu".equals(ID)){
                                    seqNew = hashMap1.get("Tu") ;
                                    temp2New = temp2.replace(seq, seqNew);
                                    bw.write(temp2New + "\n");
                                } 
                            }
                        }else if(temp2.contains("group2")){                            
                            temp2New = temp2.replace("group2", i + "_" + xmlname);
                            bw.write(temp2New + "\n");
                        }
//                        else if(temp2.contains("ABCDmodel.log")){
//                            temp2New = temp2.replace("ABCDmodel.log", i + "_" + xmlname + ".log");
//                            bw.write(temp2New + "\n");
//                        }
                        else{
                            //System.out.println(temp2);
                            bw.write(temp2 + "\n");
                        }
                    }
                    bw.flush();
                    bw.close();
            } 
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
