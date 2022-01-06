package com.jengine.engine.io;

import com.jengine.engine.common.Time;
import com.jengine.engine.ecs.CircleRenderer;
import com.jengine.engine.ecs.Entity;
import com.jengine.engine.ecs.LineRenderer;
import com.jengine.engine.ecs.SpriteRenderer;
import com.jengine.engine.physics.Collider;
import com.jengine.engine.physics.SquareCollider;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Renderer extends JPanel implements ImageObserver {
	private List<Entity> entities;
	private List<Text> textList;

	private Texture bg_Texture;
	private boolean colored;

	public boolean debugLines = false;


	public List<Collider> otherColliders() {
		List<Collider> others = new ArrayList<Collider>();

		for (Entity e : entities) {
			SquareCollider square = e.getComponent(SquareCollider.class);
			if (square != null) {
				others.add(square);
			}
		}

		return others;
	}

	public Renderer() {
		entities = new ArrayList<Entity>();
		textList = new ArrayList<Text>();
		this.setDoubleBuffered(true);
		this.setBackground(new Color(0, 0, 0).GetRawColor());
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

		this.setBackground(color.GetRawColor());
		RendererFlags.MAIN_DISPLAY.setBackground(color.GetRawColor());
		this.colored = true;
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public void addEntityFront(Entity e) {
		entities.add(0, e);
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
	public void paintComponent(Graphics g) {
		Time.BeginFrame();
		this.update();
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		if (debugLines) {
			for (Entity e : this.entities) {
				SquareCollider collider = e.getComponent(SquareCollider.class);
				if (collider != null) {
					g2d.setColor(Color.PURPLE.GetRawColor());
					g2d.drawRect(e.location.integralForm(0)-1, e.location.integralForm(1)-1, e.width+1, e.height+1);
				}
			}
		}

		this.getGraphics().setColor(getBackground());
		this.getGraphics().drawRect(0, 0, this.getWidth(), this.getHeight());

		if (!this.colored) {
			g2d.drawImage(bg_Texture.image, 0, 0, this.getWidth(), this.getHeight(), this);
		}

		for (Entity e : this.entities) {

			SpriteRenderer spr = e.getComponent(SpriteRenderer.class);
			if (spr != null) {
				if (spr.colored) {
					g2d.setColor(spr.color.GetRawColor());
					g2d.fillRect(e.location.integralForm(0), e.location.integralForm(1), e.width, e.height);
				} else {
					if(spr.sprite == null) continue;
					g2d.drawImage(spr.sprite.image, (int) e.getLocation().x, (int) e.getLocation().y, e.getWidth(),
							e.getHeight(), this);
				}
			}
			LineRenderer line = e.getComponent(LineRenderer.class);
			if (line != null) {
				g2d.setColor(line.color.GetRawColor());
				g2d.setStroke(new BasicStroke(line.Width));
				g2d.drawLine((int) line.point1.x, (int) line.point1.y, (int) line.point2.x, (int) line.point2.y);
			}
			CircleRenderer circle = e.getComponent(CircleRenderer.class);
			if (circle != null) {
				g2d.setColor(circle.color.GetRawColor());
				g2d.fillOval(e.location.integralForm(0), e.location.integralForm(1), (int) circle.Radius * 2,
						(int) circle.Radius * 2);
			}
		}

		// Render text
		for (Text t : textList) {
			Font plainFont = new Font("Serif", Font.PLAIN, t.fontSize);
			g2d.setColor(t.color);
			g2d.setFont(plainFont);
			g2d.drawString(t.getText(), (int) t.location.x, (int) t.location.y);
		}

		Time.EndFrame();
	}

	public void render() {
		repaint();
	}

	public void start() {
		for (Entity e : entities) {
			e.start();
		}
	}
}
