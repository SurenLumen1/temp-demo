package com.lumen.dssh.orchestrator.util;

public class Timer {
	private long t;
	
	public Timer() {
		reset();
	}

	/**
	 * reset timer
	 */
	public void reset() {
		t = System.currentTimeMillis();
	}

	/**
	 * @return elapsed time
	 */
	public long elapsed() {
		return System.currentTimeMillis() - t;
	}

}
