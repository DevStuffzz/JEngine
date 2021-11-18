package com.jengine.engine.math;


public class Vector2 {
	public double x, y;

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}


	@Override
	public String toString() {
		return ": [x=" + x + ", y=" + y + "]";
	}
}
