package com.jengine.engine.math;

import java.util.Iterator;

public class Vector2 {
	public static final Vector2 UP = new Vector2(1.0f, 2.0f);
	
	public static final int X = 0;
	public static final int Y = 1;
	
	public double x, y;

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void AddForce(Vector2 dir, int side, int mod) {
		if(side == X) {
			this.x += dir.x*mod;
		} if (side == Y) {
			this.y += dir.y*mod;
		}
	}
	
	public Vector2 negative(int side) {
		if(side == X) {
			return new Vector2(-x, y);
		} if (side == Y) {
			return new Vector2(x, -y);
		}
		return null;
	}
	

	
	@Override
	public String toString() {
		return ": [x=" + x + ", y=" + y + "]";
	}
}
