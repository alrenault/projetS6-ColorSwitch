package model.modelObstacle;

import java.util.List;
import java.util.Random;

import view.game.Difficulty;
import javafx.scene.paint.Color;
import model.ObstacleType;

/**
 *
 */
public class ModelMultiCircle extends ModelObstacle {
	/**
	 *
	 */
	public static final int NBR_VERSIONS = 11;
	/**
	 *
	 */
	public static final double MAX_HEIGHT = 690;
	/**
	 *
	 */
    protected static int[] versionEasy = {0, 1, 7, 8, 9, 10};
	/**
	 *
	 */
	protected static int[] versionMedium = {2, 5, 6};
	/**
	 *
	 */
    protected static int[] versionHard = {3, 4};

	/**
	 *
	 * @param x
	 * @param y
	 * @param colors
	 * @param version
	 * @param versionDefault
	 * @param type
	 */
	public ModelMultiCircle(double x, double y, List<Color> colors, int version, int versionDefault, ObstacleType type) {
		super(x, y, colors, version, versionDefault, type);
	}

	/**
	 *
	 * @param x
	 * @param y
	 * @param colors
	 * @param difficulty
	 * @param type
	 */
	public ModelMultiCircle(double x, double y, List<Color> colors, Difficulty difficulty, ObstacleType type) {
        super(x, y, colors, 0, 4, type);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiCircle.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiCircle.getRandomMediumVersion();
        else{
            version = ModelMultiCircle.getRandomHardVersion();
        }
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
