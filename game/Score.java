package game;

import game.path.items.Item;
import game.path.items.Star;

/**
 * @autor Vincent
 * @date 16/02/2018
 */
public class Score {
    private static final int nbPointsParObstacle=50;
    /**
     *Le nombre d'Obstacles franchis
     * */
    private int nbrObstaclesCrossed;

    /**
     * Le nombre d'étoiles rammassées
     * */
    private int nbEtoilesRamassees;

    /**
     * Le score calculé
     * */
    private int scoreStored;

    /**
     * Constructeur aveugle de Score  (initialiseur)
     */
    public Score() {
        nbrObstaclesCrossed = 0;
        nbEtoilesRamassees = 0;
        scoreStored = 0;


    }

    /**
     * ONLY FOR TESTING !
     * @param nbrObstaclesCrossed Le nombre d'Obstacles franchis
     * @param nbEtoilesRamassees Le nombre d'étoiles rammassées
     * @param scoreStored Le score calculé
     */
    public Score(int nbrObstaclesCrossed, int nbEtoilesRamassees, int scoreStored) {
        assert(nbrObstaclesCrossed>=0);
        assert(nbEtoilesRamassees>=0);
        assert(scoreStored>=0);
        this.nbrObstaclesCrossed = nbrObstaclesCrossed;
        this.nbEtoilesRamassees = nbEtoilesRamassees;
        this.scoreStored = scoreStored;
    }


    /**
     *Incremente le nombre d'obstacles traversés
     */
    public void increaseNOC() {
        nbrObstaclesCrossed++;
        System.err.println(nbrObstaclesCrossed);
    }

    /**
     *Augmente le score du joueur avec le nombre de points associé à l'item
     * @param item l'item en collision avec le joueur
     */
    public void ramasseItem(Item item) {
        assert (item!=null);
        if (item instanceof Star) {
            nbEtoilesRamassees++;
        }
        scoreStored += item.getNbPoints();
    }

    /**
     * Retourne le nombre d'étoiles
     * @return nbEtoiles
     */
    public int getNbEtoilesRamassees() {
        return nbEtoilesRamassees;
    }

    /**
     *Accesseur du nombre d'obsctacles
     * @return le nombre d'obstacles franchis
     */
    public int getNbrObstaclesCrossed() {
        return nbrObstaclesCrossed;
    }


    //TODO
    /**
     * Generateur du score calculé selon les données de (this)
     */

    public int getScore() {
        return scoreStored + nbrObstaclesCrossed*nbPointsParObstacle;
    }

    /**
     * Only for tests
     * @return le contenu de this
     */
    @Override
    public String toString() {
        return "{ " + nbrObstaclesCrossed +", " + nbEtoilesRamassees +", " + scoreStored +" }";
    }
}
