package model.modelItem;

import javafx.scene.paint.Color;
import model.ItemType;

import java.util.ArrayList;
import java.util.List;

/**
 * Modele générique d'Items
 */
public class ModelItem {

    /**
     * La liste de couleurs que l'on peut utiliser pour cet Item
     */
    List<Color> colors;
    /**
     * coordonnée X de l'Item
     */
    private double x;
    /**
     * coordonnée Y de l'Item
     */
    private double y;
    /**
     * Le nombre de points gagnés en rammassant l'Item
     */
    private int nbPoints;
    /**
     * Le type de l'Item
     */
    private ItemType type;

    /**
     * @param x        coordonnée x de l'Item
     * @param y        coordonnée y de l'Item
     * @param colors   L'ensemble de couleurs que l'on peut utiliser pour cet Item (Liste)
     * @param nbPoints nombre de points gagnés en rammassant l'Item
     * @param type     Le type d'Item
     */
    ModelItem(double x, double y, List<Color> colors, int nbPoints, ItemType type) {
        assert (x >= 0);
        assert (y >= 0);
        assert (nbPoints >= 0);
        this.x = x;
        this.y = y;
        this.nbPoints = nbPoints;
        if (colors == null) {
            List<Color> c = new ArrayList<>();
            c.add(Color.WHITE);
            this.colors = c;
        } else {
            this.colors = colors;
        }

        this.type = type;
    }

    /**
     * Accesseur de la liste des couleurs utilisables
     *
     * @return La liste des couleurs utilisables
     */
    public List<Color> getColors() {
        return colors;
    }

    /**
     * Mutateur des couleurs utilisables
     *
     * @param colors La (nouvelle) liste des couleurs utilisables
     */
    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    /**
     * Accesseur de coordonnée en x
     *
     * @return La coordonnée x
     */
    public double getX() {
        return x;
    }

    /**
     * Accesseur de coordonnée en y
     *
     * @return La coordonnée y
     */
    public double getY() {
        return y;
    }

    /**
     * Mutateur de coordonnée en y
     *
     * @param y La coordonnée en y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Accesseur du nombre de points
     *
     * @return Le nombre de points
     */
    public int getNbPoints() {
        return nbPoints;
    }

    /**
     * Accesseur du type d'Item
     *
     * @return Le type d'Item
     */
    public ItemType getType() {
        return type;
    }


}
