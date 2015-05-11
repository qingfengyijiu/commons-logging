package com.zhangjx.commons.logging;

/**
 * The local log interface, designed for switch between different log implementations
 * or other log technology in the future.
 * @author zhang jianxin
 *
 */
public interface Log {

	boolean isDebugEnabled();
	
	void debug(String s);
	
	void info(String s);
	
	void warn(String s);
	
	void error(String s);
	
	void error(String s, Throwable t);
}
