package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import view.game.Difficulty;

import java.util.List;
import java.util.Random;

/**
 *
 */
public class ModelMultiShapes extends ModelObstacle {
    /**
     *
     */
    public static final int NBR_VERSIONS = 8;
    /**
     *
     */
    private static final double MAX_HEIGHT = 500;
    /**
     *
     */
    private static final int[] versionEasy = {4, 6, 7};
    /**
     *
     */
    private static final int[] versionMedium = {1, 2, 3, 5};
    /**
     *
     */
    private static final int[] versionHard = {0};
    /**
     *
     */
    private double scWidth;

    /**
     * @param x
     * @param y
     * @param colors
     * @param scWidth
     * @param version
     * @param type
     */
    public ModelMultiShapes(double x, double y, List<Color> colors, double scWidth, int version, ObstacleType type) {
        super(x, y, colors, version, 1, type);
        this.scWidth = scWidth;
    }

    /**
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param scWidth
     * @param type
     */
    public ModelMultiShapes(double x, double y, List<Color> colors, Difficulty difficulty, double scWidth, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        switch (difficulty) {
            case EASY:
                version = ModelMultiShapes.getRandomEasyVersion();
                break;
            case NORMAL:
                version = ModelMultiShapes.getRandomMediumVersion();
                break;
            default:
                version = ModelMultiShapes.getRandomHardVersion();
                break;
        }

        this.scWidth = scWidth;
    }

    /**
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param type
     */
    public ModelMultiShapes(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        switch (difficulty) {
            case EASY:
                version = ModelMultiShapes.getRandomEasyVersion();
                break;
            case NORMAL:
                version = ModelMultiShapes.getRandomMediumVersion();
                break;
            default:
                version = ModelMultiShapes.getRandomHardVersion();
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
    public double getScWidth() {
        return scWidth;
    }

    /**
     * @return
     */
    public double getObstacleHeight() {
        return MAX_HEIGHT;
    }

}
