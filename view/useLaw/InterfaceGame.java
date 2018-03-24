package view.useLaw;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import model.game.Score;
import view.ball.BallPlayer;

/**
 * L'interface du jeu
 */
public class InterfaceGame implements UseLaw {

	/**
	 * Le score du joueur
	 */
	Score leScore;
	
	/**
	 * La valeur du score
	 */
    double score;
    
    /**
     * La scène oùù l'on doit mettre l'interface
     */
    Scene scene;
    
    /**
     * Le label du score
     */
    Label scoreLabel;
    
    /**
     * Le groupe de l'interface
     */
    Group interfaceGame;
    
    /**
     * La balle représentant le jeu
     */
    BallPlayer ball;
    
    /**
     * La différence entre le y du joueur et le haut de la fenêtre
     */
    double difference;
    
    /**
     * Le y du haut de la caméra
     */
    double yCamera;
    
    /**
     * La limite en y de la scène
     */
    double limite;
    
    /**
     * Constructeur de l'interface du jeu
     * @param scene La scène
     * @param leScore Le score
     * @param interfaceGame le groupe de l'interface
     * @param ball La balle représentant le joueur
     */
    public InterfaceGame(Scene scene,Score leScore, Group interfaceGame,BallPlayer ball) {
        this.leScore = leScore;
        this.scene = scene;
        this.score = leScore.getScore();
        this.ball = ball;
        scoreLabel = new Label("Score :" + leScore.getScore().toString());
        this.interfaceGame = interfaceGame;
        interfaceGame.getChildren().add(scoreLabel);
    }

    @Override
    public void apply() {

        scoreLabel.setText("HEY" + leScore.getScore().toString());
        //scoreLabel.setTranslateX(ball.getBall().getX());
        //scoreLabel.setTranslateY(ball.getBall().getY());

        Point2D coordPlayer = ball.getCoord();

        difference = coordPlayer.getY() - limite;

        if (difference < 0) {
            limite += difference;
            yCamera += difference;
        }

        //scene.getCamera().setTranslateY(yCamera);
        //interfaceGame.setTranslateY(scene.getHeight());

        Label oui = new Label("Oui");
        oui.setTextFill(Color.WHITE);
       // interfaceGame.getChildren().add(oui);


    }


}
