package com.interview.DoaLayer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.interview.Constants.ConstantProperties;
import com.interview.Models.KeyValue;


public class KeyvalueDoa {


public KeyvalueDoa(HashMap<String, String> cache) {
		super();
		this.cache = cache;
		this.context = properties.test;
	}

public KeyvalueDoa() {
		this.cache = new HashMap<String,String>();
		
		File myObj = new File(properties.filelocation);
		try {
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		       
		        String[] keyval = data.split(","); 
		       if(keyval.length==2) {
		    	   System.out.println("Loading into cacahe "+keyval[0]+" "+keyval[1]);
			        
			        cache.put(keyval[0], keyval[1]);
		       }
		      
		      }
		      myReader.close();

			this.context=properties.prod;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}


HashMap<String,String> cache;
ConstantProperties properties;  
String context ;
public KeyValue getKey(String key) {
	
	if(cache.containsKey(key) && !cache.get(key).equals(properties.delete)) {
		return new KeyValue(key,cache.get(key));
	}
	return null;
	
}

public KeyValue addorupdateordeletekeyValue(String k,String v) {
    try {
        
        File f1 = new File(properties.filelocation);
        if(!f1.exists()) {
           
        	return null;
        }

        FileWriter fileWritter = new FileWriter(f1.getName(),true);
        BufferedWriter bw = new BufferedWriter(fileWritter);
        
        if(v==null) {
        	if(this.context.equals(properties.prod)) {
        		bw.write(k+","+properties.delete);
        	}
        	
        	cache.put(k, properties.delete);
        }
        else {
        	if(this.context.equals(properties.prod)) {
        		bw.write(k+","+v);
        	}
        	
        	cache.put(k, v);
        }
        bw.write("\n");
        System.out.println("persisted the value for the key "+k+" : "+v + " in the Persistence file");
        bw.close();
        
        System.out.println("value for the key "+k+" : "+v);
        
     } catch(IOException e){
        e.printStackTrace();
     }
    
   return new KeyValue(k,cache.get(k));
}

public HashMap<String, String> getCache() {
	return cache;
}
  



}
