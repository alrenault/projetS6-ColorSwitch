package model.modelShape;

import javafx.scene.paint.Color;
import model.ShapeType;
import model.game.Speed;

import java.util.List;

/**
 * Modèle d'un triangle
 */
public class ModelTriangle extends ModelShape {

    /**
     * Hauteur du triangle
     */
    private double height;

    /**
     * Constructeur d'un modèle de triangle
     *
     * @param x                  coordonnée x du centre de gravité du triangle construit
     * @param y                  coordonnée y du centre de gravité du triangle construit
     * @param height             hauteur du triangle construit
     * @param width              epaisseur du trait du triangle
     * @param mouvementDirection indique la direction de la rotation
     * @param acceleration       Indique si la rotation du  triangle est linéaire ou est soumise à une accéleration
     * @param mouvementSpeed     vitesse de rotation du triangle
     * @param colors             la liste de couleurs à appliquer aux trapezes du triangle
     * @param pos_color          L'indice de liste de colors
     */
    public ModelTriangle(double x, double y, double height, double width, boolean mouvementDirection, boolean acceleration,
                         Speed mouvementSpeed, List<Color> colors, int pos_color) {

        super(x, y, width, mouvementDirection, acceleration, mouvementSpeed, colors, pos_color);
        this.height = height;
        type = ShapeType.Triangle;
    }

    /**
     * Accesseur de la valeur de la hauteur du triangle
     *
     * @return La hauteur du triangle
     */
    public double getHeight() {
        return height;
    }

}
