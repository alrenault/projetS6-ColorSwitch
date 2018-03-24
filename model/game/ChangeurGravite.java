package model.game;

import view.path.Modifiers;


/**
 * Change la force de gravité
 */
class ChangeurGravite extends Modifiers {
    /**
     * La nouvelle force de gravité
     */
    private double force;

    /**
     *
     * @param nbPoints le nombre de points gagné lors du rammassage du changeur
     * @param x Centre x du spawn
     * @param y Centre y du spawn
     * @param force Le coef de gravité
     */
    public ChangeurGravite(int nbPoints, double x, double y, double force) {
        super();
        // super(new GravitySwitch(x,y,null),nbPoints);
        this.force = force;
    }

}
