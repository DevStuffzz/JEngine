package com.jengine.engine.ecs;

import java.util.HashMap;
import java.util.Map;

import com.jengine.engine.io.Input;

/**
 * 
 * @author Corey Beaver
 *
 * The animator components holds multiple Animations you can swap through
 */
public class Animator extends Component {
	Map<String, Animation> animations;
	String currentAnimation = "-none";
	
	int speed = 1;
	
	public Animator(Entity e, Input i) {
		super(e, i);
		this.animations = new HashMap<String, Animation>();
		this.entity.getComponent(SpriteRenderer.class).colored = false;
		// TODO Auto-generated constructor stub
	}


	public void setSpeed(int time, String animation) {
		if(animations.containsKey(animation)) {
			animations.get(animation).time = time;
		}
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param animation Animation to add
	 */
	public void add(Animation animation, String name) {
		animations.put(name, animation);
		currentAnimation = name;
		System.out.printf("");
	}
	
	/**
	 * Sets the current animation
	 * @param name the name of the animation
	 */
	public void setAnimation(String name) {
		if(animations.containsKey(name)) {
			this.currentAnimation = name;
		}
	}
	
	@Override
	public void update() {
		if(currentAnimation.equals("-none")) return;
		animations.get(currentAnimation).update();
	}
}
