package model.modelObstacle;

import java.util.List;
import java.util.Random;

import game.Difficulty;
import game.path.obstacle.CircleInCircle;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class ModelMultiLine extends ModelObstacle {
	
	public static final int NBR_VERSIONS = 11;
    protected static int[] versionEasy = {0, 1, 4, 7};
    protected static int[] versionMedium = {2, 3, 5, 6, 8};
    protected static int[] versionHard = {9, 11};
    
    Scene scene;

    public ModelMultiLine(double x, double y, List<Color> colors, int version, Scene scene) {
        super(x, y, colors, version, 4);
        this.scene = scene;
    }

    public ModelMultiLine(double x, double y, List<Color> colors, Difficulty difficulty, Scene scene) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = getRandomMediumVersion();
        else
            version = getRandomHardVersion();

        this.scene = scene;
    }
    
    public ModelMultiLine(double x, double y, List<Color> colors, Difficulty difficulty) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = getRandomMediumVersion();
        else
            version = getRandomHardVersion();
        
        //obstacle = buildObstacle();
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
