package com.jengine.engine.ecs;

import java.awt.event.KeyEvent;

import com.jengine.engine.common.Time;
import com.jengine.engine.io.Input;
import com.jengine.engine.physics.SquareCollider;

/**
 * 
 * @author Corey Beaver
 *
 * Top Down Character controllear
 */
public class TopDownController extends Component {

	private int speed;
	public boolean moving;
	
	SquareCollider collider;
	
	public TopDownController(Entity e, Input i, int speed) {
		super(e, i);
		this.speed = speed;
		this.collider = e.getComponent(SquareCollider.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Removes this from the entity if the entity is static
	 */
	@Override
	public void start() {
		if(entity.tag.contains("-static")) entity.removeComponent(this);
	}

	@Override
	public void stop() {
	
	}

	/**
	 * Handles input and updates the characters position
	 */
	@Override
	public void update() {
		if(!collider.isColliding) {
			return;
		}
		// TODO Auto-generated method stub
		moving = false;
		if(input.keyDown(KeyEvent.VK_W)) {
			entity.location.y -= 1*speed * Time.DeltaTime;
			moving = true;
		}
		if(input.keyDown(KeyEvent.VK_S)) {
			entity.location.y += 1*speed * Time.DeltaTime;
			moving = true;
		}
		if(input.keyDown(KeyEvent.VK_D)) {
			entity.location.x += 1*speed * Time.DeltaTime;
			moving = true;
		}
		if(input.keyDown(KeyEvent.VK_A)) {
			entity.location.x -= 1*speed * Time.DeltaTime;
			moving = true;
		}
	}

}
