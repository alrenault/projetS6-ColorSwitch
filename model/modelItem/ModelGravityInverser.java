package model.modelItem;

import model.ItemType;

/**
 * Modele d'Inverseur de gravité
 */
public class ModelGravityInverser extends ModelGravitySwitch {
    /**
     * La taille de l'Inverseur de gravité
     */
    private double size;


    /**
     * Constructeur
     *
     * @param x    coordonnée x de l'Inverseur de gravité
     * @param y    coordonnée y de l'Inverseur de gravité
     * @param type Le type d'Item (GravityInverser)
     */
    public ModelGravityInverser(double x, double y, ItemType type) {
        super(x, y, -1.0, type);
        this.size = 3.0;
    }

    /**
     * Accesseur de la valeur de la taille du GravityInverser
     * @return La taille du GravityInverser
     */
    @Override
    public double getSize() {
        return size;
    }
}
