package game.path.items;

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
    private double points;
    protected Group shape;
    protected  Color[] colors ;
    protected Bounds coord;

    public Item(double x, double y, double points, Color[] colors) {
        this.x = x;
        this.y = y;
        this.points = points;
        this.colors = colors;

    }


    protected abstract Group buildItem();


    public double getPoints() {
        return points;
    }

    public double getX() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    public double getY() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }

    public Group getShape() {
        return shape;
    }
}
