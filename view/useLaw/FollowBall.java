package view.useLaw;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import view.ball.BallPlayer;
import javafx.scene.Group;

/**
 * Loi permettant à la caméra de suivre le joueur
 */
public class FollowBall implements UseLaw {

	/**
	 * La scène du jeu
	 */
    private Scene scene;
    
    /**
     * La balle représentant le jeu
     */
    private BallPlayer ball;
    
    /**
     * Différence entre le y de la balle et la limite de la balle
     */
    private double difference;
    
    /**
     * Limite avant de faire monter la fenêtre
     */
    private double limite;
    
    /**
     * Limite du haut de la fenêtre
     */
    private double yCamera;
    
    /**
     * L'interface du jeu
     */
    private Group interfaceGame;

    /**
     * Constructeur de la loi
     * @param scene La scène du jeu
     * @param ball La balle représentant le jeu
     * @param interfaceGame L'interface du jeu
     */
    public FollowBall(Scene scene, BallPlayer ball, Group interfaceGame) {
        this.scene = scene;
        this.ball = ball;
        this.interfaceGame = interfaceGame ;
        
        difference = 0;
        limite = scene.getHeight() / 2;
        yCamera = 0;

    }

    @Override
    public void apply() {

        Point2D coordPlayer = ball.getCoord();

        difference = coordPlayer.getY() - limite;

        if (difference < 0) {
            limite += difference;
            yCamera += difference;
        }

        scene.getCamera().setTranslateY(yCamera);
        interfaceGame.setTranslateY(yCamera);
        System.out.println("interface"+interfaceGame.getTranslateY());

    }

}
