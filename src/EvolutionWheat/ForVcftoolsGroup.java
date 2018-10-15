/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionWheat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class ForVcftoolsGroup {
     
    public ForVcftoolsGroup(String infileS,String outfileS){
        //this.forVcftoolsFileS(infileS, outfileS);
        this.forVcftoolsFileSForR(infileS, outfileS);
        //this.forXpclrAllFileS1(infileS, outfileS);
        //this.forXpclrAllFileS2(infileS, outfileS);
    }

    public void forVcftoolsFileS(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            StringBuilder tempAll = new StringBuilder();
            while((temp = br.readLine()) != null){
                tempAll.append(temp).append(",");
            }
            String tempForVcftools = tempAll.substring(0, tempAll.length()-1);
            bw.write(tempForVcftools);
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void forVcftoolsFileSForR(String infileS,String outfileS){
        try{
            String temp = null;
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            while((temp = br.readLine()) != null){
                String tem[] = temp.split("\t");
                if(tem[5].equals("inf") | tem[5].equals("-0.000000") | tem[5].equals("0.000000") | tem[5].equals("-nan")){
                    
                }else {
                    if(tem[0].equals("1") |tem[0].equals("2")){
                        bw.write("1A" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("3") |tem[0].equals("4")){
                        bw.write("1B" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("5") |tem[0].equals("6")){
                        bw.write("1D" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("7") |tem[0].equals("8")){
                        bw.write("2A" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("9") |tem[0].equals("10")){
                        bw.write("2B" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("11") |tem[0].equals("12")){
                        bw.write("2D" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("13") |tem[0].equals("14")){
                        bw.write("3A" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("15") |tem[0].equals("16")){
                        bw.write("3B" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("17") |tem[0].equals("18")){
                        bw.write("3D" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("19") |tem[0].equals("20")){
                        bw.write("4A" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("21") |tem[0].equals("22")){
                        bw.write("4B" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("23") |tem[0].equals("24")){
                        bw.write("4D" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("25") |tem[0].equals("26")){
                        bw.write("5A" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("27") |tem[0].equals("28")){
                        bw.write("5B" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("29") |tem[0].equals("30")){
                        bw.write("5D" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("31") |tem[0].equals("32")){
                        bw.write("6A" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("33") |tem[0].equals("34")){
                        bw.write("6B" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("35") |tem[0].equals("36")){
                        bw.write("6D" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("37") |tem[0].equals("38")){
                        bw.write("7A" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("39") |tem[0].equals("40")){
                        bw.write("7B" + "\t" + tem[3] + "\t" + tem[5] + "\n");
                    }
                    if(tem[0].equals("41") |tem[0].equals("42")){
                        bw.write("7D" + "\t" + tem[3] + "\t" + tem[5] + "\n");
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
    
    public void forXpclrAllFileS1(String infileS,String outfileS){
        try{    
            String temp = null;
            BufferedReader xpclrFile = null;
            File f = new File(infileS);
            File[] fs = listRecursiveFiles(f);
            String txt = null;
            File[] sub = listFilesEndsWith(fs, "txt");
            for(File fi:sub){
                xpclrFile = getTextReader(fi.toString());
                String chr = fi.toString().split("chr")[1];
                String ChrChr = chr.toString().split(".xpclr")[0];
                String out = fi.toString().replace("xpclrLineage", "Lineage");
                BufferedWriter bw = getTextWriter(out);
                while((temp = xpclrFile.readLine()) != null){
                    String[] tem = temp.split(" ");
                    bw.write(ChrChr + "\t" + tem[1] + "\t" + tem[2] + "\t" +tem[3] + "\t" +tem[4] + "\t" + tem[5] + "\t" +tem[6] + "\n");
                }
                bw.flush();
                bw.close();
            } 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void forXpclrAllFileS2(String infileS,String outfileS){
        try{    
            String temp = null;
            BufferedReader xpclrFile = null;
            File f = new File(infileS);
            File[] fs = listRecursiveFiles(f);
            String txt = null;
            File[] sub = listFilesEndsWith(fs, "txt");
            for(File fi:sub){
                xpclrFile = getTextReader(fi.toString());
                String chr = fi.toString().split("chr")[1];
                String ChrChr = chr.toString().split(".xpclr")[0];
                String out = fi.toString().replace("xpclrSpecies", "Species");
                BufferedWriter bw = getTextWriter(out);
                while((temp = xpclrFile.readLine()) != null){
                    String[] tem = temp.split(" ");
                    bw.write(ChrChr + "\t" + tem[1] + "\t" + tem[2] + "\t" +tem[3] + "\t" +tem[4] + "\t" + tem[5] + "\t" +tem[6] + "\n");
                }
                bw.flush();
                bw.close();
            } 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static BufferedReader getTextGzipReader (String infileS) {
        BufferedReader br = null;
        try {
            //br = new BufferedReader(new InputStreamReader(new MultiMemberGZIPInputStream(new FileInputStream(infileS))));
            br = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(infileS), 65536)), 65536);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return br;
    }
    
    public static BufferedReader getTextGzipReader (String infileS, int bufferSize) {
        BufferedReader br = null;
        try {
            //br = new BufferedReader(new InputStreamReader(new MultiMemberGZIPInputStream(new FileInputStream(infileS))));
            br = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(infileS), bufferSize)), bufferSize);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return br;
    }
    
    public static BufferedWriter getTextGzipWriter (String outfileS) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(outfileS), 65536)), 65536);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bw;
    }
    
    public static BufferedWriter getTextGzipWriter (String outfileS, int bufferSize) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(outfileS), bufferSize)), bufferSize);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bw;
    }
    
    public static BufferedWriter getTextWriter (String outfileS) {
        BufferedWriter bw = null;
        try {
             bw = new BufferedWriter (new FileWriter(outfileS), 65536);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return bw;
    }
    
    public static BufferedReader getTextReader (String infileS) {
        BufferedReader br = null;
        try {
            br = new BufferedReader (new FileReader(infileS), 65536);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return br;
    }
    
    public static DataOutputStream getBinaryWriter (String outfileS) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outfileS), 65536));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dos;
    }
    
    public static DataInputStream getBinaryReader (String infileS) {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(infileS), 65536));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dis;
    }
    
    public static ObjectOutputStream getObjectWriter (String outfileS) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(outfileS), 65536));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return oos;
    }
    
    public static ObjectInputStream getObjectReader (String infileS) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(infileS), 65536));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ois;
    }
    
    public static File[] listFilesContains (File[] fAll, String containStr) {
        ArrayList<File> al = new ArrayList();
        for (int i = 0; i < fAll.length; i++) {
            if (fAll[i].getName().contains(containStr)) al.add(fAll[i]);
        }
        return al.toArray(new File[al.size()]);
    }
    
    public static File[] listFilesStartsWith (File[] fAll, String startStr) {
        ArrayList<File> al = new ArrayList();
        for (int i = 0; i < fAll.length; i++) {
            if (fAll[i].getName().startsWith(startStr)) al.add(fAll[i]);
        }
        return al.toArray(new File[al.size()]);
    }
    
    public static File[] listFilesEndsWith (File[] fAll, String endStr) {
        ArrayList<File> al = new ArrayList();
        for (int i = 0; i < fAll.length; i++) {
            if (fAll[i].getName().endsWith(endStr)) al.add(fAll[i]);
        }
        return al.toArray(new File[al.size()]);
    }
    
    /**
     * List all the files in a directory
     * @param dir
     * @return 
     */
    public static File[] listRecursiveFiles (File dir) {
        TreeSet<File> fSet = getRecursiveFiles (dir);
        return fSet.toArray(new File[fSet.size()]);
    }
    
    private static TreeSet<File> getRecursiveFiles (File dir) {
        TreeSet<File> fileTree = new TreeSet();
        for (File entry : dir.listFiles()) {
            if (entry.isFile()) fileTree.add(entry);
            else fileTree.addAll(getRecursiveFiles(entry));
        }
        return fileTree;
    }

    public static BufferedReader getTextGzipReader(File file1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static BufferedReader getTextReader(File file1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static BufferedReader getFastaReader(File file1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}