package model.modelBall;

import game.ball.Player;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 *
 */
public class Ball {
	/**
	 *
	 */
        double x;
        double y;
	/**
	 *La taille de la Balle
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
	 * La couleur de la Balle
	 */
	private Color color;
	/**
	 *
	 */
    private final double  jumpHeight = 50;
    
    private double vectorX = 0;
    private double vectorY = 0;

    /**
     *
     * @param size
     * @param color
     */
    public Ball(float size, Color color) {
        this.size = size;
        this.color = color;
    }

    /**
     *
     * @return
     */
	public double getX() {
		return x;
	}
	
	
	public double getY() {
		return y;
	}
	
	public void setX(double newX){
		x = newX;
	}
	
	public void setY(double newY){
		System.out.println("Y ? "+newY);
		System.out.println("y ? "+y);
		y = newY;
		System.out.println("Y ? "+newY);
		System.out.println("y ? "+y);
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
    
    public double addVectorX(double j) {
    	return vectorX+=j;
    }
    
    public double addVectorY(double j) {
    	return vectorY+=j;
    }
    
    public double getVectorX(double j) {
    	return vectorX;
    }
    
    public double getVectorY(double j) {
    	return vectorY;
    }
    
    public void moveBall() {
    	x+=vectorX;
    	y+=vectorY;
    	resetVectors();
    }
    
    public void resetVectors() {
    	vectorX=0;
    	vectorY=0;
    }

}
