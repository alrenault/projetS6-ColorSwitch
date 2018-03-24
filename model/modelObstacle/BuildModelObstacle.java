package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import model.game.Difficulty;

import java.util.List;

/**
 * Générateur de Modeles d'obstacles
 */
public class BuildModelObstacle {

    /**
     * @param obs        Represente le type d'Obstacle à générer
     * @param difficulty La difficulté de l'Obstacle
     * @param posX       La posiion en x de l'Obstacle à générer
     * @param posY       La posiion en y de l'Obstacle à générer
     * @param colors     La liste des couleurs de l'Obstacle à générer
     * @param scWidth    La largeur de la fenêtre
     * @return un Model d'Obstacle corespondant au paramètres
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


        return mo;
    }
}
