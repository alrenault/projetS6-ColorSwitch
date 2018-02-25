package game;

/**
 * @autor Vincent
 * @date 16/02/2018
 */
public class Score {

    private int nbrObstaclesCrossed, nbEtoilesRamassees;

    public Score() {
        nbrObstaclesCrossed=0;
        nbEtoilesRamassees=0;

    }


    public void increaseNOC() {
        nbrObstaclesCrossed++;
    }
    public void ramasseEtoile() {
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
        return nbrObstaclesCrossed*nbEtoilesRamassees;
    }
}
