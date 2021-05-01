package com.interview.KeyValue;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.sun.tools.javac.util.Assert;

import com.interview.Exception.KeyAlreadyPresentException;
import com.interview.Exception.KeyNotPresentException;
import com.interview.Models.KeyValue;
import com.interview.serviceLayer.KeyValueService;

@SpringBootTest
class KeyValueApplicationTests {
	KeyValueService service;
	@BeforeEach
	public void setUp() {
		HashMap<String,String> m = new HashMap<String,String>();
		service = new KeyValueService(m);
	}

	@Test
	void addkeyvalue() throws KeyAlreadyPresentException {
		KeyValue keyval = service.AddKeyvalue("k1", "v1");
		Assert.check(service.getcache().size()==1);
		Assert.check(service.getcache().get("k1").equals("v1"));
	}
	
	@Test
	void getkeyvalue() throws  KeyNotPresentException, KeyAlreadyPresentException {
		 service.AddKeyvalue("k1", "v1");
		 KeyValue keyval = service.getKey("k1");
		 
		 Assert.check(keyval.getValue().equals("v1"));
	}
	
	@Test
	void updatekeyvalue() throws  KeyNotPresentException, KeyAlreadyPresentException {
		 service.AddKeyvalue("k1", "v1");
		 service.updatevalue("k1", "v1new");
		 KeyValue keyval = service.getKey("k1");
		 Assert.check(keyval.getValue().equals("v1new"));
	}
	
	@Test
	void deletekeyvalue() throws  KeyNotPresentException, KeyAlreadyPresentException {
		 service.AddKeyvalue("k1", "v1");
		 service.deletevalue("k1");
		 Assert.check(service.getcache().get("k1").equals("DELETE"));
	}
}
