package game.law;

import game.Game;

/**
 * This class represents a generic rule for the game
 * Creating a new rule for the game implies to extend Law
 */
public abstract class Law {

    public abstract void apply(Game game);

}
