package model.modelItem;

import java.util.List;

import javafx.scene.paint.Color;
import model.ItemType;

public class ModelGravitySwitch extends ModelItem{

	 /**
     * La taille
     */
    private double width;
    private double coefForce;

    /**
     * Constructeur
     * @param x coordonnée x de l'objet
     * @param y coordonnée y de l'objet
     * @param coefForce coeficient de gravité
     */
    public ModelGravitySwitch(double x, double y,double coefForce, ItemType type) {
        super(x, y,null,5, type);
        this.width = 3.0;
        this.coefForce=coefForce;
    }

	public double getWidth() {
		return width;
	}

	public double getCoefForce() {
		return coefForce;
	}
    
    

}
