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
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.LinkedList;

public class ViewScores {

    private static Scene formater(Group elements){


        Group root = new Group();

        Scene scene = new Scene(root,View.tailleX,View.tailleY);
        scene.setFill(Colorable.BLACK);

        VBox v = new VBox();
        v.getChildren().add(entete());
        v.getChildren().add(elements);

        root.getChildren().add(v);

        return scene;
    }

    public static Scene viewList(LinkedList<Record> liste){

        return formater(GroupeScoreOk(liste));
    }

    private static HBox entete(){
        HBox h = new HBox();
        Button retour = new Button();
        retour.setOnAction(e-> View.controller.startMenu());
        retour.setText(" <-- ");
        h.getChildren().add(retour);

        return h;
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
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(hBox);
        hBox =new HBox();
        hBox.setSpacing(30);
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
    public static Scene viewError(){

        Group error = new Group();
        String noCo="\nHum c'est embarrassant !\n Il semblerait que tu n'aie pas de connection...\nPas de connexion, pas de scores.";
        Text t =new Text(noCo);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setFont(new Font(26));
        t.setFill(Color.WHITE);

        error.getChildren().add(t);

        return formater(error);
    }
    public static Scene viewEndScore(Score s){
        Group fin = new Group();
        String AfficheScore="\nFin de partie!\n " +
                "Tu as fait "+s.getScore()+" points\n" +
                "Rammassé "+s.getNbEtoilesRamassees()+" étoiles et \n" +
                "traversé "+s.getNbrObstaclesCrossed()+" obstacles.";
        Text t =new Text(AfficheScore);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setFont(new Font(26));
        t.setFill(Color.WHITE);

        fin.getChildren().add(t);

        return formater(fin);
    }
}
