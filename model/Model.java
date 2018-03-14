package model;

import javafx.scene.Scene;

/**
 * This class represents the model in the MVC pattern
 * It contains ALL the data needed for the view
 */

public class Model {
    /**
     * points gagnés par ramassage d'etoiles
     */

    public int points_star;
    /**
     * Taille de la fenetre en X
     */
    public double screen_sizeX;
    /**
     * Taille de la fenetre en Y
     */
    public double screen_sizeY;
    
    public Model() {
    	
    }


    public Model(double screen_sizeX, double screen_sizeY, int points_star) {
        this.screen_sizeX = screen_sizeX;
        this.screen_sizeY = screen_sizeY;
        this.points_star = points_star;
    }

    public int getPoints_star() {
        return points_star;
    }


	public void createGame(Scene scene) {
		// TODO Auto-generated method stub
		
	}
}
