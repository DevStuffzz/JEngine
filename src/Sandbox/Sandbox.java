package Sandbox;

// Import the required libraries

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import com.jengine.engine.io.*;
import com.jengine.engine.ecs.*;
import com.jengine.engine.math.*;

// Sanbox Class for testing implimentations of the engine
public class Sandbox implements Runnable {
	// Create the IO
	Display display;
	Canvas canvas;
	Input io;

	// Create the test entity
	Entity testEntity;
	// The image for the entity
	Image img;

	public static void main(String[] args) throws InterruptedException {
		// Initialize a thread that we can stop whenever we want.
		Thread game = new Thread(new Sandbox());
		// Run the thread (Sandbox.run())
		game.run();
		// Stop the game thread
		game.join();
	}


	// This will be called when we run the game thread
	@Override
	public void run() {
		// Initialize the IO objects that we created above
		display = new Display(600, 600, "Display");
		canvas = new Canvas();
		io = new Input();

		// Initialize the objects that we need for our Entity
		img = new ImageIcon("src/Sandbox/random.jpg").getImage();
		testEntity = new Entity(new Vector2(300, 300), 100, 100, img);

		// Add our entity to the canvas
		canvas.addEntity(testEntity);

		// Add the rest of the IO to the display
		display.add(canvas);
		display.addKeyListener(io);
		display.pack();

		testEntity.add(new Controller(testEntity, io));

		// Render the frame before the loop to stop rendering bugs
		canvas.render();

		testEntity.start();

		boolean running = true;
		double last = System.currentTimeMillis();
		while (running) {
			// Avoid triple rendering by sleeping for 100 miliseconds
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


			testEntity.update();

			// Code for the delta time variable
			double now = System.currentTimeMillis();
			double delta = (now - last) / 100;
			last = System.currentTimeMillis();

			// Gather the input
			io.poll();

			// Render
			canvas.render();

		}
		testEntity.stop();
	}
}
