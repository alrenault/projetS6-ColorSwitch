package game;

/**
 * @autor Vincent
 * @date 16/02/2018
 */
public class Score {

    private int nbrObstaclesCrossed, nbEtoilesRamassees;
    private double scoreStared;

    public Score() {
        nbrObstaclesCrossed = 0;
        nbEtoilesRamassees = 0;
        scoreStared = 0.0;


    }

    /**
     * ONLY FOR TESTING !
     * @param nbrObstaclesCrossed
     * @param nbEtoilesRamassees
     * @param scoreStared
     */
    public Score(int nbrObstaclesCrossed, int nbEtoilesRamassees, double scoreStared) {
        this.nbrObstaclesCrossed = nbrObstaclesCrossed;
        this.nbEtoilesRamassees = nbEtoilesRamassees;
        this.scoreStared = scoreStared;
    }

    public void increaseNOC() {
        nbrObstaclesCrossed++;
    }

    public void ramasseEtoile(double gain) {

        nbEtoilesRamassees++;
    }


    public int getNbEtoilesRamassees() {
        return nbEtoilesRamassees;
    }


    public int getNbrObstaclesCrossed() {
        return nbrObstaclesCrossed;
    }


    //TODO
    public double getScore() {
        return scoreStared;
    }

    @Override
    public String toString() {
        return "{" +
                "" + nbrObstaclesCrossed +
                ", " + nbEtoilesRamassees +
                ", " + scoreStared +
                "}";
    }
}
