package game.path;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public abstract class Cross extends Shape {
	
	protected int length;
	protected boolean rotationDirection;
	protected boolean acceleration;
	protected double rotationSpeed;
	
	public Cross(int x, int y, int width, int length) {
		super(x, y, width);
		this.length = length;
		rotationDirection = true;
		acceleration = false;
		rotationSpeed = 4.5;
	}
	
	public Cross(int x, int y, int width, int length, boolean rotationDirection,
			boolean acceleration, int vitesseRotation) {

		super(x, y, width);
		this.length = length;
		this.rotationDirection = rotationDirection;
		this.acceleration = acceleration;
		switch (vitesseRotation) {
			case 1 :
				rotationSpeed= 4.5 ;
				break;
			case 2 :
				rotationSpeed= 3.0 ;
				break;
			case 3 :
				rotationSpeed= 1.0;
				break;
			default :
				rotationSpeed= 7.0 ;
				break;
		}		
	
	}
	
	@Override
	public boolean isOver(int x, int y) {
		//TODO
		return false;
	}
}

