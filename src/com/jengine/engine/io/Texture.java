package com.jengine.engine.io;

import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

public class Texture {
	private static Map<String, Texture> textureAtlas = new HashMap<String, Texture>();
	
	public Image image;
	private Texture(String location) {
		this.image = new ImageIcon(location).getImage();
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