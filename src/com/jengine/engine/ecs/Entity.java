package com.jengine.engine.ecs;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.jengine.engine.io.Texture;
import com.jengine.engine.math.Vector2;
import com.jengine.engine.physics.Collision;

public class Entity {
	public Vector2 location;
	public int width, height;

	public List<Component> components;

	public String tag="default", name="entity";

	public Entity(Vector2 location, int width, int height) {
		super();
		this.components = new ArrayList<Component>();
		this.location = location;
		this.width = width;
		this.height = height;
	}

	public <T extends Component> T getComponent(Class<T> componentClass) {
		for (Component c : components) {
			if (componentClass.isAssignableFrom(c.getClass())) {
				try {
					return componentClass.cast(c);
				} catch (ClassCastException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
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
	
	public void OnCollision(Collision other) {
		if(other.entity.tag.equals("no-collider")) {
			//return;
		}
		for (Component c : components) {
			c.OnCollision(other);
		}
	}

	public Vector2 getLocation() {
		return location;
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
