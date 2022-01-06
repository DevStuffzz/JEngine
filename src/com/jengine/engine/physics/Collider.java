package com.jengine.engine.physics;

import java.awt.Rectangle;

import com.jengine.engine.ecs.Component;
import com.jengine.engine.ecs.Entity;
import com.jengine.engine.io.Input;

public abstract class Collider extends Component{

	public Collider(Entity e, Input i) {
		super(e, i);
		// TODO Auto-generated constructor stub
	}
	
	public abstract boolean checkCollision(Collider other); 

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
