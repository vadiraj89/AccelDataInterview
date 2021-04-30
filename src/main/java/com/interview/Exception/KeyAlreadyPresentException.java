package com.interview.Exception;

public class KeyAlreadyPresentException extends Exception{
public KeyAlreadyPresentException(String key) {
		super();
		this.key = key;
	}

String key;

@Override
public String toString() {
	return "KeyAlreadyPresentException [key=" + key + "]";
}
}
