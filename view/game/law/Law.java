package view.game.law;

import view.game.Game;

/**
 * This class represents a generic rule for the view.game
 * Creating a new rule for the view.game implies to extend Law
 */
abstract class Law {

    public abstract void apply(Game game);

}
