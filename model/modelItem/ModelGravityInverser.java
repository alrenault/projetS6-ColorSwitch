package model.modelItem;

import model.ItemType;

public class ModelGravityInverser extends ModelGravitySwitch {

	private double width;


    /**
     * Constructeur
     * @param x coordonnée x de l'objet
     * @param y coordonnée y de l'objet
     */
    public ModelGravityInverser(double x, double y, ItemType type) {
        super(x, y,-1.0,type);
        this.width = 3.0;
    }

}
