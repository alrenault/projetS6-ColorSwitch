package model.game.path.items;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import model.modelItem.ModelBallColorSwitch;
import view.ViewPath;
import model.game.ball.BallPlayer;

import java.util.Random;

/**
 * Objet graphique de la balle chnageuse de couleur
 */
public class BallColorSwitch extends Item {

    /**
     * Constructeur de la BallColorSwitch
     *
     * @param mbcs Le model utilisé pour créé la balle
     */
    public BallColorSwitch(ModelBallColorSwitch mbcs) {
        super(mbcs);
    }

    /**
     * Genere la forme
     *
     * @return un ensemble de Forme
     */
    public Group buildItem() {

        ModelBallColorSwitch mbcs = (ModelBallColorSwitch) mi;
        Group ball = new Group();

        double angle = 90;

        ArcType type = ArcType.ROUND;


        for (int i = 0; i <= 4; i++) {
            Arc arc_1 = new Arc(mbcs.getX(), mbcs.getY(), mbcs.getSize(), mbcs.getSize(), i * angle, angle);
            arc_1.setType(type);
            mbcs.color(arc_1);
            mbcs.verifPosColor();
            ball.getChildren().add(arc_1);
            addSL(arc_1);
        }

        return ball;

    }

    public void get(ViewPath vPath, Controller c, BallPlayer b) {
        Random r = new Random();
        ModelBallColorSwitch mBCS = (ModelBallColorSwitch) getModel_item();
        int size = mBCS.getColors_use().size();
        Color color = mBCS.getColors_use().get(r.nextInt(size));
        b.setColor(color);

        //vPath.addNewObstacle();


    }


}
