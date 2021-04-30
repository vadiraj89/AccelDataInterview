package com.interview.Exception;

public class KeyNotPresentException extends Exception{

	public KeyNotPresentException(String key) {
		super();
		this.key = key;
	}

	String key;

	@Override
	public String toString() {
		return "KeyNotPresentException [key=" + key + "]";
	}
}
