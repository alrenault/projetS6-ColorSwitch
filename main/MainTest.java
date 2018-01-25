package main;

import game.ball.BallPlayer;
import game.path.Circle;
import game.path.Cross4;
import game.path.Linee;
import game.path.Square;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;



public class MainTest extends Application{


	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
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
		
		//Cross4 cr = new Cross4(350,400,100,20,false,false,1);
		Cross4 cr = new Cross4(350,400,100,20);
		Group croix = cr.getShape();

		

		
		
		
		//-------------------------------------------------------------------

		//Pour une ligne (pour le moment un seul rectangle)
		
		Linee l = new Linee(0,50,100,20,3);
		Group ligne = l.getShape();
		


		

		//-------------------------------------------------------------------

		//Circle cer =new Circle(280, 150, 50, 5);
		Circle cer =new Circle(280, 150, 50, 10 ,8,true,false,2);
		Group cercle=cer.getShape();


	
	
		//Creation du groupe des formes

		Group gr = new Group();

		gr.getChildren().add(rec);
		
		gr.getChildren().add(croix);
		
		gr.getChildren().add(ligne);
		
		gr.getChildren().add(cercle);
		
	
		Scene scene1 = new Scene(gr,500,500);

		scene1.setFill(Color.GREY);
		
		
		

		

		//-------------------------------------------------------------------

		

		//Pour le joueur

		

		BallPlayer player = new BallPlayer(10.0f,Color.RED,scene1);

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
