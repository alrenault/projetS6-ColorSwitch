package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import model.game.Difficulty;

import java.util.List;
import java.util.Random;

/**
 * Modèle de multiple carrés
*/
public class ModelMultiSquare extends ModelObstacle {
    
	/**
     * Le nombre de versions différentes de cet obstacle
     */
    public static final int NBR_VERSIONS = 5;
   
    /**
     * La hauteur maximal des versions de l'obstacles
     */
    private static final double MAX_HEIGHT = 300;
    
    /**
     * Le tableau des versions faciles de l'obstacles
     */
    private static final int[] versionEasy = {2, 3};
    
    /**
     * Le tableau des versions normales de l'obstacles
     */
    private static final int[] versionMedium = {0, 1};
   
    /**
     * Le tableau des versions difficiles de l'obstacles
     */
    private static final int[] versionHard = {4};

    /**
     * Constructeur d'une multiple formes
     * @param x Position en x du MultiSquare
     * @param y Position en y du MultiSquare
     * @param colors La liste des couleurs à utiliser
     * @param version La version de d'obstacle 
     * @param type Le type du modèle du MultiSquare
     */
    public ModelMultiSquare(double x, double y, List<Color> colors, int version, ObstacleType type) {
        super(x, y, colors, version, 2, type);
    }

    /**
     * Constructeur générant aléatoire une version d'un modèle de multiple carrés en fonction de la difficulté choisie
     * @param x Position en x du MultiSquare
     * @param y Position en y du MultiSquare
     * @param colors La liste des couleurs à utiliser
     * @param difficulty La difficulté du MultiSquare
     * @param type Le type du modèle
     */
    public ModelMultiSquare(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        switch (difficulty) {
            case EASY:
                version = ModelMultiSquare.getRandomEasyVersion();
                break;
            case NORMAL:
                version = ModelMultiSquare.getRandomMediumVersion();
                break;
            default:
                version = ModelMultiSquare.getRandomHardVersion();
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
