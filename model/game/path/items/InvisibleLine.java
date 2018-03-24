package model.game.path.items;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.modelItem.ModelInvisibleLine;
import view.ViewPath;
import model.game.ball.BallPlayer;

/**
 * Objet graphique d'une ligne invisible
 */
public class InvisibleLine extends Item {

    public InvisibleLine(ModelInvisibleLine mil) {
        super(mil);
        // TODO Auto-generated constructor stub
    }

    /**
     *
     */
    protected Group buildItem() {
        Group line = new Group();

        Rectangle rec = new Rectangle(0, mi.getY(), ((ModelInvisibleLine) mi).getLength(), 20);
        rec.setFill(Color.TRANSPARENT);
        addSL(rec);
        line.getChildren().add(rec);

        return line;
    }

    /**
     * @param vPath Le ViewPath dans lequel l'Item appartient
     * @param c     Le Controlleur utilisé
     * @param b     Le joueur ramassant l'Item
     */
    @Override
    public void get(ViewPath vPath, Controller c, BallPlayer b) {
        vPath.addNewObstacle();
        c.incItem(mi);
        if (c.getScore().getNbEtoilesRamassees() > 1) {
            vPath.removeObstacle(vPath.getObstacles().get(0));
        }
    }


}
