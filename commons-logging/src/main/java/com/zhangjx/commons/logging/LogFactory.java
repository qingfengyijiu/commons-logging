package com.zhangjx.commons.logging;

import java.lang.reflect.Constructor;

import com.zhangjx.commons.io.Resources;
import com.zhangjx.commons.logging.exception.LogException;

public class LogFactory {

	private LogFactory() {
		// disable construction
	}
	
	private static Constructor<? extends Log> logConstructor;
	
	static {
		tryImplementation(new Runnable() {
			public void run() {
				useSlf4jLogging();
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				useJclLogging();
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				useLog4jLogging();
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				useJdkLogging();
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				useStdoutLogging();
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				useNoLogging();
			}
		});
	}
	
	private static void tryImplementation(Runnable runnable) {
		if(logConstructor == null) {
			try {
				runnable.run();
			} catch (Throwable t) {
				// ignore
			}
		}
	}
	
	public static synchronized void useSlf4jLogging() {
		setImplementation("com.zhangjx.commons.logging.slf4j.Slf4jImpl");
	}
	
	public static synchronized void useNoLogging() {
		setImplementation("com.zhangjx.commons.logging.nologging.NoLoggingImpl");
	}
	
	public static synchronized void useJdkLogging() {
		setImplementation("com.zhangjx.commons.logging.jdk.JdkLoggingImpl");
	}
	
	public static synchronized void useJclLogging() {
		setImplementation("com.zhangjx.commons.logging.jcl.JakartaCommonsLoggingImpl");
	}
	
	public static synchronized void useStdoutLogging() {
		setImplementation("com.zhangjx.commons.logging.stdout.StdoutImpl");
	}
	
	public static synchronized void useLog4jLogging() {
		setImplementation("com.zhangjx.commons.logging.log4j.Log4jImpl");
	}
	
	@SuppressWarnings("unchecked")
	private static void setImplementation(String implClassName) {
		try {
			Class<? extends Log> implClass = (Class<? extends Log>) Resources.classForName(implClassName);
			Constructor<? extends Log> candidate = implClass.getConstructor(new Class[]{String.class});
			Log log = candidate.newInstance(new Object[]{LogFactory.class.getName()});
			log.debug("Logging initialized  using '" + implClassName + "' adapter.");
			logConstructor = candidate;
		} catch (Throwable t) {
			throw new LogException("Error setting Log implementation.  Cause: " + t, t);
		} 
	}
	
	public static Log getLog(Class<?> aClass) {
		return getLog(aClass.getName());
	}
	
	public static Log getLog(String logger) {
		try {
			return logConstructor.newInstance(new Object[]{logger});
		} catch (Throwable t) {
			throw new LogException("Error creating logger instance for logger " + logger + ".  Cause: " + t, t);
		} 
	}
	
	
}
