package DB;

import game.Score;

/**
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

    public String getPseudoJoueur() {
        return pseudoJoueur;
    }

    public Score getScoreJoueur() {
        return scoreJoueur;
    }

    public String getDateRecordJoueur() {
        return dateRecordJoueur;
    }

    @Override
    public String toString() {
        return "[" +
                " " + pseudoJoueur  +
                ", " + scoreJoueur.toString() +
                "," + dateRecordJoueur  +
                " ]";
    }
}
