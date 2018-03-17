package model.modelShape;

import game.Speed;
import game.Colorable;
import game.path.Element;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.ShapeType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Une Shapes représent un group de shapes de JavaFX
 * Le but est de représenter une forme concrete pouvant etre utilise pour les obstacles, items ou ennemis
 */

public abstract class ModelShape implements Colorable{

	/**
     *Coordonnée en x du centre de la forme
     */
    protected double x;
    /**
     *Coordonnée en y du centre de la forme
     */
    protected double y;
    
    
    
    /**
     * L'épaisseur du trait de la forme
     */
    
    double width;
    
    /**
     * Indique la direction du mouvement de la forme
     */
    
    boolean mouvementDirection;
    /**
     * Indique si la rotation de la forme est linéaire ou est soumise à une accéleration
     */
    
    boolean acceleration;
    
    /**
     * Position actuelle pour le parcours de la liste de couleurs
     */
    int pos_color;
    
    /**
     * Vitesse de rotation de la forme
     */
    double mouvementSpeed;
    
    /**
     * L'ensemble de couleurs que l'on peut utiliser
     */
    List<Color> colors;
    
    /**
     * L'ensemble des couleurs utilisées par la forme
     */
    List<Color> colors_use;
    
    /**
     * Type de la forme
     */
    ShapeType type;
        
    

    /**
     *
     * @param x La coordonnée en x du centre de la forme
     * @param y La coordonnée en y du centre de la forme
     * @param width l'epaisseur de la forme
     * @param mouvementDirection La direction de mouvement
     * @param acceleration L'acceleration du mouvement (ou non)
     * @param s Enum vitesse du mouvement [ SYMPA | MOYEN | HARD | TRESSYMPA | NONE]
     * @param colors Liste des couleurs de la forme à transmettre
     * @param pos_color La position initiale pour le parcours de la liste de couleurs
     */
    protected ModelShape(double x, double y, double width, boolean mouvementDirection, boolean acceleration, Speed s, List<Color> colors, int pos_color) {
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
        

    }

    public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean isMouvementDirection() {
		return mouvementDirection;
	}

	public boolean isAcceleration() {
		return acceleration;
	}

	public int getPos_color() {
		return pos_color;
	}

	public double getMouvementSpeed() {
		return mouvementSpeed;
	}

	public List<Color> getColors() {
		return colors;
	}

	/**
     * Assesseur de l'épaisseur de la forme
     * @return l'épaisseur de la forme
     */
    public double getWidth() {
        return width;
    }

    public void verifPosColor() {
        pos_color++;
        if (pos_color == colors.size())
            pos_color = 0;
    }



	public void setPos_color(int pos_color) {
		this.pos_color = pos_color;
	}

	/**
     * Colorie une (JavaFX) Shape en fonction de l'ensemble de couleurs qui lui est associe
     * @param s La (JavaFX) Shape a colorier
     */
    public void color(Shape s) {
    	Iterator<Color> it = colors.iterator();
    	Color c = null;
    	for(int i = 0;it.hasNext() && i <= pos_color;i++){
    		c = it.next();
    	}
    	
    	if(c == null)
    		c = Color.WHITE;
        s.setFill(c);
        colors_use.add(c);
    } 



    /**
     * Assesseur de l'ensemble des couleurs utilisees par la forme
     * @return L'ensemble des couleurs utilisees par la forme
     */
    public List<Color> getColors_use() {
        return colors_use;
    }
    
    
    /**
     * Determine la vitesse de mouvement de la Forme
     */
    


	public ShapeType getType() {
		return type;
	}
}
