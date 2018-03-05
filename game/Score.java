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
}
