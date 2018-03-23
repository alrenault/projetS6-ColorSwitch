package view.useLaw;

import view.game.ball.BallPlayer;

public class MoveBall implements UseLaw {

    private BallPlayer ball;

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
