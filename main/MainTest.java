package main;


import DB.GestionDB;
import game.Colorable;
import game.Difficulty;
import game.Score;
import game.ball.BallPlayer;
import game.path.Modifiers;
import game.path.Path;
import game.path.items.*;
import game.path.obstacle.CircleInCircle;
import game.path.obstacle.MultiCross;
import game.path.obstacle.MultiLinee;
import game.path.obstacle.MultiShapes;
import game.path.obstacle.MultiSquare;
import game.path.obstacle.Obstacle;
import game.path.shapes.Shapes.Speed;
import game.path.shapes.Triangle;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.Menu;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import game.path.shapes.Circle;
import game.path.shapes.Cross;
import javafx.scene.shape.Arc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainTest extends Application{


	int nFrame = 0;
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	System.out.println("_________________________________________"
    			+ "\n\nStart\n");
    	
    	List<Color> CUSTOM = new ArrayList<>();
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
        
        root.getChildren().add(jBall);
        root.getChildren().add(jObstacles);


        
        Path p = new Path(scene1, CUSTOM, 10   , Difficulty.EASY);
        jObstacles.getChildren().add(p.getPath());
        
        
        
        
        scene1.setFill(Colorable.BLACK);

		Score score = new Score();
        Label frame = new Label("Frame : " + nFrame);

        frame.setTextFill(Color.WHITE);
        root.getChildren().add(frame);


        //-------------------------------------------------------------------


        //Pour le joueur


        BallPlayer player = new BallPlayer(10, CUSTOM.get(0), scene1);

		/*player.setCenterX(250);

		player.setCenterY(490);*/

        jBall.getChildren().add(player.getShape());
        player.applyGravity();
	
        	
       
        
        
        
        //apellé a chaque shape
        new AnimationTimer() {

			@Override
			public void handle(long now) {
				checkCollision();
				//frame=score.getScore();
				double x = player.getX();
				double y = player.getY();
				
				
				//nFrame++;
				//System.out.println("X : " + x + " - Y : "+ y);
			}

			private void checkCollision() {
				
				for(Shape ball : player.getShapeList()) {
					
					for(Obstacle o : p.getObstacles()) {
						
						for(Shape shape : o.getShapeList()){
						
						Shape intersection = Shape.intersect(ball, shape);
						
							if (!intersection.getBoundsInParent().isEmpty()) {
								System.out.println(shape.getFill());
								System.out.println(ball.getFill());
								score.increaseNOC();
								if(shape instanceof Arc && shape.getStroke() != ball.getFill()){
									System.out.println("\n___________\nDEFEAT\n");
									//primaryStage.close();
								}
								
								if(!(shape instanceof Arc) &&shape.getFill() != ball.getFill()) {
									System.out.println("\n___________\nDEFEAT\n");
									//primaryStage.close();
								}
							
							}
						}
					}
					
					Boolean touch = false;
					 for(Item i : p.getItem()){
						if(i instanceof BallColorSwitch){
							for(Shape shape : i.getShapeList()){
								Shape intersection = Shape.intersect(ball,shape);
								
								if (!intersection.getBoundsInParent().isEmpty()) {
									System.out.println(shape.getFill().toString());
									System.out.println(ball.getFill().toString());
									if(shape.getFill() != ball.getFill()) {
										Random r = new Random();
										int size = ((BallColorSwitch) i).getColors_use().size();
										Color c = ((BallColorSwitch) i).getColors_use().get(r.nextInt(size));
										p.remove(i);
										player.setColor(c);
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
					
						score.ramasseItem(i);

					}	 
				}
				
				if(player.getY() >= scene1.getHeight()){
					 System.out.println("\n___________\nDEFEAT\n");
					//primaryStage.close();
				 }
				System.err.println("Score :"+ score.getScore());

			}
        	
        }//.start();
        ;
        
        //primaryStage.setScene(scene1);
        //Scene sc = Menu.createInstance(600,1000);
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        primaryStage.show();

    }
    
    public List<Shape> buildLesShapes(List<Node> liste){
    	List<Shape> shapy = new ArrayList<>();
    	
    	for(Node node : liste) {
    		if(node instanceof Shape) {
    			shapy.add((Shape)node);
    		}
    		
    		if(node instanceof Group) {
    			Group group = (Group) node;
    			shapy.addAll(buildLesShapes(group.getChildren()));
    		}
    	
    	}
    	return shapy;
    }

	


}
