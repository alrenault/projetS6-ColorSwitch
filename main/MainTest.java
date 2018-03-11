package main;


import DB.GestionDB;
import game.Colorable;
import game.Difficulty;
import game.ball.BallPlayer;
import game.path.Path;
import game.path.items.BallColorSwitch;
import game.path.items.GravitySwitch;
import game.path.items.Item;
import game.path.items.Star;
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
        
        root.getChildren().add(jBall);
        root.getChildren().add(jObstacles);


        //-------------------------------------------------------------------


        //Pour un rectangle


        //-------------------------------------------------------------------


        //Creation de la scene pour le rectangle

        // Scene scene = new Scene(rec, 500, 500);

        //scene.setFill(Color.BLUE);


        //-------------------------------------------------------------------


        //Pour une croix

        //Cross cr = new Cross(350,400,100,20,false,false,1,4,Colorable.normal,1);
        //Group croix = cr.getShape();
        //Cross4 cr = new Cross4(350,400,100,20);


        //-------------------------------------------------------------------

        //Pour une ligne (pour le moment un seul rectangle)

        //Linee l = new Linee(0,50,100,20,3,Colorable.normal);
        //Group ligne = l.getShape();

        //MultiLinee l = new MultiLinee(0, 100, CUSTOM, 10, scene1);
        //Group ligne = l.getObstacle();

        //MultiLinee ml = new MultiLinee(50, 150, CUSTOM, 8, scene1);
        //Group mult = ml.getObstacle();
        //-------------------------------------------------------------------

        //Circle cer =new Circle(280, 150, 50, 5);
        //Circle cer =new Circle(280., 150., 50., 10. ,4,true,false,Speed.SYMPA,CUSTOM,0);

        //Group cercle=cer.getShape();
       // CircleInCircle cer = new CircleInCircle(scene1.getWidth() / 2, scene1.getHeight() / 2, CUSTOM, 12);
        //MultiCircle cer = new MultiCircle((int) scene1.getWidth() / 2, 300, Colorable.CUSTOM, 2);

        //Group cercle = cer.getObstacle();


        //Creation du groupe des formes


        //Triangle Daeneris = new Triangle(scene1.getWidth() / 2, scene1.getHeight() / 2, 200, 20, false, false, Speed.SYMPA, CUSTOM, 0);
        //Group tringle = Daeneris.getShape();

        //MultiSquare squaires = new MultiSquare(scene1.getWidth() / 2, scene1.getHeight() / 2, CUSTOM, 0);
        //Group multiSquaire = squaires.getObstacle();

        //MultiShapes shapes = new MultiShapes(scene1.getWidth() / 2, scene1.getHeight() / 2, CUSTOM, scene1, 3);
       // Group multiShapes = shapes.getObstacle();


        //Star s = new Star(300, 250);
        //Group str = s.getShape();


       // GravitySwitch grvt = new GravitySwitch(scene1.getWidth() / 2, 300);
        //Group ge = grvt.getShape();

        //BallColorSwitch bcs = new BallColorSwitch(scene1.getWidth() / 2, -100, CUSTOM);
        //Group colorSwitch = bcs.getItem();
      
     // MultiCross mc = new MultiCross(scene1.getWidth()/2,scene1.getHeight()/2,CUSTOM,5);
      //Group multiCross = mc.getObstacle();

      //gr.getChildren().add(multiCross);
       // gr.getChildren().add(multiSquaire);
        //gr.getChildren().add(str);
        // gr.getChildren().add(ge);
        // gr.getChildren().add(multiShapes);
        //gr.getChildren().add(tringle);

       // gr.getChildren().add(cercle);
        // gr.getChildren().add(rec);


        //gr.getChildren().add(ligne);
        // gr.getChildren().add(cercle);
        // gr.getChildren().add(colorSwitch);

        //gr.getChildren().add(mult);

        Path p = new Path(scene1, CUSTOM, 10   , Difficulty.EASY);
        //MultiCross mc = new MultiCross(scene1.getWidth()/2,scene1.getHeight()/2,CUSTOM,5);
        //Group multiCross = mc.getObstacle();
        
        //p.add(mc);
        jObstacles.getChildren().add(p.getPath());
        
        
        
        
        scene1.setFill(Colorable.BLACK);
        //scene1.setFill(Color.valueOf("0xffff00ff"));
        
        
        Label frame = new Label("Frame : " + nFrame);
        root.getChildren().add(frame);


        //-------------------------------------------------------------------


        //Pour le joueur


        BallPlayer player = new BallPlayer(10, CUSTOM.get(0), scene1);

		/*player.setCenterX(250);

		player.setCenterY(490);*/

        jBall.getChildren().add(player.getShape());
        player.applyGravity();


        //TranslateTransition tt = new TranslateTransition(Duration.seconds(10),gr);

        //tt.setByY(1200f);//distance parcourue
        //tt.setCycleCount(4);


        //tt.play();


        //-------------------------------------------------------------------


        //primaryStage.setScene(scene);

        //g.record("toto",0.0);
        

		//List<Shape> lesShapes = p.getShapeList();
	
        	
       
        
        
        
        
        new AnimationTimer() {

			@Override
			public void handle(long now) {
				checkCollision();
				
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
							
								if(shape instanceof Arc && shape.getStroke() != ball.getFill()){
									System.out.println("\n___________\nDEFEAT\n");
									primaryStage.close();
								}
								
								if(!(shape instanceof Arc) &&shape.getFill() != ball.getFill()) {
									System.out.println("\n___________\nDEFEAT\n");
									primaryStage.close();
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
									 System.out.println("truc"); 
									System.out.println(shape.getFill());
									System.out.println(ball.getFill());
									
									
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
					}
				}
				
				
				
				/*for(Node ball : jBall.getChildren()) {
					for(Node obstacle : jObstacles.getChildren()) {
						Shape intersection = Shape.intersect((Shape) ball, (Shape) obstacle);
						
						if (!intersection.getBoundsInParent().isEmpty()) {
							primaryStage.close();
						}
					}
					
				}*/
				
			}
        	
        }.start();
        
        
        primaryStage.setScene(scene1);
        primaryStage.show();

    }
    
    public List<Shape> buildLesShapes(List<Node> liste){
    	List<Shape> shapy = new ArrayList<Shape>();
    	
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
