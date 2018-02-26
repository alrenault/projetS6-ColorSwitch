package game.path.obstacle;

import game.Colorable;
import game.Difficulty;
import game.path.shapes.Shapes.Speed;
import game.path.shapes.Square;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.Random;


public class MultiSquare extends Obstacle {
	/*
	 version 0 : petit rectangle tournant dans le sens contre horraire
	 version 1 : petit rectangle tournant dans le sens horraire
	 version 2 : rectangle de taille normal tournant dans le sens contre horraire
	 version 3 : rectangle de taille normal tournant dans le sens horraire
	 version 4 : un rectangle moyen dans un grand rectangle tournant dans des sens contraire
	 */

    public static final int NBR_VERSIONS = 5;
    protected static int[] versionEasy = {2, 3};
    protected static int[] versionMedium = {0, 1};
    protected static int[] versionHard = {4};

    public MultiSquare(double x, double y, Color[] colors, int version) {
        super(x, y, colors, version, 2);
        obstacle = buildObstacle();
    }

    public MultiSquare(double x, double y, Color[] colors, Difficulty difficulty) {
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

    public Group buildObstacle() {
        Group multiShapes = new Group();

        double tinyLength = 100.0;
        double mediumLength = 200.0;
        double bigLength = 300.0;
        double width = 15.0;

        //public Square(double x, double y, double length, double width,
        //boolean mouvementDirection, boolean acceleration,int mouvementSpeed,Color[] colors, int pos_color)
        Square squa1;
        Square squa2;

        if (version >= NBR_VERSIONS)
            version = versionDefault;

        switch (version) {
            case 0:
                squa1 = new Square(x, y, tinyLength, width, false, false, Speed.SYMPA, Colorable.CUSTOM, 0);
                multiShapes.getChildren().add(squa1.getShape());
                difficulty = Difficulty.NORMAL;
                break;
            case 1:
                squa1 = new Square(x, y, tinyLength, width, true, false, Speed.SYMPA, Colorable.CUSTOM, 0);
                multiShapes.getChildren().add(squa1.getShape());
                difficulty = Difficulty.NORMAL;
                break;
            case 2:
                squa1 = new Square(x, y, mediumLength, width, false, false, Speed.SYMPA, Colorable.CUSTOM, 0);
                multiShapes.getChildren().add(squa1.getShape());
                difficulty = Difficulty.EASY;
                break;
            case 3:
                squa1 = new Square(x, y, mediumLength, width, true, false, Speed.SYMPA, Colorable.CUSTOM, 0);
                multiShapes.getChildren().add(squa1.getShape());
                difficulty = Difficulty.EASY;
                break;
            case 4:
                squa1 = new Square(x, y, mediumLength, width, false, false, Speed.SYMPA, Colorable.CUSTOM, 0);
                squa2 = new Square(x, y, bigLength, width, true, false, Speed.MOYEN, Colorable.CUSTOM, 2);

                multiShapes.getChildren().add(squa1.getShape());
                multiShapes.getChildren().add(squa2.getShape());
                difficulty = Difficulty.HARD;
                break;
        }

        return multiShapes;
    }
}
