package game;

import game.ball.Ball;
import game.law.Universe;
import game.path.Path;

/**
 * This class is used to create a game
 * You have to use it in the model
 * Only contains data
 */

public class Game {

    Ball balle;
    Path path;
    Universe universe;

    public Game(Ball _balle, Path _path, Universe _universe) {
        this.balle = _balle;
        this.path = _path;
        this.universe = _universe;
    }

    public Game() {
        System.out.println("Game()");
    }

    public void applyGravity() {
        balle.applyGravity();
    }
}
