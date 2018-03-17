package game.path.obstacle;

import java.util.List;

import game.Difficulty;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import model.modelObstacle.*;

public class BuildObstacle {

    public static Obstacle VersionAlea(int obs, Difficulty difficulty, double posX, double posY, List<Color> colors, double scWidth) {
        ModelObstacle mo;
        Obstacle o;

        switch (obs) {
            case 0:
                mo = new ModelCircleInCircle(posX, posY, colors, difficulty);
                o = new CircleInCircle((ModelCircleInCircle)mo);
                break;

            case 1:
                mo = new ModelMultiCircle(posX, posY, colors, difficulty);
                o = new MultiCircle((ModelMultiCircle)mo);
                break;

            case 2:
                mo = new ModelMultiCross(posX, posY, colors, difficulty);
                o = new MultiCross((ModelMultiCross)mo);
                break;

            case 3:
                mo = new ModelMultiLine(posX, posY, colors, difficulty, scWidth);
                o = new MultiLinee((ModelMultiLine)mo);
                break;

            case 4:
                mo = new ModelMultiShapes(posX, posY, colors, difficulty, scWidth);
                o = new MultiShapes((ModelMultiShapes)mo);
                break;

            case 5:
                mo = new ModelMultiSquare(posX, posY, colors, difficulty);
                o = new MultiSquare((ModelMultiSquare)mo);
                break;

            default:
                mo = new ModelMultiCircle(posX, posY, colors, difficulty);
                o = new MultiCircle((ModelMultiCircle)mo);
        }
        
        return o;
    }
    
    /*public static Obstacle VersionAlea(int obs, Difficulty difficulty, double posX, double posY, List<Color> colors) {
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
    }*/
}
