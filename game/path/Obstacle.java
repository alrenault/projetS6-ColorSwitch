package game.path;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;


public class Obstacle implements Colorable {
	protected enum ensDifficulty{EASY,NORMAL,HARD};
	protected Group obstacle;
	protected int x;
	protected int y;
	protected Color colors[];
	protected int version;
	protected ensDifficulty difficulty;
	
	
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
	
	public ensDifficulty getDifficulty(){
		return difficulty;
	}
	public boolean isOver(int x, int y) {
		return this.obstacle.contains(x,y);
	}
}
