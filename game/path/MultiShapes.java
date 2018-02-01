package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;


public class MultiShapes extends Obstacle {
	/*
	 version 0 : 
	 version 1 :
	 version 2 :
	 version 3 :
	 version 4 :
	 version 5 :
	 */

    public MultiShapes(double x, double y, Color[] colors, int version) {
        super(x, y, colors, version);
        obstacle = buildObstacle();
    }

    public Group buildObstacle() {
        Group multiShapes = new Group();

        double length = 100.0;
        double tinyRadial = 40.0;
        double mediumRadial = 70.0;
        double internRadial = 85.0;
        double bigRadial = 100.0;
        double width = 15.0;
        int nb_arc = 4;
        int nbr_versions = 6;

        switch (version) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

        return multiShapes;
    }
}
