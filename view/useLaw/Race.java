package view.useLaw;


import javafx.scene.Scene;
import view.ball.BallPlayer;

/**
 * La loi pour la mode race
 */
public class Race implements UseLaw {

	/**
	 * Le joueur
	 */
    private BallPlayer ball;
    
    /**
     * La scène où se trouve le joueur
     */
    private Scene scene;
    
    /**
     * Le moment de début
     */
    private double startTime;
    
    /**
     * Le moment présent
     */
    private double currentTime;
    
    /**
     * La durée du jeu
     */
    private double duration;
    
    /**
     * La vitesse de défilement
     */
    private double speed;

    /**
     * Constructeur de la loi permettant de joueur au mode race
     * @param ball La balle représentant le joueur
     * @param scene La scène
     */
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


        if (speed > 10) speed = 5 + (duration / 120);
        else speed = 3;


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
