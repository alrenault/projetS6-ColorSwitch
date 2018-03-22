package game.path.items;

import controller.Controller;
import game.ball.BallPlayer;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.modelItem.ModelItem;
import view.ViewPath;
import model.modelItem.ModelInvisibleLine;

public class InvisibleLine extends Item{

	public InvisibleLine(ModelInvisibleLine mil) {
		super(mil);
		// TODO Auto-generated constructor stub
	}
	
	protected Group buildItem(ModelItem mi) {
        Group line = new Group();

        Rectangle rec = new Rectangle(0, mi.getY(), ((ModelInvisibleLine)mi).getLength(),20);
        rec.setFill(Color.TRANSPARENT);
        addSL(rec);
        line.getChildren().add(rec);

        return line;
    }

	@Override
	public void get(ViewPath vPath, Controller c, BallPlayer b) {
		vPath.addNewObstacle();
		if(c.getScore().getNbEtoilesRamassees() > 1)
    		vPath.removeObstacle(vPath.getObstacles().get(0));
	}

}
