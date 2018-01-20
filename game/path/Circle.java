package game.path;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

import javafx.util.Duration;

/**
 * @author Vincent
 *
 */
public class Circle extends Shape{
	
	private int xCenter;
	private int yCenter;
	private int radial;
	private int width;
	private Group shape;
	public Circle(int xCenter, int yCenter, int radial, int width,Group shape) {

		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.radial = radial;
		this.width = width;
		this.shape = buildCircle();
	}
	public Circle(int xCenter, int yCenter, int radial,Group shape) {

		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.radial = radial;
		this.width = 5;
		this.shape = buildCircle();
	}

		public Group buildCircle() {
			
			
			Group cercle = new Group();
			int angle =180;
			ArcType type =ArcType.OPEN;
			
			
			/*Arc 1*/
			Arc arc_1 = new Arc(xCenter, yCenter, radial, radial, 0, angle);
			arc_1.setType(type);
			arc_1.setFill(Color.GREEN);
			
			/*Arc 2*/
			Arc arc_2 = new Arc(xCenter, yCenter, radial, radial, 360-angle, angle);
			arc_2.setType(type);
			arc_2.setFill(Color.YELLOW);
			
			
			/*Grosse triche */
			Arc arc_fill = new Arc(xCenter, yCenter, radial-width, radial-width, 0, 360);
			arc_fill.setType(type);
			arc_fill.setFill(Color.GREY);
			
			

			cercle.getChildren().add(arc_1);
			cercle.getChildren().add(arc_2);
			cercle.getChildren().add(arc_fill);
			/* Rotation circle */
			RotateTransition rotation = new RotateTransition(Duration.seconds(2),cercle);
			rotation.setByAngle(360);
			rotation.setCycleCount((int)Double.POSITIVE_INFINITY);
			rotation.play();
			
			return cercle;
		}		
		public Group getShape() {
			return shape;
		}

	@Override
	public boolean isOver(int x, int y) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}
}
