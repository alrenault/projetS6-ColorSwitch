package game;

import game.path.items.Star;

/**
 * @autor Vincent
 * @date 25/02/2018
 */
public class Etoile {
    Star s;
    private double nbPoints;


    public Etoile(double nbPoints, double x, double y, double size) {
        this.s = new Star(x, y, size);
        this.nbPoints = nbPoints;
    }

    public double getNbPoints() {
        return nbPoints;
    }

}
