package view;
/*
*@autor Vincent
@date 22/03/2018*/

import DB.Record;
import controller.Controller;
import game.Colorable;
import game.Score;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.LinkedList;

public class ViewScores {
    private static Scene formateScene(Group racine){

        Scene s = new Scene(racine,View.tailleX,View.tailleY);
        s.setFill(Colorable.BLACK);
        return s;
    }

    /**
     * Aggrandit et blanchit
     * @param s la chaine à transformer
     * @return un Text correspondant à s en plus grand et moins (ne pas raciser)
     */
    private static Text transforme(String s){
        Text text=new Text(s);
        text.setFont(new Font(15));
        text.setFill(Color.WHITE);
        return text;
    }

    public static Group GroupeScoreOk(LinkedList<Record> liste){
        Group root = new Group();

        VBox vBox = new VBox();
        HBox hBox =new HBox();
        hBox.setSpacing(10);


        vBox.setAlignment(Pos.CENTER);

        hBox.getChildren().add(transforme("Date"));
        hBox.getChildren().add(transforme("Joueur"));
        hBox.getChildren().add(transforme("Nombre d'étoiles"));
        hBox.getChildren().add(transforme("Nombre d'obstacles"));

        hBox.getChildren().add(transforme("Score"));

        vBox.getChildren().add(hBox);

        for (Record rec : liste) {
            hBox =new HBox();
            hBox.setSpacing(10);
            hBox.getChildren().add(transforme(rec.getDateRecordJoueur()));

            hBox.getChildren().add(transforme(rec.getPseudoJoueur()));

            hBox.getChildren().add(transforme(Integer.toString(rec.getNbEtoilesRamassees())));

            hBox.getChildren().add(transforme(Integer.toString(rec.getNbrObstaclesCrossed())));

            hBox.getChildren().add(transforme(Integer.toString(rec.getScore())));


            vBox.getChildren().add(hBox);

        }
        root.getChildren().add(vBox);
        return root;
    }
    public static Scene GroupeScoresNoK(){

        Group root = new Group();
        String noCo="\nHum c'est embarrassant !\n Il semblerait que tu n'aie pas de connection...\nPas de connexion, pas de scores.";
        Text t =new Text(noCo);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setFont(new Font(26));
        t.setFill(Color.WHITE);
        root.getChildren().add(t);

        return formateScene(root);
    }
    public static Scene GroupeScoreJoueurEnCours(Score s){
        Group root = new Group();
        String AfficheScore="\nFin de partie!\n " +
                "Tu as fait "+s.getScore()+" points\n" +
                "Rammassé "+s.getNbEtoilesRamassees()+" étoiles et \n" +
                "traversé "+s.getNbrObstaclesCrossed()+" obstacles.";
        Text t =new Text(AfficheScore);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setFont(new Font(26));
        t.setFill(Color.WHITE);
        root.getChildren().add(t);

        return formateScene(root);
    }
}
