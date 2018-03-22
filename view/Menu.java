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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import main.Main;
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
		//Circle c = new Circle(100,100,100,Color.BLUE);
    	//root.getChildren().add(c);
    	//c.setOnMouseClicked(event -> System.out.println("ca click"));
    	
    	Polygon triangle = new Polygon();

    	double x = width/2;
        double y = 200;
        double side = 100;
    	

        //triangle.setTranslateX(x);
        //triangle.setTranslateY(y);
        
        
        double p1x = x;
        double p1y = y-2.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        double p2x = x + (side/2);
        double p2y = y+1.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        double p3x = x - (side/2);
        double p3y = y+1.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        
        CircleInCircle cic = (CircleInCircle) BuildObstacle.build(new ModelCircleInCircle(x-15, y-13, colorExterne, 0, ObstacleType.CircleInCircle));
    	root.getChildren().add(cic.getObstacle());
        
       
        triangle.getPoints().addAll(
               p1x, p1y, 
               p2x, p2y, 
               p3x, p3y);
    
        root.getChildren().add(triangle);
        triangle.setRotate(90);
        //triangle.setOnMouseClicked(event -> System.out.println("ca click"));
    	//triangle.
    	triangle.setFill(Colorable.WHITE[0]);

		/*VBox truc = new VBox(100);
		truc.setAlignment(Pos.CENTER);
		Button goContinuEasy = new Button("Partie continue (facile)");
		Button goContinuNormal = new Button("Partie continue (normale)");
		Button goContinuHard = new Button("Partie continue (difficile)");
		Button goLvl = new Button("Niveaux");
		Button goScore = new Button("Score");

		truc.getChildren().add(goContinuEasy);
		truc.getChildren().add(goContinuNormal);
		truc.getChildren().add(goContinuHard);
		truc.getChildren().add(goLvl);
		truc.getChildren().add(goScore);

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
		
		truc.setMinWidth(width);
		truc.setMinHeight(height);

		root.getChildren().add(truc);*/


		Scene sc = new Scene(root, width, height);
		//truc.setStyle("-fx-background-color: #393939");
		sc.setFill(Colorable.BLACK);

        triangle.setOnMouseClicked(event -> controller.startGame(Difficulty.RANDOM));
		/*goContinuEasy.setOnAction(event -> controller.startGame(Difficulty.EASY));
		goContinuNormal.setOnAction(event -> controller.startGame(Difficulty.NORMAL));
		goContinuHard.setOnAction(event -> controller.startGame(Difficulty.HARD));
		//goLvl.setOnAction(event -> );
		goScore.setOnAction(event->controller.showScoresMenu());*/


		return sc;
	}

}
