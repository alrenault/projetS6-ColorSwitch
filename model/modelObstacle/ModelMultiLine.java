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
    protected static int[] versionHard = {9, 10};
    
    double scWidth;

    public ModelMultiLine(double x, double y, List<Color> colors, int version, double scWidth) {
        super(x, y, colors, version, 4);
        
        this.scWidth = scWidth;
    }

    public ModelMultiLine(double x, double y, List<Color> colors, Difficulty difficulty, double scWidth) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiLine.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiLine.getRandomMediumVersion();
        else
            version = ModelMultiLine.getRandomHardVersion();

        this.scWidth = scWidth;
    }
    
    public ModelMultiLine(double x, double y, List<Color> colors, Difficulty difficulty) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = ModelMultiLine.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = ModelMultiLine.getRandomMediumVersion();
        else
            version = ModelMultiLine.getRandomHardVersion();
        
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

	public double getScWidth() {
		return scWidth;
	}


	
    
    

}
