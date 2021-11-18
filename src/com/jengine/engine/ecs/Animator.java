package com.jengine.engine.ecs;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.jengine.engine.io.Input;

public class Animator extends Component {

	private List<Image> animations;
	
	public Animator(Entity e, Input i) {
		super(e, i);
		this.animations = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void flip() {
		this.entity.setWidth(this.entity.width*-1);
	}
	
	public void addAnimation(String location) {
		Image temp = new ImageIcon(location).getImage();
		this.animations.add(temp);
	}
	
	public void addAnimation(Image image) {
		this.animations.add(image);
	}
	
	public Image getAnimation(int index) {
		return this.animations.get(index);
	}
	
	public void setAnimationState(int state) {
		this.entity.setSprite(getAnimation(state));
	}
}
