package model.modelItem;

import java.util.List;

import javafx.scene.paint.Color;
import model.ItemType;

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
     */
    public ModelStar(double x, double y, double radius,List<Color> colors,int nbPoints,ItemType type) {
        super(x, y, colors,nbPoints, type);
        assert (radius>0);
        this.radius = radius;
    }

    /**
     *Constructeur d'Etoile
     * @param x Coordonnée x de l'Etoile
     * @param y Coordonnée y de l'Etoile

     */
    public ModelStar(double x, double y, ItemType type) {
        super(x, y, null,10, type);
        this.radius = 10.0;
    }

	public double getRadius() {
		return radius;
	}
    
    

}
