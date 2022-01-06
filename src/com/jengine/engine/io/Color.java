package com.jengine.engine.io;

import com.jengine.engine.math.Vector3;

/**
 * 
 * @author Corey Beaver
 *
 * This class holds a vec3 for the color
 */
public class Color {
	/*
	 * Static Colors
	 */
	public static final Color WHITE = new Color(255.0f);
	public static final Color BLACK = new Color(0.0f);
	
	public static final Color GRAY = new Color(100.0f);
	public static final Color LIGHT_GRAY = new Color(195.0f);
	public static final Color DARK_GRAY = new Color(50.0f);
	
	public static final Color GREEN = new Color(0.0f, 255.0f, 0.0f);
	public static final Color BLUE = new Color(0.0f, 0.0f, 255.0f);
	public static final Color YELLOW = new Color(255.0f, 255.0f, 0.0f);
	public static final Color RED = new Color(255.0f, 0.0f, 0.0f);
	public static final Color PURPLE = new Color(255.0f, 0f, 255.0f);
	public static final Color CYAN = new Color(0.0f, 255.0f, 255.0f);
	
	public Vector3 color;

	public Color(Vector3 color) {
		this.color = color;
	}

	public Color(float x, float y, float z) {
		this.color = new Vector3(x, y, z);
	}

	public Color(float color) {
		this.color = new Vector3(color, color, color);
	}
	
	/**
	 * Since the renderer requires an awt Color, this method will make a new one with the color
	 * 
	 * @return the raw color
	 */
	public java.awt.Color GetRawColor() {
		return new java.awt.Color((int)color.x, (int)color.y, (int)color.z);
	}
}
