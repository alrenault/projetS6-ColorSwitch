package game.path.shapes;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

/**
 * @author Vincent
 */
public class Circle extends Shapes {
    /**
     * Rayon du cercle
     */
    private double radial;
    /**
     * Nombre d'arcs du cercle
     */
    private int arcs_nbr;

    /**
     * Constructeur de Cercle
     * @param xCenter
     * @param yCenter
     * @param radial
     * @param width
     * @param arcs_nbr
     * @param rotationDirection
     * @param acceleration
     * @param vitesseRotation
     * @param colors
     * @param pos_color
     */
    public Circle(double xCenter, double yCenter, double radial, double width, int arcs_nbr, boolean rotationDirection,
                  boolean acceleration, Speed vitesseRotation, List<Color> colors, int pos_color) {

        super(xCenter, yCenter, width, rotationDirection, acceleration, vitesseRotation, colors, pos_color);
        System.out.println(this.pos_color);
        this.radial = radial;

        this.arcs_nbr = arcs_nbr;
        this.shape = build();

        //recuperation de la position
        coord = shape.localToScene(shape.getBoundsInLocal());

    }

    /**
     * Generateur de la forme du cercle
     * @return un ensemble d'arcs
     */
    protected Group build() {


        Group cercle = new Group();
        double angle = 360.0 / arcs_nbr;

        ArcType type = ArcType.OPEN;

        for (int i = 0; i < arcs_nbr; i++) {
            Arc arc_1 = new Arc(x, y, radial, radial, i * angle, angle);

            arc_1.setType(type);
            arc_1.setFill(null);
            verifPosColor();
            
            Iterator<Color> it = colors.iterator();
        	Color c = null;
        	for(int j = 0;it.hasNext() && j <= pos_color;j++){
        		c = it.next();
        	}
            arc_1.setStroke(c);
            colors_use.add(c);

            arc_1.setStrokeWidth(width);
            cercle.getChildren().add(arc_1);
        }

        RotateTransition rotation = new RotateTransition(Duration.seconds(mouvementSpeed), cercle);
        rotation.setByAngle(360 * ((mouvementDirection) ? 1 : -1));
        rotation.setCycleCount((int) Double.POSITIVE_INFINITY);
        if (!acceleration) {
            rotation.setInterpolator(Interpolator.LINEAR);
        }
        rotation.play();
        return cercle;
    }

}
