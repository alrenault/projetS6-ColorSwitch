package view.game.path.items;

import controller.Controller;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import model.modelItem.ModelItem;
import view.ViewPath;
import view.game.ball.BallPlayer;
import view.game.path.Element;

/**
 * @autor Vincent
 * @date 17/02/2018
 */
public abstract class Item extends Element {


    /**
     * Forme de l'objet
     */
    Group item;
    ModelItem model_item;
    /**
     * Liste de couleurs à appliquer à la forme
     */


    private Bounds coord;

    /**
     * Constructeur de la forme
     */
    Item(ModelItem mi) {
        model_item = mi;
        item = new Group();
        item = buildItem(mi);

    }


    /**
     * Genere la forme
     *
     * @return un ensemble de Forme
     */
    protected abstract Group buildItem(ModelItem mi);

    @Override
    protected Group build() {
        return null;
    }

    public abstract void get(ViewPath vPath, Controller c, BallPlayer b);
	/*{
	    c.incItem(model_item);
    }*/

    /**
     * Assesseur de coordonnée x
     *
     * @return La coordonnée x
     */
    private double getX() {
        coord = item.localToScene(item.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    /**
     * Assesseur de coordonnée y
     *
     * @return La coordonnée y
     */

    private double getY() {
        coord = item.localToScene(item.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }

    /**
     * Assesseur de Forme de l'objet
     *
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


    public ModelItem getModel_item() {
        return model_item;
    }


}
