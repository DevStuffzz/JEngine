package com.jengine.engine.ecs;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.jengine.engine.math.Vector2;

public class Entity {
	public Vector2 location;
	public int width, height;

	public List<Component> components;

	private Image sprite;

	public Entity(Vector2 location, int width, int height, Image sprite) {
		super();
		this.components = new ArrayList<Component>();
		this.location = location;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}

	public void add(Component c) {
		this.components.add(c);
	}

	public void start() {
		for (Component c : components) {
			c.start();
		}
	}

	public void update() {
		for (Component c : components) {
			c.update();
		}
	}

	public void stop() {
		for (Component c : components) {
			c.stop();
		}
	}

	public Vector2 getLocation() {
		return location;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public void setLocation(Vector2 location) {
		this.location = location;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
