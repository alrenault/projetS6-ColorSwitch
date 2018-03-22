package model.modelShape;

import java.util.List;

import view.game.Speed;
import javafx.scene.paint.Color;
import model.ShapeType;

/**
 *
 */
public class ModelCircle extends ModelShape {

	/**
     * Rayon du cercle
     */
    private double radial;
    /**
     * Nombre d'arcs du cercle
     */
    private int arcs_nbr;

    /**
     * Constructeur de Cercle
     * @param xCenter coordonnée x du centre du cercle construit
     * @param yCenter coordonnée y du centre du cercle construit
     * @param radial rayon du cercle construit
     * @param width epaisseur des arcs
     * @param arcs_nbr nombre d'arcs du cercle
     * @param rotationDirection Indique si le cercle est autorisé a tourner (voir)
     * @param acceleration Indique si la rotation du  cercle est linéaire ou est soumise à une accéleration
     * @param vitesseRotation vitesse de rotation du cercle
     * @param colors L'ensemble de couleurs que l'on peut utiliser pour colorer les arcs
     * @param pos_color
     */
    public ModelCircle(double xCenter, double yCenter, double radial, double width, int arcs_nbr, boolean rotationDirection,
                  boolean acceleration, Speed vitesseRotation, List<Color> colors, int pos_color) {

        super(xCenter, yCenter, Math.min(width,radial), rotationDirection, acceleration, vitesseRotation, colors, pos_color);
        
        this.radial = Math.max(radial,width);
        this.arcs_nbr = arcs_nbr;
        type = ShapeType.Circle;
        

    }

    /**
     * Accesseur de la valeur du rayon
     * @return la valeur du rayon du cercle
     */
	public double getRadial() {
		return radial;
	}

    /**
     * Accesseur du nombre d'arcs de cercle
     * @return le nombre d'arcs de cercle
     */
	public int getArcs_nbr() {
		return arcs_nbr;
	}

}
