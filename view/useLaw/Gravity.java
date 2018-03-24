package view.useLaw;

import view.ball.BallPlayer;

/**
 * Loi créant la gravité
 *
 */
public class Gravity implements UseLaw {

	/**
	 * La balle soumise à la gravité
	 */
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
