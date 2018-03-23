package main;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import view.game.Colorable;


public class MainTest extends Application {


    int nFrame = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        //Circle c = new Circle(100,100,100,Color.BLUE);
        //root.getChildren().add(c);

        Polygon triangle = new Polygon();

        double x = 100;
        double y = 100;
        double side = 50;

        triangle.setLayoutX(x);
        triangle.setLayoutY(y);

        double p1x = x;
        double p1y = y - 2.0 / 3.0 * side * (Math.sqrt(3.0) / 2.0);

        double p2x = x + (side / 2);
        double p2y = y + 1.0 / 3.0 * side * (Math.sqrt(3.0) / 2.0);

        double p3x = x - (side / 2);
        double p3y = y + 1.0 / 3.0 * side * (Math.sqrt(3.0) / 2.0);

        double p1x1 = x + 1.0 / 3.0 * side * (Math.sqrt(3.0) / 2.0);
        double p1y1 = y;

        double p2x1 = x - (side / 2);
        double p2y1 = y + 1.0 / 3.0 * side * (Math.sqrt(3.0) / 2.0);

        double p3x1 = x - (side / 2);
        double p3y1 = y + 1.0 / 3.0 * side * (Math.sqrt(3.0) / 2.0);


        triangle.getPoints().addAll(
                p1x, p1y,
                p2x, p2y,
                p3x, p3y);

        root.getChildren().add(triangle);
        triangle.setRotate(90);
        triangle.setFill(Colorable.GOLD);

        Scene sc = new Scene(root, 600, 1000);
        sc.setFill(Colorable.BLACK);

        primaryStage.setScene(sc);
        primaryStage.show();
    }


}
