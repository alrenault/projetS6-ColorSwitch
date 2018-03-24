package model.modelLaw;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * Universe is a Set of Law
 * It represents all the rules in a model.game
 */
public class Universe {

    /**
     * Ensemble des types de lois
     */
    private Set<LawType> banq;
    /**
     * Le type d'univers utilisé
     */
    private UniverseType type;

    /**
     * Constructeur de l'univers
     *
     * @param type Le type de l'univers à créer
     */
    public Universe(UniverseType type) {
        this.type = type;

        banq = new HashSet<>();

        Set<LawType> collisions = new HashSet<>();
        collisions.add(LawType.CollisionItem);
        collisions.add(LawType.CollisionObstacle);
        collisions.add(LawType.Interface);

        Set<LawType> mechanics = new HashSet<>();
        mechanics.add(LawType.Gravity);
        mechanics.add(LawType.Jump);
        mechanics.add(LawType.MoveBall);
        mechanics.add(LawType.FollowBall);

        Set<LawType> race = new HashSet<>();
        race.add(LawType.Race);
        race.add(LawType.LockBall);

        switch (type) {
            case Basic:
                addAll(collisions);
                break;

            case Gravity:
                addAll(collisions);
                addAll(mechanics);
                break;

            case Race:
                addAll(race);
                addAll(collisions);
                break;


            default:
                break;
        }


    }

    /**
     * Constructeur d'un univers basique
     */
    public Universe() {
        this(UniverseType.Basic);
    }

    /**
     * Ajoute un type de loi
     *
     * @param lawType Le type de loi a ajouter
     * @return Si le type de loi a été ajouté
     */
    public boolean add(LawType lawType) {
        return banq.add(lawType);
    }

    /**
     * Supprime un type de loi
     *
     * @param o Le type de loi a supprimer
     * @return Si le type de loi a été supprimé
     */
    public boolean remove(Object o) {
        return banq.remove(o);
    }

    /**
     * Ajoute des types de loi
     *
     * @param c Les types de loi a ajouter
     * @return Si les types de loi ont été ajouté
     */
    public boolean addAll(Collection<? extends LawType> c) {
        return banq.addAll(c);
    }

    /**
     * Vide l'ensemble de types de loi
     */
    public void clear() {
        banq.clear();
    }

    /**
     * Accesseur de l'ensemble de types de loi
     *
     * @return L'ensemble de types de loi
     */
    public Set<LawType> getBanq() {
        return banq;
    }

    /**
     * Accesseur du type d'univers
     *
     * @return Le type d'univers
     */
    public UniverseType getType() {
        return type;
    }

    /**
     * Enum des types d'univers
     */
    public enum UniverseType {
        Basic,
        Race,
        Gravity
    }
}
