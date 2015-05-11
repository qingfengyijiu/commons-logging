package com.zhangjx.commons.logging.stdout;

import com.zhangjx.commons.logging.Log;

public class StdoutImpl implements Log {

	public boolean isDebugEnabled() {
		return true;
	}

	public void debug(String s) {
		print(s);
	}

	public void info(String s) {
		print(s);
	}

	public void warn(String s) {
		print(s);
	}

	public void error(String s) {
		System.err.println(s);
	}

	public void error(String s, Throwable t) {
		System.err.println(s);
		t.printStackTrace(System.err);
	}
	
	private void print(String s) {
		System.out.println(s);
	}

}
