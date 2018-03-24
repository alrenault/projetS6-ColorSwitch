package view.useLaw;

import view.ball.BallPlayer;

public class Gravity implements UseLaw {

	private BallPlayer ball;

    /**
     * Constructeur de la gravité
     * @param ball La balle sur laquelle appliquer la gravité
     */
    public Gravity(BallPlayer ball) {
        this.ball = ball;
    }

    @Override
    public void apply() {

        ball.getBall().addVectorY(6);

    }

}
