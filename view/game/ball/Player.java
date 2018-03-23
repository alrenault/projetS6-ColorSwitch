package view.game.ball;


import javafx.scene.paint.Color;
import model.modelBall.Ball;
import view.game.path.Element;

/**
 * This is a generic ball which represents the player in the view.game
 * To create a ball, you have to extend this class
 */
public abstract class Player extends Element {

    Ball model_ball;
    /**
     * Couleur de la Balle
     */
    private Color color;
    private double x;
    private double y;

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
    public double getX() {
        return x;
    }


    /**
     * Accesseur de coordonée y de la Balle
     *
     * @return La coordonée y de la Balle
     */
    public double getY() {
        return y;
    }

    /**
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return
     */
    public abstract double getSize();

    /**
     * @return
     */
    public Ball getBall() {
        return model_ball;
    }


}
