package com.jengine.engine.io;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class Display extends JFrame{
	
	public static enum DisplayType {
		Windowed, WindowedFullscreen, Fullscreen
	}

	private DisplayType type;
	public Display(int width, int height, String title) {
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(width, height, 0, 0);
		this.setLocation(width / 2, (height / 2) + 45);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(0, 138, 197));

		this.setVisible(true);

		this.pack();
	}
	
	public void setType(DisplayType type) {
		this.type = type;
		resize();
	}

	private void resize() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		if(this.type == DisplayType.Windowed) {
			this.setSize(new Dimension(width/2, height/2));
			this.setLocation(width/3, height/3);
		} else if (this.type == DisplayType.WindowedFullscreen) {
			this.setSize(new Dimension(width, height));
			this.setLocation(0, 0);
		}
	}
	
	public void SetIcon(Texture icon) {
		this.setIconImage(icon.image);
	}
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

}
