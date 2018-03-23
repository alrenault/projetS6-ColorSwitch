package view.useLaw;


import javafx.scene.Scene;
import view.game.ball.BallPlayer;

/**
 *
 */
public class Race implements UseLaw {

    private BallPlayer ball;
    private Scene scene;
    private double startTime;
    private double currentTime;
    private double duration;
    private double speed;

    public Race(BallPlayer ball, Scene scene) {
        this.ball = ball;
        this.scene = scene;
        startTime = System.currentTimeMillis();
        speed = 5;
    }

    @Override
    public void apply() {
        // TODO Auto-generated method stub

        currentTime = System.currentTimeMillis();

        duration = currentTime - startTime;


        if (speed > 10) speed = 5 + (duration / 12000);
        else speed = 10;


        ball.getShape().setTranslateY(ball.getShape().getTranslateY() - speed);

        scene.setOnMouseMoved(event -> {
            double i;
            i = event.getSceneX();
            //ball.getShape().setTranslateX(i-scene.getWidth()/2);
            ball.getShape().setTranslateX(i);
        });


        //ball.getShape().setTranslateX(ball.getShape().getTranslateY()-5);

    }

}
