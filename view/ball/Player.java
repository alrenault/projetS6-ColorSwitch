package view.ball;


import javafx.scene.paint.Color;
import model.modelBall.Ball;
import view.path.Element;

/**
 * Une balle générique représentant le joueur
 * Pour créer une balle, vous devez étendre cette classe
 */
public abstract class Player extends Element {

    /**
     * Le moèle utilisé par le joueur
     */
    Ball model_ball;

    /**
     * Couleur de la Balle
     */
    private Color color;

    /**
     * La coordonnée en x du joueur
     */
    private double x;

    /**
     * La coordonnée en y du joueur
     */
    private double y;

    /**
     * Application de la gravité
     */
    public abstract void applyGravity();

    /**
     * Application de l'action 'jump'
     */
    public abstract void jump();

    /**
     * Accesseur de coordonée x de la Balle
     *
     * @return La coordonée x de la Balle
     */
    public double getX() {
        return x;
    }


    /**
     * Accesseur de coordonnée y de la Balle
     *
     * @return La coordonnée y de la Balle
     */
    public double getY() {
        return y;
    }

    /**
     * Accesseur de la couleur utilisée par le joueur
     *
     * @return L couleur utilisée par le joueur
     */
    public Color getColor() {
        return color;
    }

    /**
     * Mutateur de la couleur utilisée par le joueur
     *
     * @param color La nouvelle couleur
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Accesseur de la taille de la balle du joueur
     *
     * @return La taille de la balle du joueur
     */
    public abstract double getSize();

    /**
     * Accesseur du modèle de la balle représentant le joueur
     *
     * @return Le modèle de la balle représentant le joueur
     */
    public Ball getBall() {
        return model_ball;
    }


}
