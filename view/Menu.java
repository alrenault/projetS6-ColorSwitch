package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
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
import view.game.Colorable;
import view.game.Difficulty;
import view.game.path.obstacle.BuildObstacle;
import view.game.path.obstacle.CircleInCircle;
import javafx.scene.image.*;
import javafx.scene.shape.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
class Menu {

    private static int i = 0;

    /**
     * @param controller
     * @return
     */
    public static Scene createInstance(Controller controller) {
        List<Color> colorExterne = new ArrayList<>();
        colorExterne.add(Colorable.YELLOW);
        colorExterne.add(Colorable.PURPLE);
        colorExterne.add(Colorable.ROSE);
        colorExterne.add(Colorable.BLUE);


        Integer buttonWidth = 200;
        Integer buttonHeight = 50;

        Group root = new Group();

        //VBox vColor = new VBox(10);


        //vColor.getChildren().add(colorSwitch);
        //root.getChildren().add(vColor);

        VBox vBox = new VBox(25);
        //Circle c = new Circle(100,100,100,Color.BLUE);
        //root.getChildren().add(c);
        Label colorSwitch = new Label("Color Switch");
        Font f = Font.font("Verdana", FontWeight.BOLD, 50);
        colorSwitch.setFont(f);
        colorSwitch.setTextFill(colorExterne.get(i));
        //colorSwitch.setTranslateX(125);
        //colorSwitch.setTranslateY(50);
        vBox.getChildren().add(colorSwitch);

        double x = View.tailleX / 2.0;
        double y = 200.0;
        double side = 100.0;


        CircleInCircle cic = (CircleInCircle) BuildObstacle.build(new ModelCircleInCircle(x - 15, y - 13, colorExterne, 0, ObstacleType.CircleInCircle));

        Polygon playRandom = FilledTriangle.create(x, y, side, Colorable.WHITE[0]);

        HBox circleButtons = new HBox();
        circleButtons.setAlignment(Pos.CENTER);
        vBox.getChildren().add(circleButtons);

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
        circleButtons.getChildren().add(randomButton);

        Group playEasy = FilledTriangle.create(120, y, side/2, Color.LIGHTGREEN, "Easy");
        Group playNormal = FilledTriangle.create(320, y, side/2, Color.ORANGERED, "Normal");
        Group playHard = FilledTriangle.create(520, y, side/2, Color.DARKRED, "Hard");

        //HBox infinite_difficulties = new HBox();
        //infinite_difficulties.setAlignment(Pos.CENTER);
        
        Group infinite_difficulties = new Group();

        infinite_difficulties.getChildren().add(playEasy);
        infinite_difficulties.getChildren().add(playNormal);
        infinite_difficulties.getChildren().add(playHard);
        
        
        Group parameter = new Group();
        Circle circleParameter = new Circle(25,25,35,Color.GREY);
        parameter.getChildren().add(circleParameter);
        
        String imageParam = "src/ressources/42695.png";
        final ImageView selectedImage = new ImageView();   
        Image image1 = new Image(Paths.get(imageParam).toUri().toString());
        
        selectedImage.setImage(image1);
        
        selectedImage.setFitHeight(50);
        selectedImage.setFitWidth(50);

        
        parameter.getChildren().add(selectedImage);
        

        root.setTranslateY(-100);
        
        
        parameter.setOnMouseClicked(event -> System.out.println("Bonjour"));
        circleButtons.getChildren().add(parameter);
        
        parameter.setTranslateX(70);
        parameter.setTranslateY(-70);
        

        vBox.getChildren().add(infinite_difficulties);

        //vBox.getChildren().add(goContinuEasy);
        //vBox.getChildren().add(goContinuNormal);
        //vBox.getChildren().add(goContinuHard);
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
        
        playEasy.setOnMouseClicked(event -> controller.startGame(Difficulty.EASY));
        playNormal.setOnMouseClicked(event -> controller.startGame(Difficulty.NORMAL));
        playHard.setOnMouseClicked(event -> controller.startGame(Difficulty.HARD));
        
        
        goLvl.setOnAction(event -> controller.menuLvl());
        goScore.setOnAction(event -> controller.showScoresMenu());


        colorSwitch.setOnMouseClicked(event -> {
            i = (i + 1) % colorExterne.size();
            colorSwitch.setTextFill(colorExterne.get(i));
        });


        return sc;
    }

}
