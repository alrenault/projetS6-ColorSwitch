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
     * Les points gagnés par étoiles
     * */
    private int scoreStored;

    public Score() {
        nbrObstaclesCrossed = 0;
        nbEtoilesRamassees = 0;
        scoreStored = 0;


    }

    /**
     * ONLY FOR TESTING !
     * @param nbrObstaclesCrossed
     * @param nbEtoilesRamassees
     * @param scoreStored
     */
    public Score(int nbrObstaclesCrossed, int nbEtoilesRamassees, int scoreStored) {
        this.nbrObstaclesCrossed = nbrObstaclesCrossed;
        this.nbEtoilesRamassees = nbEtoilesRamassees;
        this.scoreStored = scoreStored;
    }

    /**
     *
     * @param nbrObstaclesCrossed
     * @param nbEtoilesRamassees
     */
    public Score(int nbrObstaclesCrossed, int nbEtoilesRamassees) {
        this.nbrObstaclesCrossed = nbrObstaclesCrossed;
        this.nbEtoilesRamassees = nbEtoilesRamassees;
        this.scoreStored = getScore();
    }

    /**
     *
     */
    public void increaseNOC() {
        nbrObstaclesCrossed++;
    }

    /**
     *
     * @param item
     */
    public void ramasseItem(Item item) {
        if (item instanceof Star) {
            nbEtoilesRamassees++;
        }
        scoreStored += item.getNbPoints();
    }
/**
 * Retourne le nombre d'étoiles
 */

    public int getNbEtoilesRamassees() {
        return nbEtoilesRamassees;
    }

    /**
     *
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
        return "{" +
                "" + nbrObstaclesCrossed +
                ", " + nbEtoilesRamassees +
                ", " + scoreStored +
                "}";
    }
}
