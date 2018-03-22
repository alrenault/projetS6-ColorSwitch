package view.game.path.shapes;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import model.modelShape.ModelTriangle;

/**
 * Objet graphique d'un triangle
 */
public class Triangle extends Shapes {
   


    /**
     * Constructeur de Triangle
     
     */
    public Triangle(ModelTriangle mt) {
        super(mt);

        this.group_shape = buildShape(mt);

        //recuperation de la position (a voir si on ne peut pas le mettre dans la factory)
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
        
        //check();
    }

    /**
     * Génère le triangle
     * @return le Group correspondant au triangle
     */
    protected Group buildShape(ModelTriangle mt) {
        Group t = new Group();

        double height = mt.getHeight();
        double width = mt.getWidth();
        double x = mt.getX();
        double y = mt.getY();
        
        double xa, ya, xb, yb, xc, yc, xd, yd, xe, ye, xf, yf, cote, coefReduction;
        Polygon trapeze_1, trapeze_2, trapeze_3;
        trapeze_1 = new Polygon();
        trapeze_2 = new Polygon();
        trapeze_3 = new Polygon();
        coefReduction = (height - (3.0 * width)) / height;
        cote = (2.0*height)/Math.sqrt(3.0);
                //(Math.sqrt((4.0 * height * height) / 5.0));


        xa = x;
        ya = y - (height * (2.0/3.0));//+
        xb = x + (cote / 2.0);
        yb = y + (height * (1.0/3.0));
        xc = x + ((cote / 2.0) * coefReduction);
        yc = yb - width;
        xd = x;
        yd = ya + 2.0 * width;
        xe = x - (cote / 2.0);
        ye = yb;
        xf = x - ((cote / 2.0) * coefReduction);
        yf = yc;

        trapeze_1.getPoints().addAll(xa, ya, xb, yb, xc, yc, xd, yd);
        trapeze_2.getPoints().addAll(xb, yb, xe, ye, xf, yf, xc, yc);
        trapeze_3.getPoints().addAll(xe, ye, xf, yf, xd, yd, xa, ya);
        mt.color(trapeze_1);
        mt.verifPosColor();
        mt.color(trapeze_2);
        mt.verifPosColor();
        mt.color(trapeze_3);
        mt.verifPosColor();

        addSL(trapeze_1,trapeze_2,trapeze_3);
        t.getChildren().add(trapeze_1);
        t.getChildren().add(trapeze_2);
        t.getChildren().add(trapeze_3);


        RotateTransition rotation = new RotateTransition(Duration.seconds(mt.getMouvementSpeed()), t);

        rotation.setByAngle(360 * ((mt.isMouvementDirection()) ? 1 : -1));

        rotation.setCycleCount((int) Double.POSITIVE_INFINITY);
        if (!mt.isAcceleration()) {
            rotation.setInterpolator(Interpolator.LINEAR);
        }


        rotation.play();
        return t;
    }

}
