package game.path;
import java.util.List;
import java.util.Random;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;


public class Obstacle implements Colorable {
	protected Group obstacle;
	protected int centre_x;
	protected int centre_y;
	protected Color colors[];
	
	
	public Obstacle(int x, int y,Color[] colors){
		centre_x = x;
		centre_y = y;
		this.colors = colors;
	}
	
	public int getX() {
		return centre_x;
	}

	public int getY() {
		return centre_y;
	}

	public Group getShape() {
		return obstacle;
	}
}
