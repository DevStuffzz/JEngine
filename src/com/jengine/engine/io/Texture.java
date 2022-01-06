package com.jengine.engine.io;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Texture {
	private static Map<String, Texture> textureAtlas = new HashMap<String, Texture>();
	
	public BufferedImage image;
	private Texture(String location) {
		try {
			this.image = ImageIO.read(new File(location));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.printf("Cannot open %s\n", location);
		}
;
	}
	
	public static Texture create(String location) {
		if(textureAtlas.containsKey(location)) {
			return textureAtlas.get(location);
		}
		Texture t = new Texture(location);
		textureAtlas.put(location, t);
		return t;
	}
}