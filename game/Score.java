package game;

/**
 * @autor Vincent
 * @date 16/02/2018
 */
public class Score {

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
     * @param gain
     */
    public void ramasseEtoile(int gain) {
        assert (gain>0);

        scoreStored +=gain;
        nbEtoilesRamassees++;
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
        return scoreStored *nbEtoilesRamassees + nbrObstaclesCrossed;
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
