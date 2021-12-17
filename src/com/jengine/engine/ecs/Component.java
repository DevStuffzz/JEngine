package com.jengine.engine.ecs;

import com.jengine.engine.io.Input;
import com.jengine.engine.physics.Collision;

public abstract class Component {
	public Entity entity;
	protected Input input;

	public Component(Entity e, Input i) {
		this.entity = e;
		this.input = i;
	}

	public abstract void start();
	public abstract void stop();

	public abstract void update();
	
	public void OnCollision(Collision other) {
		
	}
}
