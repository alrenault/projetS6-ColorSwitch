package model.modelItem;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.ItemType;
import model.game.Colorable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Modèle de la balle changeant la couleur
 */
public class ModelBallColorSwitch extends ModelItem implements Colorable {
    /**
     * La taille de la ballCS
     */
    private double size;

    /**
     * La position à laquelle on commence à parcourir la liste de couleurs
     */
    private Integer pos_color = 0;

    /**
     * La liste des couleurs utilisées
     */
    private List<Color> colors_use;


    /**
     * Constructeur d'un modèle de BallColorSwitch
     *
     * @param x      Coordonnée x du modèle de la BallColorSwitch
     * @param y      Coordonnée y du modèle de la BallColorSwitch
     * @param colors L'ensemble des couleurs utilisées
     * @param type   Le type de l'Item
     */
    public ModelBallColorSwitch(double x, double y, List<Color> colors, ItemType type) {
        super(x, y, colors, 10, type);
        this.size = 12;

        this.colors_use = new ArrayList<>();
    }

    /**
     * Accesseur de la pos_color
     *
     * @return La pos_color
     */
    public Integer getPos_color() {
        return pos_color;
    }

    /**
     * Mutateur de la pos_color
     *
     * @param pos_color La nouvelle position
     */
    public void setPos_color(int pos_color) {
        this.pos_color = pos_color;
    }

    /**
     * Accesseur de la taille de la balle
     *
     * @return La taille de la balle
     */
    public double getSize() {
        return size;
    }

    /**
     * Accesseur de la liste de couleur utilisées
     *
     * @return La liste de couleurs utilsées
     */
    public List<Color> getColors_use() {
        return colors_use;
    }

    /**
     * Mutateur de la liste de couleurs utilisées
     *
     * @param colors_use La nouvelle liste de couleurs utilisées
     */
    public void setColors_use(List<Color> colors_use) {
        this.colors_use = colors_use;
    }

    public void verifPosColor() {
        pos_color++;
        if (pos_color == colors.size())
            pos_color = 0;
    }

    public void color(Shape s) {
        Iterator<Color> it = colors.iterator();
        Color c = null;
        for (int i = 0; it.hasNext() && i <= pos_color; i++) {
            c = it.next();
        }

        if (c == null)
            c = Color.WHITE;
        s.setFill(c);
    }


}
