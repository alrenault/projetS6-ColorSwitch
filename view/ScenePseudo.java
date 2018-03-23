package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *Mini Form recuperrant le pseudo du joueur à la fin de la partie
 */
class ScenePseudo {



    /**
     * Genère une stage contant un form pour entrer un pseudo
     * @param c
     * @return la stage et submit entraine (TODO) la stage de menu (recommencer une partie) ou de fin
     */

    public static  Scene stre(Controller c){
        Button buttonClear,buttonSubmit;
        Label labelPseudo;
        TextField inputPseudo;
        Scene scene;

        GridPane grille = new GridPane();
        grille.setPadding(new Insets(5,5,5,5));
        grille.setVgap(5);
        grille.setHgap(5);

        labelPseudo = new Label("Pseudo :");
        GridPane.setConstraints(labelPseudo,4,0);
        grille.getChildren().add(labelPseudo);

        inputPseudo = new TextField();
        inputPseudo.setPromptText("Entrer un pseudo [a-Z_0-9]");
        GridPane.setConstraints(inputPseudo,5,0);
        grille.getChildren().add(inputPseudo);

        buttonClear = new Button("Reset");
        GridPane.setConstraints(buttonClear, 7, 5);
        grille.getChildren().add(buttonClear);

        buttonSubmit = new Button("Envoyer");
        GridPane.setConstraints(buttonSubmit, 8, 5);
        grille.getChildren().add(buttonSubmit);

        buttonSubmit.setOnAction(e -> {
            String p = inputPseudo.getText();
            System.err.println(p);
            c.recordScore(View.controller.getScore());//nullpointerException
            View.controller.startMenu();
        });

        scene = new Scene(grille, View.tailleX, View.tailleY);
        //ou les tailles du model
        return scene;
    }
}
