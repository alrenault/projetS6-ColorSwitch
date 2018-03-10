package game.path.items;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * @autor Vincent
 * @date 17/02/2018
 */
public abstract class Item {
    protected double x;
    protected double y;
    protected Group item;
    protected List<Color> colors;
    protected Bounds coord;

    public Item(double x, double y, List<Color> colors) {
        this.x = x;
        this.y = y;
        if (colors==null) {
            List<Color> c = new ArrayList<>();
            c.add(Color.WHITE);
            this.colors = c;
        }else {
            this.colors = colors;
        }
        item = new Group();

    }


    protected abstract Group buildItem();



    public double getX() {
        coord = item.localToScene(item.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    public double getY() {
        coord = item.localToScene(item.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }

    public Group getItem() {
        return item;
    }
}
