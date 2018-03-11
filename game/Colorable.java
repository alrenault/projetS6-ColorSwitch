package game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This interface propose to use already defined colors when building shapes
 */
public interface Colorable {
	Color BLACK = Color.rgb(39, 39, 39);
    Color YELLOW = Color.rgb(255, 255, 0);
    Color PURPLE = Color.rgb(144, 13, 255);
    Color ROSE = Color.rgb(255, 1, 129);
    Color BLUE = Color.rgb(50, 219, 240);
   // Set<Color> CUSTOM;
    
	/*public static default List<Color> custom(){
		List<Color> CUSTOM = new ArrayList<Color>();
		CUSTOM.add(YELLOW);
		CUSTOM.add(PURPLE);
		CUSTOM.add(ROSE);
		CUSTOM.add(BLUE);
		return CUSTOM;
	}*/
    

    Color[] WHITE = {Color.rgb(255, 255, 255)};
    Color[] CUSTOM = {YELLOW, PURPLE, ROSE, BLUE};
    Color[] NORMAL = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    Color[] HARD = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE};
    Color[] RANDOM_NORMAL = {
            new Color((new Random()).nextDouble(), (new Random()).nextDouble(), (new Random()).nextDouble(), 1),
            new Color((new Random()).nextDouble(), (new Random()).nextDouble(), (new Random()).nextDouble(), 1),
            new Color((new Random()).nextDouble(), (new Random()).nextDouble(), (new Random()).nextDouble(), 1),
            new Color((new Random()).nextDouble(), (new Random()).nextDouble(), (new Random()).nextDouble(), 1)};


    void verifPosColor();

    void color(Shape s);
}
