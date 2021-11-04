package Sandbox;

import java.awt.event.KeyEvent;

import com.jengine.engine.ecs.Component;
import com.jengine.engine.ecs.Entity;

import com.jengine.engine.io.Input;
import com.jengine.engine.math.Vector2;

public class Controller extends Component {

	public Controller(Entity e, Input i) {
		super(e, i);
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
		if (input.keyDown(KeyEvent.VK_A)) {
			this.entity.location = new Vector2(this.entity.location.x - 5, this.entity.location.y);
		}
		if (input.keyDown(KeyEvent.VK_D)) {
			this.entity.location = new Vector2(this.entity.location.x + 5, this.entity.location.y);
		}
		if (input.keyDown(KeyEvent.VK_W)) {
			this.entity.location = new Vector2(this.entity.location.x, this.entity.location.y - 5);
		}
		if (input.keyDown(KeyEvent.VK_S)) {
			this.entity.location = new Vector2(this.entity.location.x, this.entity.location.y + 5);
		}
	}

}
