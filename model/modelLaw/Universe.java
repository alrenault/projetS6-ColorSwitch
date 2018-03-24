package model.modelLaw;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * Universe is a Set of Law
 * It represents all the rules in a model.game
 */
public class Universe {
	
	public enum UniverseType{
		Basic,
		Race,
		Gravity
	}
	
    private Set<Law> laws;
    private Set<LawType>banq;

    public Universe(UniverseType type) {
        laws = new HashSet<>();
        banq = new HashSet<>();
        
        Set<LawType> collisions = new HashSet<>();
        collisions.add(LawType.CollisionItem);
        collisions.add(LawType.CollisionObstacle);
        collisions.add(LawType.Interface);
        
        Set<LawType> mechanics = new HashSet<>();
        mechanics.add(LawType.Gravity);
        mechanics.add(LawType.Jump);
        mechanics.add(LawType.MoveBall);

        Set<LawType> race = new HashSet<>();
        race.add(LawType.Race);
        race.add(LawType.LockBall);
        
        switch(type) {
        	case Basic:
        		addAll(collisions);
        		break;
        		
        	case Gravity:
        		addAll(collisions);
        		addAll(mechanics);
        		break;
        		
        	case Race:
        		addAll(race);
        		break;
        		
        		
        	default: break;
        }
        
        
    }
    
    public Universe() {
        this(UniverseType.Basic);
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
