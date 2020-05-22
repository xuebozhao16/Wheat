/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vcf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import static java.lang.Math.random;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class RandomLine {
    public RandomLine(String infileS,String n,String outfileS){
        this.C33_getrandomLine(infileS, n, outfileS);
    }
    public void C33_getrandomLine(String infileS,String n,String outfileS){
        try{
            FileReader in = new FileReader(infileS);
            LineNumberReader reader = new LineNumberReader(in);
            reader.skip(Long.MAX_VALUE);
            int lines = reader.getLineNumber();
            reader.close();
            BufferedReader br = IOUtils.getTextReader(infileS);
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            String temp = null;
            int i = 0;
            int nn = Integer.valueOf(n);
            Set ramnumbber = randonumber2(nn,lines);
            while((temp = br.readLine()) !=null){
                i = i + 1;
                if(temp.startsWith("#")){
                    bw.write(temp + "\n");
                }else{
                    if(ramnumbber.add(i)){
                        ramnumbber.remove(i);
                    }else{
                        bw.write(temp + "\n");
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
    
    //统计文件长度
    public int getTotalLines(File file) throws IOException {
        long startTime = System.currentTimeMillis();
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        reader.skip(Long.MAX_VALUE);
        int lines = reader.getLineNumber();
        reader.close();
        long endTime = System.currentTimeMillis();

        System.out.println("统计文件行数运行时间： " + (endTime - startTime) + "ms");
        return lines;
    }
    
    //产生随机数组
    private static int[] randonumber(int x,int y){
        int[] ran = new int[x];
	for(int i = 0; i < ran.length; i++){
            int index = (int)(Math.random() * y + 1);
            ran[i] = index;
            for(int j=0;j<i;j++) {
                if(ran[j] == ran[i]) {
                    i--;
                    break;
                }
            }           
        }
        return ran;
    }
     
    
    
    //产生随机数组2--取指定范围内的随机数
    private static Set randonumber2(int x,int y){
        Set rammm = new HashSet();
	int[] ran = new int[x];
	for(int i = 0; i < ran.length; i++){
            //int index = (int)(Math.random() * y + 1);
            Random random = new Random();
            int index = random.nextInt(y)%(y-15+1) + 15;
            ran[i] = index;
            for(int j=0;j<i;j++) {
                if(ran[j] == ran[i]) {
                    i--;
                    break;
                }
            }           
        }
        for(int j=0;j<ran.length;j++){
            rammm.add(ran[j]);
        }
        return rammm;
    }
}
