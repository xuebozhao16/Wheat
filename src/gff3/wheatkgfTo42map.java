/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gff3;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pgl.infra.table.RowTable;
import pgl.infra.utils.IOUtils;

/**
 *
 * @author xuebozhao
 */
public class wheatkgfTo42map {
    Map<String,List<String>> gff3 = new HashMap<String,List<String>>();
    public wheatkgfTo42map(){
        
    }
    public void readKgf(String inFile){
        try{
            BufferedReader br = IOUtils.getTextReader(inFile);
            List<String> list = new ArrayList<String>();
            String temp = null;
            Set keySet = new HashSet();
            while (( temp = br.readLine()) != null) {
                String [] tem = temp.split("\t");
                if(keySet.add(tem[0])) {
                    list = new ArrayList<String>();
                }
                list.add(tem[1]);
                list.add(tem[3]);
                list.add(tem[4]);
                gff3.put(tem[0],list);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public Map<String,List<String>> returnMap(){
        return gff3;
    }
}
