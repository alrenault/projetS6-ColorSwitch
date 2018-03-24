package model.game;

import model.ItemType;
import model.modelItem.ModelItem;

/**
 * Classe représentant le score d'un joueur
 */
public class Score {
    private static final int nbPointsParObstacle = 5;
    /**
     * Le nombre d'Obstacles franchis
     */
    private Integer nbrObstaclesCrossed;

    /**
     * Le nombre d'étoiles rammassées
     */
    private Integer nbEtoilesRamassees;

    /**
     * Le score calculé
     */
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
     * ONLY FOR TESTING ET DB !
     * Utilisé uniquement dans populate
     *
     * @param nbrObstaclesCrossed Le nombre d'Obstacles franchis
     * @param nbEtoilesRamassees  Le nombre d'étoiles rammassées
     */
    public Score(Integer nbrObstaclesCrossed, Integer nbEtoilesRamassees) {
        assert (nbrObstaclesCrossed >= 0);
        assert (nbEtoilesRamassees >= 0);
        this.nbrObstaclesCrossed = nbrObstaclesCrossed;
        this.nbEtoilesRamassees = nbEtoilesRamassees;
        this.scoreStored=0;
        this.scoreStored = getScore();
    }

    /**
     * Constructeur de Score complet (uniquement dans DB)
     *
     * @param nbrObstaclesCrossed Le nombre d'Obstacles franchis
     * @param nbEtoilesRamassees  Le nombre d'étoiles rammassées
     * @param scoreStored         Le score
     */
    public Score(Integer nbrObstaclesCrossed, Integer nbEtoilesRamassees, Integer scoreStored) {
        assert (nbrObstaclesCrossed >= 0);
        assert (nbEtoilesRamassees >= 0);
        this.nbrObstaclesCrossed = nbrObstaclesCrossed;
        this.nbEtoilesRamassees = nbEtoilesRamassees;
        this.scoreStored = scoreStored;
    }

    /**
     * Augmente le score du joueur avec le nombre de points associé à l'item
     * Et met à jour les nbs
     *
     * @param modelItem me ModelItem en collision avec le joueur
     */
    public void ramasseItem(ModelItem modelItem) {
        assert (modelItem != null);
        if (modelItem.getType() == ItemType.Star) {
            nbEtoilesRamassees++;
        }
        if (modelItem.getType() == ItemType.InvisibleLine) {
            nbrObstaclesCrossed++;
        }

        scoreStored += modelItem.getNbPoints();
    }

    /**
     * Retourne le nombre d'étoiles
     *
     * @return nbEtoiles
     */
    public Integer getNbEtoilesRamassees() {
        return nbEtoilesRamassees;
    }

    /**
     * Accesseur du nombre d'obsctacles
     *
     * @return le nombre d'obstacles franchis
     */
    public Integer getNbrObstaclesCrossed() {
        return nbrObstaclesCrossed;
    }


    /**
     * Accesseur du score calculé selon les données de (this)
     * @return Le score calculé selon les données
     */

    public Integer getScore() {
        return scoreStored + nbrObstaclesCrossed * nbPointsParObstacle;
    }

    /**
     * Only for tests
     *
     * @return le contenu de this
     */
    @Override
    public String toString() {
        return "{ " + nbrObstaclesCrossed + ", " + nbEtoilesRamassees + ", " + scoreStored + " }";
    }
}