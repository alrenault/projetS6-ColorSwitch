package view;

import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import controller.Controller;
import game.Colorable;
import game.Difficulty;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import main.Main;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;


public class MenuLvl {

	public static Scene createInstance(Controller controller,double width, double height){
		List<Color> colorExterne = new ArrayList<Color>();
		colorExterne.add(Colorable.YELLOW);
		colorExterne.add(Colorable.PURPLE);
		colorExterne.add(Colorable.ROSE);
		colorExterne.add(Colorable.BLUE);
    	
		int buttonWidth = 100;
		int buttonHeight = 50;
		
		Group root = new Group();
		Label niveaux = new Label("Niveaux");
		Label modesJeu = new Label("Modes de jeu");
		
		niveaux.setTextFill(Colorable.GOLD);
		niveaux.setFont(Font.font("Verdana",FontWeight.BOLD,20));
		modesJeu.setTextFill(Colorable.GOLD);
		modesJeu.setFont(Font.font("Verdana",FontWeight.BOLD,20));
		
		
		//Niveaux
		Button niveau10 = new Button("10 obstacles");
		Button niveau20 = new Button("20 obstacles");
		Button niveau30 = new Button("30 obstacles");
		Button enferCercle = new Button("L'enfer des cercles");
		
		niveau10.setMinHeight(buttonHeight);
		niveau20.setMinHeight(buttonHeight);
		niveau30.setMinHeight(buttonHeight);
		enferCercle.setMinHeight(buttonHeight);
		
		niveau10.setMinWidth(buttonWidth);
		niveau20.setMinWidth(buttonWidth);
		niveau30.setMinWidth(buttonWidth);
		enferCercle.setMinWidth(buttonWidth);
		
		HBox hBoxNiveaux = new HBox(20);
		hBoxNiveaux.getChildren().add(ViewScores.entete());
		hBoxNiveaux.getChildren().add(niveau10);
		hBoxNiveaux.getChildren().add(niveau20);
		hBoxNiveaux.getChildren().add(niveau30);
		hBoxNiveaux.getChildren().add(enferCercle);
		
		hBoxNiveaux.setTranslateX(50);;
		
		//Modes de jeu
		
		
		VBox vBoxRoot = new VBox(20);
		vBoxRoot.getChildren().add(niveaux);
		vBoxRoot.getChildren().add(hBoxNiveaux);
		vBoxRoot.getChildren().add(modesJeu);
		
		vBoxRoot.setAlignment(Pos.CENTER);
		
		root.getChildren().add(vBoxRoot);
		
		Scene sc = new Scene(root,width,height);
		sc.setFill(Colorable.BLACK);
		
		niveau10.setOnAction(event -> controller.startLvl(10));
		niveau20.setOnAction(event -> controller.startLvl(20));
		niveau30.setOnAction(event -> controller.startLvl(30));
		enferCercle.setOnAction(event -> controller.startHellCircle() );
		
		return sc;
		
		
	}

}
