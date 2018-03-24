package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Formulaire pour modifier les parametres de la base de données
 */
public class ViewParamDBForm {
	
	/**
	 * Crée le formulaire
	 * @return Le formulaire
	 */
    public static Scene formParamDB(){
        Group root = new Group();
        Button valider = new Button();
        Label l_n_ports = new Label();
        Label l_userDB = new Label();
        Label l_password_DB = new Label();
        TextField i_n_ports = new TextField();
        TextField i_userDB = new TextField();
        PasswordField i_password_DB = new PasswordField();
        VBox vBox = new VBox();
        HBox ligne_user = new HBox();
        HBox ligne_psswd = new HBox();
        HBox ligne_ports = new HBox();
        l_userDB.setTextFill(Color.WHITE);
        l_n_ports.setTextFill(Color.WHITE);
        l_password_DB.setTextFill(Color.WHITE);

        l_userDB.setText("Nom d'utilisateur root");
        l_password_DB.setText("Mot de passe root");
        l_n_ports.setText("No de port MySql");
        ligne_user.getChildren().addAll(l_userDB, i_userDB);
        ligne_psswd.getChildren().addAll(l_password_DB, i_password_DB);
        ligne_ports.getChildren().addAll(l_n_ports, i_n_ports);

        valider.setText("Valider");
        valider.setOnAction(event -> {
            //TODO


        });

        vBox.getChildren().addAll(ligne_user, ligne_psswd, ligne_ports, valider);
        root.getChildren().add(vBox);
        return ViewScores.formater(root);
    }
}
