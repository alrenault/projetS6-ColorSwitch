package game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javafx.scene.paint.Color;
import javafx.scene.Node;


public interface Colorable {
	Color[] normal = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW};
	Color[] hard = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.MAGENTA,Color.ORANGE};
	Color[] randomNormal = {
			new Color((new Random()).nextDouble(),(new Random()).nextDouble(),(new Random()).nextDouble(),1),
			new Color((new Random()).nextDouble(),(new Random()).nextDouble(),(new Random()).nextDouble(),1),
			new Color((new Random()).nextDouble(),(new Random()).nextDouble(),(new Random()).nextDouble(),1),
			new Color((new Random()).nextDouble(),(new Random()).nextDouble(),(new Random()).nextDouble(),1)};
	
	public void color(Node n);
	


}
