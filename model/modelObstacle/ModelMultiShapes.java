package model.modelObstacle;

import java.util.List;
import java.util.Random;

import game.Difficulty;
import game.path.obstacle.CircleInCircle;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class ModelMultiShapes extends ModelObstacle {
	
	public static final int NBR_VERSIONS = 8;
    protected static int[] versionEasy = {4,6,7};
    protected static int[] versionMedium = {1, 2, 3, 5};
    protected static int[] versionHard = {0};
    
    double scWidth;

    public ModelMultiShapes(double x, double y, List<Color> colors, double scWidth, int version) {
        super(x, y, colors, version, 1);
        this.scWidth = scWidth;
    }

    public ModelMultiShapes(double x, double y, List<Color> colors, Difficulty difficulty, double scWidth) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiShapes.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiShapes.getRandomMediumVersion();
        else
            version = ModelMultiShapes.getRandomHardVersion();

        this.scWidth = scWidth;
    }

    public ModelMultiShapes(double x, double y, List<Color> colors, Difficulty difficulty) {
		super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiShapes.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiShapes.getRandomMediumVersion();
        else
            version = ModelMultiShapes.getRandomHardVersion();

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

	public double getScWidth() {
		return scWidth;
	}

	
}
