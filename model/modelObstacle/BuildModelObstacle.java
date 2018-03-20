package model.modelObstacle;

import java.util.List;

import game.Difficulty;
import game.path.obstacle.CircleInCircle;
import game.path.obstacle.MultiCircle;
import game.path.obstacle.MultiCross;
import game.path.obstacle.MultiLinee;
import game.path.obstacle.MultiShapes;
import game.path.obstacle.MultiSquare;
import game.path.obstacle.Obstacle;
import javafx.scene.paint.Color;
import model.ObstacleType;

/**
 *
 */
public class BuildModelObstacle {

    /**
     *
     * @param obs
     * @param difficulty
     * @param posX
     * @param posY
     * @param colors
     * @param scWidth
     * @return
     */
	public static ModelObstacle build(int obs, Difficulty difficulty, double posX, double posY, List<Color> colors, double scWidth) {
        ModelObstacle mo;
        ObstacleType type = ObstacleType.getEnum(obs);

        switch (type) {
            case CircleInCircle:
                mo = new ModelCircleInCircle(posX, posY, colors, difficulty, type);
                break;

            case MultiCircle:
                mo = new ModelMultiCircle(posX, posY, colors, difficulty, type);
                break;

            case MultiCross:
                mo = new ModelMultiCross(posX, posY, colors, difficulty, type);
                break;

            case MultiLine:
                mo = new ModelMultiLine(posX, posY, colors, difficulty, scWidth, type);
                break;

            case MultiShapes:
                mo = new ModelMultiShapes(posX, posY, colors, difficulty, scWidth, type);
                break;

            case MultiSquare:
                mo = new ModelMultiSquare(posX, posY, colors, difficulty, type);
                break;

            default:
                mo = new ModelMultiCircle(posX, posY, colors, difficulty, type);
        }
        
        System.out.println(mo.getBcs());
        
        return mo;
    }
}
