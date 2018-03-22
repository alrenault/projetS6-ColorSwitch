package view.game.ball;

import java.util.List;

import controller.Listeners;
import view.game.path.Element;
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

public class BallPlayer extends Player{

    private double size;
    private Color color;
    private Group shape;
    private Scene scene;
    private TranslateTransition gravity;
    private TranslateTransition tt2;
    private TranslateTransition tt3;
    private Bounds coord;
    private double jumpHeight = 50;
    private double limiteJump;
    private TranslateTransition ttl;
    //private Ball ball;
    

    public BallPlayer(float size, Color color, Scene scene) {
    	super();
    	Ball bawl = new Ball(size,color);
    	this.model_ball = bawl;
    	
        this.size = size;
        this.color = color;
        this.scene = scene;
        
        this.shape = buildBall();
        
        System.out.println("X : "+model_ball.getX() + " Y : "+model_ball.getY());
        
        model_ball.setX(scene.getWidth()/2);
        model_ball.setY(scene.getHeight()/2);
        
        System.out.println("X : "+model_ball.getX() + " Y : "+model_ball.getY());
        
    }
    
    public BallPlayer(Ball ball, Scene scene) {
    	super();
    	
    	this.model_ball = ball;
    	
    	this.scene = scene;
    	//this.ball = ball;
    	this.size = ball.getSize();
    	this.color = ball.getColor();
    	limiteJump = scene.getHeight() / 2;
    	
    	this.shape = buildBall();
    	
    	model_ball.setX(scene.getWidth()/2);
    	
        model_ball.setY(scene.getHeight()/1.25);
        
        
    	
    }


	public Group buildBall() {
        Group ball = new Group();
        Circle player = new Circle(size, color);
        //player.setCenterX(scene.getWidth() / 2);
        //player.setCenterY(scene.getHeight() - 150);
        
        addSL(player);
        ball.getChildren().add(player);

        //recuperation de la position
        coord = ball.localToScene(ball.getBoundsInLocal());


        Listeners l = new Listeners(scene, this);

        //animation si en dessous si assez bas
        tt2 = new TranslateTransition(Duration.millis(150), ball);
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


        //animation si se rapproche des 50% de la hauteur de la fenetre
       /* tt3 = new TranslateTransition(Duration.millis((150 * ((coord.getMinY() + coord.getHeight() / 2) - scene.getHeight() / 2)) / jumpHeight), ball);
        tt3.setByY(-((coord.getMinY() + coord.getHeight() / 2) - scene.getHeight() / 2));
        tt3.setCycleCount(1);
        //tt1.setCycleCount((int)Double.POSITIVE_INFINITY);//mouvement a l'infini
        tt3.setAutoReverse(false);
        tt3.setInterpolator(Interpolator.EASE_OUT);
        tt3.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gravity.play();
            }
        });*/

        l.jump(ball);


        //tt1.play();

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
    
    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }


    
    public void applyGravity() {
        //System.out.println("Gravity Ball");
        gravity = new TranslateTransition(Duration.seconds(4), shape);
        gravity.setByY(scene.getHeight() + size);
        //tt1.setCycleCount(4);
        //gravity.setCycleCount((int) Double.POSITIVE_INFINITY);//mouvement a l'infini
        gravity.setAutoReverse(false);
        //gravity.setInterpolator(Interpolator.EASE_IN);
        gravity.setInterpolator(Interpolator.LINEAR);
        //gravity.play();

    }

    //static int xj = 100;

    
    public void jump() {
        // TODO Auto-generated method stub
    	applyGravity();
        gravity.pause();
        gravity.stop();
        tt2.stop();
        //tt3.stop();
       /* if (scene.getHeight() / 2 - jumpHeight >= getY()) {
            tt3.setByY(-((coord.getMinY() + coord.getHeight() / 2) - scene.getHeight() / 2));
            tt3.play();
        } else {
            tt2.play();
        }*/
        tt2.play();
        
        
        
        
        
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

    public void jumpLimit() {
    	//scene.getCamera().setTranslateY(scene.getCamera().getTranslateY()-100);
    	//Group g = (Group)scene.getRoot();
    	//g.setTranslateY(g.getTranslateY()+100);
    	//scene.getCamera().setLayoutY(scene.getCamera().getLayoutY()-100);
    	if(ttl != null){
    		//ttl.stop();
    		ttl.setByY(ttl.getByY());
    	}
    	else{
    		ttl = new TranslateTransition(Duration.seconds(0.2), scene.getCamera());
            ttl.setByY(-100);
            ttl.setInterpolator(Interpolator.LINEAR);

    	}
        ttl.play();
    	//scene.getCamera().setTranslateY(-100);
    	limiteJump -= 100;
    	System.out.println("jumplimit "+ limiteJump);
        /*TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), scene.getRoot());
        tt1.setByY(100);

        tt1.setInterpolator(Interpolator.LINEAR);

        tt1.play();*/
    }

	
	public double getSize() {
		return size;
	}
	
	public Group getShape() {
		return shape;
	}

	@Override
	protected Group build() {
		return buildBall();
	}

	public double getLimiteJump() {
		return limiteJump;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		for(Shape s : getShapeList()){
			s.setFill(color);
		}
		this.color = color;
	}
	

    




	

}