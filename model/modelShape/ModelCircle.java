package model.modelShape;

import java.util.List;

import game.Speed;
import javafx.scene.paint.Color;

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
     * @param colors L'ensemble de couleurs que l'on peut utiliser
     * @param pos_color
     */
    public ModelCircle(double xCenter, double yCenter, double radial, double width, int arcs_nbr, boolean rotationDirection,
                  boolean acceleration, Speed vitesseRotation, List<Color> colors, int pos_color) {

        super(xCenter, yCenter, width, rotationDirection, acceleration, vitesseRotation, colors, pos_color);
        
        this.radial = radial;
        this.arcs_nbr = arcs_nbr;
        

    }


	public double getRadial() {
		return radial;
	}

	public int getArcs_nbr() {
		return arcs_nbr;
	}

}
