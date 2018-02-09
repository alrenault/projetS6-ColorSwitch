package game.path;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Triangle extends Shapes {

    private double height;

    public Triangle(double x, double y, double height, double width, boolean mouvementDirection, boolean acceleration, Speed _mouvementSpeed, Color[] colors, int pos_color) {
        super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed, colors, pos_color);
        this.height = height;

        this.shape = build();
        
      //recuperation de la position
        coord = shape.localToScene(shape.getBoundsInLocal());
    }

    protected Group build() {
        Group t = new Group();

        double xa, ya, xb, yb, xc, yc, xd, yd, xe, ye, xf, yf, coef, coefReduction;
        Polygon arc_1, arc_2, arc_3;
        arc_1 = new Polygon();
        arc_2 = new Polygon();
        arc_3 = new Polygon();
        coefReduction = (height - (3.0 * width)) / height;
        coef = (Math.sqrt((4.0 * height * height) / 5.0));

        xa = x;
        ya = y - (height / 2.0);//+
        xb = x + (coef / 2.0);
        yb = y + (height / 2.0);
        xc = x + ((coef / 2.0) * coefReduction);
        yc = yb - width;
        xd = x;
        yd = ya + 2.0 * width;


        xe = x - (coef / 2.0);
        ye = yb;


        xf = x - ((coef / 2.0) * coefReduction);
        yf = yc;

        arc_1.getPoints().addAll(xa, ya, xb, yb, xc, yc, xd, yd);
        arc_2.getPoints().addAll(xb, yb, xe, ye, xf, yf, xc, yc);
        arc_3.getPoints().addAll(xe, ye, xf, yf, xd, yd, xa, ya);
        color(arc_1);
        verifPosColor();
        color(arc_2);
        verifPosColor();
        color(arc_3);
        verifPosColor();

        t.getChildren().add(arc_1);
        t.getChildren().add(arc_2);
        t.getChildren().add(arc_3);


        RotateTransition rotation = new RotateTransition(Duration.seconds(mouvementSpeed), t);

        rotation.setByAngle(360 * ((mouvementDirection) ? 1 : -1));

        rotation.setCycleCount((int) Double.POSITIVE_INFINITY);
        if (!acceleration) {
            rotation.setInterpolator(Interpolator.LINEAR);
        }


        rotation.play();
        return t;
    }

}
