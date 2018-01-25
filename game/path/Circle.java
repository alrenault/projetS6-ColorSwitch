package game.path;


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
	

	private int radial;
	
	private int arcs_nbr;
	
	private boolean rotationDirection;
	private boolean acceleration;
	private double rotationSpeed;
	
	
	
	
	

		public Circle(int xCenter, int yCenter, int radial, int width,int arcs_nbr) {
			super(xCenter,yCenter , width);
		this.radial = radial;

		this.arcs_nbr = arcs_nbr;
		this.rotationDirection = true;
		this.acceleration = false;
		this.rotationSpeed = 4.5;
		this.shape = buildCircle();
	}
		
		public Circle(int xCenter, int yCenter, int radial, int width, int arcs_nbr, boolean rotationDirection,
				boolean acceleration, int vitesseRotation) {

			super(xCenter, yCenter, width);
			this.radial = radial;
	
			this.arcs_nbr = arcs_nbr;
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
			this.shape = buildCircle();

			//set stroke
		}


	private Group buildCircle() {
			
			
			Group cercle = new Group();
			int angle =360/arcs_nbr;

		ArcType type = ArcType.OPEN;
			
			

			for (int i = 0; i <= arcs_nbr; i++) {
				Arc arc_1 = new Arc(x, y, radial, radial, i*angle, angle);
				arc_1.setType(type);

				arc_1.setFill(null);
				arc_1.setStroke(coloRand());
				arc_1.setStrokeWidth(10);
				cercle.getChildren().add(arc_1);
			}




		/* Rotation circle */
			RotateTransition rotation = new RotateTransition(Duration.seconds(rotationSpeed),cercle);


		rotation.setByAngle(360* ((rotationDirection)? 1 :-1 ));//sens -1

		rotation.setCycleCount((int)Double.POSITIVE_INFINITY);
			if (!acceleration) {
				rotation.setInterpolator(Interpolator.LINEAR);
			}
		

			rotation.play();
			
			return cercle;
        }


	@Override
	public boolean isOver(int x, int y) {
        //TODO
		return false;
	}
}
