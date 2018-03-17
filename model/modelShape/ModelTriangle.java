package model.modelShape;

import java.util.List;

import game.Speed;
import javafx.scene.paint.Color;

public class ModelTriangle extends ModelShape {
	
	 /**
     * Hauteur du triangle
     */
    private double height;
    
    /**
     * 
     * @param x coordonnée x du centre de gravité du triangle construit
     * @param y coordonnée y du centre de gravité du triangle construit
     * @param height hauteur du triangle construit
     * @param width epaisseur du trait du triangle
     * @param mouvementDirection indique la direction de la rotation
     * @param acceleration Indique si la rotation du  triangle est linéaire ou est soumise à une accéleration
     * @param _mouvementSpeed   vitesse de rotation du triangle
     * @param colors la liste de couleurs à applique aux traits du triangle
     * @param pos_color
     */
	protected ModelTriangle(double x, double y, double height, double width, boolean mouvementDirection, boolean acceleration, 
			Speed mouvementSpeed, List<Color> colors, int pos_color) {

		super(x, y, width, mouvementDirection, acceleration, mouvementSpeed, colors, pos_color);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

}
