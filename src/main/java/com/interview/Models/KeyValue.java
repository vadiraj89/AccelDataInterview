package com.interview.Models;

public class KeyValue {
  public KeyValue(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
  String key;
  String value;
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
}
