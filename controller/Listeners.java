package controller;

import game.ball.BallPlayer;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


public class Listeners {
    private Scene sc;
    private BallPlayer ball;

    public Listeners(Scene sc, BallPlayer ball) {
        this.sc = sc;
        //TODO
        this.ball = ball;
    }

    public void jump(Group group) {
        //Label l1 = new Label("je test");
        //group.getChildren().add(l1);
        //l1.setFont(new Font(50));
        sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                //if(ke.getCode() == KeyCode.ENTER){
                if (ke.getCode().getName().equals("Space")) {
                    System.out.println("Jump");
                    ball.jump();

                    Point2D coordPlayer = ball.getCoord();
                    if (coordPlayer.getY() <= sc.getHeight() / 2) {
                        //appel d'une methode pour faire descendre tout le monde
                        //System.out.println(coordPlayer.getX() + "," + coordPlayer.getY());
                        ball.jumpLimit();
                    }
                    //l1.setText(ke.getCode().getName());
                }


            }
        });
    }


}
