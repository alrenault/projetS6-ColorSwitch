package view.game.path.obstacle;

import model.modelObstacle.*;

public class BuildObstacle {

	/*
    public static Obstacle VersionAlea(int obs, Difficulty difficulty, double posX, double posY, List<Color> colors, double scWidth) {
        ModelObstacle mo;
        Obstacle o;

        switch (obs) {
            case 0:
                mo = new ModelCircleInCircle(posX, posY, colors, difficulty);
                o = new CircleInCircle((ModelCircleInCircle)mo);
                break;

            case 1:
                mo = new ModelMultiCircle(posX, posY, colors, difficulty);
                o = new MultiCircle((ModelMultiCircle)mo);
                break;

            case 2:
                mo = new ModelMultiCross(posX, posY, colors, difficulty);
                o = new MultiCross((ModelMultiCross)mo);
                break;

            case 3:
                mo = new ModelMultiLine(posX, posY, colors, difficulty, scWidth);
                o = new MultiLinee((ModelMultiLine)mo);
                break;

            case 4:
                mo = new ModelMultiShapes(posX, posY, colors, difficulty, scWidth);
                o = new MultiShapes((ModelMultiShapes)mo);
                break;

            case 5:
                mo = new ModelMultiSquare(posX, posY, colors, difficulty);
                o = new MultiSquare((ModelMultiSquare)mo);
                break;

            default:
                mo = new ModelMultiCircle(posX, posY, colors, difficulty);
                o = new MultiCircle((ModelMultiCircle)mo);
        }
        
        return o;
    }*/

    public static Obstacle build(ModelObstacle mo) {
        Obstacle o;


        switch (mo.getType()) {
            case CircleInCircle:
                o = new CircleInCircle((ModelCircleInCircle) mo);
                break;

            case MultiCircle:
                o = new MultiCircle((ModelMultiCircle) mo);
                break;

            case MultiCross:
                o = new MultiCross((ModelMultiCross) mo);
                break;

            case MultiLine:
                o = new MultiLinee((ModelMultiLine) mo);
                break;

            case MultiShapes:
                o = new MultiShapes((ModelMultiShapes) mo);
                break;

            case MultiSquare:
                o = new MultiSquare((ModelMultiSquare) mo);
                break;

            default:
                o = new MultiCircle((ModelMultiCircle) mo);
        }

        return o;
    }


}
