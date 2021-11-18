package com.jengine.engine.ecs;

import java.awt.event.KeyEvent;

import com.jengine.engine.io.Input;

public class TopDownController extends Component {

	private int speed;
	public boolean moving;
	
	public TopDownController(Entity e, Input i, int speed) {
		super(e, i);
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
	
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		moving = false;
		if(input.keyDown(KeyEvent.VK_W)) {
			entity.location.y -= 1*speed;
			moving = true;
		}
		if(input.keyDown(KeyEvent.VK_S)) {
			entity.location.y += 1*speed;
			moving = true;
		}
		if(input.keyDown(KeyEvent.VK_D)) {
			entity.location.x += 1*speed;
			moving = true;
		}
		if(input.keyDown(KeyEvent.VK_A)) {
			entity.location.x -= 1*speed;
			moving = true;
		}
	}

}
