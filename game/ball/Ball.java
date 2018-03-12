package game.ball;

import java.util.List;

import game.path.Element;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * This is a generic ball which represents the player in the game
 * To create a ball, you have to extend this class
 */
public abstract class Ball extends Element {
	

    protected Color color;


    public abstract void applyGravity();

    public abstract void jump();
    
    public abstract double getX();
    
    public abstract double getY();
    
    

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        for(Shape s : getShapeList()){
        	s.setFill(color);
        }
    }
    




    

	@Override
	protected Group build() {
		// TODO Auto-generated method stub
		return null;
	}


}
