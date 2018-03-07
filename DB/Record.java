package DB;

import game.Score;

import java.util.Date;

/**
 * @autor Vincent
 * @date 07/03/2018
 */
public class Record {
    private String pseudoJoueur;
    private Score scoreJoueur;
    private String dateRecordJoueur;

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
}
