package com.jengine.engine.common;

/**
 * 
 * @author Corey Beaver
 *
 * This class handles the time in the engine
 *
 */
public class Time {
	// Time between frames
	public static double DeltaTime = 0;
	
	private static double begin = 0;
	private static double end = 0;
	
	/*
	 * The Frames per Second of your program
	 */
	public static int FPS;
	
	/**
	 * Sets the begin time of the frame
	 */
	public static void BeginFrame() {
		begin = end;
	}
	
	/**
	 * Ends the frame and calculates DeltaTime/FPS
	 */
	public static void EndFrame() {
		end = System.currentTimeMillis();
		DeltaTime = (end-begin)/1000;
		FPS = (int)DeltaTime * 60;
	}
}
