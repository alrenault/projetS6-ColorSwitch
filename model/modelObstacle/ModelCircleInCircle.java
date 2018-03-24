package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import model.game.Difficulty;

import java.util.List;
import java.util.Random;

/**
 * Modèle d'un Cercles imbriqués
 */
public class ModelCircleInCircle extends ModelObstacle {
	
    /**
     * Le nombre de versions différentes de cet obstacle
     */
    public static final int NBR_VERSIONS = 7;
    
    /**
     * La hauteur maximal des versions de l'obstacles
     */
    private static final double MAX_HEIGHT = 230;
    
    /**
     * Le tableau des versions faciles de l'obstacles
     */
    private static final int[] versionEasy = {4, 5};
    
    /**
     * Le tableau des versions normales de l'obstacles
     */
    private static final int[] versionMedium = {0, 1, 6};
    
    /**
     * Le tableau des versions difficiles de l'obstacles
     */
    private static final int[] versionHard = {2, 3};

    /**
     * Constructeur d'un modèle de cercles imbriqués
     * @param x Position en x du CircleInCIrcle
     * @param y Position en y du CircleInCircle
     * @param colors La liste des couleurs à utiliser
     * @param version La version de d'obstacle 
     * @param type Le type du modèle
     */
    public ModelCircleInCircle(double x, double y, List<Color> colors, int version, ObstacleType type) {
        super(x, y, colors, version, 4, type);

    }

    /**
     * Constructeur générant aléatoire une version d'un modèle de cercles imbriqués en fonction de la difficulté choisie
     * @param x Position en x du CircleInCIrcle
     * @param y Position en y du CircleInCircle
     * @param colors La liste des couleurs à utiliser
     * @param difficulty La difficulté de d'obstacle 
     * @param type Le type du modèle
     */
    public ModelCircleInCircle(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        switch (difficulty) {
            case EASY:
                version = ModelCircleInCircle.getRandomEasyVersion();
                break;
            case NORMAL:
                version = ModelCircleInCircle.getRandomMediumVersion();
                break;
            default:
                version = ModelCircleInCircle.getRandomHardVersion();
                break;
        }
    }

    /**
     * Accesseur d'une version facile aléatoire
     * @return Le numéro de la version facile
     */
    private static int getRandomEasyVersion() {
        Random r = new Random();
        return versionEasy[r.nextInt(versionEasy.length)];
    }

    /**
     * Accesseur d'une version normale aléatoire
     * @return Le numéro de la version normale
     */
    private static int getRandomMediumVersion() {
        Random r = new Random();
        return versionMedium[r.nextInt(versionMedium.length)];
    }

    /**
     * Accesseur d'une version difficile aléatoire
     * @return Le numéro de la version difficile
     */
    private static int getRandomHardVersion() {
        Random r = new Random();
        return versionHard[r.nextInt(versionHard.length)];
    }

    public double getObstacleHeight() {
        return MAX_HEIGHT;
    }


}
