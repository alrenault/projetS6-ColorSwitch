package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.ObstacleType;
import model.game.Colorable;
import model.game.Difficulty;
import model.modelLaw.Universe.UniverseType;
import model.modelObstacle.ModelCircleInCircle;
import view.path.obstacle.BuildObstacle;
import view.path.obstacle.CircleInCircle;

import java.util.ArrayList;
import java.util.List;


/**
 * Gènere le menu principal
 */
class Menu {

    private static int i = 0;

    /**
     * Crée une instance du menu
     *
     * @param controller Instance du controlleur
     * @return Une scène représentant le menu principal
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
        ImageLoader imageLoader = new ImageLoader();

        //VBox vColor = new VBox(10);


        //vColor.getChildren().add(colorSwitch);
        //root.getChildren().add(vColor);

        VBox menu = new VBox(25);
        //Circle c = new Circle(100,100,100,Color.BLUE);
        //root.getChildren().add(c);

        //Init Title

        Label colorSwitch = new Label("Color Switch");
        Font f = Font.font("Verdana", FontWeight.BOLD, 50);
        colorSwitch.setFont(f);
        colorSwitch.setTextFill(colorExterne.get(i));
        //colorSwitch.setTranslateX(125);
        //colorSwitch.setTranslateY(50);


        double x = View.tailleX / 2.0;
        double y = 200.0;
        double side = 100.0;

        menu.setAlignment(Pos.CENTER);
        Button goLvl = new Button("Niveaux");

        //Init Circular buttons

        HBox circleButtons = new HBox();
        circleButtons.setAlignment(Pos.CENTER);


        Group score = new Group();
        Group randomButton = new Group();
        Group parameter = new Group();

        circleButtons.getChildren().add(score);
        circleButtons.getChildren().add(randomButton);
        circleButtons.getChildren().add(parameter);

        //Score Button


        Circle circleScore = new Circle(25, 25, 35, Color.DARKRED);
        score.getChildren().add(circleScore);


        ImageView imageScore = imageLoader.getScorePicture();


        imageScore.setFitHeight(50);
        imageScore.setFitWidth(50);

        score.setTranslateX(-40);
        score.setTranslateY(-50);


        score.getChildren().add(imageScore);

        //PlayRandom Button

        CircleInCircle cic = (CircleInCircle) BuildObstacle.build(new ModelCircleInCircle(x - 15, y - 13, colorExterne, 0, ObstacleType.CircleInCircle));

        Polygon playRandom = FilledTriangle.create(x, y, side, Colorable.WHITE);


        randomButton.getChildren().add(cic.getObstacle());
        //randomButton.getChildren().add(triangle);
        randomButton.getChildren().add(playRandom);

        //Parameter Button


        Circle circleParameter = new Circle(25, 25, 35, Color.GREY);
        parameter.getChildren().add(circleParameter);

        final ImageView imageParameters = imageLoader.getParametersPicture();

        imageParameters.setFitHeight(50);
        imageParameters.setFitWidth(50);


        parameter.getChildren().add(imageParameters);

        parameter.setTranslateX(40);
        parameter.setTranslateY(-50);


        //Difficulties

        Group playEasy = FilledTriangle.create(120, y, side / 2, Color.LIGHTGREEN, "Easy");
        Group playNormal = FilledTriangle.create(320, y, side / 2, Color.ORANGERED, "Normal");
        Group playHard = FilledTriangle.create(520, y, side / 2, Color.DARKRED, "Hard");

        //HBox infinite_difficulties = new HBox();
        //infinite_difficulties.setAlignment(Pos.CENTER);

        Group infinite_difficulties = new Group();

        infinite_difficulties.getChildren().add(playEasy);
        infinite_difficulties.getChildren().add(playNormal);
        infinite_difficulties.getChildren().add(playHard);


        root.setTranslateY(-100);


////////////////////////////////////////////////////

        Label authors = new Label("Alexis, Vincent, Quentin\n\t Groupe 23");
        Font autFont = Font.font("Tahoma", FontWeight.LIGHT, 20);
        authors.setFont(autFont);
        authors.setTextFill(Color.DEEPSKYBLUE);

////////////////////////////////////////////////////


        //vBox.getChildren().add(goContinuEasy);
        //vBox.getChildren().add(goContinuNormal);
        //vBox.getChildren().add(goContinuHard);


        menu.setTranslateY(-100);

        goLvl.setMinHeight(buttonHeight);


        goLvl.setMinWidth(buttonWidth);

        menu.setMinWidth(View.tailleX);
        menu.setMinHeight(View.tailleY);

        root.getChildren().add(menu);


        Scene sc = new Scene(root, View.tailleX, View.tailleY);
        //vBox.setStyle("-fx-background-color: #393939");
        sc.setFill(Colorable.BLACK);


        //Construction
        menu.getChildren().add(colorSwitch);
        menu.getChildren().add(circleButtons);
        menu.getChildren().add(infinite_difficulties);
        menu.getChildren().add(goLvl);
        menu.getChildren().add(authors);


        //Events

        //Title
        colorSwitch.setOnMouseClicked(event -> {
            i = (i + 1) % colorExterne.size();
            colorSwitch.setTextFill(colorExterne.get(i));
        });

        //Random
        playRandom.setOnMouseClicked(event -> controller.startGame(Difficulty.RANDOM, UniverseType.Basic));

        //Score
        score.setOnMouseClicked(event -> controller.showScoresMenu());

        //Parameter
        parameter.setOnMouseClicked(event -> controller.parametres());


        //Difficulties
        playEasy.setOnMouseClicked(event -> controller.startGame(Difficulty.EASY, UniverseType.Basic));
        playNormal.setOnMouseClicked(event -> controller.startGame(Difficulty.NORMAL, UniverseType.Basic));
        playHard.setOnMouseClicked(event -> controller.startGame(Difficulty.HARD, UniverseType.Basic));

        //Levels
        goLvl.setOnAction(event -> controller.menuLvl());

        return sc;
    }

}
