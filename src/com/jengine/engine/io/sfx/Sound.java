package com.jengine.engine.io.sfx;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;


public class Sound{
	private String location;

	public Clip clip;

	public Sound(String location)  {
		super();
		this.location = location;

		
		open();
	}
	
	private void open()  {
		AudioInputStream audioInputStream;
		
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(location).getAbsoluteFile());
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				clip.open(audioInputStream);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException | IOException e2) {
			e2.printStackTrace();
			System.exit(-1);
		}

		// create clip reference
		// open audioInputStream to the clip
	}
	
	public void playLoop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
	}

	public void play() {
		open();
		clip.start();
	}
}
