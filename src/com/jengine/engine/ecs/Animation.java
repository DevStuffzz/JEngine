package com.jengine.engine.ecs;

import java.util.ArrayList;
import java.util.List;

import com.jengine.engine.io.Input;
import com.jengine.engine.io.Texture;

public class Animation extends Component {
	private long time = 1;
	
	private List<Texture> textureAtlas;
	private int state;
	
	public Animation(Entity e, Input i) {
		super(e, i);
		this.textureAtlas = new ArrayList<Texture>();
		this.state = 0;
	}
	

	public void addSprite(Texture texture) {
		this.textureAtlas.add(texture);
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
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		state++;
		if(state > textureAtlas.size()-1) state = 0;
		
		SpriteRenderer spr = this.entity.getComponent(SpriteRenderer.class);
		
		if(spr != null) {
			spr.setSprite(textureAtlas.get(state));
		}
	}

}
