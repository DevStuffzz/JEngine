package com.jengine.engine.io;

import java.awt.Color;

import com.jengine.engine.math.Vector2;

public class Text {
	private String text;
	public Vector2 location;
	public int fontSize;

	public Color color;

	public Text(String text) {
		super();
		this.text = text;
		this.location = new Vector2(0, 0);
		this.fontSize = 25;
		this.color = Color.PINK;
	}

	public Text(String text, Vector2 location) {
		super();
		this.text = text;
		this.location = location;
		this.fontSize = 25;
		this.color = Color.PINK;

	}

	public Text(String text, Vector2 location, int fontSize) {
		super();
		this.text = text;
		this.location = location;
		this.fontSize = fontSize;
		this.color = Color.PINK;
	}

	public Vector2 getLocation() {
		return location;
	}

	public void setLocation(Vector2 location) {
		this.location = location;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return this.text;
	}

	public boolean compare(Text t) {
		return t.equals(this.text);
	}

}
