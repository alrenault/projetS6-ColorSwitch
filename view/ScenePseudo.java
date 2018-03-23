package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.game.Colorable;

/**
 *Mini Form recuperrant le pseudo du joueur à la fin de la partie
 * et qui propose l'enregistrement
 */
class ScenePseudo {



    /**
     * Genère une stage contant un form pour entrer un pseudo
     * @param c Le controleur de la partie
     * @return la stage et submit entraine  la stage de menu
     */

    public static  Scene stre(Controller c){
        Button buttonClear,buttonSubmit;
        Label labelPseudo;
        TextField inputPseudo;
        Scene scene;

        VBox root = new VBox();
        HBox ligne_input_label=new HBox();
        HBox ligne_buttons=new HBox();
        root.setStyle("-fx-background-color: #393939");
        labelPseudo = new Label("Pseudo :");

        inputPseudo = new TextField();
        inputPseudo.setPromptText("Entrer un pseudo [a-Z_0-9]");

        ligne_input_label.getChildren().add(labelPseudo);
        ligne_input_label.getChildren().add(inputPseudo);
        ligne_input_label.setAlignment(Pos.CENTER);
        root.getChildren().add(ligne_input_label);

        buttonClear = new Button("Reset");

        buttonSubmit = new Button("Envoyer");

        buttonSubmit.setOnAction(e -> {
            String p = inputPseudo.getText();
            System.err.println(p);
            System.err.println(c+"==" + ((c==null)?"Null":"Non null"));
            System.err.println(View.controller.getScore().toString());
            c.recordScore(View.controller.getScore());
            View.controller.startMenu();
        });
        buttonClear.setOnAction(event -> inputPseudo.clear());

        ligne_buttons.getChildren().add(buttonSubmit);
        ligne_buttons.getChildren().add(buttonClear);
        ligne_buttons.setAlignment(Pos.CENTER);
        root.getChildren().add(ligne_buttons);
        root.setSpacing(20);
        //root.setAlignment(Pos.CENTER);// centre pas ou il faut

        scene = new Scene(root, View.tailleX, View.tailleY);

        return scene;
    }
}
