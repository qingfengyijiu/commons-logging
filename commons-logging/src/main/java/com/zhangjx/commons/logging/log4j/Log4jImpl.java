package com.zhangjx.commons.logging.log4j;

import org.apache.log4j.Logger;

import com.zhangjx.commons.logging.Log;

public class Log4jImpl implements Log {
	
	private Logger log;
	
	public Log4jImpl(String clazz) {
		log = Logger.getLogger(clazz);
	}

	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	public void debug(String s) {
		log.debug(s);
	}

	public void info(String s) {
		log.info(s);
	}

	public void warn(String s) {
		log.warn(s);
	}

	public void error(String s) {
		log.error(s);
	}

	public void error(String s, Throwable t) {
		log.error(s, t);
	}

}
