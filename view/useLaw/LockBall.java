package view.useLaw;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.Group;
import view.ball.BallPlayer;

/**
 * Loi qui permet de garder la balle au milieu de l'écran dans le mode race
 */
public class LockBall implements UseLaw {

	/**
	 * La scène où se trouve le joueur
	 */
    private Scene scene;
    
    /**
     * Le joueur se trouvant au centre de la scène
     */
    private BallPlayer ball;
    
    /**
     * La différence entre la position y du joueur et du haut de la scène
     */
    private double difference;
    
    /**
     * La limite en y
     */
    private double limite;
    
    /**
     * La position y du haut de la caméra
     */
    private double yCamera;
    
    /**
     * Le groupe représentant l'interface
     */
    private Group interfaceGame;

    /**
     * Constructeur de la balle
     * @param scene La scène
     * @param ball Le joueur
     * @param interfaceGame L'interface du jeu
     */
    public LockBall(Scene scene, BallPlayer ball, Group interfaceGame) {
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


        limite += difference;
        yCamera += difference;


        scene.getCamera().setTranslateY(yCamera);
        interfaceGame.setTranslateY(yCamera);
    }

}
