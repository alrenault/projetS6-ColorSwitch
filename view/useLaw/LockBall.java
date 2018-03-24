package view.useLaw;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import view.ball.BallPlayer;
import javafx.scene.Group;

public class LockBall implements UseLaw {

    private Scene scene;
    private BallPlayer ball;
    private double difference;
    private double limite;
    private double yCamera;
    private Group interfaceGame;

    public LockBall(Scene scene, BallPlayer ball) {
        this.scene = scene;
        this.ball = ball;

        difference = 0;
        limite = scene.getHeight() / 2;
        yCamera = 0;
    }

    @Override
    public void apply() {


        Point2D coordPlayer = ball.getCoord();

        difference = coordPlayer.getY() - limite;


        limite += difference;
        yCamera += difference;


        scene.getCamera().setTranslateY(yCamera);
    }

}
