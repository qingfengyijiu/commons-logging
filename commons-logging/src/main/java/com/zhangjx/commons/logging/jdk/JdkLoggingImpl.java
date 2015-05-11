package com.zhangjx.commons.logging.jdk;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.zhangjx.commons.logging.Log;

public class JdkLoggingImpl implements Log {
	
	private Logger log;
	
	public JdkLoggingImpl(String clazz) {
		log = Logger.getLogger(clazz);
	}

	public boolean isDebugEnabled() {
		return log.isLoggable(Level.FINE);
	}

	public void debug(String s) {
		log.log(Level.FINE, s);
	}

	public void info(String s) {
		log.log(Level.INFO, s);
	}

	public void warn(String s) {
		log.log(Level.WARNING, s);
		
	}

	public void error(String s) {
		log.log(Level.SEVERE, s);
	}

	public void error(String s, Throwable t) {
		log.log(Level.SEVERE, s, t);
	}

}
