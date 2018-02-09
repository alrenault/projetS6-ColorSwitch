package game;

import javafx.scene.paint.Color;

/**
 * This interface propose to use already defined colors when building shapes
 */
public interface Colorable {

    Color BLACK = Color.rgb(39, 39, 39);
    Color YELLOW = Color.rgb(255, 255, 0);
    Color PURPLE = Color.rgb(144, 13, 255);
    Color ROSE = Color.rgb(255, 1, 129);
    Color BLUE = Color.rgb(50, 219, 240);


    Color[] WHITE = {Color.rgb(255, 255, 255)};

    Color[] CUSTOM = {YELLOW, PURPLE, ROSE, BLUE};


    //public void color(Node n);


}
