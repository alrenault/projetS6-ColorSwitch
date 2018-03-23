package model.modelBall;

import javafx.scene.Scene;
import view.game.ball.BallPlayer;

public class BuildBall {

    public static BallPlayer build(Ball ball, Scene scene) {
        BallPlayer ballplayer;

        ballplayer = new BallPlayer(ball, scene);

        return ballplayer;
    }
}
