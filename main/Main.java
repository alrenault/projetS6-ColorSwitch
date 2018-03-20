package main;

import DB.GestionDB;
import DB.Record;
import controller.Controller;
import game.Game;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.InterfaceModelColorSwitch;
import model.Model;
import view.InterfaceViewColorSwitch;
import view.View;

import java.io.File;
import java.net.URL;
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
	/**
	 *
	 */
	InterfaceModelColorSwitch model;
	/**
	 *
	 */
	InterfaceViewColorSwitch view;
	/**
	 *
	 */
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
		
		
		controller.init();
		
		   
		//Hello
		
		
		
		
        
        //Set Scene
		Group root = new Group();
		Scene scene = new Scene(root, 600, 1000);
		//Game colorSuitch = new Game(scene);
        
        //model.startGame();
        //view.viewGame(model.getGame());
		
        //view.viewGame(colorSuitch);
		
		help();
    	
    	
    		
    	//colorSuitch.play();
		
		//SOUND
				String musicFile = "src/SpringCS.mp3";     

				Media sound = new Media(new File(musicFile).toURI().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(sound);
				MediaView mv = new MediaView(mediaPlayer);
				root.getChildren().add(mv);
				mediaPlayer.setAutoPlay(true);
				//mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
				
				mediaPlayer.setOnEndOfMedia(new Runnable() {
				       public void run() {
				           mediaPlayer.seek(Duration.ZERO);
				         }
				     });
				
				mediaPlayer.setOnError(() -> { 
		            mediaPlayer.getError().printStackTrace(); 
		        }); 
				
				//mediaPlayer.play();
				mediaPlayer.setAutoPlay(true);
				
				
				/*
				 URL resource = getClass().getResource("abcd.mp3");
				 MediaPlayer a =new MediaPlayer(new Media(resource.toString()));
				 a.setOnEndOfMedia(new Runnable() {
				       public void run() {
				         a.seek(Duration.ZERO);
				       }
				   });
				  a.play();*/
		
	}
	
	
	
	
}
