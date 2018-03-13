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
        Button clearButton,submitButton;
        Label fNameLabel;
        TextField fNameTextField;
        Scene scene;
        GestionDB gestion=new GestionDB();
        primaryStage.setTitle("Identification");
        primaryStage.setOnCloseRequest(e -> { primaryStage.close(); });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5,5,5,5));
        grid.setVgap(5);
        grid.setHgap(5);

        fNameLabel = new Label("Pseudo :");
        GridPane.setConstraints(fNameLabel,4,0);
        grid.getChildren().add(fNameLabel);

        fNameTextField = new TextField();
        fNameTextField.setPromptText("Entrer un pseudo [a-Z_0-9]");
        GridPane.setConstraints(fNameTextField,5,0);
        grid.getChildren().add(fNameTextField);

        clearButton = new Button("Reset");
        GridPane.setConstraints(clearButton, 7, 5);
        grid.getChildren().add(clearButton);

        submitButton = new Button("Envoyer");
        GridPane.setConstraints(submitButton, 8, 5);
        grid.getChildren().add(submitButton);

        submitButton.setOnAction(e -> {
            String p = fNameTextField.getText();


                gestion.record(p,scorePlayer);

                System.err.println(p);
            //on retourne au menu
        });

        scene = new Scene(grid, 400, 400);
        //ou les tailles du model
        primaryStage.setScene(scene);
        return primaryStage;
    }
}
