package game.path.items;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;

/**
 * @autor Vincent
 * @date 09/02/2018
 */
public class GravitySwitch extends Item {
    private double width;

    public GravitySwitch(double x, double y) {
        super(x, y, 5.0, Colorable.WHITE);
        this.width = 3.0;
        shape = buildItem();
    }

    protected Group buildItem() {
        double w = width;
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


        Group g = new Group();
        p.setFill(colors[0]);
        g.getChildren().add(p);
        return g;


    }
}
