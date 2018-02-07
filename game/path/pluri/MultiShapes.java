package game.path.pluri;

import game.Colorable;
import game.path.*;
import game.path.Shapes.Speed;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.util.Random;


public class MultiShapes extends Obstacle {
	/*
	 version 0 : Cercle dans un carré tourant dans des sens différents 
	 version 1 : Carré avec 1 segment au dessus et en dessous faisant des allez-retour
	 version 2 : Cercle avec 1 segment au dessus et en dessous faisant des allez-retour
	 version 3 : Deux croix avec une ligne au dessus et en dessous faisant des allez-retour
	 */

    Scene scene;

    public MultiShapes(double x, double y, Color[] colors, Scene scene, int version) {
        super(x, y, colors, version, 1);
        this.scene = scene;
        obstacle = buildObstacle();
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
        int nbr_versions = 4;

        Random r = new Random();
        int colorR1 = r.nextInt(colors.length);
        int colorR2 = r.nextInt(colors.length);
        Square squa1;
        Circle cer1;
        Linee l1;
        Linee l2;
        Cross cr1;
        Cross cr2;

        if (version >= nbr_versions)
            version = versionDefault;

        switch (version) {
            case 0:
                squa1 = new Square(x, y, length, width, false, false, Shapes.Speed.MOYEN, Colorable.normal, 0);
                cer1 = new Circle(x, y, bigRadial - (3 * width) / 2, width, nb_arc, true, false, Speed.SYMPA, colors, 1);

                multiShapes.getChildren().add(squa1.getShape());
                multiShapes.getChildren().add(cer1.getShape());
                difficulty = ensDifficulty.HARD;
                break;

            case 1:
                squa1 = new Square(x, y, length, width, false, false, Speed.MOYEN, Colorable.normal, 0);
                l1 = new Linee(-length, y - length - width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorR1, (int) scene.getWidth() + length);
                l2 = new Linee((int) scene.getWidth(), y + length + width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorR2, -((int) scene.getWidth() + length));

                multiShapes.getChildren().add(squa1.getShape());
                multiShapes.getChildren().add(l1.getShape());
                multiShapes.getChildren().add(l2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;

            case 2:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                l1 = new Linee(-length, y - length - width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorR1, (int) scene.getWidth() + length);
                l2 = new Linee((int) scene.getWidth(), y + length + width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorR2, -((int) scene.getWidth() + length));

                multiShapes.getChildren().add(cer1.getShape());
                multiShapes.getChildren().add(l1.getShape());
                multiShapes.getChildren().add(l2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;

            case 3:
                cr1 = new Cross(x + tinyLength + width / 2, y, tinyLength, width, false, false, Speed.MOYEN, 4, colors, 0);
                cr2 = new Cross(x - tinyLength - width / 2, y, tinyLength, width, false, false, Speed.MOYEN, 4, colors, 2);
                l1 = new Linee(-length * 4, y - length - width * 2, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                l2 = new Linee(0, y + length + width * 2, length, width, false, false, Speed.MOYEN, (int) scene.getWidth() / (int) length + 4, colors, 1, -(length * 4));

                multiShapes.getChildren().add(cr1.getShape());
                multiShapes.getChildren().add(cr2.getShape());
                multiShapes.getChildren().add(l1.getShape());
                multiShapes.getChildren().add(l2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
        }

        return multiShapes;
    }
}
