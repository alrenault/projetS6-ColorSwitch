package game.path.obstacle;

import game.Difficulty;
import game.path.shapes.*;
import game.path.shapes.Shapes.Speed;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;


public class MultiShapes extends Obstacle {
	/*
	 version 0 : Cercle dans un carré tourant dans des sens différents 
	 version 1 : Carré avec 1 segment au dessus et en dessous faisant des allez-retour
	 version 2 : Cercle avec 1 segment au dessus et en dessous faisant des allez-retour
	 version 3 : Deux croix avec une ligne au dessus et en dessous faisant des allez-retour
	 version 4 : Cercle tournant dans le sens horraire avec une barre verticale faisant des allez retour
	 version 5 : Carré tournant dans le sens horraire avec une barre verticale faisant des allez retour
	 */

    public static final int NBR_VERSIONS = 6;
    protected static int[] versionEasy = {4};
    protected static int[] versionMedium = {1, 2, 3, 5};
    protected static int[] versionHard = {0};
    Scene scene;


    public MultiShapes(double x, double y, List<Color> colors, Scene scene, int version) {
        super(x, y, colors, version, 1);
        this.scene = scene;
        obstacle = buildObstacle();
    }

    public MultiShapes(double x, double y, List<Color> colors, Difficulty difficulty, Scene scene) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = CircleInCircle.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = CircleInCircle.getRandomMediumVersion();
        else
            version = CircleInCircle.getRandomHardVersion();

