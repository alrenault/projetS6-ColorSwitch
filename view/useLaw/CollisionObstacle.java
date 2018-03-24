package view.useLaw;

import controller.Controller;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import view.ViewPath;
import view.ball.BallPlayer;

/**
 * Gère les collisions entre le joueur et les obstacles
 */
public class CollisionObstacle implements UseLaw {

	/**
	 * La balle représentant le joueur
	 */
    private BallPlayer ball;
    
    /**
     * Le ViewPath contenant les items afin de les modifier si besoin
     */
    private ViewPath path;
    
    /**
     * Référence au controleur
     */
    private Controller controller;

    /**
     * Constructeur du vérificateur de collision
     * @param ball La ball dont on veut teste la collision
     * @param path le path dont on veut les obstacles
     * @param controller Référence vers le controller
     */
    public CollisionObstacle(BallPlayer ball, ViewPath path, Controller controller) {
        this.ball = ball;
        this.path = path;
        this.controller = controller;
    }

    @Override
    public void apply() {

        for (Shape b : ball.getShapeList()) {

            for (Shape shape : path.getObstaclesShapes()) {

                Shape intersection = Shape.intersect(b, shape);


                if (!intersection.getBoundsInParent().isEmpty()) {

                    if (shape instanceof Arc && shape.getStroke() != b.getFill()) {
                        controller.gameOver();
                    }

                    if (!(shape instanceof Arc) && shape.getFill() != b.getFill()) {
                        controller.gameOver();
                    }

                }
            }

        }

    }
}
