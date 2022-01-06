package com.jengine.engine.ecs;

import com.jengine.engine.io.Input;

public class LineBetween extends Component {

	LineRenderer line;
	Entity a, b;
	
	public LineBetween(Entity e, Input i, Entity a, Entity b) {
		super(e, i);
		line = e.getComponent(LineRenderer.class);
		this.a = a;
		this.b = b;
		// TODO Auto-generated constructor stub
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
		line.point1 = a.location;
		line.point2 = b.location;
	}

}
