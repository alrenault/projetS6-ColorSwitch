package game.path;

import java.util.Random;

import javafx.animation.Interpolator;
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
	private int arcs_nbr;
	private Group shape;
	private boolean rotationDirection;
	private boolean acceleration;
	private double rotationSpeed;
	
	
	
	
	

		public Circle(int xCenter, int yCenter, int radial, int width,int arcs_nbr) {
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.radial = radial;
		this.width = width;
		this.arcs_nbr = arcs_nbr;
		this.shape = buildCircle();
		this.rotationDirection = true;
		this.acceleration = false;
		this.rotationSpeed = 4.5;
	}
		
		public Circle(int xCenter, int yCenter, int radial, int width, int arcs_nbr, boolean rotationDirection,
				boolean acceleration, int vitesseRotation) {

			this.xCenter = xCenter;
			this.yCenter = yCenter;
			this.radial = radial;
			this.width = width;
			this.arcs_nbr = arcs_nbr;
			this.shape = buildCircle();
			this.rotationDirection = rotationDirection;
			this.acceleration = acceleration;
			switch (vitesseRotation) {
				case 1 :
					rotationSpeed= 4.5 ;
					break;
				case 2 :
					rotationSpeed= 3 ;
					break;
				case 3 :
					rotationSpeed= 1;
					break;
				default :
					rotationSpeed= 7 ;
					break;
			}
			
		
		}


		public Group buildCircle() {
			
			
			Group cercle = new Group();
			int angle =360/arcs_nbr;
			
			ArcType type =ArcType.ROUND;
			
			

			for (int i = 0; i <= arcs_nbr; i++) {
				Arc arc_1 = new Arc(xCenter, yCenter, radial, radial, i*angle, angle);
				arc_1.setType(type);
				arc_1.setFill(coloRand());
				cercle.getChildren().add(arc_1);
			}
			
			
			
			/*
				//arc 2
			Arc arc_2 = new Arc(xCenter, yCenter, radial, radial, 360-angle, angle);
			arc_2.setType(type);
			arc_2.setFill(coloRand());
			cercle.getChildren().add(arc_2);
			
			*/
			
			
			/*Grosse triche */
			Arc arc_fill = new Arc(xCenter, yCenter, radial-width, radial-width, 0, 360);
			arc_fill.setType(type);
			arc_fill.setFill(Color.GREY);
			cercle.getChildren().add(arc_fill);
			
			

			/* Rotation circle */
			RotateTransition rotation = new RotateTransition(Duration.seconds(3),cercle);
			
		
			//rotation.setByAngle(360* ((rotationDirection)? 1 :-1 ));//sens -1
			rotation.setByAngle(360);//sens -1
			
			rotation.setCycleCount((int)Double.POSITIVE_INFINITY);
			if (!acceleration) {
				rotation.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
			}
		

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
	public Color coloRand() {
		Random r =new Random();
		return new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1);
	}
}
