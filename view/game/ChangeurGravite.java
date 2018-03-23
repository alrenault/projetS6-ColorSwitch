package view.game;

import view.game.path.Modifiers;


/**
 * Change la force de gravité
 */
class ChangeurGravite extends Modifiers {
    /**
     * La nouvelle force de gravité
     */
    private double force;

    public ChangeurGravite(int nbPoints, double x, double y, double force) {
        super();
        // super(new GravitySwitch(x,y,null),nbPoints);
        this.force = force;
    }

}
