package view.useLaw;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import model.game.ball.BallPlayer;

public class Jump implements UseLaw {

    private BallPlayer ball;
    private Scene scene;
    private double last_jump_time;
    private double duration_since_last_jump;
    private double current_time;
    private double vectorY = 0;
    private double jump_duration;

    public Jump(BallPlayer ball, Scene scene) {
        this.ball = ball;
        this.scene = scene;
        current_time = System.currentTimeMillis();
        last_jump_time = current_time;
        duration_since_last_jump = 0;
        jump_duration = 1;
    }

    @Override
    public void apply() {

        current_time = System.currentTimeMillis();


        scene.setOnKeyPressed(event -> {

            boolean space = event.getCode() == KeyCode.SPACE;
            if (space && duration_since_last_jump > 150) {
                last_jump_time = current_time;
            }
        });


        duration_since_last_jump = current_time - last_jump_time;

        double j = computePosition(duration_since_last_jump);

        ball.getBall().addVectorY(-j * 0.75);

    }

    private double computePosition(double duration_since_last_jump) {
        double during_jump = jump_duration * 1000 - duration_since_last_jump;
        System.out.println(jump_duration);
        if (during_jump < 0) during_jump = 0;
        vectorY = Math.abs(during_jump) / 50;
        System.out.println("Y : " + vectorY);

        //vectorY = 800 / (duration_since_last_jump + 0.01);
        return vectorY;
    }

}
