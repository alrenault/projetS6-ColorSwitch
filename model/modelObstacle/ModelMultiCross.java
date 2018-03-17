package model.modelObstacle;

import java.util.List;
import java.util.Random;

import game.Difficulty;
import game.path.obstacle.CircleInCircle;
import javafx.scene.paint.Color;

public class ModelMultiCross extends ModelObstacle {
	
    public static final int NBR_VERSIONS = 6;
    protected static int[] versionEasy = {0, 1};
    protected static int[] versionMedium = {2, 5};
    protected static int[] versionHard = {3,4};

	public ModelMultiCross(double x, double y, List<Color> colors, int version, int versionDefault) {
		super(x, y, colors, version, versionDefault);
		// TODO Auto-generated constructor stub
	}
	
    public ModelMultiCross(double x, double y, List<Color> colors, Difficulty difficulty) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiCross.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiCross.getRandomMediumVersion();
        else
            version = ModelMultiCross.getRandomHardVersion();
    }
	
	public static int getRandomEasyVersion() {
        Random r = new Random();
        return versionEasy[r.nextInt(versionEasy.length)];
    }

    public static int getRandomMediumVersion() {
        Random r = new Random();
        return versionMedium[r.nextInt(versionMedium.length)];
    }

    public static int getRandomHardVersion() {
        Random r = new Random();
        return versionHard[r.nextInt(versionHard.length)];
    }


}
