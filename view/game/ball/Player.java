package view.game.ball;


import view.game.path.Element;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.modelBall.Ball;

/**
 * This is a generic ball which represents the player in the view.game
 * To create a ball, you have to extend this class
 */
public abstract class Player extends Element {

    /**
     * Couleur de la Balle
     */
    protected Color color;

    protected Ball model_ball;
    
    protected double x;
    protected double y;

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
     * @return La coordonée y de la Balle
     */
    public double getY() {
    	return y;
    }

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

    /**
     *
     * @return
     */
	public abstract double getSize();

    /**
     *
     * @return
     */
	public Ball getBall() {
		return model_ball;
	}



    /**
     *
     * @return
     */



}