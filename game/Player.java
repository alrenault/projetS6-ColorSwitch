package game;

/**
 * @autor Vincent
 * @date 25/02/2018
 */
public class Player {
    private String namePlayer;
    private Score scorePlayer;

    public Player(String namePlayer) {
        this.namePlayer = namePlayer;
        this.scorePlayer = new Score();
    }

    public Player() {
        this.namePlayer = "";
        this.scorePlayer = new Score();
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public double getScorePlayer() {
        return scorePlayer.getScore();
    }
}
