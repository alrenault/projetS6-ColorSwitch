package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import view.game.Difficulty;

import java.util.List;
import java.util.Random;

/**
 *
 */
public class ModelMultiCross extends ModelObstacle {
    /**
     *
     */
    public static final int NBR_VERSIONS = 6;
    /**
     *
     */
    private static final double MAX_HEIGHT = 600;
    /**
     *
     */
    private static final int[] versionEasy = {0, 1};
    /**
     *
     */
    private static final int[] versionMedium = {2, 5};
    /**
     *
     */
    private static final int[] versionHard = {3, 4};

    /**
     * @param x
     * @param y
     * @param colors
     * @param version
     * @param versionDefault
     * @param type
     */
    public ModelMultiCross(double x, double y, List<Color> colors, int version, int versionDefault, ObstacleType type) {
        super(x, y, colors, version, versionDefault, type);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param type
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
     * @return
     */
    private static int getRandomEasyVersion() {
        Random r = new Random();
        return versionEasy[r.nextInt(versionEasy.length)];
    }

    /**
     * @return
     */
    private static int getRandomMediumVersion() {
        Random r = new Random();
        return versionMedium[r.nextInt(versionMedium.length)];
    }

    /**
     * @return
     */
    private static int getRandomHardVersion() {
        Random r = new Random();
        return versionHard[r.nextInt(versionHard.length)];
    }

    /**
     * @return
     */
    public double getObstacleHeight() {
        return MAX_HEIGHT;
    }

}
