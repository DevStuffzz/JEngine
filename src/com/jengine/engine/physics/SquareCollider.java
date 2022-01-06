package com.jengine.engine.physics;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.jengine.engine.ecs.Component;
import com.jengine.engine.ecs.Entity;
import com.jengine.engine.io.Input;
import com.jengine.engine.io.RendererFlags;

public class SquareCollider extends Collider {

	public boolean isColliding;

	public SquareCollider(Entity e, Input i) {
		super(e, i);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		for(Collider other : RendererFlags.MAIN_RENDERER.otherColliders()) {
			if(checkCollision(other)) {
				entity.OnCollision(other);
			}
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkCollision(Collider other) {
		if(other.entity.tag.contains("-debug true"))
			System.out.println(other.entity.name);
		Rectangle collider = new Rectangle((int)this.entity.location.x, (int)this.entity.location.y, this.entity.width, this.entity.height);
		return collider.intersects(new Rectangle((int)other.entity.location.x, (int)other.entity.location.y, other.entity.width, other.entity.height));
	}

	@Override
	public void OnCollision(Collider other) {
		this.isColliding = true;
	}
	
	
}
