package model.modelShape;

import javafx.scene.paint.Color;
import model.ShapeType;
import view.game.Speed;

import java.util.List;

/**
 * Modèle d'une ligne verticale
*/
public class ModelVLine extends ModelShape {


    /**
     * Hauteur d'un rectangle
     */
    private double height;

    /**
     * Le nombre de segment formant la ligne
     */
    private int nbr_seg;

    /**
     * Point d'arrivée pour l'animation
     */
    private double goal;

    /**
     * Active les allez-retours
     */
    private boolean reverse;

    /**
     * La distance separant 2 segments
     */
    private double distanceSeparation;

    /**
     * @param x                  Coordonnée en x de la ligne
     * @param y                  Coordonnée en y de la ligne
     * @param height             La hauteur d'un rectangle
     * @param width              La largeur d'un rectangle
     * @param distanceSeparation La distance separant 2 segments
     * @param acceleration       Active l'accélération de l'animation
     * @param reverse            Active les allez-retour
     * @param mouvementSpeed     La vitesse du mouvement
     * @param nbr_seg            Le nombre de rectangle pour la ligne
     * @param colors             L'ensemble de couleurs que l'on peut utiliser
     * @param pos_color          La position de départ dans la liste
     * @param goal               Le point d'arrivée pour l'animation
     */
    public ModelVLine(double x, double y, double height, double width, double distanceSeparation, boolean acceleration
            , boolean reverse, Speed mouvementSpeed, int nbr_seg, List<Color> colors, int pos_color, double goal) {
        super(x, y, width, true, acceleration, mouvementSpeed, colors, pos_color);

        this.height = height;
        this.nbr_seg = nbr_seg;
        this.goal = goal;
        this.reverse = reverse;
        this.distanceSeparation = distanceSeparation;
        type = ShapeType.Vertical_Line;
    }

    /**
     * Accesseur de la hauteur d'un rectangle
     * @return La hauteur d'un rectangle
     */
    public double getHeight() {
        return height;
    }

    /**
     * Accesseur du nombre de rectangle
     * @return Le nombre de rectangle
     */
    public int getNbr_seg() {
        return nbr_seg;
    }

    /**
     * Accesseur du point d'arrivé en y 
     * @return La point d'arrivé en y
     */
    public double getGoal() {
        return goal;
    }

    /**
     * Teste si la ligne peut faire des allez-retour
     * @return Si la ligne peut faire des allez-retour
     */
    public boolean isReverse() {
        return reverse;
    }

    /**
     * Accesseur de la distance séparant 2 rectangles
     * @return La distance séparant 2 rectangles
     */
    public double getDistanceSeparation() {
        return distanceSeparation;
    }


}
