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
    
    

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		initStage(primaryStage);
		
		model = new Model();
		view = new View();
		controller = new Controller();
		
		
		
		
        
        //Set Scene
        Group root = new Group();
        Scene scene = new Scene(root, 600, 1000);
        
        model.createGame(scene);
		view.viewGame(scene);
    	
    	Game colorSuitch = new Game(scene);
    		
    	colorSuitch.play();
		
	}
	
	
	
	public void initStage(Stage stage) {
		//Set Stage
        stage.setTitle("ColorSuitch");
        stage.getIcons().add(new Image("file:../view/color_icon.png"));
	}
}
