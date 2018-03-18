package model.modelObstacle;

import java.util.List;
import java.util.Random;

import game.Difficulty;
import javafx.scene.paint.Color;
import model.ObstacleType;

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
	public static final double MAX_HEIGHT = 230;
    /**
     *
     */
    protected static int[] versionEasy = {4, 5};
    /**
     *
     */
    protected static int[] versionMedium = {0, 1, 6};
    /**
     *
     */
    protected static int[] versionHard = {2, 3};

    /**
     *
     * @param x
     * @param y
     * @param colors
     * @param version
     * @param type
     */
    public ModelCircleInCircle(double x, double y, List<Color> colors, int version, ObstacleType type){
    	super(x, y,  colors, version, 4, type);
    }

    /**
     *
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param type
     */
    public ModelCircleInCircle(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        if (difficulty == Difficulty.EASY)
            version = ModelCircleInCircle.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelCircleInCircle.getRandomMediumVersion();
        else
            version = ModelCircleInCircle.getRandomHardVersion();
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
    public double getObstacleHeight() {
		return MAX_HEIGHT;
	}

    
    
}
