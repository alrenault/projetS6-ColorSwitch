package game.path.shapes;

import game.Colorable;
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
 * A Shape is a group of javafx shapes
 * The goal is to represent a concrete shape that can be used for obstacles
 * This class is the pattern of all the shapes
 */
public abstract class Shapes implements Colorable {


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
     * @param colors la liste de couleurs à applique aux arcs de cercle
     * @param pos_color
     */

    /**
     *coordonnée x du centre de la forme
     */
    protected double x;
    /**
     *coordonnée y du centre de la forme
     */
    protected double y;
    /**
     *Forme
     */
    protected Group shape;
    /**
     *
     */
    protected Bounds coord;
    /**
     * L'épaisseur du trait de la forme
     */
    double width;
    /**
     *Indique la direction du mouvement de la forme
     */
    boolean mouvementDirection;
    /**
     *Indique si la rotation de la forme est linéaire ou est soumise à une accéleration
     */
    boolean acceleration;
    /**
     *
     */
    int pos_color;
    /**
     * vitesse de rotation de la forme
     */
    double mouvementSpeed;
    /**
     *La liste des couleurs de la forme
     */
    List<Color> colors;
    /**
     *
     */
    List<Color> colors_use;

    /**
     *
     * @param x coordonnée x du centre de la forme
     * @param y coordonnée y du centre de la forme
     * @param width épaisseur à transmetre
     * @param mouvementDirection direction de mouvement
     * @param acceleration acceleration du mouvement (ou non)
     * @param s Enum vitesse du mouvement [ SYMPA | MOYEN | HARD | TRESSYMPA | NONE]
     * @param colors Liste des couleurs de la forme à transmettre
     * @param pos_color
     */
    protected Shapes(double x, double y, double width, boolean mouvementDirection, boolean acceleration, Speed s, List<Color> colors, int pos_color) {
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
        this.colors_use = new ArrayList<Color>();

    }

    /**
     * Assesseur de l'épaisseur de Forme
     * @return l'épaisseur de la forme
     */
    public double getWidth() {
        return width;
    }

    protected abstract Group build();

    /**
     *
     */
    public void verifPosColor() {
        pos_color++;
        if (pos_color == colors.size())
            pos_color = 0;
    }

    /**
     *
     * @param s
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
     * Assesseur de la coordonée x de Forme
     * @return La coordonnée x
     */
    public double getX() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }


    /**
     * Assesseur de la coordonée y de Forme
     * @return La coordonnée y
     */
    public double getY() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }

    public List<Color> getColors_use() {
        return colors_use;
    }

    public boolean isOver(double _x, double _y) {
        return this.shape.contains(_x, _y);
        //return this.shape.intersects(getX(),getY(),coord.getWidth(),coord.getHeight());
    }


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
