package model.game.path.shapes;

import model.modelShape.*;

/**
 * Générateur de forme
 */
public class BuildShape {

    /**
     * Génère une forme en fonction du modèle (et de son type)
     *
     * @param model_shape Le modèle dont on veut la forme
     * @return l'Obstacle représentant le modèle
     */
    public static Shapes constructShape(ModelShape model_shape) {

        Shapes shape;

        switch (model_shape.getType()) {
            case Circle:
                shape = new Circle((ModelCircle) model_shape);
                break;

            case Cross:
                shape = new Cross((ModelCross) model_shape);
                break;

            case Square:
                shape = new Square((ModelSquare) model_shape);
                break;

            case Triangle:
                shape = new Triangle((ModelTriangle) model_shape);
                break;

            case Horizontal_Line:
                shape = new Linee((ModelHLine) model_shape);
                break;

            case Vertical_Line:
                shape = new VerticalLine((ModelVLine) model_shape);
                break;

            default:
                shape = null;
        }

        return shape;
    }
}
