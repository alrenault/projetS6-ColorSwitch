package DB;

import game.Score;
import java.lang.String;

/**Objet de gestion des interactions avec la base de données
 * @autor Vincent
 * @date 07/03/2018
 */
public class Record {
    private String pseudoJoueur;
    private Score scoreJoueur;
    private String dateRecordJoueur;

    /**
     * Constructeur de Record
     * @param pseudoJoueur le pseudo du joueur
     * @param scoreJoueur  le score du joueur
     * @param dateRecordJoueur la date du record
     */
    public Record(String pseudoJoueur, Score scoreJoueur, String dateRecordJoueur) {
        this.pseudoJoueur = pseudoJoueur;
        this.scoreJoueur = scoreJoueur;
        this.dateRecordJoueur = dateRecordJoueur;
    }

    /**
     * Accesseur de pseudoJoueur
     * @return pseudoJoueur
     */
    public String getPseudoJoueur() {
        return pseudoJoueur;
    }

    /**
     * Accesseur de ScoreJoueur
     * @return scoreJoueur contenu dans le Score
     */
    public Score getScoreJoueurRecord() {
        return scoreJoueur;
    }

    /**
     * Accesseur du nombre d'etoiles ramassées
     * @return le nombre d'etoiles ramassées contenu dans le Score
     */
     public int getNbEtoilesRamassees() {
        return scoreJoueur.getNbEtoilesRamassees();
    }

    /**
     * Accesseur du nombre d'obstacles traversés
     * @return le nombre d'obstacles traversés contenu dans le Score
     */
    public int getNbrObstaclesCrossed() {
        return scoreJoueur.getNbrObstaclesCrossed();
    }

    /**
     * Assesseur du score du joueur
     * @return le score du joueur contenu dans le Score
     */
    public int getScore() {
        return scoreJoueur.getScore();
    }

    /**
     * Accesseur de la date du score du joueur
     * @return La date du score casté en String
     */
    public String getDateRecordJoueur() {
        return dateRecordJoueur;
    }

    /**
     * Pour tests
     * @return le toString de Score
     */
    @Override
    public String toString() {
        return "[" +
                " " + pseudoJoueur  +
                ", " + scoreJoueur.toString() +
                "," + dateRecordJoueur  +
                " ]";
    }
}
