package game.path.items;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import game.ball.Player;
import game.ball.BallPlayer;
import game.path.Element;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.modelItem.ModelItem;
import view.ViewPath;

/**
 * @autor Vincent
 * @date 17/02/2018
 */
public abstract class Item extends Element {
	
    
    /**
     * Forme de l'objet
     */
    protected Group item;
    /**
     * Liste de couleurs à appliquer à la forme
     */



    protected Bounds coord;
    
    ModelItem model_item;

    /**
     * Constructeur de la forme
     */
    public Item(ModelItem mi) {
       model_item = mi;
        item = new Group();

    }



    /**
     * Genere la forme
     * @return un ensemble de Forme
     */
    protected abstract Group buildItem(ModelItem mi);
    
	@Override
	protected Group build() {
		return null;
	}

	public abstract void get(ViewPath vPath, Controller c, BallPlayer b);

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



	public ModelItem getModel_item() {
		return model_item;
	}
	
	
}
