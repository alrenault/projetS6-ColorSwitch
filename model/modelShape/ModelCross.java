package model.modelShape;

import java.util.List;

import game.path.shapes.Shapes.Speed;
import javafx.scene.paint.Color;

public class ModelCross extends ModelShape {

	/**
	 * Nombre de rectangle (par defaut 2. Pourra aussi valoir 4
	 */
    private int nbr_rect = 2;
    
    /**
     * Longueur d'un rectangle de la croix
     */
    private double length;
    
    /**
     * Constructeur plus précis de la croix
     * @param x Coordonnée en x de la croix
     * @param y Coordonnée en y de la croix
     * @param width Largeur d'un rectangle
     * @param length Longueur d'un rectangle
     * @param mouvementDirection Direction du mouvement (true sens horraire, false contre-horraire)
     * @param acceleration Permet d'activer ou de désactiver l'accélération de la croix
     * @param _mouvementSpeed La vitesse de la croix
     * @param nbr_rect Le nombre de rectangle (2 ou 4)
     * @param colors L'ensemble de couleurs que l'on peut utiliser
     * @param pos_color La position initiale pour le parcours de la liste
     */
    public ModelCross(double x, double y, double width, double length, boolean mouvementDirection, boolean acceleration,
                 Speed _mouvementSpeed, int nbr_rect, List<Color> colors, int pos_color) {

        super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed, colors, pos_color);
        if (nbr_rect != 2)
            this.nbr_rect = 4;

        this.length = length;
    }

}
