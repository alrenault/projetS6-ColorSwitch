package model;

/**
 * This class represents the model in the MVC pattern
 * It contains ALL the data needed for the view
 */

public class Model {
    /**
     * points gagnés par ramassage d'etoiles
     */

    public final double points_star;
    /**
     * Taille de la fenetre en X
     */
    public double screen_sizeX;
    /**
     * Taille de la fenetre en Y
     */
    public double screen_sizeY;


    public Model(double screen_sizeX, double screen_sizeY, double points_star) {
        this.screen_sizeX = screen_sizeX;
        this.screen_sizeY = screen_sizeY;
        this.points_star = points_star;
    }

    public double getPoints_star() {
        return points_star;
    }
}
