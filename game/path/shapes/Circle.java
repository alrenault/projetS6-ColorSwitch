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
import model.modelShape.ModelCircle;
import model.modelShape.ModelShape;

/**Objet graphique Cercle
 */
public class Circle extends Shapes {


	protected Circle(ModelCircle mc) {
		super(mc);
		group_shape = buildShape(mc);
	    coord = group_shape.localToScene(group_shape.getBoundsInLocal());
	}

	/**
     * Generateur de la forme du cercle
     * @return un ensemble d'arcs
     */
    protected Group buildShape(ModelCircle mc) {



        Group cercle = new Group();
        double angle = 360.0 / mc.getArcs_nbr();
        

        ArcType type = ArcType.OPEN;

        for (int i = 0; i < mc.getArcs_nbr(); i++) {
            Arc arc_1 = new Arc(mc.getX(), mc.getY(), mc.getRadial(), mc.getRadial(), (-45) + i * angle, angle);

            arc_1.setType(type);
            arc_1.setFill(null);
            mc.verifPosColor();
            
            //Iterator<Color> it = mc.getColors().iterator();
        	Color c = mc.getColors().get(mc.getPos_color());
        	/*for(int j = 0;it.hasNext() && j <= mc.getPos_color();j++){
        		c = it.next();
        	}*/
            arc_1.setStroke(c);
            mc.getColors_use().add(c);

            arc_1.setStrokeWidth(mc.getWidth());
            
            cercle.getChildren().add(arc_1);
            addSL(arc_1);
        }

        RotateTransition rotation = new RotateTransition(Duration.seconds(mc.getMouvementSpeed()), cercle);
        rotation.setByAngle(360 * ((mc.isMouvementDirection()) ? 1 : -1));
        rotation.setCycleCount((int) Double.POSITIVE_INFINITY);
        if (!mc.isAcceleration()) {
            rotation.setInterpolator(Interpolator.LINEAR);
        }
        rotation.play();
        return cercle;
    }

    
    
    
    
    /*
    
	protected Group buildShape() {
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
	}*/

}
