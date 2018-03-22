package model.modelObstacle;

import java.util.List;
import java.util.Random;

import view.game.Difficulty;
import view.game.path.obstacle.CircleInCircle;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import model.ObstacleType;

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
	public static final double MAX_HEIGHT = 500;
    /**
     *
     */
    protected static int[] versionEasy = {4,6,7};
    /**
     *
     */
    protected static int[] versionMedium = {1, 2, 3, 5};
    /**
     *
     */
    protected static int[] versionHard = {0};
    /**
     *
     */
    double scWidth;

    /**
     *
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
     *
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param scWidth
     * @param type
     */
    public ModelMultiShapes(double x, double y, List<Color> colors, Difficulty difficulty, double scWidth, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiShapes.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiShapes.getRandomMediumVersion();
        else
            version = ModelMultiShapes.getRandomHardVersion();

        this.scWidth = scWidth;
    }

    /**
     *
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param type
     */
    public ModelMultiShapes(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
		super(x, y, colors, 0, 4, type);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiShapes.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiShapes.getRandomMediumVersion();
        else
            version = ModelMultiShapes.getRandomHardVersion();

	}

    /**
     *
     * @return
     */
    public static int getRandomEasyVersion() {
        Random r = new Random();
        return versionEasy[r.nextInt(versionEasy.length)];
    }

    /**
     *
     * @return
     */
    public static int getRandomMediumVersion() {
        Random r = new Random();
        return versionMedium[r.nextInt(versionMedium.length)];
    }

    /**
     *
     * @return
     */
    public static int getRandomHardVersion() {
        Random r = new Random();
        return versionHard[r.nextInt(versionHard.length)];
    }

    /**
     *
     * @return
     */
	public double getScWidth() {
		return scWidth;
	}

    /**
     *
     * @return
     */
	public double getObstacleHeight() {
		return MAX_HEIGHT;
	}
	
}
