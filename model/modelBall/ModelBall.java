package model.modelBall;

import game.ball.Ball;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 *
 */
public class ModelBall extends Ball {
	/**
	 *
	 */
        int  x = 70;
	/**
	 *
	 */
    private float size;
	/**
	 *
	 */
	private double scWidth;
	/**
	 *
	 */
    private double scHeight;
	/**
	 *
	 */
	private Color color;
	/**
	 *
	 */
    private final double  jumpHeight = 50;

    /**
     *
     * @param size
     * @param color
     * @param scWidth
     * @param scHeight
     */
    public ModelBall(float size, Color color, double scWidth, double scHeight) {
        this.size = size;
        this.color = color;
        this.scWidth = scWidth;
        this.scHeight = scHeight;
    }

    /**
     *
     * @return
     */
	public double getX() {
		return x;
	}

    /**
     *
     * @return
     */
	public double getSize() {
		return size;
	}

    /**
     *
     * @return
     */
	public double getScWidth() {
		return scWidth;
	}

    /**
     *
     * @return
     */
	public double getScHeight() {
		return scHeight;
	}

    /**
     *
     * @return
     */
	public Color getColor() {
		return color;
	}

    /**
     * Accesseur de la valeur de hauteur de saut
     * @return La hauteur de saut
     */
	public double getJumpHeight() {
		return jumpHeight;
	}

	@Override
	public void applyGravity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    

}
