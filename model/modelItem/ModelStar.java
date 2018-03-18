package model.modelItem;

import java.util.List;

import javafx.scene.paint.Color;
import model.ItemType;

/**
 *
 */
public class ModelStar extends ModelItem {

	/**
     * Rayon de l'etoile
     */
    private double radius;

    /**
     *Constructeur d'Etoile
     * @param x Coordonnée x de l'Etoile
     * @param y Coordonnée y de l'Etoile
     * @param radius Rayon de l'Etoile
     * @param colors couleur de l'Etoile
     * @param nbPoints le nombre de points de l'Etoile
     * @param type Le type
     */
    public ModelStar(double x, double y, double radius,List<Color> colors,int nbPoints,ItemType type) {
        super(x, y, colors,nbPoints, type);
        assert (radius>0);
        this.radius = radius;
    }

    /**
     *Constructeur simple d'Etoile
     * @param x Coordonnée x de l'Etoile
     * @param y Coordonnée y de l'Etoile
     * @param type
     */
    public ModelStar(double x, double y, ItemType type) {
        super(x, y, null,10, type);
        this.radius = 10.0;
    }

    /**
     * Accesseur de la valeur du rayon de l'Etoile
     * @return Le rayon de l'Etoile
     */
	public double getRadius() {
		return radius;
	}
    
    

}
