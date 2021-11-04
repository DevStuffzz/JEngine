package com.jengine.engine.math;


public class Vector2 {
	public double x, y;

	private String name;

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
		this.name = "Unnamed Vector2";
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name + ": [x=" + x + ", y=" + y + "]";
	}


}
