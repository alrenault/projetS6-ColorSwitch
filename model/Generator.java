package model;

import game.Game;
import game.ball.Player;
import game.law.Universe;
import game.path.Path;

/**
 * This class is an automatic generator of games for Color Switch
 */
public class Generator {
    /**
     *
     */
    private Game game;

    /**
     *
     * @param _balle
     * @param _path
     * @param _universe
     */
    public Generator(Player _balle, Path _path, Universe _universe) {
        game = new Game(_balle, _path, _universe);
    }


}
