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
    /**
     * coordonnée x de l'objet
     */
    protected double x;
    /**
     * coordonnée Y de l'objet
     */
    protected double y;
    /**
     * Forme de l'objet
     */
    protected Group item;
    /**
     * Liste de couleurs à appliquer à la forme
     */
    protected List<Color> colors;
    protected Bounds coord;

    /**
     * Constructeur de la forme
     * @param x coordonnée x de l'objet
     * @param y coordonnée y de l'objet
     * @param colors Liste de couleur à appliquer
     */
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

    /**
     * Genere la forme
     * @return un ensemble de Forme
     */
    protected abstract Group buildItem();


    /**
     * Assesseur de coordonnée x
     * @return La coordonnée x
     */
    public double getX() {
        coord = item.localToScene(item.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    /**
     * Assesseur de coordonnée y
     * @return La coordonnée y
     */

    public double getY() {
        coord = item.localToScene(item.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }
    /**
     * Assesseur de Forme de l'objet
     * @return La Forme de l'objet
     */
    public Group getItem() {
        return item;
    }
}
