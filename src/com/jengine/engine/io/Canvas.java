package com.jengine.engine.io;


import com.jengine.engine.ecs.Entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Canvas extends JPanel implements ImageObserver {
	private List<Entity> entities;
	private List<Text> textList;


	public Canvas() {
		entities = new ArrayList<Entity>();
		textList = new ArrayList<Text>();
		this.setDoubleBuffered(true);
		this.setBackground(new Color(103, 203, 226));
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void addText(Text t) {
		textList.add(t);
	}



	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D)g;

		for (Entity e : entities) {
			g2d.drawImage(e.getSprite(), (int)e.getLocation().x, (int)e.getLocation().y, e.getWidth(), e.getHeight(), this);
		}
		
		// Render text
		for(Text t : textList) {
			Font plainFont = new Font("Serif", Font.PLAIN, t.fontSize);
			g2d.setColor(t.color);
			g2d.setFont(plainFont);
			g2d.drawString(t.getText(), (int)t.location.x, (int)t.location.y);
		}
		
	}

	public void render() {
		repaint();
	}
}
