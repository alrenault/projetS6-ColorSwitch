package game.path.obstacle;

import game.Difficulty;
import game.path.shapes.Cross;
import game.path.shapes.Shapes.Speed;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.Random;

public class MultiCross extends Obstacle {
	/*
	version 0 : Une croix décalée vers la droite
	version 1 : Une croix décalée vers la gauche
	version 2 : Deux croix tournant vers le bas
	version 3 : Deux croix tournant vers le haut
	version 4 : 
	*/

    public static final int NBR_VERSIONS = 4;
    protected static int[] versionEasy = {0, 1};
    protected static int[] versionMedium = {2, 3};
    protected static int[] versionHard = {4};

    public MultiCross(double x, double y, Color[] colors, int version) {
        super(x, y, colors, version, 0);
        obstacle = buildObstacle();
    }

    public MultiCross(double x, double y, Color[] colors, Difficulty difficulty) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = CircleInCircle.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = CircleInCircle.getRandomMediumVersion();
        else
            version = CircleInCircle.getRandomHardVersion();
        obstacle = buildObstacle();
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

    private Group buildObstacle() {
        Group multiCross = new Group();
        double length = 100.0;
        double width = 15.0;


		/*public Cross(int x, int y, int width, int length, boolean mouvementDirection, boolean acceleration,
			int _mouvementSpeed, int nbr_rect,Color[] colors,int pos_color)*/

        Cross cr1;
        Cross cr2;

        if (version >= NBR_VERSIONS)
            version = versionDefault;

        switch (version) {
            case 0:
                cr1 = new Cross(x + length / 2, y, length, width, true, false, Speed.SYMPA, 4, colors, 0);
                multiCross.getChildren().add(cr1.getShape());
                difficulty = Difficulty.EASY;
                break;
            case 1:
                cr1 = new Cross(x - length / 2, y, length, width, true, false, Speed.SYMPA, 4, colors, 0);
                multiCross.getChildren().add(cr1.getShape());
                difficulty = Difficulty.EASY;
                break;
            case 2:
                cr1 = new Cross(x + length + width / 2, y, length, width, true, false, Speed.MOYEN, 4, colors, 0);
                cr2 = new Cross(x - length - width / 2, y, length, width, true, false, Speed.MOYEN, 4, colors, 2);

                multiCross.getChildren().add(cr1.getShape());
                multiCross.getChildren().add(cr2.getShape());
                difficulty = Difficulty.NORMAL;
                break;
            case 3:
                cr1 = new Cross(x + length + width / 2, y, length, width, false, false, Speed.MOYEN, 4, colors, 0);
                cr2 = new Cross(x - length - width / 2, y, length, width, false, false, Speed.MOYEN, 4, colors, 2);

                multiCross.getChildren().add(cr1.getShape());
                multiCross.getChildren().add(cr2.getShape());
                difficulty = Difficulty.NORMAL;
                break;
            case 4:
                cr1 = new Cross(x + length / 2 + 3 * width, y, length, width, true, false, Speed.SYMPA, 4, colors, 0);
                cr2 = new Cross(x - length / 2, y, length, width, true, false, Speed.SYMPA, 4, colors, 2);
                multiCross.getChildren().add(cr1.getShape());
                multiCross.getChildren().add(cr2.getShape());
                difficulty = Difficulty.HARD;

                break;
        }
        return multiCross;
    }

}
