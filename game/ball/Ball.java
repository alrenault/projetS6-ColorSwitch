package game.ball;


import game.path.Element;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * This is a generic ball which represents the player in the game
 * To create a ball, you have to extend this class
 */
public abstract class Ball {

    /**
     * Couleur de la Balle
     */
    protected Color color;

    /**
     * Application de la gravité
     */
    public abstract void applyGravity();

    /**
     * Application de l'action 'jump'
     */
    public abstract void jump();

    /**
     * Accesseur de coordonée x de la Balle
     *
     * @return La coordonée x de la Balle
     */
    public abstract double getX();

    /**
     * Accesseur de coordonée y de la Balle
     * @return La coordonée y de la Balle
     */
    public abstract double getY();


    /**
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

	public abstract double getSize();

    /**
     *
     * @return
     */



}
