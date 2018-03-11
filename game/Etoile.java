package game;
import game.path.Modifiers;
import game.path.items.Star;

/**
 * @autor Vincent
 * @date 25/02/2018
 */
public class Etoile extends Modifiers {


    /**
     * @param nbPoints Le nombre de points obtenus en attrapant cette étoile
     * @param x        coordonnée x de l'etoile
     * @param y        coordonnée y de l'etoile
     * @param size     la taille de l'étoile (diametre)
     */
    public Etoile(int nbPoints, double x, double y, double size) {
        super(new Star(x, y, size / 2, null), nbPoints);
    }
}
