package com.zhangjx.commons.logging.exception;

public class LogException extends RuntimeException {

	private static final long serialVersionUID = 1112381096772279567L;
	
	public LogException() {
		
	}
	
	public LogException(String s) {
		super(s);
	}
	
	public LogException(String s, Throwable t) {
		super(s, t);
	}
	
	public LogException(Throwable t) {
		super(t);
	}

}
