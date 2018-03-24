package controller;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import view.game.ball.BallPlayer;

/**
 * Un écouteur de touche utilisé pour l'ancienne version du saut du joueur
 */
public class Listeners {
    /**
     * La scène où se trouve le joueur
     */
    private Scene sc;
    
    /**
     * Le joueur
     */
    private BallPlayer ball;

    /**
     * Constructeur de l'écouteur de touche
     * @param sc La scène où se trouve le joueur
     * @param ball Le joueur
     */
    public Listeners(Scene sc, BallPlayer ball) {
        this.sc = sc;
        this.ball = ball;
    }

    /**
     * Fait sauter le joueur
     * @param group Le groupe représentant le joueur
     */
    public void jump(Group group) {
        sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().getName().equals("Space")) {
                    ball.jump();

                    Point2D coordPlayer = ball.getCoord();
                    if (coordPlayer.getY() <= ball.getLimiteJump()) {
                        //appel d'une methode pour faire descendre tout le monde
                        ball.jumpLimit();
                    }
                }


            }
        });
    }


}
