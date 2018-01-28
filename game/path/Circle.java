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
public class Circle extends Shape {

	private int radial;
	private int arcs_nbr;
	private Color colors[];


		public Circle(int xCenter, int yCenter, int radial, int width, int arcs_nbr, boolean rotationDirection,
				boolean acceleration, int vitesseRotation,Color[] colors) {

			super(xCenter, yCenter, width,rotationDirection,acceleration,vitesseRotation);
			this.radial = radial;

			this.arcs_nbr = arcs_nbr;

			this.colors = colors;
			this.shape = buildCircle();

			//set stroke
		}


	private Group buildCircle() {
			
			
		Group cercle = new Group();
		int angle =360/arcs_nbr;

		ArcType type = ArcType.OPEN;

		int nbr_color = 0;
		for (int i = 0; i < arcs_nbr; i++,nbr_color++) {
			if(nbr_color == colors.length)
				nbr_color = 0;
			Arc arc_1 = new Arc(x, y, radial, radial, i*angle, angle);
			
			arc_1.setType(type);
			arc_1.setFill(null);
			//arc_1.setStroke(coloRand());
			arc_1.setStroke(colors[nbr_color]);
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


	@Override
	public boolean isOver(int x, int y) {
        //TODO
		return false;
	}
}
