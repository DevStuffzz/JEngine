package com.jengine.engine.math;

public class Vector3 {
	public float x, y, z;

	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3(Vector2 vec, float z) {
		this.x = vec.x;
		this.y = vec.y;
		this.z = z;
	}
}
