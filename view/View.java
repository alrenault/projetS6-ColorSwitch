package view;

import DB.Record;
import controller.Controller;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.game.Game;

import java.util.LinkedList;


/**
 * Gère les fenetre ,scenes du jeu
 */
public class View implements InterfaceViewColorSwitch {
    /**
     * La largeur des fenètres
     */
    static final Integer tailleX = 600;
    /**
     * La hauteur des fenètres
     */
    static final Integer tailleY = 1000;
    /**
     * Le Controller de jeu
     */
    static Controller controller;
    /**
     * La stage représentant la fenêtre utilisée par le jeu
     */
    private Stage stage;
    
    public static Sound sound;

    /**
     * Constructeur de la vue
     * @param primaryStage La fenêtre du jeu
     */
    public View(Stage primaryStage) {
        stage = primaryStage;
        initStage(stage);
        sound = new Sound();

    }

    /**
     * Initialisation de la fenêtre
     * @param stage La fenêtre à initialiser
     */
    private void initStage(Stage stage) {
        stage.setTitle("ColorSuitch");
        stage.getIcons().add(new Image("file:../view/color_icon.png"));
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> stage.close());
    }

    /**
     * Affiche la Scene
     * @param scene La scene à afficher
     */
    private void display(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public void basicView() {
        viewMenu();
    }

    public void viewMenu() {

        Scene scene = Menu.createInstance(controller);
        display(scene);
    }

    public void viewMenuLvl() {
        Scene scene = MenuLvl.createInstance(controller);
        display(scene);
    }

    public void viewGame(Game thisGame) {

        Group root = new Group();
        Scene scene = new Scene(root, tailleX, tailleY);
        scene.setCamera(new PerspectiveCamera());

        sound.playMusic();
        ViewGameManagement.view(thisGame, scene, controller);


        display(scene);

    }

    /*
     *Génère l'affichage de fin de partie en cas de GameOver
     */
    @Override
    public void viewGameOver() {

    	sound.stopMusic();
    	sound.playGameOverSound();
    	ViewGameManagement.destroy();
        display(ViewScores.viewEndScore(controller.getScore()));

    }
    @Override
    public void viewGameEnd() {

    	viewGameOver();

    }

    @Override
    public void viewGameOverRecord() {
        display(ScenePseudo.stre(controller));
    }


    @Override
    public Controller getController() {
        return controller;

    }

    /**
     * Mutateur de Controller
     *
     * @param c Le Controller
     */
    public void setController(Controller c) {
        controller = c;
    }


    @Override
    public void viewScoreError() {


        display(ViewScores.viewError());
    }


    @Override
    public void viewScores(LinkedList<Record> liste) {

        display(ViewScores.GroupeScoreOk(liste));

    }

    @Override
    public void viewParams() {
        display(ViewParamDBForm.formParamDB());
    }


}