package com.jengine.engine.io;

import java.awt.Color;

import com.jengine.engine.math.Vector2;

/**
 * 
 * @author Corey Beaver
 *
 * This class holds things like the String, font, and location of 
 * the text
 */
public class Text {
	private String text;
	public Vector2 location;
	public int fontSize;

	public Color color;

	/**
	 * 
	 * @param text the text
	 */
	public Text(String text) {
		super();
		this.text = text;
		this.location = new Vector2(0, 0);
		this.fontSize = 25;
		this.color = Color.PINK;
	}

	/**
	 * 
	 * @param text the text
	 * @param location location to render
	 */
	public Text(String text, Vector2 location) {
		super();
		this.text = text;
		this.location = location;
		this.fontSize = 25;
		this.color = Color.PINK;

	}

	/**
	 * 
	 * @param text the text
	 * @param location location to render
	 * @param fontSize font size
	 */
	public Text(String text, Vector2 location, int fontSize) {
		super();
		this.text = text;
		this.location = location;
		this.fontSize = fontSize;
		this.color = Color.PINK;
	}

	/**
	 * 
	 * @return the location
	 */
	public Vector2 getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location location to set to
	 */
	public void setLocation(Vector2 location) {
		this.location = location;
	}

	/**
	 * 
	 * @return the font size
	 */
	public int getFontSize() {
		return fontSize;
	}

	/**
	 * 
	 * @param fontSize font size to set to
	 */
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	/**
	 * 
	 * @param text text to set to
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return text
	 */
	@Override
	public String toString() {
		return this.text;
	}

	/**
	 * Compares two text's and tells if they are the same
	 * 
	 * @param t other text object
	 * @return if the text's strings are the same
	 */
	public boolean compare(Text t) {
		return t.equals(this.text);
	}

}
