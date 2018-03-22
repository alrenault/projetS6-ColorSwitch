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
import javafx.scene.layout.GridPane;
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


    public static HBox entete(){
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
        text.setTextAlignment(TextAlignment.CENTER);
        return text;
    }

    /**
     *
     * @param liste
     * @return
     */
    public static Scene GroupeScoreOk(LinkedList<Record> liste){
        Group root = new Group();
        GridPane g = new GridPane();

        g.setAlignment(Pos.CENTER);
        g.setHgap(10);

        Integer i=0,j=0;
        g.add(transforme("Date"),i,j);
        i++;
        g.add(transforme("Joueur"),i,j);
        i++;
        g.add(transforme("Nombre d'étoiles"),i,j);
        i++;
        g.add(transforme("Nombre d'obstacles"),i,j);
        i++;
        g.add(transforme("Score"),i,j);

        for (Record rec : liste) {
            j++;
            i=0;
            g.add(transforme(rec.getDateRecordJoueur()),i++,j);
            g.add(transforme(rec.getPseudoJoueur()),i++,j);
            g.add(transforme(Integer.toString(rec.getNbEtoilesRamassees())),i++,j);
            g.add(transforme(Integer.toString(rec.getNbrObstaclesCrossed())),i++,j);
            g.add(transforme(Integer.toString(rec.getScore())),i++,j);
        }
        root.getChildren().add(g);

        return formater(root);
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @param s
     * @return
     */
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
