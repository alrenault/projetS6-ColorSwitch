package game.path.items;

import java.util.List;

import game.path.Element;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * @autor Vincent
 * @date 17/02/2018
 */
public abstract class Item extends Element {
    protected double x;
    protected double y;
    protected Group item;
    protected List<Color> colors;
    protected Bounds coord;
    private double points;

    public Item(double x, double y, double points, List<Color> colors) {
    	super();
        this.x = x;
        this.y = y;
        this.points = points;
        this.colors = colors;
        //this.item = build();
        //check();

    }
    
    protected Group build() {
    	return buildItem();
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


	@Override
	public Group getShape() {
		// TODO Auto-generated method stub
		return item;
	}


	@Override
	public List<Shape> getShapeList() {
		// TODO Auto-generated method stub
		return null;
	}
}
