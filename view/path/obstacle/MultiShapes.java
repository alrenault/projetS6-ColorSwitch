package view.path.obstacle;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.game.Difficulty;
import model.game.Speed;
import model.modelObstacle.ModelMultiShapes;
import model.modelShape.*;
import view.path.shapes.BuildShape;
import view.path.shapes.Shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Objet graphique d'un Obstacle représentant de multiple formes
 * version 0 : Cercle dans un carré tourant dans des sens différents
 * version 1 : Carré avec 1 segment au dessus et en dessous faisant des allez-retour
 * version 2 : Cercle avec 1 segment au dessus et en dessous faisant des allez-retour
 * version 3 : Deux croix avec une ligne au dessus et en dessous faisant des allez-retour
 * version 4 : Cercle tournant dans le sens horraire avec une barre verticale en haut et en bas faisant des allez retour
 * version 5 : Carré tournant dans le sens horraire avec une barre verticale en haut et en bas faisant des allez retour
 * version 6 : Triangle tournant dans le sens horraire
 * version 7 : Triangle tournant dans le sens contre horraire
 */
public class MultiShapes extends Obstacle {

    /**
     * Constructeur de multiShapes
     *
     * @param mms le model de la multiShapes à construire
     */
    public MultiShapes(ModelMultiShapes mms) {
        super(mms);
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

        List<Color> colors = mo.getColors();
        double x = mo.getX();
        double y = mo.getY();
        double scWidth = ((ModelMultiShapes) mo).getScWidth();

        // Random r = new Random();
        //int colorR1 = r.nextInt(colors.size());
        //int colorR2 = r.nextInt(colors.size());

        Shapes s;
        List<ModelShape> modelC = new ArrayList<>();

        Random r = new Random();
        int colorDeb = r.nextInt(colors.size());
        int colorOppose = (colorDeb + colors.size() / 2) % colors.size();
        int colorRand = r.nextInt(colors.size());


        if (mo.getVersion() >= ModelMultiShapes.NBR_VERSIONS)
            mo.setVersion(mo.getVersionDefault());

        switch (mo.getVersion()) {
            case 0:
                modelC.add(new ModelSquare(x, y, length, width, false, false, Speed.SYMPA, colors, 0));
                modelC.add(new ModelCircle(x, y, bigRadial - (3 * width) / 2, width, nb_arc, true, false, Speed.SYMPA, colors, 0));
                color_passable.add(colors.get(1));
                color_passable.add(colors.get(3));

                mo.setDifficulty(Difficulty.HARD);
                break;

            case 1:
                modelC.add(new ModelSquare(x, y, length, width, false, false, Speed.MOYEN, colors, 0));
                modelC.add(new ModelHLine(-length, y - length - width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorDeb, (int) scWidth + length));
                modelC.add(new ModelHLine((int) scWidth, y + length + width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorRand, -((int) scWidth + length)));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.NORMAL);
                break;

            case 2:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1));
                modelC.add(new ModelHLine(-length, y - length - width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorDeb, (int) scWidth + length));
                modelC.add(new ModelHLine((int) scWidth, y + length + width * 2, length, width, false, true, Speed.MOYEN, 1, colors, colorRand, -((int) scWidth + length)));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.NORMAL);
                break;

            case 3:
                modelC.add(new ModelCross(x + tinyLength + width / 2, y, tinyLength, width, false, false, Speed.MOYEN, 4, colors, colorDeb));
                modelC.add(new ModelCross(x - tinyLength - width / 2, y, tinyLength, width, false, false, Speed.MOYEN, 4, colors, colorOppose));
                modelC.add(new ModelHLine(-length * 4, y - length - width * 2, length, width, false, false, Speed.SYMPA, (int) scWidth / (int) length + 4, colors, colorDeb, length * 4));
                modelC.add(new ModelHLine(0, y + length + width * 2, length, width, false, false, Speed.MOYEN, (int) scWidth / (int) length + 4, colors, colorRand, -(length * 4)));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));
                mo.setDifficulty(Difficulty.NORMAL);
                break;

            case 4:
                modelC.add(new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.MOYEN, colors, colorDeb));
                modelC.add(new ModelVLine(-width, y - length / 2, length, width, 300, false, true, Speed.TRESSYMPA, 1, colors, colorDeb, (scWidth + width)));
                modelC.add(new ModelVLine(scWidth, y - length / 2, length, width, 300, false, true, Speed.TRESSYMPA, 1, colors, colorRand, -(scWidth + width)));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.EASY);
                break;

            case 5:
                modelC.add(new ModelSquare(x, y, length, width, false, false, Speed.MOYEN, colors, colorDeb));
                modelC.add(new ModelVLine(-width, y - length / 2, length, width, 300, false, true, Speed.TRESSYMPA, 1, colors, colorDeb, (scWidth + width)));
                modelC.add(new ModelVLine(scWidth, y - length / 2, length, width, 300, false, true, Speed.TRESSYMPA, 1, colors, colorRand, -(scWidth + width)));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.NORMAL);
                break;

            case 6:
                modelC.add(new ModelTriangle(x, y, length, width, true, false, Speed.SYMPA, colors, colorDeb));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get((colorDeb + 1) % colors.size()));
                color_passable.add(colors.get((colorDeb + 2) % colors.size()));

                mo.setDifficulty(Difficulty.EASY);
                break;

            case 7:
                modelC.add(new ModelTriangle(x, y, length, width, false, false, Speed.SYMPA, colors, colorDeb));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get((colorDeb + 1) % colors.size()));
                color_passable.add(colors.get((colorDeb + 2) % colors.size()));

                mo.setDifficulty(Difficulty.EASY);
                break;
        }

        for (ModelShape ms : modelC) {
            s = BuildShape.constructShape(ms);
            addSL(s.getShapeList());
            multiShapes.getChildren().add(s.getShape());
            mo.getColor_use().addAll(ms.getColors_use());
        }


        return multiShapes;
    }
}
