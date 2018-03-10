package game;
import java.util.List;
import javafx.scene.paint.Color;
import game.path.items.Star;

/**
 * @autor Vincent
 * @date 25/02/2018
 */
public class Etoile {
    /**
     * Forme de l'etoile
     * */
    Star s;

    /**
     * Le nombre de points obtenus en attrapant cette étoile
     * */
    private double nbPoints;

    /**
     *
     * @param nbPoints Le nombre de points obtenus en attrapant cette étoile
     * @param x coordonnée x de l'etoile
     * @param y coordonnée y de l'etoile
     * @param size la taille de l'étoile (diametre)
     * @param colors
     */
    public Etoile(double nbPoints, double x, double y, double size, List<Color> colors) {
        this.s = new Star(x, y, size,colors);
        this.nbPoints = nbPoints;
    }

    /**
     *
     * @return Le nombre de points obtenus en attrapant cette étoile
     */
    public double getNbPoints() {
        return nbPoints;
    }

}
