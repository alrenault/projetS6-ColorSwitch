package model.modelShape;

import java.util.List;

import view.game.Speed;
import javafx.scene.paint.Color;
import model.ShapeType;

/**
 *
 */
public class ModelHLine extends ModelShape {
	/**
	 *Longueur de la ligne
	 */
	private double length;
	/**
	 * indique si on active les allez-retour
	 */
	private boolean reverse;
	/**
	 *Le nombre de segments (rectangle ) de la ligne
	 */
	private int nbr_seg;
	/**
	 * Le point d'arrivée (pour l'animation )
	 */
	private double goal;


	/**
	 * Constructeur de ligne
	 * @param x Coordonnée en x de la ligne
	 * @param y Coordonnée en y de la ligne
	 * @param width La largeur d'un rectangle
	 * @param length Longueur d'un rectangle
	 * @param acceleration Active l'accélération de l'animation
	 * @param reverse Active les allez-retour
	 * @param mouvementSpeed La vitesse du mouvement
	 * @param nbr_seg Le nombre de rectangle pour la ligne
	 * @param colors L'ensemble de couleurs que l'on peut utiliser
	 * @param pos_color La position de départ dans la liste
	 * @param goal Le point d'arrivée pour l'animation
	 */
	public ModelHLine(double x, double y, double length, double width, boolean acceleration
            , boolean reverse, Speed mouvementSpeed, int nbr_seg, List<Color> colors, int pos_color, double goal) {
		super(x, y, width, true, acceleration, mouvementSpeed, colors, pos_color);
		
		this.length = length;
		this.reverse = reverse;
		this.nbr_seg = nbr_seg;
		this.goal = goal;
        type = ShapeType.Horizontal_Line;
	}

	/**
	 *Accesseur de la valeur de la longueur de la ligne
	 * @return length
	 */
	public double getLength() {
		return length;
	}

	/**
	 *Indique si l'annimation est en boucle
	 * @return reverse
	 */
	public boolean isReverse() {
		return reverse;
	}

	/**
	 *Accesseur du nombre de segments composant la ligne
	 * @return nbr_seg
	 */
	public int getNbr_seg() {
		return nbr_seg;
	}

	/**
	 *Accesseur de la valeur du point d'arrivée (pour l'animation)
	 * @return goal
	 */
	public double getGoal() {
		return goal;
	}
	
	

}
