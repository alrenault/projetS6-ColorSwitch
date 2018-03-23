package model.modelObstacle;

import java.util.List;
import java.util.Random;

import view.game.Difficulty;
import javafx.scene.paint.Color;
import model.ObstacleType;

public class ModelMultiSquare extends ModelObstacle {
    /**
     *
     */
    public static final int NBR_VERSIONS = 5;
    /**
     *
     */
	private static final double MAX_HEIGHT = 300;
    /**
     *
     */
    private static final int[] versionEasy = {2, 3};
    /**
     *
     */
    private static final int[] versionMedium = {0, 1};
    /**
     *
     */
    private static final int[] versionHard = {4};

    /**
     *
     * @param x
     * @param y
     * @param colors
     * @param version
     * @param type
     */
    public ModelMultiSquare(double x, double y, List<Color> colors, int version, ObstacleType type) {
        super(x, y, colors, version, 2, type);
    }

    /**
     *
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param type
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
     *
     * @return
     */
    private static int getRandomEasyVersion() {
        Random r = new Random();
        return versionEasy[r.nextInt(versionEasy.length)];
    }

    /**
     *
     * @return
     */
    private static int getRandomMediumVersion() {
        Random r = new Random();
        return versionMedium[r.nextInt(versionMedium.length)];
    }

    /**
     *
     * @return
     */
    private static int getRandomHardVersion() {
        Random r = new Random();
        return versionHard[r.nextInt(versionHard.length)];
    }

    /**
     *
     * @return
     */
    public double getObstacleHeight() {
		return MAX_HEIGHT;
	}
    

}
