package model.game;

/**
 * Modelise le joueur de l'appli (Non utlisée ( on ne demande pas le nom du joueur au début)
 */
class Player {
    /**
     * Le nom du joueur
     */

    private String namePlayer;
    /**
     *
     */
    private Score scorePlayer;

    /**
     * Constucteur aveugle de Joueur
     *
     * @param namePlayer le pseudo du Joueur
     */
    public Player(String namePlayer) {
        this.namePlayer = namePlayer;
        this.scorePlayer = new Score();
    }

    /**
     * Constucteur aveugle de Joueur
     */
    public Player() {
        this.namePlayer = "";
        this.scorePlayer = new Score();
    }

    /**
     * Getter du nom du Joueur
     *
     * @return le pseudo du Joueur
     */
    public String getNamePlayer() {
        return namePlayer;
    }

    /**
     * @param namePlayer le pseudo du joueur
     */
    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    /**
     * @return le score du joueur
     */
    public double getScorePlayer() {
        return scorePlayer.getScore();
    }
}
