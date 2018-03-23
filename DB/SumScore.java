package DB;

/**
 * Objet permettant de stocker des Triplets (classement, joueur , score total)
 * utilisé dans GestionDB in topJoueur
 */

public class SumScore {
    /**
     * Le numéro de classement du joueur (= la position du joueur dans le classement )
     */
    private Integer classement;
    /**
     * Le nom du joueur
     */
    private String joueur;
    /**
     * La somme de ses scores
     */
    private Integer sumScoreJoueur;


    /**
     * Constructeur de triplets ( classement joueur , score total)
     *
     * @param classement     la position du joueur dans le classement
     * @param joueur         le pseudo du joueur
     * @param sumScoreJoueur la somme de ses scores
     */
    public SumScore(Integer classement, String joueur, Integer sumScoreJoueur) {
        this.classement = classement;
        this.joueur = joueur;
        this.sumScoreJoueur = sumScoreJoueur;
    }

    /**
     * Accesseur du Joueur
     *
     * @return le nom du joueur
     */
    public String getJoueur() {
        return joueur;
    }

    /**
     * Accesseur du score total du joueur
     *
     * @return le score total
     */
    public Integer getSumScoreJoueur() {
        return sumScoreJoueur;
    }

    /**
     * Accesseur du calssement du joueur
     *
     * @return la position du joueur dans le classement
     */
    public Integer getClassement() {
        return classement;
    }

    /**
     * UNIQUEMENT POUR TESTS
     *
     * @return Le toString de this
     */
    @Override
    public String toString() {
        return "[" + classement + "]" + joueur + "," + sumScoreJoueur;
    }
}
