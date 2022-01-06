package com.jengine.engine.ecs;

import com.jengine.engine.io.Input;
import com.jengine.engine.physics.Collider;
import com.jengine.engine.physics.SquareCollider;

/**
 * 
 * @author Corey Beaver
 *
 * The Abstract Component class
 * All built in and client components will extend this class
 */
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
	
	public void OnCollision(Collider other) {
		
	}
}
