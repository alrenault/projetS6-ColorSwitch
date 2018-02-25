package game.path.pluri;

import game.path.Circle;
import game.path.Shapes;
import game.path.Shapes.Speed;
import javafx.scene.Group;
import javafx.scene.paint.Color;


public class MultiCircle extends Obstacle {
	/*
	version 0 : Cercle au dessus d'un cercle dans le meme sens
	version 1 : Cercle au dessus d'un cercle dans des sens différents
	version 2 : 2 cercles l'un à côté de l'autre tournant vers le haut
	version 3 : 3 cercles les uns au dessus des autres
	version 4 : 2 cercle imbriqué vers le haut
	*/
	
	public static final int NBR_VERSIONS = 5;


    public MultiCircle(double x, double y, Color[] colors, int version) {
        super(x, y, colors, version, 0);
        obstacle = buildObstacle();
    }

    private Group buildObstacle() {
        Group multiCircle = new Group();

        double bigRadial = 100.0;
        double width = 15.0;
        int nb_arc = 4;

        Circle cer1;
        Circle cer2;
        Circle cer3;

        if (version >= NBR_VERSIONS)
            version = versionDefault;

        switch (version) {
            case 0:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                cer2 = new Circle(x, y + bigRadial * 2 + width, bigRadial, width, nb_arc, true, false, Shapes.Speed.SYMPA, colors, 1);

                multiCircle.getChildren().add(cer1.getShape());
                multiCircle.getChildren().add(cer2.getShape());
                difficulty = ensDifficulty.EASY;
                break;

            case 1:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                cer2 = new Circle(x, y + bigRadial * 2 + width, bigRadial, width, nb_arc, false, false, Speed.MOYEN, colors, 1);

                multiCircle.getChildren().add(cer1.getShape());
                multiCircle.getChildren().add(cer2.getShape());
                difficulty = ensDifficulty.EASY;
                break;
            case 2:
                cer1 = new Circle(x - bigRadial - width / 2, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
                cer2 = new Circle(x + bigRadial + width / 2, y, bigRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 1);

                multiCircle.getChildren().add(cer1.getShape());
                multiCircle.getChildren().add(cer2.getShape());
                difficulty = ensDifficulty.NORMAL;

                break;
            case 3:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 1);
                cer2 = new Circle(x, y + bigRadial * 2 + width, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
                cer3 = new Circle(x, y - bigRadial * 2 - width, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);

                multiCircle.getChildren().add(cer1.getShape());
                multiCircle.getChildren().add(cer2.getShape());
                multiCircle.getChildren().add(cer3.getShape());
                difficulty = ensDifficulty.HARD;
                break;
            case 4:
                cer1 = new Circle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 2);
                cer2 = new Circle(x, y + bigRadial, bigRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 1);

                multiCircle.getChildren().add(cer1.getShape());
                multiCircle.getChildren().add(cer2.getShape());
                difficulty = ensDifficulty.HARD;
        }

        return multiCircle;
    }

}