        this.scene = scene;
        obstacle = buildObstacle();
    }

    public MultiShapes(double x, double y, List<Color> colors, Difficulty difficulty) {
		super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = CircleInCircle.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = CircleInCircle.getRandomMediumVersion();
        else
            version = CircleInCircle.getRandomHardVersion();

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

    public Group buildObstacle() {
        Group multiShapes = new Group();

        double length = 200.0;
        double tinyLength = 100;
        double tinyRadial = 40.0;
        double mediumRadial = 70.0;
        double internRadial = 85.0;
        double bigRadial = 100.0;
        double width = 15.0;
        int nb_arc = 4;

        Random r = new Random();
        int colorR1 = r.nextInt(colors.size());
        int colorR2 = r.nextInt(colors.size());
        Square squa1;
        Circle cer1;
        Linee l1;
        Linee l2;
        VerticalLine vl1;
        VerticalLine vl2;
        Cross cr1;
        Cross cr2;

        if (version >= NBR_VERSIONS)
            version = versionDefault;

        switch (version) {
            case 0:
                squa1 = new Square(x, y, length, width, false, false, Shapes.Speed.MOYEN, colors, 0);
                cer1 = new Circle(x, y, bigRadial - (3 * width) / 2, width, nb_arc, true, false, Speed.SYMPA, colors, 1);

                addSL(squa1.getShapeList(),cer1.getShapeList());
                multiShapes.getChildren().add(squa1.getShape());
                multiShapes.getChildren().add(cer1.getShape());
                
                difficulty = Difficulty.HARD;
                color_use.addAll(squa1.getColors_use());
                color_use.addAll(cer1.getColors_use());
                break;

            case 1:
                squa1 = new Square(x, y, length, width, false, false, Speed.MOYEN, colors, 0);
                l1 = new Linee(-length, y - length - width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorR1, (int) scene.getWidth() + length);
                l2 = new Linee((int) scene.getWidth(), y + length + width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorR2, -((int) scene.getWidth() + length));

                addSL(squa1.getShapeList(),l1.getShapeList(),l2.getShapeList());
                multiShapes.getChildren().add(squa1.getShape());
                multiShapes.getChildren().add(l1.getShape());
                multiShapes.getChildren().add(l2.getShape());
                
                difficulty = Difficulty.NORMAL;
                color_use.addAll(squa1.getColors_use());
                color_use.addAll(l1.getColors_use());
                color_use.addAll(l2.getColors_use());
                break;

            case 2:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                l1 = new Linee(-length, y - length - width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorR1, (int) scene.getWidth() + length);
                l2 = new Linee((int) scene.getWidth(), y + length + width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorR2, -((int) scene.getWidth() + length));

                addSL(cer1.getShapeList(),l1.getShapeList(),l2.getShapeList());
                multiShapes.getChildren().add(cer1.getShape());
                multiShapes.getChildren().add(l1.getShape());
                multiShapes.getChildren().add(l2.getShape());
                
                difficulty = Difficulty.NORMAL;
                color_use.addAll(cer1.getColors_use());
                color_use.addAll(l1.getColors_use());
                color_use.addAll(l2.getColors_use());
                break;

            case 3:
                cr1 = new Cross(x + tinyLength + width / 2, y, tinyLength, width, false, false, Speed.MOYEN, 4, colors, 0);
                cr2 = new Cross(x - tinyLength - width / 2, y, tinyLength, width, false, false, Speed.MOYEN, 4, colors, 2);
                l1 = new Linee(-length * 4, y - length - width * 2, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                l2 = new Linee(0, y + length + width * 2, length, width, false, false, Speed.MOYEN, (int) scene.getWidth() / (int) length + 4, colors, 1, -(length * 4));

                addSL(cr1.getShapeList(),cr2.getShapeList(),l1.getShapeList(),l2.getShapeList());
                multiShapes.getChildren().add(cr1.getShape());
                multiShapes.getChildren().add(cr2.getShape());
                multiShapes.getChildren().add(l1.getShape());
                multiShapes.getChildren().add(l2.getShape());
                
                difficulty = Difficulty.NORMAL;
                color_use.addAll(cr1.getColors_use());
                color_use.addAll(cr2.getColors_use());
                color_use.addAll(l1.getColors_use());
                color_use.addAll(l2.getColors_use());
                break;

            case 4:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 1);
                vl1 = new VerticalLine(-width, y - length / 2, length, width, 300, false, true, Speed.TRESSYMPA, 1, colors, 0, (scene.getWidth() + width));
                vl2 = new VerticalLine(scene.getWidth(), y - length / 2, length, width, 300, false, true, Speed.TRESSYMPA, 1, colors, 2, -(scene.getWidth() + width));

                addSL(cer1.getShapeList(),vl1.getShapeList(),vl2.getShapeList());
                multiShapes.getChildren().add(cer1.getShape());
                multiShapes.getChildren().add(vl1.getShape());
                multiShapes.getChildren().add(vl2.getShape());
                
                difficulty = Difficulty.EASY;
                color_use.addAll(cer1.getColors_use());
                color_use.addAll(vl1.getColors_use());
                color_use.addAll(vl2.getColors_use());
                System.out.println("taille1 : "+color_use);
                break;

            case 5:
                squa1 = new Square(x, y, length, width, false, false, Speed.MOYEN, colors, 0);
                vl1 = new VerticalLine(-width, y - length / 2, length, width, 300, false, true, Speed.TRESSYMPA, 1, colors, 0, (scene.getWidth() + width));
                vl2 = new VerticalLine(scene.getWidth(), y - length / 2, length, width, 300, false, true, Speed.TRESSYMPA, 1, colors, 2, -(scene.getWidth() + width));

                addSL(squa1.getShapeList(),vl1.getShapeList(),vl2.getShapeList());
                multiShapes.getChildren().add(squa1.getShape());
                multiShapes.getChildren().add(vl1.getShape());
                multiShapes.getChildren().add(vl2.getShape());
                difficulty = Difficulty.NORMAL;
                color_use.addAll(squa1.getColors_use());
                color_use.addAll(vl1.getColors_use());
                color_use.addAll(vl2.getColors_use());
                System.out.println("taille2 : "+color_use);
                break;
        }

        return multiShapes;
    }
}
