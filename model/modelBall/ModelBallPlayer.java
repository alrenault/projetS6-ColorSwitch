package model.modelBall;

import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class ModelBallPlayer {

	int x = 70;
    private float size;
    private double scWidth;
    private double scHeight;
    private Color color;
    private double jumpHeight = 50;

    public ModelBallPlayer(float size, Color color, double scWidth, double scHeight) {
        this.size = size;
        this.color = color;
        this.scWidth = scWidth;
        this.scHeight = scHeight;
    }

	public int getX() {
		return x;
	}

	public float getSize() {
		return size;
	}

	public double getScWidth() {
		return scWidth;
	}

	public double getScHeight() {
		return scHeight;
	}

	public Color getColor() {
		return color;
	}

	public double getJumpHeight() {
		return jumpHeight;
	}
    
    

}
