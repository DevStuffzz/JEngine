package com.jengine.engine.common;


public class Logger {
	public static void printf(String format, Object... args) {
		System.out.printf(format, args);
	}

	public static void println(Object object) {
		System.out.println(object);
	}
	
	public static void print(Object object) {
		System.out.println(object);
	}
	
	public static void errprintf(String format, Object... args) {
		System.err.printf(format, args);
	}

	public static void errprintln(Object object) {
		System.err.println(object);
	}
	
	public static void errprint(Object object) {
		System.err.println(object);
	}
	
}
