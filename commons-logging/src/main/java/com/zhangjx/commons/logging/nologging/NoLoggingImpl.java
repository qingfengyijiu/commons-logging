package com.zhangjx.commons.logging.nologging;

import com.zhangjx.commons.logging.Log;

public class NoLoggingImpl implements Log {
	
	public boolean isDebugEnabled() {
		return false;
	}

	public void debug(String s) {
		
	}

	public void info(String s) {
		
	}

	public void warn(String s) {
		
	}

	public void error(String s) {
		
	}

	public void error(String s, Throwable t) {
		
	}

}
