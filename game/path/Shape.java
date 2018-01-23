package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Shape implements Touchable {
	int x;
	int y;
	int width;
	Group shape;

	Shape(int _x, int _y, int _width) {

		this.x = _x;
		this.y = _y;
		this.width = _width;
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	Color coloRand() {
		Random r =new Random();
		return new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1);
	}

	public Group getShape() {
		return shape;
	}
}
