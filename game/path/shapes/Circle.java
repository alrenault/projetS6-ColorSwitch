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

/**Objet graphique Cercle
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
     * @param xCenter coordonnée x du centre du cercle construit
     * @param yCenter coordonnée y du centre du cercle construit
     * @param radial rayon du cercle construit
     * @param width epaisseur des arcs
     * @param arcs_nbr nombre d'arcs du cercle
     * @param rotationDirection Indique si le cercle est autorisé a tourner (voir)
     * @param acceleration Indique si la rotation du  cercle est linéaire ou est soumise à une accéleration
     * @param vitesseRotation vitesse de rotation du cercle
     * @param colors la liste de couleurs à applique aux arcs de cercle
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
        
        check();

    }

    protected Group buildShape() {
		return build();
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
            addSL(arc_1);
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
