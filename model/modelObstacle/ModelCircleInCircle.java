package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import view.game.Difficulty;

import java.util.List;
import java.util.Random;

/**
 *
 */
public class ModelCircleInCircle extends ModelObstacle {
    /**
     *
     */
    public static final int NBR_VERSIONS = 7;
    /**
     *
     */
    private static final double MAX_HEIGHT = 230;
    /**
     *
     */
    private static final int[] versionEasy = {4, 5};
    /**
     *
     */
    private static final int[] versionMedium = {0, 1, 6};
    /**
     *
     */
    private static final int[] versionHard = {2, 3};

    /**
     * @param x
     * @param y
     * @param colors
     * @param version
     * @param type
     */
    public ModelCircleInCircle(double x, double y, List<Color> colors, int version, ObstacleType type) {
        super(x, y, colors, version, 4, type);

    }

    /**
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param type
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
