package game;
import java.util.List;
import javafx.scene.paint.Color;
import game.path.items.Star;

/**
 * @autor Vincent
 * @date 25/02/2018
 */
public class Etoile {
    Star s;
    private double nbPoints;

    /**
     *
     * @param nbPoints
     * @param x
     * @param y
     * @param size
     * @param colors
     */
    public Etoile(double nbPoints, double x, double y, double size, List<Color> colors) {
        this.s = new Star(x, y, size,colors);
        this.nbPoints = nbPoints;
    }

    /**
     *
     * @return
     */
    public double getNbPoints() {
        return nbPoints;
    }

}
