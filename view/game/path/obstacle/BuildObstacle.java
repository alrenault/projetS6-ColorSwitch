package view.game.path.obstacle;

import model.modelObstacle.*;

/**
 * Générateur d'Obstacle
 * @author alexis
 *
 */
public class BuildObstacle {
    
	/**
	 * Génère un Obstacle en fonction du modèle (et de son type)
	 * @param mi Le modèle dont on veut l'Obstacle
	 * @return l'Obstacle représentant le modèle
	 */
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
