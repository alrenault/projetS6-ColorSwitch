package model.game.path.shapes;


import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;
import model.modelShape.ModelCircle;

/**
 * Objet graphique d'un Cercle
 */
public class Circle extends Shapes {

    /**
     * Constructeur d'un cercle
     *
     * @param mc Le model utilisé pour le MultiCircle
     */
    Circle(ModelCircle mc) {
        super(mc);
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
    }

    /**
     * Generateur de la forme du cercle
     *
     * @return un group représentant un cercle
     */
    protected Group buildShape() {

        ModelCircle mc = (ModelCircle) ms;
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

}
