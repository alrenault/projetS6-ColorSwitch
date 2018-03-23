package view.game.path.obstacle;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.modelObstacle.ModelMultiSquare;
import model.modelObstacle.ModelObstacle;
import model.modelShape.ModelShape;
import model.modelShape.ModelSquare;
import view.game.Difficulty;
import view.game.Speed;
import view.game.path.shapes.BuildShape;
import view.game.path.shapes.Shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MultiSquare extends Obstacle {
	/*
	 version 0 : petit rectangle tournant dans le sens contre horraire
	 version 1 : petit rectangle tournant dans le sens horraire
	 version 2 : rectangle de taille normal tournant dans le sens contre horraire
	 version 3 : rectangle de taille normal tournant dans le sens horraire
	 version 4 : un rectangle moyen dans un grand rectangle tournant dans des sens contraire
	 */


    public MultiSquare(ModelMultiSquare mms) {
        super(mms);
    }


    public Group buildObstacle(ModelObstacle mo) {
        Group multiSquare = new Group();

        double tinyLength = 150.0;
        double mediumLength = 200.0;
        double bigLength = 300.0;
        double width = 15.0;

        double x = mo.getX();
        double y = mo.getY();
        List<Color> colors = mo.getColors();

        Random r = new Random();
        int colorDeb = r.nextInt(colors.size());
        int colorOppose = (colorDeb + colors.size()) % colors.size();

        //public Square(double x, double y, double length, double width,
        //boolean mouvementDirection, boolean acceleration,int mouvementSpeed,Color[] colors, int pos_color)
        Shapes s;
        List<ModelShape> modelC = new ArrayList<>();

        if (mo.getVersion() >= ModelMultiSquare.NBR_VERSIONS)
            mo.setVersion(mo.getVersionDefault());
        switch (mo.getVersion()) {
            case 0:
                modelC.add(new ModelSquare(x, y, tinyLength, width, false, false, Speed.SYMPA, colors, colorDeb));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.NORMAL);
                break;
            case 1:
                modelC.add(new ModelSquare(x, y, tinyLength, width, true, false, Speed.SYMPA, colors, colorDeb));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.NORMAL);
                break;
            case 2:
                modelC.add(new ModelSquare(x, y, mediumLength, width, false, false, Speed.SYMPA, colors, colorDeb));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.EASY);
                break;
            case 3:
                modelC.add(new ModelSquare(x, y, mediumLength, width, true, false, Speed.SYMPA, colors, colorDeb));
                color_passable.addAll(colors);

                mo.setDifficulty(Difficulty.EASY);

                break;
            case 4:
                modelC.add(new ModelSquare(x, y, mediumLength, width, false, false, Speed.SYMPA, colors, colorDeb));
                modelC.add(new ModelSquare(x, y, bigLength, width, true, false, Speed.SYMPA, colors, colorOppose));
                color_passable.add(colors.get(colorDeb));
                color_passable.add(colors.get(colorOppose));

                mo.setDifficulty(Difficulty.HARD);
                break;

        }

        for (ModelShape ms : modelC) {
            s = BuildShape.constructShape(ms);
            addSL(s.getShapeList());
            multiSquare.getChildren().add(s.getShape());
            mo.getColor_use().addAll(ms.getColors_use());
        }


        return multiSquare;
    }
}
