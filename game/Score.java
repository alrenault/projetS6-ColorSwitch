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
    private int scoreStared;

    public Score() {
        nbrObstaclesCrossed = 0;
        nbEtoilesRamassees = 0;
        scoreStared = 0;


    }

    /**
     * ONLY FOR TESTING !
     * @param nbrObstaclesCrossed
     * @param nbEtoilesRamassees
     * @param scoreStared
     */
    public Score(int nbrObstaclesCrossed, int nbEtoilesRamassees, int scoreStared) {
        this.nbrObstaclesCrossed = nbrObstaclesCrossed;
        this.nbEtoilesRamassees = nbEtoilesRamassees;
        this.scoreStared = scoreStared;
    }

    /**
     *
     * @param nbrObstaclesCrossed
     * @param nbEtoilesRamassees
     */
    public Score(int nbrObstaclesCrossed, int nbEtoilesRamassees) {
        this.nbrObstaclesCrossed = nbrObstaclesCrossed;
        this.nbEtoilesRamassees = nbEtoilesRamassees;
        this.scoreStared = getScore();
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

        scoreStared+=gain;
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
        return scoreStared*nbEtoilesRamassees +nbrObstaclesCrossed;
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
                ", " + scoreStared +
                "}";
    }
}
