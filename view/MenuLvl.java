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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.game.Colorable;

import java.util.ArrayList;
import java.util.List;

/**
 * Génère le Menu
 */
class MenuLvl {
    /**
     * Génère une Scene de menu pour lacer une partie
     *
     * @param controller Le controller de jeu
     * @return Une Scene de Menu
     */
    public static Scene createInstance(Controller controller) {
        List<Color> colorExterne = new ArrayList<>();
        colorExterne.add(Colorable.YELLOW);
        colorExterne.add(Colorable.PURPLE);
        colorExterne.add(Colorable.ROSE);
        colorExterne.add(Colorable.BLUE);

        int buttonWidth = 100;
        int buttonHeight = 50;

        Group root = new Group();
        Label niveaux = new Label("Niveaux");
        Label modesJeu = new Label("Modes de jeu");
        Button retour = new Button();
        VBox boxMenu = new VBox();
        boxMenu.getChildren().add(retour);
        retour.setOnAction(e -> controller.startMenu());

        retour.setText(" <-- ");
        root.getChildren().add(boxMenu);

        niveaux.setTextFill(Colorable.GOLD);
        niveaux.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        modesJeu.setTextFill(Colorable.GOLD);
        modesJeu.setFont(Font.font("Verdana", FontWeight.BOLD, 20));


        //Niveaux
        Button niveau10 = new Button("10 obstacles");
        Button niveau20 = new Button("20 obstacles");
        Button niveau30 = new Button("30 obstacles");
        Button enferCercle = new Button("L'enfer des cercles");

        niveau10.setMinHeight(buttonHeight);
        niveau20.setMinHeight(buttonHeight);
        niveau30.setMinHeight(buttonHeight);
        enferCercle.setMinHeight(buttonHeight);

        niveau10.setMinWidth(buttonWidth);
        niveau20.setMinWidth(buttonWidth);
        niveau30.setMinWidth(buttonWidth);
        enferCercle.setMinWidth(buttonWidth);

        HBox hBoxNiveaux = new HBox(20);
        hBoxNiveaux.getChildren().add(niveau10);
        hBoxNiveaux.getChildren().add(niveau20);
        hBoxNiveaux.getChildren().add(niveau30);
        hBoxNiveaux.getChildren().add(enferCercle);

        hBoxNiveaux.setTranslateX(50);

        //Modes de jeu


        VBox vBoxRoot = new VBox(20);
        vBoxRoot.getChildren().add(niveaux);
        vBoxRoot.getChildren().add(hBoxNiveaux);
        vBoxRoot.getChildren().add(modesJeu);

        vBoxRoot.setAlignment(Pos.CENTER);

        boxMenu.getChildren().add(vBoxRoot);

        Scene sc = new Scene(root, View.tailleX, View.tailleY);
        sc.setFill(Colorable.BLACK);

        niveau10.setOnAction(event -> controller.startLvl(10));
        niveau20.setOnAction(event -> controller.startLvl(20));
        niveau30.setOnAction(event -> controller.startLvl(30));
        enferCercle.setOnAction(event -> controller.startHellCircle());

        return sc;


    }

}
