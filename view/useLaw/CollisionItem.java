package view.useLaw;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.shape.Shape;
import view.ViewPath;
import model.game.ball.BallPlayer;
import model.game.path.items.Item;

/**
 * Gère les collisions entre le joueur et les items
 */
public class CollisionItem implements UseLaw {

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
     * Le group contenant les Item
     */
    private Group jItems;

    /**
     * Constructeur du vérificateur de collision
     * @param ball La ball dont on veut teste la collision
     * @param path le path dont on veut les items
     * @param controller Référence vers le controller
     */
    public CollisionItem(BallPlayer ball, ViewPath path, Controller controller) {
        this.ball = ball;
        this.path = path;
        this.controller = controller;
        this.jItems = path.getjItems();
    }


    public void apply() {
        Boolean touch = false;
        for (Shape b : ball.getShapeList()) {
            for (Item item : path.getItems()) {
                for (Shape i : path.getItemsShapes()) {
                    Shape intersection = Shape.intersect(b, i);

                    if (!intersection.getBoundsInParent().isEmpty()) {
                        touch = true;

                        item.get(path, controller, ball);

                        jItems.getChildren().remove(item.getItem());


                        path.removeItem(item);
                        break;

                    }
                }
                if (touch) {
                    touch = false;
                    break;
                }
            }


        }

    }


}
