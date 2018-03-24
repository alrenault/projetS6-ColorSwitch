package view.game.ball;

import controller.Listeners;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import model.modelBall.Ball;

/**
 * Ball représentant un joueur
 */
public class BallPlayer extends Player {

	/**
	 * Taille de la ball
	 */
    private double size;
    
    /**
     * Couleur de la balle
     */
    private Color color;
    
    /**
     * Groupe représentant la balle
     */
    private Group shape;
    
    /**
     * Scène à laquelle appartient le joueur
     */
    private Scene scene;
    
    /**
     * La transition représentant la gravité
     */
    private TranslateTransition gravity;
    
    /**
     * La transition représentant le saut du joueur
     */
    private TranslateTransition tt2;
    
    /**
     * Objet permettant de trouver les coordonnées et d'autres informations
     */
    private Bounds coord;
    
    /**
     * La hauteur du saut du joueur
     */
    private double jumpHeight = 60;
    
    /**
     * Coordonnée en y de la limite de saut. Si elle est dépassée, la caméra montera
     */
    private double limiteJump;
    
    /**
     * Transition lorsque la limiteJump est atteinte
     */
    private TranslateTransition ttl;


    /**
     * Constructeur d'une balle représentant le joueur 
     * @param size La taille de la balle
     * @param color La couleur de la balle
     * @param scene La scène à laquelle la balle appartient
     */
    public BallPlayer(float size, Color color, Scene scene) {
        super();
        this.model_ball = new Ball(size, color);

        this.size = size;
        this.color = color;
        this.scene = scene;

        this.shape = buildBall();

        model_ball.setX(scene.getWidth() / 2);
        model_ball.setY(scene.getHeight() / 2);

    }

    /**
     * Constructeur d'une balle représentant le joueur 
     * @param ball La taille de la balle
     * @param scene La scène à laquelle la balle appartient
     */
    public BallPlayer(Ball ball, Scene scene) {
        super();

        this.model_ball = ball;

        this.scene = scene;
        //this.ball = ball;
        this.size = ball.getSize();
        this.color = ball.getColor();
        limiteJump = scene.getHeight() / 2;

        this.shape = buildBall();

        model_ball.setX(scene.getWidth() / 2);

        model_ball.setY(scene.getHeight() / 1.25);


    }

    /**
     * Construit la balle
     * @return Un groupe représentant la balle
     */
    private Group buildBall() {
        Group ball = new Group();
        Circle player = new Circle(size, color);
        player.setCenterX(scene.getWidth() / 2);
        player.setCenterY(scene.getHeight() * 4 / 5);

        addSL(player);
        ball.getChildren().add(player);

        //recuperation de la position
        coord = ball.localToScene(ball.getBoundsInLocal());


        Listeners l = new Listeners(scene, this);

        //animation si en dessous si assez bas
        tt2 = new TranslateTransition(Duration.millis(250), ball);
        tt2.setByY(-jumpHeight);
        tt2.setCycleCount(1);
        //tt1.setCycleCount((int)Double.POSITIVE_INFINITY);//mouvement a l'infini
        tt2.setAutoReverse(false);
        tt2.setInterpolator(Interpolator.EASE_OUT);
        tt2.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gravity.play();
            }
        });

        l.jump(ball);

        return ball;

    }

    
    public double getX() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    public double getY() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;

    }

    /**
     * Accesseur des coordonnées de la balle sous forme de point 2D
     * @return Les coordonnées de la balle sous forme de point 2D
     */
    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }


    /**
     * Applique la gravité au joueur
     */
    public void applyGravity() {
        gravity = new TranslateTransition(Duration.seconds(4), shape);
        gravity.setByY(scene.getHeight() + size);
        gravity.setAutoReverse(false);
        gravity.setInterpolator(Interpolator.LINEAR);

    }



    public void jump() {
        applyGravity();
        gravity.pause();
        gravity.stop();
        tt2.stop();
        tt2.play();

    }

    public void jumpLimit() {
        if (ttl != null) {
            ttl.setByY(ttl.getByY());
        } else {
            ttl = new TranslateTransition(Duration.seconds(0.1), scene.getCamera());
            ttl.setByY(-100);
            ttl.setInterpolator(Interpolator.LINEAR);

        }
        ttl.play();
        limiteJump -= 100;
    }


    public double getSize() {
        return size;
    }

    /**
     * Accesseur du groupe de la balle
     * @return Le groupe de la balle
     */
    public Group getShape() {
        return shape;
    }

    /**
     * Accesseur de la coordonnée en y de la limite de saut
     * @return La coordonnée y de la limite de saut
     */
    public double getLimiteJump() {
        return limiteJump;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        for (Shape s : getShapeList()) {
            s.setFill(color);
        }
        this.color = color;
    }


}