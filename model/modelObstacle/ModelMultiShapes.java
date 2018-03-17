package model.modelObstacle;

import java.util.List;
import java.util.Random;

import game.Difficulty;
import game.path.obstacle.CircleInCircle;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class ModelMultiShapes extends ModelObstacle {
	
	public static final int NBR_VERSIONS = 6;
    protected static int[] versionEasy = {4};
    protected static int[] versionMedium = {1, 2, 3, 5};
    protected static int[] versionHard = {0};
    Scene scene;

    public ModelMultiShapes(double x, double y, List<Color> colors, Scene scene, int version) {
        super(x, y, colors, version, 1);
        this.scene = scene;
    }

    public ModelMultiShapes(double x, double y, List<Color> colors, Difficulty difficulty, Scene scene) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = getRandomMediumVersion();
        else
            version = getRandomHardVersion();

        this.scene = scene;
    }

    public ModelMultiShapes(double x, double y, List<Color> colors, Difficulty difficulty) {
		super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = getRandomMediumVersion();
        else
            version = getRandomHardVersion();

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

	public Scene getScene() {
		return scene;
	}
}
