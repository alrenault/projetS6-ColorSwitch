package model.game;

import model.game.path.Modifiers;

/**
 * Change le sens de gravité
 */
class InverserGravity extends Modifiers {
    public InverserGravity(int nbPoints, double x, double y) {
        super();
        //super(new GravitySwitch(x,y,null),nbPoints);
    }
}
