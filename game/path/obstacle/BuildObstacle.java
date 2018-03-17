package game.path.obstacle;

import java.util.List;

import game.Difficulty;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class BuildObstacle {

    public static Obstacle VersionAlea(int obs, Difficulty difficulty, double posX, double posY, List<Color> colors, Scene scene) {
        Obstacle o;

        System.out.println("Builder");
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
    
    public static Obstacle VersionAlea(int obs, Difficulty difficulty, double posX, double posY, List<Color> colors) {
        Obstacle o;

        System.out.println("Builder");
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
                o = new MultiLinee(posX, posY, colors, difficulty);
                break;

            case 4:
                o = new MultiShapes(posX, posY, colors, difficulty);
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
