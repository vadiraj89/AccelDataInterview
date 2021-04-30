package com.interview.KeyValue;

import java.util.*;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.interview.Exception.*;
import com.interview.Models.*;
import com.interview.serviceLayer.*;


@SpringBootApplication
@RestController
public class KeyValueApplication {
    KeyValueService service = new KeyValueService();
	public static void main(String[] args) {
		SpringApplication.run(KeyValueApplication.class, args);
	}
	
    //GET
	@GetMapping("/getvalueforKey/{id}")
	public KeyValue getValueForKey(@PathVariable(value = "id") String key) throws KeyNotPresentException  {
		return service.getKey(key);
	 }
	
	//POST
	@PostMapping(value = "/createkeyvalue", consumes = "application/json", produces = "application/json")
	public KeyValue createKeyValue(@RequestBody KeyValue request) throws KeyAlreadyPresentException  {
		return service.AddKeyvalue(request.getKey(), request.getValue());
	 }
	
	//PUT
	@PutMapping(value = "/updatekeyvalue", consumes = "application/json", produces = "application/json")
	public KeyValue updateKeyValue(@RequestBody KeyValue request) throws KeyNotPresentException  {
		return service.updatevalue(request.getKey(), request.getValue());
	 }
	
	//DELETE
	@DeleteMapping(value = "/deletekeyvalue", consumes = "application/json", produces = "application/json")
	public KeyValue deleteKeyValue(@RequestBody KeyValue request) throws KeyNotPresentException  {
		return service.deletevalue(request.getKey());
	 }
	
	

	
}
