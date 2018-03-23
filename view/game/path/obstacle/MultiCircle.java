package view.game.path.obstacle;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.modelObstacle.ModelMultiCircle;
import model.modelShape.ModelCircle;
import model.modelShape.ModelShape;
import view.game.Difficulty;
import view.game.Speed;
import view.game.path.shapes.BuildShape;
import view.game.path.shapes.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Objet graphique d'un Obstacle représentant de multiple cercles
 */

public class MultiCircle extends Obstacle {
	/*
	version 0 : Cercle au dessus d'un cercle dans des sens différents
	version 1 : Cercle au dessus d'un cercle dans des sens différents (autre sens)
	version 2 : 2 cercles l'un à côté de l'autre tournant vers le haut
	version 3 : 3 cercles les uns au dessus des autres
	version 4 : 2 cercle imbriqué vers le haut
	version 5 : petit cercle tournant dans le sens horraire
	version 6 : petit cercle tournant dans le sens contre horraire
	version 7 : cercle moyen tournant dans le sens horraire
	version 8 : cercle moyen tournant dans le sens contre horraire
	version 9 : grand cercle tournant dans le sens horraire
	version 10 : grand cercle tournant dans le sens contre horraire
	*/


    /**
     * Constructeur du MultiCircle
     *
     * @param mmc Le model utilisé pour le MultiCircle
     */

    public MultiCircle(ModelMultiCircle mmc) {
        super(mmc);
    }


    protected Group buildObstacle() {
        Group multiCircle = new Group();

        double tinyRadial = 60.0;
        double mediumRadial = 70.0;
        double bigRadial = 100.0;
        double width = 15.0;
        int nb_arc = 4;

        double x = mo.getX();
        double y = mo.getY();
        List<Color> colors = mo.getColors();


        Circle cer1;
        List<ModelShape> modelC = new ArrayList<>();

        if (mo.getVersion() >= ModelMultiCircle.NBR_VERSIONS)
            mo.setVersion(mo.getVersionDefault());

        Random r = new Random();
        int colorDeb = r.nextInt(colors.size());
        int colorOppose = (colorDeb + nb_arc / 2) % colors.size();

        boolean acceleration = r.nextBoolean();


        switch (mo.getVersion()) {
            case 0:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x, y + bigRadial * 2 + width, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorOppose));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mo.setDifficulty(Difficulty.EASY);
                break;

            case 1:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x, y + bigRadial * 2 + width, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorOppose));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mo.setDifficulty(Difficulty.EASY);
                break;

            case 2:
                modelC.add(new ModelCircle(x - bigRadial - width / 2, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x + bigRadial + width / 2, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorOppose));
                color_passable.add(colors.get((colorDeb + 1) % colors.size()));
                color_passable.add(colors.get((colorOppose + 1) % colors.size()));
                mo.setDifficulty(Difficulty.NORMAL);

                break;

            case 3:
                modelC.add(new ModelCircle(x, y + bigRadial * 2 + width, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, colorOppose));
                modelC.add(new ModelCircle(x, y - bigRadial * 2 - width, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, colorDeb));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mo.setDifficulty(Difficulty.HARD);
                break;

            case 4:
                modelC.add(new ModelCircle(x, y, bigRadial + 40, width, nb_arc, true, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelCircle(x, y + bigRadial + 40, bigRadial + 40, width, nb_arc, true, false, Speed.MOYEN, colors, colorDeb));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mo.setDifficulty(Difficulty.HARD);
                break;

            case 5:
                modelC.add(new ModelCircle(x, y, tinyRadial, width, nb_arc, true, acceleration, Speed.SYMPA, colors, colorDeb));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.NORMAL);
                break;

            case 6:
                modelC.add(new ModelCircle(x, y, tinyRadial, width, nb_arc, false, acceleration, Speed.SYMPA, colors, colorDeb));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.NORMAL);
                break;

            case 7:
                modelC.add(new ModelCircle(x, y, mediumRadial, width, nb_arc, true, acceleration, Speed.SYMPA, colors, colorDeb));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.EASY);
                break;

            case 8:
                modelC.add(new ModelCircle(x, y, mediumRadial, width, nb_arc, false, acceleration, Speed.SYMPA, colors, colorDeb));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.EASY);
                break;

            case 9:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, true, acceleration, Speed.SYMPA, colors, colorDeb));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.EASY);
                break;

            case 10:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, false, acceleration, Speed.SYMPA, colors, 1));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.EASY);
                break;
        }

        for (ModelShape ms : modelC) {
            cer1 = (Circle) BuildShape.constructShape(ms);
            addSL(cer1.getShapeList());
            multiCircle.getChildren().add(cer1.getShape());
            mo.getColor_use().addAll(ms.getColors_use());
        }


        return multiCircle;
    }

}
