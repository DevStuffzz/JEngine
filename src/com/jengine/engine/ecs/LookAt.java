package com.jengine.engine.ecs;

import com.jengine.engine.io.Input;

public class LookAt extends Component {
	private Entity toLookAt;
	
	public LookAt(Entity e, Input io, Entity toLookAt) {
		super(e, io);
		this.toLookAt = toLookAt;
	}

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
