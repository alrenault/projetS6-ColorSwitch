package view;

import DB.Record;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.game.Colorable;
import model.game.Score;

import java.util.LinkedList;

class ViewScores {
    /**
     * Formate le groupe en une scene formattée ( Factorisation de code)
     *
     * @param elements Le groupe à Formater
     * @return Une Scene avec un bouton retour et une couleur noire en background
     */
    public static Scene formater(Group elements) {
        Group root = new Group();
        Scene scene = new Scene(root, View.tailleX, View.tailleY);
        scene.setFill(Colorable.BLACK);
        VBox v = new VBox();
        v.getChildren().add(entete());
        v.getChildren().add(elements);
        root.getChildren().add(v);
        return scene;
    }

    /**
     * Insere de quoi retourner au menu
     *
     * @return Un Hbox contenant un bouton retour
     */
    private static HBox entete() {
        HBox h = new HBox();
        Button retour = new Button();
        retour.setOnMouseClicked(event -> View.controller.startMenu());
        retour.setOnAction(e -> View.controller.startMenu());
        retour.setText(" <-- ");
        h.getChildren().add(retour);

        return h;
    }

    /**
     * Aggrandit et blanchit
     *
     * @param s la chaine à transformer
     * @return un Text formaté
     */
    private static Text transforme(String s) {
        Text text = new Text(s);
        text.setFont(new Font(15));
        text.setFill(Color.WHITE);
        text.setTextAlignment(TextAlignment.CENTER);
        return text;
    }

    /**
     * Génère une page contenant les derniers scores enregistrés
     *
     * @param liste La liste des scores
     * @return Une scene contenant la grille des scores
     */
    public static Scene GroupeScoreOk(LinkedList<Record> liste) {
        Group root = new Group();
        GridPane g = new GridPane();

        g.setAlignment(Pos.CENTER);
        g.setHgap(10);

        Integer i = 0, j = 0;
        g.add(transforme("Date"), i, j);
        i++;
        g.add(transforme("Joueur"), i, j);
        i++;
        g.add(transforme("Nombre d'étoiles"), i, j);
        i++;
        g.add(transforme("Nombre d'obstacles"), i, j);
        i++;
        g.add(transforme("Score"), i, j);
        for (Record rec : liste) {
            j++;
            i = 0;
            g.add(transforme(rec.getDateRecordJoueur()), i++, j);
            g.add(transforme(rec.getPseudoJoueur()), i++, j);
            g.add(transforme(Integer.toString(rec.getNbEtoilesRamassees())), i++, j);
            g.add(transforme(Integer.toString(rec.getNbrObstaclesCrossed())), i++, j);
            g.add(transforme(Integer.toString(rec.getScore())), i++, j);
        }
        root.getChildren().add(g);

        return formater(root);
    }

    /**
     * Génère une page comportant un message d'erreur (Scores)
     *
     * @return Une Scene Avec un message expliquatif
     */
    public static Scene viewError() {

        Group error = new Group();
        String noCo = "\nHum c'est embarrassant !\n Il semblerait que tu n'aie pas de connection...\nPas de connexion, pas de scores.";
        Text t = new Text(noCo);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setFont(new Font(26));
        t.setFill(Color.WHITE);

        error.getChildren().add(t);

        return formater(error);
    }

    /**
     * Affiche le score de la partie et propose d'enregistrer
     *
     * @param s Le score de la partie
     * @return Une Scene de fin de partie
     */
    public static Scene viewEndScore(Score s) {
        Group g = new Group();

        VBox stack = new VBox();

        HBox ligne = new HBox();

        String AfficheScore = "\nFin de partie!\n " +
                "Tu as fait " + s.getScore() + " points\n" +
                "Rammassé " + s.getNbEtoilesRamassees() + " étoiles et \n" +
                "traversé " + s.getNbrObstaclesCrossed() + " obstacles.";
        Text t = new Text(AfficheScore);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setFont(new Font(26));
        t.setFill(Color.WHITE);
        if (View.controller.isConnect()) {
            Button recordScore_oui = new Button();
            recordScore_oui.setText("Oui");
            recordScore_oui.setOnAction(event -> View.controller.recordScore(s));
            Button recordScore_non = new Button();
            recordScore_non.setText("Non");
            recordScore_non.setOnAction(event -> View.controller.startMenu());
            Text boutons = new Text();
            boutons.setText("Enregistrer score ? :");
            boutons.setTextAlignment(TextAlignment.CENTER);
            boutons.setFont(new Font(26));
            boutons.setFill(Color.WHITE);

            ligne.getChildren().addAll(boutons, recordScore_oui, recordScore_non);
        } else {

            Button retourMenu = new Button();
            retourMenu.setText("Retour au Menu");
            retourMenu.setOnAction(event -> View.controller.startMenu());

            ligne.getChildren().add(retourMenu);
        }
        stack.getChildren().add(t);
        stack.getChildren().add(ligne);
        stack.setAlignment(Pos.CENTER);

        g.getChildren().add(stack);

        return formater(g);
    }
}
