package com.zhangjx.commons.logging.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhangjx.commons.logging.Log;

public class Slf4jImpl implements Log {
	
	private Logger log;
	
	public Slf4jImpl(String clazz) {
		log = LoggerFactory.getLogger(clazz);
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
