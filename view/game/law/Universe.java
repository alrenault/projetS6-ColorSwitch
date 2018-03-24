package view.game.law;

import view.game.Game;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * Universe is a Set of Law
 * It represents all the rules in a view.game
 */
public class Universe {
    private Set<Law> laws;
    private Set<LawType>banq;

    public Universe() {
        laws = new HashSet<>();
        banq = new HashSet<>();
    }


    public boolean add(LawType lawType) {
        return banq.add(lawType);
    }

    public boolean remove(Object o) {
        return banq.remove(o);
    }

    public boolean addAll(Collection<? extends LawType> c) {
        return banq.addAll(c);
    }

    public void clear() {
        banq.clear();
    }

    public Set<LawType> getBanq() {
        return banq;
    }

    /**
     * Vide les lois
     */
    public void cleanUniverse(){
        this.laws.clear();
    }
}
