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
public class ModelMultiLine extends ModelObstacle {
    /**
     *
     */
	public static final int NBR_VERSIONS = 11;
    /**
     *
     */
	public static final double MAX_HEIGHT = 220;
    /**
     *
     */
    protected static int[] versionEasy = {0, 1, 4, 7};
    /**
     *
     */
    protected static int[] versionMedium = {2, 3, 5, 6, 8};
    /**
     *
     */
    protected static int[] versionHard = {9, 10};
    /**
     *
     */
    double scWidth;

    /**
     *
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
     *
     * @param x
     * @param y
     * @param colors
     * @param difficulty
     * @param scWidth
     * @param type
     */
    public ModelMultiLine(double x, double y, List<Color> colors, Difficulty difficulty, double scWidth, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiLine.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiLine.getRandomMediumVersion();
        else
            version = ModelMultiLine.getRandomHardVersion();

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
    public ModelMultiLine(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiLine.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiLine.getRandomMediumVersion();
        else
            version = ModelMultiLine.getRandomHardVersion();
        
        //obstacle = buildObstacle();
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
