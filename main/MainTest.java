package main;

import javafx.scene.paint.Color;



import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.Group;

import javafx.stage.Stage;

import javafx.scene.shape.*;



import javafx.util.Duration;



import javafx.animation.RotateTransition;

import javafx.animation.TranslateTransition;

import game.path.Cross;



public class MainTest extends Application{

	

	Button button;

	

	public static void main(String[] args){

		launch(args);

	}
	
	public void shapeBuilder(Shape hello) {
		//hello instanceof cross...
	}

	public Group buildCross(int x, int y, int radial, int length) {
		
		Cross cross = new Cross(x,y,radial,length);
		return cross.getShape();
	}

	//@Override

	public void start(Stage primaryStage) throws Exception{

		primaryStage.setTitle("ColorSuitch");
		
		

		

		//-------------------------------------------------------------------

		

		//Pour un rectangle

		Group rec = new Group();



		Rectangle r = new Rectangle(50,50,200,20);

		r.setFill(Color.RED);

		

		Rectangle r1 = new Rectangle(50,70,20,180);

		r1.setFill(Color.GREEN);

		

		Rectangle r2 = new Rectangle(70,230,190,20);

		r2.setFill(Color.BLUE);



		Rectangle r3 = new Rectangle(240,50,20,180);

		r3.setFill(Color.FUCHSIA);



		rec.getChildren().add(r);

		rec.getChildren().add(r1);

		rec.getChildren().add(r2);

		rec.getChildren().add(r3);

		//------------------------------------------------------------------

		

		//Pour la rotation du rectangle

		RotateTransition rt = new RotateTransition(Duration.seconds(30),rec);

		rt.setByAngle(1800);

		//rt.setCycleCount(4);

		//rt.setAutoReverse(true);

		rt.play();

		

		//-------------------------------------------------------------------



		//Creation de la scene pour le rectangle

		Scene scene = new Scene(rec,500,500);

		scene.setFill(Color.BLUE);



		//-------------------------------------------------------------------



		

		//Pour une croix
		
		Group croix = buildCross(200,300,100,20);

		

		RotateTransition rt1 = new RotateTransition(Duration.seconds(30),croix);

		rt1.setByAngle(-1800);

		rt1.play();	

		

		//-------------------------------------------------------------------





		//Creation du groupe avec un rectangle et une croix

		Group gr = new Group();

		gr.getChildren().add(rec);
		
		gr.getChildren().add(croix);

		

		//-------------------------------------------------------------------

		

		//Pour le joueur

		

		Circle player = new Circle(10.0f,Color.RED);

		player.setCenterX(250);

		player.setCenterY(490);

		gr.getChildren().add(player);

		

		TranslateTransition tt = new TranslateTransition(Duration.seconds(5),gr);

		tt.setByY(200f);//distance parcourue

		//tt.play();

		

		//-------------------------------------------------------------------

			

		Scene scene1 = new Scene(gr,500,500);

		scene1.setFill(Color.WHITE);





		//primaryStage.setScene(scene);

		primaryStage.setScene(scene1);



		primaryStage.show();

	}

	

	

}
