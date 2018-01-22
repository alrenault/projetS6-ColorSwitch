package game.path;

import java.util.Random;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public abstract class Shape {
	protected int x;
	protected int y;
	protected int width;
	protected Group shape;
	public Shape(int x, int y, int width) {
		
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	public abstract boolean isOver(int x, int y);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public Color coloRand() {
		Random r =new Random();
		return new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1);
	}

	public Group getShape() {
		return shape;
	}
}
