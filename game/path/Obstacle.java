package game.path;
import java.util.List;
import java.util.Random;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;


public class Obstacle implements Colorable {
	protected Group obstacle;
	protected int x;
	protected int y;
	protected Color colors[];
	protected int version;
	
	
	public Obstacle(int x, int y,Color[] colors, int version){
		this.x = x;
		this.y = y;
		this.colors = colors;
		this.version = version;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Group getObstacle(){
		return obstacle;
	}
}
