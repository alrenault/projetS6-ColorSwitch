package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import game.ball.Ball;
import game.ball.BallPlayer;
import game.law.Universe;
import game.path.Path;
import game.path.items.BallColorSwitch;
import game.path.items.Item;
import game.path.obstacle.Obstacle;
import game.law.Law;


import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import model.modelBall.ModelBallPlayer;
import view.ViewGameManagement;

/**
 * This class is used to create a game
 * You have to use it in the model
 * Only contains data
 */

public class Game {

    Ball ball;
	Path path;
    Universe universe;
    
    Difficulty difficulty;
    List<Color> colors;
    Score score;
    
    Stage stage;
    Scene scene;
    
    int nFrame = 0;

    public Game(Ball _ball, Path _path, Universe _universe) {
        this.ball = _ball;
        this.path = _path;
        this.universe = _universe;
    }
    
    public Game() {
    	/*
    	difficulty = Difficulty.NO;
    	colors = new ArrayList<Color>();
    	colors.add(Colorable.YELLOW);
    	colors.add(Colorable.PURPLE);
    	colors.add(Colorable.ROSE);
    	colors.add(Colorable.BLUE);
    	
    	ball = new BallPlayer(10, colors.get(0));
    	path = new Path(colors, Integer.MAX_VALUE, difficulty);
    	universe = new Universe();
    	
    	this.score = new Score();
    	*/
    	
    	System.out.println(
        		"\n_______________"
        		+ "\nRandom Game\n\n");
        
        List<Color> CUSTOM = new ArrayList<Color>();
    	CUSTOM.add(Colorable.YELLOW);
    	CUSTOM.add(Colorable.PURPLE);
    	CUSTOM.add(Colorable.ROSE);
    	CUSTOM.add(Colorable.BLUE);
    	
    	this.path = new Path(600,1000, CUSTOM, 10   , Difficulty.EASY);
    	
    	//this.ball = new BallPlayer(10, CUSTOM.get(0), scene);
    	
    	this.universe = new Universe();
    	
    	this.score = new Score();
    	
    	
    }
    
    
	public Ball getBall() {
		return ball;
	}

	public Path getPath() {
		return path;
	}

	public Universe getUniverse() {
		return universe;
	}
	
	public Score getScore() {
		return score;
	}

	
    public Game(Scene scene) {
        System.out.println(
        		"\n_______________"
        		+ "\nRandom Game\n\n");
        
        List<Color> CUSTOM = new ArrayList<Color>();
    	CUSTOM.add(Colorable.YELLOW);
    	CUSTOM.add(Colorable.PURPLE);
    	CUSTOM.add(Colorable.ROSE);
    	CUSTOM.add(Colorable.BLUE);
    	
    	
    	this.path = new Path(scene.getWidth(),scene.getHeight(), CUSTOM, 10   , Difficulty.EASY);
    	
    	//this.ball = new BallPlayer(10, CUSTOM.get(0), scene);

    	
    	this.universe = new Universe();
    	
    	this.score = new Score();
    	
    	ViewGameManagement.view(this,scene);
        
        
    }

    public void applyGravity() {
        ball.applyGravity();
    }
    
    public void defeat() {
    	
    	System.out.println("\n___________\nDEFEAT\n");
    	stage.close();
    }

    /*
	public void play() {

		new AnimationTimer() {

			@Override
			public void handle(long now) {
				checkCollision();
				
				double x = ball.getX();
				double y = ball.getY();
				
				
				//nFrame++;
				//System.out.println("X : " + x + " - Y : "+ y);
			}

			private void checkCollision() {
				
				for(Shape b : ball.getShapeList()) {
					
					for(Obstacle o : path.getObstacles()) {
						
						for(Shape shape : o.getShapeList()){
						
						Shape intersection = Shape.intersect(b, shape);
						
							if (!intersection.getBoundsInParent().isEmpty()) {
								System.out.println(shape.getFill());
								System.out.println(b.getFill());
							
								if(shape instanceof Arc && shape.getStroke() != b.getFill()){
									
									defeat();

								}
								
								if(!(shape instanceof Arc) &&shape.getFill() != b.getFill()) {
									
									defeat();

								}
							
							}
						}
					}
					
					Boolean touch = false;
					 for(Item i : path.getItem()){
						if(i instanceof BallColorSwitch){
							for(Shape shape : i.getShapeList()){
								Shape intersection = Shape.intersect(b,shape);
								
								if (!intersection.getBoundsInParent().isEmpty()) {
									System.out.println(shape.getFill());
									System.out.println(b.getFill());
									
									
									if(shape.getFill() != b.getFill()) {
										Random r = new Random();
										int size = ((BallColorSwitch) i).getColors_use().size();
										Color c = ((BallColorSwitch) i).getColors_use().get(r.nextInt(size));
										path.remove(i);
										ball.setColor(c);
										touch = true;
										break;
									}
									
								}
							}
							if(touch){
								touch = false;
								break;
							}
						}
					}	 
				}
				
				if(ball.getY() >= scene.getHeight()){
					
					defeat();
					
				 }
				
			}
        	
        }.start();
		
	}*/
	
	


    
    public void hello(Stage primaryStage) {
    	
    	System.out.println("_________________________________________"
    			+ "\n\nStart\n");
    	
    	List<Color> CUSTOM = new ArrayList<Color>();
    	CUSTOM.add(Colorable.YELLOW);
    	CUSTOM.add(Colorable.PURPLE);
    	CUSTOM.add(Colorable.ROSE);
    	CUSTOM.add(Colorable.BLUE);

    	//Set Stage
        primaryStage.setTitle("ColorSuitch");
        primaryStage.getIcons().add(new Image("file:../view/color_icon.png"));
        
        //Set Scene
        Group root = new Group();
        Scene scene1 = new Scene(root, 600, 1000);
        //GestionDB g=new GestionDB();
        
        Group jBall = new Group();
        Group jObstacles = new Group();
        Group jItems = new Group();
        
        root.getChildren().add(jBall);
        root.getChildren().add(jObstacles);
        root.getChildren().add(jItems);


        

        Path p = new Path(scene1.getWidth(),scene1.getHeight(), CUSTOM, 10   , Difficulty.EASY);
        
        //jObstacles.getChildren().add(p.getPath());
        
        
        
        
        scene1.setFill(Colorable.BLACK);
        
        
        Label frame = new Label("Frame : " + nFrame);
        root.getChildren().add(frame);


        //-------------------------------------------------------------------


        //Pour le joueur


        //BallPlayer player = new BallPlayer(10, CUSTOM.get(0), scene1);

		/*player.setCenterX(250);

		player.setCenterY(490);*/

        //jBall.getChildren().add(player.getShape());
        //player.applyGravity();


	
        	
       
        
        
        
        
        
        
        
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

	public void jump() {
		// TODO Auto-generated method stub
		
	}



}
