package com.jengine.engine.ecs;

import com.jengine.engine.io.Color;
import com.jengine.engine.io.Input;
import com.jengine.engine.math.Vector2;

/**
 * 
 * @author Corey Beaver
 *
 * Line Renderer component
 * Has two vec2's and a color
 * renders a line with its width
 */
public class LineRenderer extends Component {
	public Vector2 point1, point2;
	public Color color;
	
	public int Width = 1;
	
	public LineRenderer(Entity e, Input i, Vector2 point1, Vector2 point2, Color color) {
		super(e, i);
		this.point1 = point1;
		this.point2 = point2;
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
