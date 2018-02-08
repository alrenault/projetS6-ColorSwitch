package game;

import javafx.scene.paint.Color;

import java.util.Random;

/**
 * This interface propose to use already defined colors when building shapes
 */
public interface Colorable {
	Color[] normal = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
	Color[] hard = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE};
	Color[] randomNormal = {
			new Color((new Random()).nextDouble(), (new Random()).nextDouble(), (new Random()).nextDouble(), 1),
			new Color((new Random()).nextDouble(), (new Random()).nextDouble(), (new Random()).nextDouble(), 1),
			new Color((new Random()).nextDouble(), (new Random()).nextDouble(), (new Random()).nextDouble(), 1),
			new Color((new Random()).nextDouble(), (new Random()).nextDouble(), (new Random()).nextDouble(), 1)};
	
	Color BLACK = Color.rgb(39,39,39);
	Color YELLOW = Color.rgb(255,255,0);
	Color PURPLE = Color.rgb(144,13,255);
	Color ROSE = Color.rgb(255,1,129);
	Color BLUE = Color.rgb(50,219,240);
	Color[] WHITE = {Color.rgb(255, 255, 255)};
	
	Color[] CUSTOM = {YELLOW,PURPLE,ROSE,BLUE};


	//public void color(Node n);


}
