package DB;
/**
*Objet permettant de stocker des Triplets (classement, joueur , score total)
* @autor Vincent
* @date 16/03/2018
*
* */

public class SumScore {
    /**
     * Le numéro de classement du joueur (= la position du joueur dans le classement )
     */
    private int classement;
    /**
     * Le nom du joueur
     */
    private String joueur;
    /**
     * La somme de ses scores
     */
    private int sumScoreJoueur;


    /**
     * Constructeur de triplets ( classement joueur , score total)
     * @param classement la position du joueur dans le classement
     * @param joueur le pseudo du joueur
     * @param sumScoreJoueur la somme de ses scores
     */
    public SumScore(int classement, String joueur, int sumScoreJoueur) {
        this.classement = classement;
        this.joueur = joueur;
        this.sumScoreJoueur = sumScoreJoueur;
    }

    /**
     * Accesseur du Joueur
     * @return le nom du joueur
     */
    public String getJoueur() {
        return joueur;
    }

    /**
     * Accesseur du score total du joueur
     * @return le score total
     */
    public int getSumScoreJoueur() {
        return sumScoreJoueur;
    }

    /**
     * Accesseur du calssement du joueur
     * @return la position du joueur dans le classement
     */
    public int getClassement() {
        return classement;
    }

    /**
     * UNIQUEMENT POUR TESTS
     * @return Le toString de this
     */
    @Override
    public String toString() { return "[" + classement + "]'" + joueur +"," + sumScoreJoueur; }
}
