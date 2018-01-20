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

import javafx.animation.Interpolator;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

import game.path.*;
import game.ball.*;



public class MainTest extends Application{


	public static void main(String[] args){

		launch(args);

	}
	

	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("ColorSuitch");
		

		//-------------------------------------------------------------------

		

		//Pour un rectangle
		
		Square carre = new Square(150,300,200,20);
		Group rec = carre.getShape();
		
		

		//------------------------------------------------------------------

		

		//Pour la rotation du rectangle
		

		//dans le ficher directement

		

		//-------------------------------------------------------------------



		//Creation de la scene pour le rectangle

		Scene scene = new Scene(rec,500,500);

		scene.setFill(Color.BLUE);



		//-------------------------------------------------------------------



		

		//Pour une croix
		
		Cross cr = new Cross(350,400,100,20);
		Group croix = cr.getShape();

		

		RotateTransition rt1 = new RotateTransition(Duration.seconds(4.5),croix);

		rt1.setByAngle(-360);
		
		rt1.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
		
		rt1.setCycleCount((int)Double.POSITIVE_INFINITY);


		rt1.play();	
		
		
		//-------------------------------------------------------------------

		//Pour une ligne (pour le moment un seul rectangle)
		
		Linee l = new Linee(0,50,100,20, Color.AQUA);
		Group ligne = l.getShape();
		


		

		//-------------------------------------------------------------------





		//Creation du groupe des formes

		Group gr = new Group();

		gr.getChildren().add(rec);
		
		gr.getChildren().add(croix);
		
		gr.getChildren().add(ligne);
		
		Scene scene1 = new Scene(gr,500,500);

		scene1.setFill(Color.WHITE);
		
		
		

		

		//-------------------------------------------------------------------

		

		//Pour le joueur

		

		Ball player = new Ball(10.0f,Color.RED,scene1);

		/*player.setCenterX(250);

		player.setCenterY(490);*/

		gr.getChildren().add(player.getShape());
				

		TranslateTransition tt = new TranslateTransition(Duration.seconds(10),gr);

		tt.setByY(1200f);//distance parcourue
		//tt.setCycleCount(4);


		//tt.play();

		

		//-------------------------------------------------------------------

			

		





		//primaryStage.setScene(scene);


		primaryStage.setScene(scene1);
		primaryStage.show();

	}

	

	

}
