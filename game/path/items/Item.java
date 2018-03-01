package game.path.items;

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
    private double points;

    public Item(double x, double y, double points, List<Color> colors) {
        this.x = x;
        this.y = y;
        this.points = points;
        this.colors = colors;
        item = new Group();

    }


    protected abstract Group buildItem();


    public double getPoints() {
        return points;
    }

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
