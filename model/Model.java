package model;

/**
 * This class represents the model in the MVC pattern
 * It contains ALL the data needed for the view
 */
public class Model {
    public final double points_star;//points gagnés par ramassage d'etoiles
    public double screen_sizeX, screen_sizeY;


    public Model(double screen_sizeX, double screen_sizeY, double points_star) {
        this.screen_sizeX = screen_sizeX;
        this.screen_sizeY = screen_sizeY;
        this.points_star = points_star;
    }
}
