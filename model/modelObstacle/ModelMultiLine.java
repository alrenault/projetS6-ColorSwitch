package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import view.game.Difficulty;

import java.util.List;
import java.util.Random;

/**
 * Modèle de multiple ligne
 */
public class ModelMultiLine extends ModelObstacle {
	
	/**
     * Le nombre de versions différentes de cet obstacle
     */
    public static final int NBR_VERSIONS = 11;
    
    /**
     * La hauteur maximal des versions de l'obstacles
     */
    private static final double MAX_HEIGHT = 220;
    
    /**
     * Le tableau des versions faciles de l'obstacles
     */
    private static final int[] versionEasy = {0, 1, 4, 7};
    
    /**
     * Le tableau des versions normales de l'obstacles
     */
    private static final int[] versionMedium = {2, 3, 5, 6, 8};
    
    /**
     * Le tableau des versions difficiles de l'obstacles
     */
    private static final int[] versionHard = {9, 10};
    
    /**
     * La largeur de la scène
     */
    private double scWidth;

    /**
     * Constructeur d'une multiple ligne
     * @param x Position en x du MultiLine
     * @param y Position en y du MultiLine
     * @param colors La liste des couleurs à utiliser
     * @param version La version de d'obstacle 
     * @param type Le type du modèle du MultiLine
     */
    public ModelMultiLine(double x, double y, List<Color> colors, int version, double scWidth, ObstacleType type) {
        super(x, y, colors, version, 4, type);

        this.scWidth = scWidth;
    }

    /**
     * Constructeur générant aléatoire une version d'un modèle de multiple ligne en fonction de la difficulté choisie
     * @param x Position en x du MultiLine
     * @param y Position en y du MultiLine
     * @param colors La liste des couleurs à utiliser
     * @param difficulty La difficulté du MultiLine
     * @param type Le type du modèle
     */
    public ModelMultiLine(double x, double y, List<Color> colors, Difficulty difficulty, double scWidth, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        switch (difficulty) {
            case EASY:
                version = ModelMultiLine.getRandomEasyVersion();
                break;
            case NORMAL:
                version = ModelMultiLine.getRandomMediumVersion();
                break;
            default:
                version = ModelMultiLine.getRandomHardVersion();
                break;
        }

        this.scWidth = scWidth;
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

    /**
     * Accesseir de la largeur de la scene
     * @return De la largeur de la scene
     */
    public double getScWidth() {
        return scWidth;
    }

    public double getObstacleHeight() {
        return MAX_HEIGHT;
    }


}
