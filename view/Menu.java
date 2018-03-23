package view;

import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import view.game.Colorable;
import view.game.Difficulty;
import view.game.path.obstacle.BuildObstacle;
import view.game.path.obstacle.CircleInCircle;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.ObstacleType;
import model.modelObstacle.ModelCircleInCircle;
import javafx.scene.Group;

/**
 *
 */
class Menu {
	
	private static int i = 0;

	/**
	 *
	 * @param controller
	 * @return
	 */
	public static Scene createInstance(Controller controller){
		List<Color> colorExterne = new ArrayList<>();
		colorExterne.add(Colorable.YELLOW);
		colorExterne.add(Colorable.PURPLE);
		colorExterne.add(Colorable.ROSE);
		colorExterne.add(Colorable.BLUE);
		
    	
		int buttonWidth = 200;
		int buttonHeight = 50;
		
		Group root = new Group();
		
		//VBox vColor = new VBox(10);
		
		
		//vColor.getChildren().add(colorSwitch);
		//root.getChildren().add(vColor);

		VBox vBox = new VBox(25);
		//Circle c = new Circle(100,100,100,Color.BLUE);
    	//root.getChildren().add(c);
    	//c.setOnMouseClicked(event -> System.out.println("ca click"));
		Label colorSwitch = new Label("Color Switch");
		Font f = Font.font("Verdana",FontWeight.BOLD,50);
		colorSwitch.setFont(f);
		colorSwitch.setTextFill(colorExterne.get(i));
		//colorSwitch.setTranslateX(125);
		//colorSwitch.setTranslateY(50);
		vBox.getChildren().add(colorSwitch);

    	double x = View.tailleX/2;
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
		
		//Polygon playEasy = FilledTriangle.create(x, y, side/2, Color.LIGHTGREEN);
		//Polygon playNormal = FilledTriangle.create(x, y, side/2, Color.ORANGERED);
		//Polygon playHard = FilledTriangle.create(x, y, side/2, Color.DARKRED);
		
		HBox infinite_difficulties = new HBox();
		
		//infinite_difficulties.getChildren().add(playEasy);
		//infinite_difficulties.getChildren().add(playNormal);
		//infinite_difficulties.getChildren().add(playHard);
        
		vBox.getChildren().add(infinite_difficulties);
        
		vBox.getChildren().add(goContinuEasy);
		vBox.getChildren().add(goContinuNormal);
		vBox.getChildren().add(goContinuHard);
		vBox.getChildren().add(goLvl);
		vBox.getChildren().add(goScore);
		
		vBox.setTranslateY(-100);

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
		
		vBox.setMinWidth(View.tailleX);
		vBox.setMinHeight(View.tailleY);

		root.getChildren().add(vBox);


		Scene sc = new Scene(root, View.tailleX, View.tailleY);
		//vBox.setStyle("-fx-background-color: #393939");
		sc.setFill(Colorable.BLACK);
		playRandom.setOnMouseClicked(event -> controller.startGame(Difficulty.RANDOM));
		
		goContinuEasy.setOnAction(event -> controller.startGame(Difficulty.EASY));
		goContinuNormal.setOnAction(event -> controller.startGame(Difficulty.NORMAL));
		goContinuHard.setOnAction(event -> controller.startGame(Difficulty.HARD));
		goLvl.setOnAction(event -> controller.menuLvl() );
		goScore.setOnAction(event->controller.showScoresMenu());
		

		colorSwitch.setOnMouseClicked(event ->{
			i = (i+1)% colorExterne.size();
			colorSwitch.setTextFill(colorExterne.get(i));
		});


		return sc;
	}

}
