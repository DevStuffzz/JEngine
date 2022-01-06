package com.jengine.engine.common;

import com.jengine.engine.io.Color;

/**
 * 
 * @author Corey Beaver
 * 
 * This is the Static Random class (Which java should have already -_-
 */
public class Random {
	private static java.util.Random r = new java.util.Random();

	/**
	 * 
	 * @param min the minimum your random will be
	 * @param max the maximum your random will be
	 * @return a random double between your min and max
	 */
	public static double Range(int min, int max) {
		return min + (Math.random() * ((max - min) + 1));
	}

	/**
	 * 
	 * @return random true or false
	 */
	public static boolean Bool() {
		return r.nextBoolean();
		
	}
	
	/**
	 * 
	 * @return a random integer from Integer.MIN_VALUE to Integer.MAX_VALUE
	 */
	public static int Seed() {
		return r.nextInt();
	}
	
	/**
	 * 
	 * @return a random color
	 */
	public static Color Color() {
		return new Color((float)Range(0, 255), (float)Range(0, 255), (float)Range(0, 255));
	}
}
