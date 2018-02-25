package main;


import game.Colorable;
import game.Difficulty;
import game.ball.BallPlayer;
import game.path.Path;
import game.path.items.GravitySwitch;
import game.path.items.Star;
import game.path.obstacle.CircleInCircle;
import game.path.obstacle.MultiLinee;
import game.path.obstacle.MultiShapes;
import game.path.obstacle.MultiSquare;
import game.path.shapes.Triangle;
import game.path.shapes.Shapes.Speed;
import game.path.items.BallColorSwitch;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainTest extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ColorSuitch");
        Group gr = new Group();
        Scene scene1 = new Scene(gr, 600, 1000);


        //-------------------------------------------------------------------


        //Pour un rectangle


        //-------------------------------------------------------------------


        //Creation de la scene pour le rectangle

        // Scene scene = new Scene(rec, 500, 500);

        //scene.setFill(Color.BLUE);


        //-------------------------------------------------------------------


        //Pour une croix

        //Cross cr = new Cross(350,400,100,20,false,false,1,4,Colorable.normal,1);
        //Group croix = cr.getShape();
        //Cross4 cr = new Cross4(350,400,100,20);


        //-------------------------------------------------------------------

        //Pour une ligne (pour le moment un seul rectangle)

        //Linee l = new Linee(0,50,100,20,3,Colorable.normal);
        //Group ligne = l.getShape();

        MultiLinee l = new MultiLinee(0, 100, Colorable.CUSTOM, 6, scene1);
        Group ligne = l.getObstacle();

        MultiLinee ml = new MultiLinee(50, 150, Colorable.CUSTOM, 8, scene1);
        Group mult = ml.getObstacle();
        //-------------------------------------------------------------------

        //Circle cer =new Circle(280, 150, 50, 5);
        //Circle cer =new Circle(280, 150, 50, 10 ,8,true,false,2);
        //Group cercle=cer.getShape();
        CircleInCircle cer = new CircleInCircle(scene1.getWidth()/2,scene1.getHeight()/2,Colorable.CUSTOM,12);
        //MultiCircle cer = new MultiCircle((int) scene1.getWidth() / 2, 300, Colorable.CUSTOM, 2);

        Group cercle = cer.getObstacle();


        //Creation du groupe des formes


        Triangle Daeneris = new Triangle(scene1.getWidth() / 2, scene1.getHeight() / 2, 200, 20, false, false, Speed.SYMPA, Colorable.CUSTOM, 0);
        Group tringle = Daeneris.getShape();

        MultiSquare squaires = new MultiSquare(scene1.getWidth() / 2, scene1.getHeight() / 2, Colorable.CUSTOM, 0);
        Group multiSquaire = squaires.getObstacle();

        MultiShapes shapes = new MultiShapes(scene1.getWidth() / 2, scene1.getHeight() / 2, Colorable.CUSTOM, scene1, 3);
        Group multiShapes = shapes.getObstacle();


        Star s = new Star(300, 250);
        Group str = s.getShape();


        GravitySwitch grvt = new GravitySwitch(scene1.getWidth()/2, 300);
        Group ge = grvt.getShape();
        
        BallColorSwitch bcs = new BallColorSwitch(scene1.getWidth()/2,-100,Colorable.CUSTOM);
        Group colorSwitch = bcs.getShape();


       // gr.getChildren().add(multiSquaire);
        //gr.getChildren().add(str);
       // gr.getChildren().add(ge);
       // gr.getChildren().add(multiShapes);
        //gr.getChildren().add(tringle);

        //gr.getChildren().add(cer);
        // gr.getChildren().add(rec);


        //gr.getChildren().add(ligne);
       // gr.getChildren().add(cercle);
       // gr.getChildren().add(colorSwitch);

        //gr.getChildren().add(mult);
        
        Path p = new Path(scene1,Colorable.CUSTOM,100,Difficulty.EASY);
        gr.getChildren().add(p.getPath());
        scene1.setFill(Colorable.BLACK);


        //-------------------------------------------------------------------


        //Pour le joueur


        BallPlayer player = new BallPlayer(10, Colorable.CUSTOM[0], scene1);

		/*player.setCenterX(250);

		player.setCenterY(490);*/

        gr.getChildren().add(player.getShape());
        player.applyGravity();


        //TranslateTransition tt = new TranslateTransition(Duration.seconds(10),gr);

        //tt.setByY(1200f);//distance parcourue
        //tt.setCycleCount(4);


        //tt.play();


        //-------------------------------------------------------------------


        //primaryStage.setScene(scene);


        primaryStage.setScene(scene1);
        primaryStage.show();

    }


}
