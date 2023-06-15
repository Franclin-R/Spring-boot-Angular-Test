package com.javafranclin.enums;

public enum ErrorCodes {
	
	PRODUIT_NOT_VALID(1000)
	
	;

	private int code;
	
	ErrorCodes(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
