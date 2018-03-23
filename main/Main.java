package main;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InterfaceModelColorSwitch;
import model.Model;
import view.InterfaceViewColorSwitch;
import view.View;

/**
 * Main class for Color Suitch
 *
 * @author leveque
 * @author renault
 * @author renard
 * @version 1.0
 */
public class Main extends Application {
    private static int j = 0;
    /**
     * Le modele du jeu
     */
    private InterfaceModelColorSwitch model;
    /**
     * La vue du jeu
     */
    private InterfaceViewColorSwitch view;
    /**
     * Le controller du jeu
     */
    private Controller controller;

    public static void main(String[] args) {
        launch(args);
    }

    private static void help() {
        Throwable t = new Throwable();
        t.fillInStackTrace();
        StackTraceElement e = t.getStackTrace()[1];
        String className = e.getClassName();
        String functionName = e.getMethodName();
        System.out.println(className + "." + functionName + " - " + j);
        j++;
    }


    @Override
    public void start(Stage primaryStage) {

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

        /* Audio */
		
		
		/*{
			 String bip = "src/ressources/Spring.wav";
			 Media hit = new Media(Paths.get(bip).toUri().toString());
			 MediaPlayer truc = new MediaPlayer(hit);
			 truc.play();
		}*/
				    

				
				/*
				{
			        String bip = "src/ressources/Spring.wav";
			        Media hit = new Media(Paths.get(bip).toUri().toString());
			        AudioClip putain = new AudioClip(hit.getSource());
			        putain.play();
			    }
				*/


    }


}
