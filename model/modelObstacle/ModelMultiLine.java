package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import view.game.Difficulty;

import java.util.List;
import java.util.Random;

/**
 *
 */
public class ModelMultiLine extends ModelObstacle {
    /**
     *
     */
    public static final int NBR_VERSIONS = 11;
    /**
     *
     */
    private static final double MAX_HEIGHT = 220;
    /**
     *
     */
    private static final int[] versionEasy = {0, 1, 4, 7};
    /**
     *
     */
    private static final int[] versionMedium = {2, 3, 5, 6, 8};
    /**
     *
     */
    private static final int[] versionHard = {9, 10};
    /**
     *
     */
    private double scWidth;

    /**
     * @param x
     * @param y
     * @param colors
     * @param version
     * @param scWidth
     * @param type
     */
    public ModelMultiLine(double x, double y, List<Color> colors, int version, double scWidth, ObstacleType type) {
        super(x, y, colors, version, 4, type);

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
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param type
     */
    public ModelMultiLine(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
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

        //obstacle = buildObstacle();
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
