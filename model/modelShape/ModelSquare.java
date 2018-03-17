package model.modelShape;

import java.util.List;

import game.Speed;
import javafx.scene.paint.Color;

public class ModelSquare extends ModelShape {

	private double length;
	
	/**
	 * 
	 * @param x La coordonnee en x du centre du carre
     * @param y La coordonnee en y du centre du carre
     * @param length La longueur d'un cote du carre
     * @param width La largeur des rectangles constituant les cotes du carres
     * @param mouvementDirection Le sens de rotation (true : dans le sen horraire, false contre-horraire)
     * @param acceleration Active l'acceleration du mouvement
     * @param mouvementSpeed La vitesse du mouvement
     * @param colors La liste des couleurs de la forme à transmettre
     * @param pos_color La position initiale pour le parcours de la liste de couleurs
	 */
	protected ModelSquare(double x, double y, double length, double width,
            boolean mouvementDirection, boolean acceleration, Speed mouvementSpeed, List<Color> colors, int pos_color) {
		super(x, y, width, mouvementDirection, acceleration, mouvementSpeed, colors, pos_color);

		this.length = length;
	}

	public double getLength() {
		return length;
	}
	

}
