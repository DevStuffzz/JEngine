package com.jengine.engine.io;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Display extends JFrame{


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


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

}
