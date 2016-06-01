package com.emc.interview.servlet;

public class ValidatorException extends Exception {

	private static final long serialVersionUID = 8312141416860093495L;

	public int getCode() {
		return code;
	}

	private int code;

	public ValidatorException(int code, String message) {
		super(message);
		this.code = code;
	}

}