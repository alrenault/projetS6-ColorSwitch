package main;


import DB.GestionDB;
import game.Colorable;
import game.Difficulty;
import game.Game;
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
import game.path.shapes.Triangle;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.Menu;
import view.ViewPath;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import game.path.shapes.Cross;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Polygon;

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
    	
    	//System.out.println("_________________________________________"+ "\n\nStart\n");
    	Group root = new Group();
    	//Circle c = new Circle(100,100,100,Color.BLUE);
    	//root.getChildren().add(c);
    	//c.setOnMouseClicked(event -> System.out.println("ca click"));
    	
    	Polygon triangle = new Polygon();

    	double x = 100;
        double y = 100;
        double side = 50;

        triangle.setLayoutX(x);
        triangle.setLayoutY(y);
        
        double p1x = x;
        double p1y = y-2.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        double p2x = x + (side/2);
        double p2y = y+1.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        double p3x = x - (side/2);
        double p3y = y+1.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        double p1x1 = x+1.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        double p1y1 = y;
        
        double p2x1 = x - (side/2);
        double p2y1 = y+1.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        double p3x1 = x - (side/2);
        double p3y1 = y+1.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        System.out.println(p1x+" "+p1y);
        System.out.println(p2x+" "+p2y);
        System.out.println(p3x+" "+p3y);
        
        triangle.getPoints().addAll(
               p1x, p1y, 
               p2x, p2y, 
               p3x, p3y);
    
        root.getChildren().add(triangle);
        triangle.setRotate(90);
        triangle.setOnMouseClicked(event -> System.out.println("ca click"));
    	//triangle.
    	triangle.setFill(Colorable.GOLD);
    	
    	Scene sc = new Scene(root,600, 1000);
    	sc.setFill(Colorable.BLACK);
    
    	primaryStage.setScene(sc);
    	primaryStage.show();
    }


}
