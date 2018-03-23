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
 * Objet graphique d'un Item (non instanciable)
 */
public abstract class Item extends Element {


    /**
     * Forme de l'objet
     */
    Group item;
    /**
     * Objet permettant de manipuler les coordonnees (et la largeur et hauteur) de l'Item) 
     */
    private Bounds coord;
    
    /**
     * Le model contenant les données pour la construction e l'Item
     */
    ModelItem mi;
    /**
     * Constructeur de la forme
     */
    Item(ModelItem mi) {
       this.mi = mi;
       item = new Group();
       item = buildItem();
    }


    /**
     * Genere la forme
     *
     * @return un ensemble de Forme
     */
    protected abstract Group buildItem();
    
	@Override
	protected Group build() {
		return null;
	}

	/**
	 * Méthodes définissant les actions à réaliser une fois l'Item ramassé
	 * @param vPath Le ViewPath dans lequel l'Item appartient
	 * @param c Le Controlleur utilisé
	 * @param b Le joueur ramassant l'Item
	 */
	public abstract void get(ViewPath vPath, Controller c, BallPlayer b);


    /**
     * Assesseur de coordonnée x
     * @return La coordonnée x
     */
    private double getX() {
        coord = item.localToScene(item.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    /**
     * Accesseur de coordonnée y
     * @return La coordonnée y
     */

    private double getY() {
        coord = item.localToScene(item.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    /**
     * Accesseur des coordonnées sous forme d'un Point2D
     * @return Les coordonnées
     */
    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }
    
    /**
     * Accesseur de Forme de l'objet
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


	/**
	 * Accesseur du model de l'Item
	 * @return le model de l'Item
	 */
	public ModelItem getModel_item() {
		return mi;
	}
}
