package game.path.pluri;

import game.path.Circle;
import game.path.Shapes.Speed;
import javafx.scene.Group;
import javafx.scene.paint.Color;


public class CircleInCircle extends Obstacle {
	/*
	version 0 : petit cercle tournant dans le sens horraire
	version 1 : petit cercle tournant dans le sens contre horraire
	version 2 : cercle moyen tournant dans le sens horraire
	version 3 : cercle moyen tournant dans le sens contre horraire
	version 4 : grand cercle tournant dans le sens horraire
	version 5 : grand cercle tournant dans le sens contre horraire
	version 6 : 2 cercles imbriqués 
	version 7 : 2 cercles imbriqués dans autre sens 
	version 8 : 3 cercles imbriqués
	version 9 : 3 cercles imbriqués dans l'autre sens
	version 10 : 2 cercle croisés tournant vers le haut
	version 11 : 2 cercle croisés tournant vers le bas
	default : version 4
	*/

    public CircleInCircle(double x, double y, Color[] colors, int version) {
        super(x, y, colors, version, 4);
        obstacle = buildObstacle();
    }

    private Group buildObstacle() {
        double tinyRadial = 40.0;
        double mediumRadial = 70.0;
        double internRadial = 85.0;
        double bigRadial = 100.0;
        double width = 15.0;
        int nb_arc = 4;
        int nbr_versions = 12;
        Group circleInCircle = new Group();
        Circle cer1;
        Circle cer2;
        Circle cer3;

        if (version >= nbr_versions)
            version = versionDefault;

        //int xCenter, int yCenter, int radial, int width, int arcs_nbr, boolean rotationDirection,boolean acceleration, int vitesseRotation,Color[] colors,int pos_color

        switch (version) {
            case 0:
                cer1 = new Circle(x, y, tinyRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                circleInCircle.getChildren().add(cer1.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
            case 1:
                cer1 = new Circle(x, y, tinyRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
                circleInCircle.getChildren().add(cer1.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;

            case 2:
                cer1 = new Circle(x, y, mediumRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                circleInCircle.getChildren().add(cer1.getShape());
                difficulty = ensDifficulty.EASY;
                break;

            case 3:
                cer1 = new Circle(x, y, mediumRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
                circleInCircle.getChildren().add(cer1.getShape());
                difficulty = ensDifficulty.EASY;
                break;

            case 4:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                circleInCircle.getChildren().add(cer1.getShape());
                difficulty = ensDifficulty.EASY;
                break;
            case 5:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
                circleInCircle.getChildren().add(cer1.getShape());
                difficulty = ensDifficulty.EASY;
                break;
            case 6:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                cer2 = new Circle(x, y, internRadial, width, nb_arc, false, false, Speed.MOYEN, colors, 3);

                circleInCircle.getChildren().add(cer1.getShape());
                circleInCircle.getChildren().add(cer2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
            case 7:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
                cer2 = new Circle(x, y, internRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 3);

                circleInCircle.getChildren().add(cer1.getShape());
                circleInCircle.getChildren().add(cer2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
            case 8:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
                cer2 = new Circle(x, y, internRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 1);
                cer3 = new Circle(x, y, mediumRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);

                circleInCircle.getChildren().add(cer1.getShape());
                circleInCircle.getChildren().add(cer2.getShape());
                circleInCircle.getChildren().add(cer3.getShape());
                difficulty = ensDifficulty.HARD;
                break;
            case 9:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                cer2 = new Circle(x, y, internRadial, width, nb_arc, false, false, Speed.MOYEN, colors, 3);
                cer3 = new Circle(x, y, mediumRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);

                circleInCircle.getChildren().add(cer1.getShape());
                circleInCircle.getChildren().add(cer2.getShape());
                circleInCircle.getChildren().add(cer3.getShape());
                difficulty = ensDifficulty.HARD;
                break;
            case 10:
                cer1 = new Circle(x - bigRadial / 2, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 0);
                cer2 = new Circle(x + bigRadial / 2, y, bigRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 2);
                circleInCircle.getChildren().add(cer1.getShape());
                circleInCircle.getChildren().add(cer2.getShape());
                difficulty = ensDifficulty.EASY;
                break;
            case 11:
                cer1 = new Circle(x - bigRadial / 2, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 0);
                cer2 = new Circle(x + bigRadial / 2, y, bigRadial, width, nb_arc, false, false, Speed.MOYEN, colors, 2);
                circleInCircle.getChildren().add(cer1.getShape());
                circleInCircle.getChildren().add(cer2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;

            default:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                circleInCircle.getChildren().add(cer1.getShape());
                difficulty = ensDifficulty.EASY;

        }


        return circleInCircle;

    }

}
