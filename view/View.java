package view;

import DB.Record;
import controller.Controller;
import game.Colorable;
import game.Game;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.PerspectiveCamera;

import java.util.LinkedList;


/**
 *
 */
public class View implements InterfaceViewColorSwitch {
	/**
	 *
	 */
	Stage stage;
	/**
	 *
	 */
	Controller controller;
	/**
	 *
	 */
	private final int tailleX = 600;
	/**
	 *
	 */
	private final int tailleY = 1000;
	//Preferences

	/**
	 *
	 * @param primaryStage
	 */
	public View(Stage primaryStage) {
		stage = primaryStage ;
		initStage(stage);
		//basicView();
		
	}

	/**
	 *
	 * @param c
	 */
	public void setController(Controller c) {
		controller = c;
	}



	/**
	 *
	 * @param stage
	 */
	private void initStage(Stage stage) {
		//Set Stage
        stage.setTitle("ColorSuitch");
        stage.getIcons().add(new Image("file:../view/color_icon.png"));
        stage.setFullScreen(1==0);
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> stage.close());
	}

	/**
	 *
	 * @param scene
	 */
	private void display(Scene scene) {
        stage.setScene(scene);
        stage.show();
	}


	/**
	 *
	 */
	public void basicView() {
		viewMenu();
	}


	/**
	 *
	 */
	public void viewMenu() {
 
		Scene scene = Menu.createInstance(controller,600,1000);
		display(scene);	
	}

	/**
	 *
	 * @param thisGame
	 */
	public void viewGame(Game thisGame) {
		
		Group root = new Group();
		Scene scene = new Scene(root,tailleX,tailleY);
		scene.setCamera(new PerspectiveCamera());
		
		ViewGameManagement.view(thisGame,scene,controller);
		
		
		display(scene);
		
	}

	/**
	 *
	 */
	@Override
	public void viewGameOver() {
		//stage.close();
		Scene form = null;
		try {
			form = ScenePseudo.class.newInstance().stre( controller);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		display(form);
	}


	/**
	 *
	 * @return
	 */
	@Override
	public Controller getController() {
		return controller;
		
	}
//TODO ajouter de quoi retourner au menu
	@Override
	public void viewScoreNoCo() {
		Group root = new Group();
		String noCo="\nHum c'est embarrassant !\n Il semblerait que tu n'aie pas de connection...\nPas de connexion, pas de scores.";
        Text t =new Text(noCo);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setFont(new Font(26));
        t.setFill(Color.WHITE);
        root.getChildren().add(t);
		Scene scene = new Scene(root,tailleX,tailleY);
		scene.setFill(Colorable.BLACK);
        display(scene);
	}
	@Override
	public void viewScores(LinkedList<Record> liste) {
	    Group root = new Group();

        VBox vBox = new VBox();
        HBox hBox =new HBox();



        vBox.setAlignment(Pos.CENTER);

        hBox.getChildren().add(aggranditBlancit("Date"));
        hBox.getChildren().add(aggranditBlancit("Joueur"));
        hBox.getChildren().add(aggranditBlancit("Nombre d'étoiles"));
        hBox.getChildren().add(aggranditBlancit("Nombre d'obstacles"));

        hBox.getChildren().add(aggranditBlancit("Score"));

        vBox.getChildren().add(hBox);

		for (Record rec : liste) {
            hBox =new HBox();
            hBox.getChildren().add(aggranditBlancit(rec.getDateRecordJoueur()));

            hBox.getChildren().add(aggranditBlancit(rec.getPseudoJoueur()));

            hBox.getChildren().add(aggranditBlancit(Integer.toString(rec.getNbEtoilesRamassees())));

            hBox.getChildren().add(aggranditBlancit(Integer.toString(rec.getNbrObstaclesCrossed())));

            hBox.getChildren().add(aggranditBlancit(Integer.toString(rec.getScore())));


            vBox.getChildren().add(hBox);

        }
        root.getChildren().add(vBox);
        Scene scene = new Scene(root,tailleX,tailleY);
        scene.setFill(Colorable.BLACK);

		display(scene);
	}

    /**
     * Aggrandit et blanchit
     * @param s la chaine à transformer
     * @return un Text correspondant à s en plus grand et moins (ne pas raciser)
     */
	private Text aggranditBlancit(String s){
        Text text=new Text(s);
        text.setFont(new Font(15));
        text.setFill(Color.WHITE);
        return text;
    }


	public int getTailleX() {
		return tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}
}
