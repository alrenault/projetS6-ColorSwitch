package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Shape extends Movement implements Touchable {
	int x;
	int y;
	int width;
	Group shape;

	Shape(int x, int y, int width, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed) {
		super(mouvementDirection, acceleration, _mouvementSpeed);
		this.x = x;
		this.y = y;
		this.width = width;
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
