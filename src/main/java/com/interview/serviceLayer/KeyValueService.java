package com.interview.serviceLayer;

import com.interview.DoaLayer.KeyvalueDoa;
import com.interview.Exception.KeyAlreadyPresentException;
import com.interview.Exception.KeyNotPresentException;
import com.interview.Models.KeyValue;


public class KeyValueService {
	public KeyValueService() {
		super();
		doa = new KeyvalueDoa();
		
	}

	private KeyvalueDoa doa ;
	
	public KeyValue getKey(String key) throws KeyNotPresentException {
		KeyValue output = doa.getKey(key);
		if(output==null) {
			throw new KeyNotPresentException(key);
		}
		else 
		return output;
	}
	public KeyValue AddKeyvalue(String key,String val) throws KeyAlreadyPresentException {
		if(doa.getKey(key)!=null) {
			throw new KeyAlreadyPresentException(key);
			
		}
		return doa.addorupdateordeletekeyValue(key, val);
		
	}
	
	public KeyValue updatevalue(String key,String val) throws KeyNotPresentException {
		if(doa.getKey(key)==null) {
			throw new KeyNotPresentException(key);
		}
		else {
			return doa.addorupdateordeletekeyValue(key, val);
		}
	}
	
	public KeyValue deletevalue(String key) throws KeyNotPresentException {
		if(doa.getKey(key)==null) {
			throw new KeyNotPresentException(key);
		}
		else return doa.addorupdateordeletekeyValue(key, null);
	}
}
