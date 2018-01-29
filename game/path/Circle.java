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
public class Circle extends Shapes {

	private int radial;
	private int arcs_nbr;


		public Circle(int xCenter, int yCenter, int radial, int width, int arcs_nbr, boolean rotationDirection,
				boolean acceleration, int vitesseRotation,Color[] colors,int pos_color) {

			super(xCenter, yCenter, width,rotationDirection,acceleration,vitesseRotation,colors,pos_color);
			System.out.println(this.pos_color);
			this.radial = radial;

			this.arcs_nbr = arcs_nbr;
			this.shape = buildCircle();

		}


	private Group buildCircle() {
			
			
		Group cercle = new Group();
		int angle =360/arcs_nbr;

		ArcType type = ArcType.OPEN;

		for (int i = 0; i < arcs_nbr; i++) {
			Arc arc_1 = new Arc(x, y, radial, radial, i*angle, angle);
			
			arc_1.setType(type);
			arc_1.setFill(null);
			//arc_1.setStroke(coloRand());
			verifPosColor();
			arc_1.setStroke(colors[pos_color]);
			
			arc_1.setStrokeWidth(width);
			cercle.getChildren().add(arc_1);
		}




		/* Rotation circle */
			RotateTransition rotation = new RotateTransition(Duration.seconds(mouvementSpeed),cercle);


		rotation.setByAngle(360* ((mouvementDirection)? 1 :-1 ));

		rotation.setCycleCount((int)Double.POSITIVE_INFINITY);
			if (!acceleration) {
				rotation.setInterpolator(Interpolator.LINEAR);
			}
		

			rotation.play();
			
			return cercle;
        }



}
