package game;

/**
 * @autor Vincent
 * @date 16/02/2018
 */
public class Score {

    private int nbrObstaclesCrossed;

    public Score() {
        nbrObstaclesCrossed=0;

    }

    public void increaseNOC() {
        nbrObstaclesCrossed++;
    }
    public int getNbrObstaclesCrossed() {
        return nbrObstaclesCrossed;
    }
    //TODO
    public double getScore() {
        return nbrObstaclesCrossed;
    }
}
