package model.modelShape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.ShapeType;
import model.game.Colorable;
import model.game.Speed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Un modèle d'une Shapes représentant un group de shapes de JavaFX
 * Le but est de représenter une forme concrete pouvant etre utilise pour les obstacles, items ou une simple forme
 */

public abstract class ModelShape implements Colorable {

    /**
     * Type de la forme
     */
    ShapeType type;
    /**
     * Coordonnée en x du centre de la forme
     */
    private double x;
    /**
     * Coordonnée en y du centre de la forme
     */
    private double y;
    /**
     * L'épaisseur du trait de la forme
     */

    private double width;
    /**
     * Indique la direction du mouvement de la forme
     */

    private boolean mouvementDirection;
    /**
     * Indique si la rotation de la forme est linéaire ou est soumise à une accéleration
     */

    private boolean acceleration;
    /**
     * Position actuelle pour le parcours de la liste de couleurs
     */
    private int pos_color;
    /**
     * Vitesse de rotation de la forme
     */
    private double mouvementSpeed;
    /**
     * L'ensemble de couleurs que l'on peut utiliser
     */
    private List<Color> colors;
    /**
     * L'ensemble des couleurs utilisées par la forme
     */
    private List<Color> colors_use;


    /**
     * @param x                  La coordonnée en x du centre de la forme
     * @param y                  La coordonnée en y du centre de la forme
     * @param width              l'epaisseur de la forme
     * @param mouvementDirection La direction de mouvement
     * @param acceleration       L'acceleration du mouvement (ou non)
     * @param s                  Enum vitesse du mouvement [ SYMPA | MOYEN | HARD | TRESSYMPA | NONE]
     * @param colors             Liste des couleurs de la forme à transmettre
     * @param pos_color          La position initiale pour le parcours de la liste de couleurs
     */
    ModelShape(double x, double y, double width, boolean mouvementDirection, boolean acceleration, Speed s, List<Color> colors, int pos_color) {
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

    /**
     * Accesseur de la position en x
     * @return La position en x
     */
    public double getX() {
        return x;
    }

    /**
     * Accesseur de la position en y
     * @return La position en y
     */
    public double getY() {
        return y;
    }

    /**
     * Accesseur de la direction du mouvement 
     * @return La direction du mouvement
     */
    public boolean isMouvementDirection() {
        return mouvementDirection;
    }

    /**
     * Renvoie si la shape à une accélération ou non
     * @return Si la shape à une accélération ou non
     */
    public boolean isAcceleration() {
        return acceleration;
    }

    /**
     * Accesseur de la pos_color
     * @return La pos_color
     */
    public int getPos_color() {
        return pos_color;
    }

    /**
     * Mutateur de la pos_color
     * @param pos_color La nouvelle pos_color
     */
    public void setPos_color(int pos_color) {
        this.pos_color = pos_color;
    }

    /**
     * Accesseur de la vitesse de mouvement de la Forme
     * @return La vitesse du mouvement
     */
    public double getMouvementSpeed() {
        return mouvementSpeed;
    }

    /**
     * Accesseur de la liste de couleurs à utiliser
     * @return La liste de couleurs à utiliser
     */
    public List<Color> getColors() {
        return colors;
    }

    /**
     * Accesseur de l'épaisseur de la forme
     * @return L'épaisseur de la forme
     */
    public double getWidth() {
        return width;
    }

    
    public void verifPosColor() {
        pos_color++;
        if (pos_color == colors.size())
            pos_color = 0;
    }

   
    public void color(Shape s) {
        Iterator<Color> it = colors.iterator();
        Color c = null;
        for (int i = 0; it.hasNext() && i <= pos_color; i++) {
            c = it.next();
        }

        if (c == null)
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
     * Accesseur du type du modèle de la forme
     * @return Le type du modèle de la forme
     */
    public ShapeType getType() {
        return type;
    }
}
