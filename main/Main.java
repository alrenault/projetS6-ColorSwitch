package main;

import DB.GestionDB;
import DB.Record;
import controller.Controller;
import game.Game;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Model;
import view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Main class for Color Suitch
 *
 * @author leveque
 * @author renault
 * @author renard
 * @version 1.0
 */
public class Main extends Application {
	
	Model model;
	View view;
	Controller controller;

    public static void main(String[] args) {
    	launch(args);
    }
    
    static int j = 0;
    public static void help() {
    	Throwable t = new Throwable();
        t.fillInStackTrace();
        StackTraceElement e = t.getStackTrace()[1];
        String className = e.getClassName();
        String functionName = e.getMethodName();
        System.out.println(className + "." + functionName + " - "+ j);
        j++;
    }
    

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		help();
		
		model = new Model();
		view = new View(primaryStage);
		
		controller = new Controller(model, view);
		
		
		
		
		
        
        //Set Scene
        Group root = new Group();
        Scene scene = new Scene(root, 600, 1000);
        
        model.startGame();
        view.basicView();
		//view.viewGame(model.getGame());
		
		help();
    	
    	//Game colorSuitch = new Game(scene);
    		
    	//colorSuitch.play();
		
	}
	
	
	
	
}
