package com.jengine.engine.physics;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.jengine.engine.ecs.Component;
import com.jengine.engine.ecs.Entity;
import com.jengine.engine.io.Input;

public class Collision extends Component {

	private List<Collision> otherColliders;

	public Collision(Entity e, Input i) {
		super(e, i);
		otherColliders = new ArrayList<Collision>();
	}

	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}


	public boolean checkCollision(Collision other) {
		Rectangle collider = new Rectangle((int)this.entity.location.x, (int)this.entity.location.y, this.entity.width, this.entity.height);
		return collider.intersects(new Rectangle((int)other.entity.location.x, (int)other.entity.location.y, other.entity.width, other.entity.height));
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
}


