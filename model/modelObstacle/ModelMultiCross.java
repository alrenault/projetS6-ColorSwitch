package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import view.game.Difficulty;

import java.util.List;
import java.util.Random;

/**
 * Modèle de multiple croix
 */
public class ModelMultiCross extends ModelObstacle {
	
	/**
     * Le nombre de versions différentes de cet obstacle
     */
    public static final int NBR_VERSIONS = 6;
    
    /**
     * La hauteur maximal des versions de l'obstacles
     */
    private static final double MAX_HEIGHT = 600;
    
    /**
     * Le tableau des versions faciles de l'obstacles
     */
    private static final int[] versionEasy = {0, 1};
    
    /**
     * Le tableau des versions normales de l'obstacles
     */
    private static final int[] versionMedium = {2, 5};
   
    /**
     * Le tableau des versions difficiles de l'obstacles
     */
    private static final int[] versionHard = {3, 4};

    /**
     * Constructeur d'une multiple croix
     * @param x Position en x du MultiCross
     * @param y Position en y du MultiCross
     * @param colors La liste des couleurs à utiliser
     * @param version La version de d'obstacle 
     * @param versionDefault La version par défaut du MultiCross
     * @param type Le type du modèle du MultiCross
     */
    public ModelMultiCross(double x, double y, List<Color> colors, int version, int versionDefault, ObstacleType type) {
        super(x, y, colors, version, versionDefault, type);
    }

    /**
     * Constructeur générant aléatoire une version d'un modèle de multiple croix en fonction de la difficulté choisie
     * @param x Position en x du MultiCross
     * @param y Position en y du MultiCross
     * @param colors La liste des couleurs à utiliser
     * @param difficulty La difficulté du MultiCross
     * @param type Le type du modèle
     */
    public ModelMultiCross(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        switch (difficulty) {
            case EASY:
                version = ModelMultiCross.getRandomEasyVersion();
                break;
            case NORMAL:
                version = ModelMultiCross.getRandomMediumVersion();
                break;
            default:
                version = ModelMultiCross.getRandomHardVersion();
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
