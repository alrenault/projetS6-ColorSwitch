package game.ball;

import java.util.List;

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
import model.modelBall.ModelBallPlayer;

/**
 *
 */
public class BallPlayer extends Ball {
    /**
     *
     */
    private Group shape;
    /**
     *
     */
    private TranslateTransition gravity;
    /**
     *
     */
    private TranslateTransition tt2;
    /**
     *
     */
    private TranslateTransition tt3;
    /**
     *
     */
    private Bounds coord;
    /**
     *
     */
    private Scene sc;
    /**
     *
     */
    private ModelBallPlayer model_ball;

    /**
     *
     * @param sc
     * @param mbp
     */
    public BallPlayer(Scene sc,ModelBallPlayer mbp) {
    	this.sc = sc;
    	model_ball = mbp;
        this.shape = buildBall();
    }

    /**
     *
     * @return
     */
	public Group buildBall() {
        Group ball = new Group();
        Circle player = new Circle(model_ball.getSize(), color);
        player.setCenterX(model_ball.getScWidth() / 2);
        player.setCenterY(model_ball.getScHeight() - 150);
        
        addSL(player);
        ball.getChildren().add(player);

        //recuperation de la position
        coord = ball.localToScene(ball.getBoundsInLocal());


        Listeners l = new Listeners(sc, this);

        //animation si en dessous si assez bas
        tt2 = new TranslateTransition(Duration.millis(150), ball);
        tt2.setByY(-model_ball.getJumpHeight());
        tt2.setCycleCount(1);
        //tt1.setCycleCount((int)Double.POSITIVE_INFINITY);//mouvement a l'infini
        tt2.setAutoReverse(false);
        tt2.setInterpolator(Interpolator.EASE_OUT);
        tt2.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gravity.play();
            }
        });

        //animation si se rapproche des 50% de la hauteur de la fenetre
        System.out.println("test : "+(150 * ((coord.getMinY() + coord.getHeight() / 2) - model_ball.getScHeight() / 2)) / model_ball.getJumpHeight());
        //tt3 = new TranslateTransition(Duration.millis(150), ball);

        tt3 = new TranslateTransition(Duration.millis((150  * ((coord.getMinY() + coord.getHeight() / 2) - model_ball.getScHeight() / 2)) / model_ball.getJumpHeight()), ball);
        tt3.setByY(-((coord.getMinY() + coord.getHeight() / 2) - model_ball.getScHeight() / 2));
        tt3.setCycleCount(1);
        //tt1.setCycleCount((int)Double.POSITIVE_INFINITY);//mouvement a l'infini
        tt3.setAutoReverse(false);
        tt3.setInterpolator(Interpolator.EASE_OUT);
        tt3.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gravity.play();
            }
        });

        l.jump(ball);


        //tt1.play();

        return ball;

    }

    /**
     *
     * @return
     */
    public double getX() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    /**
     *
     * @return
     */
    public double getY() {
        coord = shape.localToScene(shape.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;

    }

    /**
     *
     * @return
     */
    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }

    /**
     *
     */
    @Override
    public void applyGravity() {
        //System.out.println("Gravity Ball");
        gravity = new TranslateTransition(Duration.seconds(4), shape);
        gravity.setByY(model_ball.getScHeight() + model_ball.getSize());
        //tt1.setCycleCount(4);
        //gravity.setCycleCount((int) Double.POSITIVE_INFINITY);//mouvement a l'infini
        gravity.setAutoReverse(false);
        //gravity.setInterpolator(Interpolator.EASE_IN);
        gravity.setInterpolator(Interpolator.LINEAR);
        //gravity.play();

    }

    //static int xj = 100;

    /**
     *
     */
    @Override
    public void jump() {
        // TODO Auto-generated method stub
        gravity.pause();
        gravity.stop();
        tt2.stop();
        tt3.stop();
        if (model_ball.getScHeight() / 2 - model_ball.getJumpHeight() >= getY()) {
            tt3.setByY(-((coord.getMinY() + coord.getHeight() / 2) - model_ball.getScHeight() / 2));
            tt3.play();
        } else {
            tt2.play();
        }
        
        
        
        
        
        /*
        Timeline time = new Timeline();
        KeyValue kv = new KeyValue(shape.translateXProperty(), 2);
        KeyFrame ke = new KeyFrame(Duration.millis(1000),kv);
        //time.getKeyFrames().add(ke);
        
        xj+=100;

        time.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, // set start position at 0
                   new KeyValue(shape.translateXProperty(), shape.getTranslateX()),
                   new KeyValue(shape.translateYProperty(), shape.getLayoutY()-x)),

                new KeyFrame(new Duration(400), // set end position at 40s
                   new KeyValue(shape.translateXProperty(), 0),
                   new KeyValue(shape.translateYProperty(), -x,Interpolator.EASE_OUT)));
        time.play();
        */

    }

    /**
     *
     */
    public void jumpLimit() {
        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), sc.getRoot());
        tt1.setByY(100);

        tt1.setInterpolator(Interpolator.LINEAR);

        tt1.play();
    }

    /**
     *
     * @return
     */
	@Override
	public Group getShape() {
		// TODO Auto-generated method stub
		return shape;
	}



	

}
