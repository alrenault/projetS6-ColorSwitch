package game;

import game.path.items.Star;
import model.ItemType;
import model.modelItem.ModelItem;
import model.modelItem.ModelStar;

/**
 * @autor Vincent
 * @date 16/02/2018
 */
public class Score {
    private static final int nbPointsParObstacle=50;
    /**
     *Le nombre d'Obstacles franchis
     * */
    private Integer nbrObstaclesCrossed;

    /**
     * Le nombre d'étoiles rammassées
     * */
    private Integer nbEtoilesRamassees;

    /**
     * Le score calculé
     * */
    private Integer scoreStored;

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
     * Utilisé uniquement dans populate
     * @param nbrObstaclesCrossed Le nombre d'Obstacles franchis
     * @param nbEtoilesRamassees Le nombre d'étoiles rammassées
     * @param scoreStored Le score calculé
     */
    public Score(Integer nbrObstaclesCrossed, Integer nbEtoilesRamassees, Integer scoreStored) {
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
    public void ramasseItem(ModelItem item) {
        assert (item!=null);
        System.err.println(item.getType().toString()+" "+item.getNbPoints());
        if (item.getType()== ItemType.Star) {
            nbEtoilesRamassees++;
        }

        scoreStored += item.getNbPoints();
        System.err.println(getScore());
    }
    public void incEtoile(){
    	nbEtoilesRamassees++;
    }

    /**
     * Retourne le nombre d'étoiles
     * @return nbEtoiles
     */
    public Integer getNbEtoilesRamassees() {
        return nbEtoilesRamassees;
    }

    /**
     *Accesseur du nombre d'obsctacles
     * @return le nombre d'obstacles franchis
     */
    public Integer getNbrObstaclesCrossed() {
        return nbrObstaclesCrossed;
    }


    //TODO
    /**
     * Generateur du score calculé selon les données de (this)
     */

    public Integer getScore() {
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
