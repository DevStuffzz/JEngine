package com.jengine.engine.common;

public class Time {
	public static void pause(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
