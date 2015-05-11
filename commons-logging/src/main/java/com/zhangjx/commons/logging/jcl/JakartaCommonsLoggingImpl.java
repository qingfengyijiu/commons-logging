package com.zhangjx.commons.logging.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JakartaCommonsLoggingImpl implements com.zhangjx.commons.logging.Log {

	private Log log;
	
	public JakartaCommonsLoggingImpl(String clazz) {
		log = LogFactory.getLog(clazz);
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
