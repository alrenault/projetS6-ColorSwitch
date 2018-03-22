package view;

import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import game.Colorable;
import game.Difficulty;
import game.path.obstacle.BuildObstacle;
import game.path.obstacle.CircleInCircle;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import model.ObstacleType;
import model.modelObstacle.ModelCircleInCircle;
import javafx.scene.Group;

/**
 *
 */
public class Menu {
	/**
	 *
	 * @param controller
	 * @param width
	 * @param height
	 * @return
	 */
	public static Scene createInstance(Controller controller,double width, double height){
		List<Color> colorExterne = new ArrayList<Color>();
		colorExterne.add(Colorable.YELLOW);
		colorExterne.add(Colorable.PURPLE);
		colorExterne.add(Colorable.ROSE);
		colorExterne.add(Colorable.BLUE);
    	
		int buttonWidth = 200;
		int buttonHeight = 50;
		
		Group root = new Group();
		VBox vBox = new VBox(25);
		//Circle c = new Circle(100,100,100,Color.BLUE);
    	//root.getChildren().add(c);
    	//c.setOnMouseClicked(event -> System.out.println("ca click"));

    	double x = width/2;
        double y = 200;
        double side = 100;
        
        
        CircleInCircle cic = (CircleInCircle) BuildObstacle.build(new ModelCircleInCircle(x-15, y-13, colorExterne, 0, ObstacleType.CircleInCircle));
    	
    	Polygon playRandom = FilledTriangle.create(x, y, side, Colorable.WHITE[0]);

		
		vBox.setAlignment(Pos.CENTER);
		Button goContinuEasy = new Button("Partie continue (facile)");
		Button goContinuNormal = new Button("Partie continue (normale)");
		Button goContinuHard = new Button("Partie continue (difficile)");
		Button goLvl = new Button("Niveaux");
		Button goScore = new Button("Score");

		Group randomButton = new Group();
		randomButton.getChildren().add(cic.getObstacle());
		//randomButton.getChildren().add(triangle);
		randomButton.getChildren().add(playRandom);
		vBox.getChildren().add(randomButton);
		
		Polygon playEasy = FilledTriangle.create(x, y, side/2, Color.LIGHTGREEN);
		Polygon playNormal = FilledTriangle.create(x, y, side/2, Color.ORANGERED);
		Polygon playHard = FilledTriangle.create(x, y, side/2, Color.DARKRED);
		
		HBox infinite_difficulties = new HBox();
		
		infinite_difficulties.getChildren().add(playEasy);
		infinite_difficulties.getChildren().add(playNormal);
		infinite_difficulties.getChildren().add(playHard);
        
		vBox.getChildren().add(infinite_difficulties);
        
		vBox.getChildren().add(goContinuEasy);
		vBox.getChildren().add(goContinuNormal);
		vBox.getChildren().add(goContinuHard);
		vBox.getChildren().add(goLvl);
		vBox.getChildren().add(goScore);

		goContinuEasy.setMinHeight(buttonHeight);
		goContinuNormal.setMinHeight(buttonHeight);
		goContinuHard.setMinHeight(buttonHeight);
		goLvl.setMinHeight(buttonHeight);
		goScore.setMinHeight(buttonHeight);


		goContinuEasy.setMinWidth(buttonWidth);
		goContinuNormal.setMinWidth(buttonWidth);
		goContinuHard.setMinWidth(buttonWidth);
		goLvl.setMinWidth(buttonWidth);
		goScore.setMinWidth(buttonWidth);
		
		vBox.setMinWidth(width);
		vBox.setMinHeight(height);

		root.getChildren().add(vBox);


		Scene sc = new Scene(root, width, height);
		//vBox.setStyle("-fx-background-color: #393939");
		sc.setFill(Colorable.BLACK);
		playRandom.setOnMouseClicked(event -> controller.startGame(Difficulty.RANDOM));
		
		goContinuEasy.setOnAction(event -> controller.startGame(Difficulty.EASY));
		goContinuNormal.setOnAction(event -> controller.startGame(Difficulty.NORMAL));
		goContinuHard.setOnAction(event -> controller.startGame(Difficulty.HARD));
		goLvl.setOnAction(event -> controller.menuLvl() );
		goScore.setOnAction(event->controller.showScoresMenu());


		return sc;
	}

}
