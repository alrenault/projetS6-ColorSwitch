package main;

import controller.Controller;
import controller.InterfaceModelColorSwitch;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import view.InterfaceViewColorSwitch;
import view.Sound;
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

    @Override
    public void start(Stage primaryStage) {

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


        
        Sound sound = new Sound();
        
       // sound.playMusic();

				    

				
				
				
				


    }


}
