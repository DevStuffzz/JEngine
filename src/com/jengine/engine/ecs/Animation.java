package com.jengine.engine.ecs;

import java.util.ArrayList;
import java.util.List;

import com.jengine.engine.io.Input;
import com.jengine.engine.io.Texture;

/**
 * 
 * @author Corey Beaver
 *
 *         This Component holds a list of textures and alternates between them,
 *         giving the illusion of movement
 *
 */
public class Animation {
	public int time = 1;
	private int current = 0;

	private List<Texture> textureAtlas;
	private int state;

	Animator anim;

	/**
	 * Creates an animation
	 * 
	 * @param e the entity
	 * @param i the input
	 */
	public Animation(Animator animator) {
		this.textureAtlas = new ArrayList<Texture>();
		this.state = 0;
		anim = animator;
	}

	/**
	 * Add a texture to the list
	 * 
	 * @param texture adds this texture to the list
	 */
	public void addSprite(Texture texture) {
		this.textureAtlas.add(texture);
	}

	public void update() {


		if (current >= time) {
			state++;
			if (state > textureAtlas.size() - 1)
				state = 0;

			SpriteRenderer spr = anim.entity.getComponent(SpriteRenderer.class);

			if (spr != null) {
				spr.sprite = textureAtlas.get(state);
			}
			current = 0;
		}
		current++;
	}

}
