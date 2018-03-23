package model.modelItem;

import javafx.scene.paint.Color;
import model.ItemType;

import java.util.List;

/**
 *
 */
public class ModelInvisibleLine extends ModelItem {
    /**
     * La longueur de la ligne Invisible
     */
    private double length;


    /**
     * @param x        coordonnée x de la ligne
     * @param y        coordonnée y de la ligne
     * @param colors   L'ensemble de couleurs que l'on peut utiliser pour la ligne
     * @param nbPoints nombre de points gagnés en touchant la ligne
     * @param type     Le type d'Item
     * @param length
     */
    public ModelInvisibleLine(double x, double y, List<Color> colors, int nbPoints, ItemType type, double length) {
        super(x, y, colors, nbPoints, type);
        this.length = length;
    }

    /**
     * Accesseur de la valeur de la longueur de la ligne Invisible
     *
     * @return la longueur de la ligne Invisible
     */
    public double getLength() {
        return length;
    }


}
