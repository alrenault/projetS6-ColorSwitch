package game.path.shapes;

import game.Colorable;
import game.path.Element;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Une Shapes représent un group de shapes de JavaFX
 * Le but est de représenter une forme concrete pouvant etre utilise pour les obstacles, items ou ennemis
 */

public abstract class Shapes extends Element implements Colorable{

	/**
     *Coordonnée en x du centre de la forme
     */
    protected double x;
    /**
     *Coordonnée en y du centre de la forme
     */
    protected double y;
    /**
     * Le groupe représentant la forme
     */
    protected Group shape;
    
    /**
     * Objet permettant de manipuler les coordonnees (et la largeur et hauteur) de la forme) 
     */
    protected Bounds coord;
    
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
     * L'ensemble des (JavaFX) Shape utilisées par la forme
     */
    List<Shape> shape_list;

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
    protected Shapes(double x, double y, double width, boolean mouvementDirection, boolean acceleration, Speed s, List<Color> colors, int pos_color) {
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

    }

    /**
     * Assesseur de l'épaisseur de la forme
     * @return l'épaisseur de la forme
     */
    public double getWidth() {
        return width;
    }

    /**
     * Génère la forme
     * @return Le Group représentant la forme
     */
    protected Group build() {
    	return buildShape();
    }

    protected abstract Group buildShape();

    public void verifPosColor() {
        pos_color++;
        if (pos_color == colors.size())
            pos_color = 0;
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
     * Assesseur de la coordonée en x de la forme
     * @return La coordonnée en x de la forme
     */
    public double getX() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }


    /**
     * Assesseur de la coordonée en y de la forme
     * @return La coordonnée en y de la forme
     */
    public double getY() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    /**
     * Assesseur des coordonnees de la forme sous la forme d'un Point2D
     * @return Les coordonnees de ka forme
     */
    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }

    /**
     * Assesseur de l'ensemble des couleurs utilisees par la forme
     * @return L'ensemble des couleurs utilisees par la forme
     */
    public List<Color> getColors_use() {
        return colors_use;
    }

    /**
     * 
     * @param _x
     * @param _y
     * @return
     */
    public boolean isOver(double _x, double _y) {
        return this.shape.contains(_x, _y);
        //return this.shape.intersects(getX(),getY(),coord.getWidth(),coord.getHeight());
    }
    
    /**
     * Retourne le groupe correspondant a la forme
     * @return Le groupe correspondant a la forme
     */
    public Group getShape() {
    	return shape;
    }
    
    /**
     * Determine la vitesse de mouvement de la Forme
     */
    public enum Speed {
        SYMPA,
        MOYEN,
        HARD,
        TRESSYMPA,
        NONE
    }
}
