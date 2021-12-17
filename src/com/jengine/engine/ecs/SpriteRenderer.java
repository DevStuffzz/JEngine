package com.jengine.engine.ecs;

import com.jengine.engine.io.Input;
import com.jengine.engine.io.Texture;

public class SpriteRenderer extends Component {

	private Texture sprite;

	public SpriteRenderer(Entity e, Input i, Texture sprite) {
		super(e, i);
		this.sprite = sprite;
		// TODO Auto-generated constructor stub
	}

	public Texture getSprite() {
		return sprite;
	}

	public void setSprite(Texture sprite) {
		this.sprite = sprite;
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
