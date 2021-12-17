package com.jengine.engine.io;

import com.jengine.engine.ecs.Entity;
import com.jengine.engine.ecs.SpriteRenderer;
import com.jengine.engine.physics.Collision;

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
	
	private Texture bg_Texture;
	private boolean colored;
	public List<Collision> otherColliders() {
		List<Collision> others = new ArrayList<Collision>();

		for (Entity e : entities) {
			Collision other = e.getComponent(Collision.class);
			if (other != null) {
				others.add(other);
			}
		}

		return others;
	}

	public Canvas() {
		entities = new ArrayList<Entity>();
		textList = new ArrayList<Text>();
		this.setDoubleBuffered(true);
		this.setBackground(new Color(103, 203, 226));
		this.colored = true;
	}

	public void SetBackground(Texture texture) {
		this.bg_Texture = texture;
		this.colored = false;
	}
	
	public void resize(Display d) {
		this.setSize(d.getSize());
	}

	public void SetBackground(Color color) {
		this.setBackground(color);
		this.colored = true;
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}

	public void addText(Text t) {
		textList.add(t);
	}

	public void update() {
		for (Entity e : entities) {
			e.update();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		if(!this.colored) {
			g2d.drawImage(bg_Texture.image, 0, 0, this.getWidth(), this.getHeight(), this);
		}
		
		for (Entity e : entities) {
			SpriteRenderer spr = e.getComponent(SpriteRenderer.class);
			if (spr != null) {
				g2d.drawImage(spr.getSprite().image, (int) e.getLocation().x, (int) e.getLocation().y, e.getWidth(),
						e.getHeight(), this);
			}
		}

		// Render text
		for (Text t : textList) {
			Font plainFont = new Font("Serif", Font.PLAIN, t.fontSize);
			g2d.setColor(t.color);
			g2d.setFont(plainFont);
			g2d.drawString(t.getText(), (int) t.location.x, (int) t.location.y);
		}

	}

	public void render() {
		repaint();
	}
}
