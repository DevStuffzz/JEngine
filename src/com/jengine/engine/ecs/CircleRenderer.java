package com.jengine.engine.ecs;

import com.jengine.engine.io.Color;
import com.jengine.engine.io.Input;

/**
 * 
 * @author Corey Beaver
 *
 * This component will render a circle with a given color and radius
 */
public class CircleRenderer extends Component {

	public float Radius;
	public Color color;
	
	/**
	 * Constructor for the Circle Renderer
	 * 
	 * @param e The Entity
	 * @param i The Input
	 * @param radius Radius you want the circle to be
	 * @param color Color you want the circle to be
	 */
	public CircleRenderer(Entity e, Input i, float radius, Color color) {
		super(e, i);
		// TODO Auto-generated constructor stub
		entity.width = (int)radius*2;
		entity.height = (int)radius*2;
		this.Radius = radius;
		this.color = color;
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
