package view.game.law;

import view.game.Game;

import java.util.HashSet;
import java.util.Set;


/**
 * Universe is a Set of Law
 * It represents all the rules in a view.game
 */
public class Universe {
    private Set<Law> laws;

    public Universe() {
        laws = new HashSet<>();
    }


    /**
     * Vide les lois
     */
    public void cleanUniverse(){
        this.laws.clear();
    }
}
