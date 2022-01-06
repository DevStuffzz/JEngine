package com.jengine.engine.ecs;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.jengine.engine.io.Input;
import com.jengine.engine.io.Texture;
import com.jengine.engine.math.Vector2;
import com.jengine.engine.physics.Collider;
import com.jengine.engine.physics.SquareCollider;


/**
 * 
 * @author Corey Beaver
 *
 * This class holds our entity and all of its data
 */
public class Entity {
	public Vector2 location;
	public int width, height;

	public float rotation = 0.0f;

	public List<Component> components;

	public String tag = "default", name = "entity";

	/**
	 * 
	 * 
	 * @param location Two-Component vector which is the location
	 * @param width width
	 * @param height height
	 */
	public Entity(Vector2 location, int width, int height) {
		super();
		this.components = new ArrayList<Component>();
		this.location = location;
		this.width = width;
		this.height = height;
	}

	/**
	 * 
	 * @param <T> any component
	 * @param componentClass the class you want to get
	 * @return Component of your choice
	 */
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

	/**
	 * adds a component to the list
	 * @param c component to add
	 */
	public void add(Component c) {
		this.components.add(c);
	}

	/**
	 * starts all components
	 */
	public void start() {

		for (Component c : components) {
			c.start();
		}
	}

	/**
	 * updates all components
	 */
	public void update() {
		for (Component c : components) {
			c.update();
		}
	}

	/**
	 * stops all components
	 */
	public void stop() {
		for (Component c : components) {

			c.stop();
		}
	}

	/**
	 * calls the OnCollision funcion for all components
	 * @param other the other thing you are colliding with
	 */
	public void OnCollision(Collider other) {
		if (other.entity.tag.equals("no-collider")) {
			return;
		}
		for (Component c : components) {
			c.OnCollision(other);
		}
	}

	/**
	 * 
	 * @return the current location
	 */
	public Vector2 getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location location to set to
	 */
	public void setLocation(Vector2 location) {
		this.location = location;
	}

	/**
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @param width width to set to
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @param height height to set to
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Removes a component for the list
	 * 
	 * @param component Component to remove
	 * @return if the component was removed successfully
	 */
	public boolean removeComponent(Component component) {
		for (Component c : components) {
			if (c == component) {
				components.remove(c);
				return true;
			}
		}
		return false;
	}

}
