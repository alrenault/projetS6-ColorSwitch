package model.modelObstacle;

import java.util.List;
import java.util.Random;

import game.Difficulty;
import javafx.scene.paint.Color;

public class ModelCircleInCircle extends ModelObstacle {
	
	public static final int NBR_VERSIONS = 7;
    protected static int[] versionEasy = {4, 5};
    protected static int[] versionMedium = {0, 1, 6};
    protected static int[] versionHard = {2, 3};

    public ModelCircleInCircle(double x, double y, List<Color> colors, int version){
    	super(x, y,  colors, version, 4);
    }
    
    public ModelCircleInCircle(double x, double y, List<Color> colors, Difficulty difficulty) {
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
}
