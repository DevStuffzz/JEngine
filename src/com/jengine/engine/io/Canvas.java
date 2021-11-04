package com.jengine.engine.io;


import com.jengine.engine.ecs.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Canvas extends JPanel implements ImageObserver {
	private List<Entity> entities;

	public Canvas() {
		entities = new ArrayList<Entity>();
		this.setDoubleBuffered(true);
		this.setBackground(new Color(103, 203, 226));
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}



	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D)g;

		for (Entity e : entities) {
			g2d.drawImage(e.getSprite(), (int)e.getLocation().x, (int)e.getLocation().y, e.getWidth(), e.getHeight(), this);
		}
	}

	public void render() {
		repaint();
	}
}
