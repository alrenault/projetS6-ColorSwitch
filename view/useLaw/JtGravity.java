package view.useLaw;

import model.game.ball.BallPlayer;

/**
 * Loi créant la gravité
 */
public class JtGravity implements UseLaw {
    
	/**
     * La balle sur laquelle appliquer la gravité
     */
    private BallPlayer ball;

    /**
     * Constructeur de la gravité
     * @param ball La balle sur laquelle appliquer la gravité
     */
    public JtGravity(BallPlayer ball) {
        this.ball = ball;
    }

    @Override
    public void apply() {

        ball.getBall().addVectorY(6);

    }
}
