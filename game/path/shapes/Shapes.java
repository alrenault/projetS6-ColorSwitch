package game.path.shapes;

import game.Colorable;
import game.path.Element;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.modelShape.ModelCircle;
import model.modelShape.ModelCross;
import model.modelShape.ModelHLine;
import model.modelShape.ModelShape;
import model.modelShape.ModelSquare;
import model.modelShape.ModelTriangle;
import model.modelShape.ModelVLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Une Shapes représent un group de shapes de JavaFX
 * Le but est de représenter une forme concrete pouvant etre utilise pour les obstacles, items ou ennemis
 */

public abstract class Shapes extends Element{

	/**
     *Coordonnée en x du centre de la forme
     */
   // protected double x;
    /**
     *Coordonnée en y du centre de la forme
     */
   // protected double y;
    
    
    /**
     * Objet permettant de manipuler les coordonnees (et la largeur et hauteur) de la forme) 
     */
    //protected Bounds coord;
    
    /**
     * L'épaisseur du trait de la forme
     */
    
   // double width;
    
    /**
     * Indique la direction du mouvement de la forme
     */
    
   // boolean mouvementDirection;
    /**
     * Indique si la rotation de la forme est linéaire ou est soumise à une accéleration
     */
    
    //boolean acceleration;
    
    /**
     * Position actuelle pour le parcours de la liste de couleurs
     */
    //int pos_color;
    
    /**
     * Vitesse de rotation de la forme
     */
    //double mouvementSpeed;
    
    /**
     * L'ensemble de couleurs que l'on peut utiliser
     */
    //List<Color> colors;
    
    /**
     * L'ensemble des couleurs utilisées par la forme
     */
    //List<Color> colors_use;
    
    
    
    /**
     * Patron de la forme
     */
    protected ModelShape model_shape;
    
    
    


    /**
     * Constructeur d'une Shapes
     * @param x La coordonnée en x du centre de la forme
     * @param y La coordonnée en y du centre de la forme
     * @param width l'epaisseur de la forme
     * @param mouvementDirection La direction de mouvement
     * @param acceleration L'acceleration du mouvement (ou non)
     * @param s Enum vitesse du mouvement [ SYMPA | MOYEN | HARD | TRESSYMPA | NONE]
     * @param colors Liste des couleurs de la forme à transmettre
     * @param pos_color La position initiale pour le parcours de la liste de couleurs
     */
   /* protected Shapes(double x, double y, double width, boolean mouvementDirection, boolean acceleration, Speed s, List<Color> colors, int pos_color) {
        super();
    	this.x = x;
        this.y = y;
        this.width = width;

        this.mouvementDirection = mouvementDirection;
        this.acceleration = acceleration;
        switch (s) {
            case SYMPA:
                mouvementSpeed = 6.0;
                break;
            case MOYEN:
                mouvementSpeed = 4.5;
                break;
            case HARD:
                mouvementSpeed = 3.0;
                break;
            case TRESSYMPA:
                mouvementSpeed = 7.0;
                break;
            case NONE:
                mouvementSpeed = 0.0;
                break;
        }

        this.colors = colors;
        if (pos_color <= 0)
            this.pos_color = 0;
        else {
            this.pos_color = pos_color % colors.size();
        }
        this.colors_use = new ArrayList<>();
        //this.shape = build();
        //check();

    }*/
    
    protected Shapes(ModelShape modelShape) {
    	super();
    	model_shape = modelShape;
    	model_shape.setGroup_shape(buildShape(model_shape));
    	//model_shape.setCoord(model_shape.getGroup_shape().localToScene(model_shape.getGroup_shape().getBoundsInLocal()));
    	//group_shape = buildShape();
    	
    }

	/**
     * Assesseur de l'épaisseur de la forme
     * @return l'épaisseur de la forme
     */
   /* public double getWidth() {
        return width;
    }*/

    /**
     * Génère la forme
     * @return Le Group représentant la forme
     */
   /* protected Group build() {
    	return buildShape();
    }*/

    protected abstract Group buildShape(ModelShape ms);

	public ModelShape getModel_shape() {
		return model_shape;
	}

    

	
}
