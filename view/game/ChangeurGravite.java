package view.game;

import view.game.path.Modifiers;
import view.game.path.items.GravitySwitch;
import view.game.path.items.Star;


/**Change la force de gravité
 * @autor Vincent
 * @date 10/03/2018
 */
public class ChangeurGravite extends Modifiers {
    /**
     * La nouvelle force de gravité
     */
    private double force;
    public ChangeurGravite(int nbPoints, double x, double y, double force) {
        super();
       // super(new GravitySwitch(x,y,null),nbPoints);
        this.force=force;
    }

}