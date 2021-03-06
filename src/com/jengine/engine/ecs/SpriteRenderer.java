package com.jengine.engine.ecs;

import com.jengine.engine.io.Color;
import com.jengine.engine.io.Input;
import com.jengine.engine.io.Texture;

/**
 * 
 * @author Corey Beaver
 *
 * This component is the only way to render a texture, but also handles colors
 */
public class SpriteRenderer extends Component {

	public Texture sprite;
	public Color color;
	
	public boolean colored;
	
	public SpriteRenderer(Entity e, Input i, Texture sprite) {
		super(e, i);
		this.sprite = sprite;
		this.colored = false;
		// TODO Auto-generated constructor stub
	}

	
	
	public SpriteRenderer(Entity e, Input i, Color color) {
		super(e, i);
		this.color = color;
		this.colored = true;
	}




	/**
	 * All components have a start method, there is none in any renderers
	 */
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * All components have a stop method, there is none in any renderers
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * All components have a update method, there is none in any renderers
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
