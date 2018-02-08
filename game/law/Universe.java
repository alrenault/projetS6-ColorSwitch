package game.law;

import game.Game;

import java.util.HashSet;
import java.util.Set;


/**
 * Universe is a Set of Law
 * It represents all the rules in a game
 */
public class Universe {
    Set<Law> laws;

    public Universe() {
        laws = new HashSet<Law>();
    }

    public void apply(Game game) {
        laws.forEach(law -> law.apply(game));
    }
}
