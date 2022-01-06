package com.jengine.engine.io;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

/**
 * 
 * @author Corey Beaver
 *
 * The Display class is cross-platform for Windows, MacOS, and all linux distros
 * creates a window that we can physically see and render to
 */
public class Display extends JFrame{
	
	/**
	 * 
	 * @author Corey Beaver
	 *
	 * The Type of display
	 */
	public static enum DisplayType {
		Windowed, WindowedFullscreen, Fullscreen
	}

	private DisplayType type;
	public Display(int width, int height, String title) {
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds(width, height, 0, 0);
		this.setLocation(width / 2, (height / 2) + 45);
		this.setTitle(title);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);

		this.pack();
	}
	
	/**
	 * 
	 * @param type The type to set it to
	 */
	public void setType(DisplayType type) {
		this.type = type;
		resize();
	}

	/**
	 * Reszes the display
	 * 
	 */
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
	
	/**
	 * Sets the icon
	 * @param icon texture to set as the icon
	 */
	public void SetIcon(Texture icon) {
		this.setIconImage(icon.image);
	}
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

}
