package view.useLaw;

import view.ball.BallPlayer;

/**
 * L loi permettant le mouvment plus fluide de la balle
 */
public class MoveBall implements UseLaw {

	/**
	 * Le joueur à bouger
	 */
    private BallPlayer ball;

    /**
     * Le constructeur de la loi
     * @param ball La balle à bouger
     */
    MoveBall(BallPlayer ball) {
        this.ball = ball;
    }

    @Override
    public void apply() {
        ball.getBall().moveBall();


        ball.getShape().setTranslateX(ball.getBall().getX());
        ball.getShape().setTranslateY(ball.getBall().getY());

    }

}
