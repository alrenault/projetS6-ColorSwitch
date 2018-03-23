package model.modelItem;

import model.ItemType;

/**
 * Modele de Modifieur de gravité
 */
public class ModelGravitySwitch extends ModelItem {

    /**
     * La taille du modifieur de gravité
     */
    private double size;
    /**
     * Le coeficient de gravité (nouvel)
     */
    private double coefForce;

    /**
     * Constructeur
     *
     * @param x         coordonnée x de l'objet
     * @param y         coordonnée y de l'objet
     * @param coefForce coeficient de gravité
     * @param type      Le type d'Item (GravitySwitch)
     */

    public ModelGravitySwitch(double x, double y, double coefForce, ItemType type) {
        super(x, y, null, 5, type);
        this.size = 3.0;
        this.coefForce = coefForce;
    }

    /**
     * Accesseur de la valeur de taille du modifieur de gravité
     *
     * @return La taille du modifieur de gravité
     */
    public double getSize() {
        return size;
    }

    /**
     * Accesseur de la valeur du coeficient de gravité
     *
     * @return Le coeficient de gravité
     */
    public double getCoefForce() {
        return coefForce;
    }


}
