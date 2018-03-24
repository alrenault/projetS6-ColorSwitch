package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import model.game.Difficulty;

import java.util.List;
import java.util.Random;

/**
 * Modèle de multiple cercles
 */
public class ModelMultiCircle extends ModelObstacle {
	
	/**
     * Le nombre de versions différentes de cet obstacle
     */
    public static final int NBR_VERSIONS = 11;
    
    /**
     * La hauteur maximal des versions de l'obstacles
     */
    private static final double MAX_HEIGHT = 690;
    
    /**
     * Le tableau des versions faciles de l'obstacles
     */
    private static final int[] versionEasy = {0, 1, 7, 8, 9, 10};
    
    /**
     * Le tableau des versions normales de l'obstacles
     */
    private static final int[] versionMedium = {2, 5, 6};
    
    /**
     * Le tableau des versions difficiles de l'obstacles
     */
    private static final int[] versionHard = {3, 4};

    /**
     * Constructeur d'un multiple cercles
     * @param x Position en x du MultiCircle
     * @param y Position en y du MultiCircle
     * @param colors La liste des couleurs à utiliser
     * @param version La version de d'obstacle 
     * @param versionDefault La version par défaut du MultiCircle
     * @param type Le type du modèle du MultiCircle
     */
    public ModelMultiCircle(double x, double y, List<Color> colors, int version, int versionDefault, ObstacleType type) {
        super(x, y, colors, version, versionDefault, type);
    }

    /**
     * Constructeur générant aléatoire une version d'un modèle de multiple cercle en fonction de la difficulté choisie
     * @param x Position en x du MultiCircle
     * @param y Position en y du MultiCircle
     * @param colors La liste des couleurs à utiliser
     * @param difficulty La difficulté du MultiCircle
     * @param type Le type du modèle
     */
    public ModelMultiCircle(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        switch (difficulty) {
            case EASY:
                version = ModelMultiCircle.getRandomEasyVersion();
                break;
            case NORMAL:
                version = ModelMultiCircle.getRandomMediumVersion();
                break;
            default:
                version = ModelMultiCircle.getRandomHardVersion();
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
