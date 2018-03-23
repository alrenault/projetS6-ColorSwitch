package view.game.path.obstacle;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.modelObstacle.ModelCircleInCircle;
import model.modelObstacle.ModelObstacle;
import model.modelShape.ModelCircle;
import model.modelShape.ModelShape;
import view.game.Difficulty;
import view.game.Speed;
import view.game.path.shapes.BuildShape;
import view.game.path.shapes.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CircleInCircle extends Obstacle {
	/*
	version 0 : 2 cercles imbriqués 
	version 1 : 2 cercles imbriqués dans autre sens 
	version 2 : 3 cercles imbriqués
	version 3 : 3 cercles imbriqués dans l'autre sens
	version 4 : 2 cercle croisés tournant vers le haut
	version 5 : 2 cercle croisés tournant vers le bas
	version 6 : petit cercle dans un grand cercle
	default : version 4
	*/


    public CircleInCircle(ModelCircleInCircle mcic) {
        super(mcic);


    }

   /* public CircleInCircle(double x, double y, List<Color> colors, Difficulty difficulty) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = CircleInCircle.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = CircleInCircle.getRandomMediumVersion();
        else
            version = CircleInCircle.getRandomHardVersion();
        obstacle = buildObstacle();
    }*/


    protected Group buildObstacle(ModelObstacle mcic) {
        double tinyRadial = 60.0;
        double mediumRadial = 70.0;
        double internRadial = 85.0;
        double bigRadial = 100.0;
        double width = 15.0;
        int nb_arc = 4;

        double x = mcic.getX();
        double y = mcic.getY();
        List<Color> colors = mcic.getColors();

        //BuildShape builder = new BuildShape();

        Group circleInCircle = new Group();
        Circle cer1;

        List<ModelShape> modelC = new ArrayList<>();


        if (mcic.getVersion() >= ModelCircleInCircle.NBR_VERSIONS)
            mcic.setVersion(mcic.getVersionDefault());

        //double xCenter, double yCenter, double radial, double width, int arcs_nbr, boolean rotationDirection,
        //boolean acceleration, Speed vitesseRotation, List<Color> colors, int pos_color
        Random r = new Random();
        int colorDeb = r.nextInt(colors.size());
        int colorOppose = (colorDeb + nb_arc / 2) % colors.size();


        switch (mcic.getVersion()) {

            case 0:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x, y, internRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mcic.setDifficulty(Difficulty.NORMAL);
                break;

            case 1:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x, y, internRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorDeb));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mcic.setDifficulty(Difficulty.NORMAL);
                break;

            case 2:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 0));
                modelC.add(new ModelCircle(x, y, internRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 2));
                modelC.add(new ModelCircle(x, y, mediumRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 0));
                color_passable.add(colors.get(1));
                color_passable.add(colors.get(3));

                mcic.setDifficulty(Difficulty.HARD);
                break;

            case 3:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 0));
                modelC.add(new ModelCircle(x, y, internRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 2));
                modelC.add(new ModelCircle(x, y, mediumRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 0));
                color_passable.add(colors.get(1));
                color_passable.add(colors.get(3));

                mcic.setDifficulty(Difficulty.HARD);
                break;

            case 4:
                modelC.add(new ModelCircle(x - bigRadial / 2, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x + bigRadial / 2, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorDeb));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mcic.setDifficulty(Difficulty.EASY);
                break;

            case 5:
                modelC.add(new ModelCircle(x - bigRadial / 2, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x + bigRadial / 2, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mcic.setDifficulty(Difficulty.EASY);
                break;

            case 6:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x, y, mediumRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mcic.setDifficulty(Difficulty.NORMAL);
                break;

            default:
                modelC.add(new ModelCircle(x - bigRadial / 2, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x + bigRadial / 2, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorOppose));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mcic.setDifficulty(Difficulty.EASY);
        }

        for (ModelShape ms : modelC) {
            cer1 = (Circle) BuildShape.constructShape(ms);
            addSL(cer1.getShapeList());
            circleInCircle.getChildren().add(cer1.getShape());
            mcic.getColor_use().addAll(ms.getColors_use());
        }


        return circleInCircle;

    }


}
