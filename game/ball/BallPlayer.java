package game.ball;

import controller.Listeners;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPlayer extends Ball {

    private float size;
    private Color color;
    private Group shape;
    private Scene scene;
    private TranslateTransition gravity;

    public BallPlayer(float size, Color color, Scene scene) {
        this.size = size;
        this.color = color;
        this.scene = scene;
        this.shape = buildBall();
    }

    public Group buildBall() {
        Group ball = new Group();

        Circle player = new Circle(size, color);
        System.out.println(scene.getWidth() + " " + scene.getHeight());
        player.setCenterX(scene.getWidth() / 2);
        player.setCenterY(scene.getHeight() - 150);
        ball.getChildren().add(player);

        //animation
        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(4), ball);
        tt1.setByY(scene.getHeight() + size);
        //tt.setCycleCount(4);
        //tt1.setCycleCount((int)Double.POSITIVE_INFINITY);//mouvement a l'infini
        //tt1.setAutoReverse(true);
        //tt1.setInterpolator(Interpolator.LINEAR);
        Listeners l = new Listeners(scene, this);
        l.jump(ball);


        //tt1.play();

        return ball;

    }

    public Group getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    int x = 70;

    @Override
    public void applyGravity() {
        System.out.println("Gravity Ball");
        gravity = new TranslateTransition(Duration.seconds(2), shape);
        gravity.setByY(scene.getHeight() + size);
        //tt1.setCycleCount(4);
        //gravity.setCycleCount((int) Double.POSITIVE_INFINITY);//mouvement a l'infini
        gravity.setAutoReverse(false);
        gravity.setInterpolator(Interpolator.LINEAR);
        //gravity.play();

    }

    //static int xj = 100;
    
    @Override
    public void jump() {
        // TODO Auto-generated method stub
        System.out.println("Jump Ball");
        gravity.pause();
        gravity.stop();
        TranslateTransition tt1 = new TranslateTransition(Duration.millis(150), shape);
        tt1.setByY(-x);
        tt1.setCycleCount(1);
        //tt1.setCycleCount((int)Double.POSITIVE_INFINITY);//mouvement a l'infini
        tt1.setAutoReverse(false);
        tt1.setInterpolator(Interpolator.EASE_OUT);
        tt1.setOnFinished(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				gravity.play();	
			}	
        });
        tt1.stop();
        tt1.play();
        
        
        
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

}
