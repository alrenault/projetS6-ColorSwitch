package game.path.items;

import game.Colorable;
import game.path.Shapes;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;

/**
 * @autor Vincent
 * @date 09/02/2018
 */
public class GravitySwitch extends Shapes {

    public GravitySwitch(double x, double y) {
        super(x, y, 3, false, false, Speed.NONE, Colorable.WHITE, 0);
        shape = build();
    }

    protected Group build() {
        double w = getWidth();
        Polygon p = new Polygon();
        //1
        p.getPoints().add(x - w);
        p.getPoints().add(y - 2 * w);
        //2
        p.getPoints().add(x - w);
        p.getPoints().add(y + 2 * w);
        //5
        p.getPoints().add(x - 2 * w);
        p.getPoints().add(y + 2 * w);

        //6
        p.getPoints().add(x);
        p.getPoints().add(y + 4 * w);
        //7
        p.getPoints().add(x + 2 * w);
        p.getPoints().add(y + 2 * w);
        //3
        p.getPoints().add(x + w);
        p.getPoints().add(y + 2 * w);
        //4
        p.getPoints().add(x + w);
        p.getPoints().add(y - 2 * w);
        //8
        p.getPoints().add(x + 2 * w);
        p.getPoints().add(y - 2 * w);
        //9
        p.getPoints().add(x);
        p.getPoints().add(y - 4 * w);
        p.getPoints().add(x - 2 * w);
        p.getPoints().add(y - 2 * w);

        color(p);
        Group g = new Group();
        g.getChildren().add(p);
        return g;


    }
}
