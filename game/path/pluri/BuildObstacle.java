package game.path.pluri;

import game.Difficulty;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class BuildObstacle {

    public Obstacle BuildObstacleVersionAlea(int obs, Difficulty difficulty, double posX, double posY, Color[] colors, Scene scene) {
        Obstacle o;

        switch (obs) {
            case 0:
                o = new CircleInCircle(posX, posY, colors, difficulty);
                break;

            case 1:
                o = new MultiCircle(posX, posY, colors, difficulty);
                break;

            case 2:
                o = new MultiCross(posX, posY, colors, difficulty);
                break;

            case 3:
                o = new MultiLinee(posX, posY, colors, difficulty, scene);
                break;

            case 4:
                o = new MultiShapes(posX, posY, colors, difficulty, scene);
                break;

            case 5:
                o = new MultiSquare(posX, posY, colors, difficulty);
                break;

            default:
                o = new MultiCircle(posX, posY, colors, difficulty);
        }
        return o;
    }
}
