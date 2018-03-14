package view;
/**
*
* @autor Vincent
* @date 13/03/2018
*/

import DB.GestionDB;
import game.Score;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 */
public class StagePseudo {


    /**
     * Genère une stage contant un form pour entrer un pseudo
     * @param primaryStage la stage de jeu (game over ou gagné)
     * @param scorePlayer le score du joueur à inserer
     * @return la stage et submit entraine (TODO) la stage de menu (recommencer une partie) ou de fin
     */
    public Stage stre(Stage primaryStage, Score scorePlayer){
        Button buttonClear,buttonSubmit;
        Label labelPseudo;
        TextField inputPseudo;
        Scene scene;
        GestionDB gestion=new GestionDB();
        primaryStage.setTitle("Identification");
        primaryStage.setOnCloseRequest(e -> { primaryStage.close(); });

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
                gestion.record(p,scorePlayer);

                System.err.println(p);
            //on retourne au menu
        });

        scene = new Scene(grille, 400, 400);
        //ou les tailles du model
        primaryStage.setScene(scene);
        return primaryStage;
    }
}
