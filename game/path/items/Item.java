package game.path.items;

import java.util.ArrayList;
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

    /**
     * Le nombre de points gagné
     */
    protected int nbPoints;


    protected Bounds coord;

    /**
     * Constructeur de la forme
     * @param x coordonnée x de l'objet
     * @param y coordonnée y de l'objet
     * @param colors Liste de couleur à appliquer
     */
    public Item(double x, double y, List<Color> colors,int nbPoints) {
        assert (x>=0);
        assert (y>=0);
        assert (nbPoints>=0);
        this.x = x;
        this.y = y;
        this.nbPoints=nbPoints;
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
    
	@Override
	protected Group build() {
		return buildItem();
	}

    public int getNbPoints() {
        return nbPoints;
    }

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


	@Override
	public Group getShape() {
		// TODO Auto-generated method stub
		return item;
	}
}
