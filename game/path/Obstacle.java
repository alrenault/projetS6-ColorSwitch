package game.path;
import java.util.List;
import game.Colorable;


public class Obstacle implements Colorable {
	List<Shape> shapes;
	protected int centre_x;
	protected int centre_y;
	
	
	public Obstacle(int x, int y){
		centre_x = x;
		centre_y = y;
	}
}
