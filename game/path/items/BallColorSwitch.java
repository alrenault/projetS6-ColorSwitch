package game.path.items;

import game.Colorable;
import game.ball.Player;
import game.ball.BallPlayer;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import model.modelItem.ModelBallColorSwitch;
import model.modelItem.ModelItem;
import view.ViewPath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import controller.Controller;

public class BallColorSwitch extends Item {


    public BallColorSwitch(ModelBallColorSwitch mbcs) {
    	super(mbcs);
        item = buildItem(mbcs);
    }

    public Group buildItem(ModelItem mi) {
    	
    	ModelBallColorSwitch mbcs = (ModelBallColorSwitch)mi;
    	
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
    
    public void get(ViewPath vPath, Controller c, BallPlayer b){
    	Random r = new Random();
		ModelBallColorSwitch mBCS = (ModelBallColorSwitch)getModel_item();
		int size = mBCS.getColors_use().size();
		Color color = mBCS.getColors_use().get(r.nextInt(size));
		b.setColor(color);
		//vPath.addNewObstacle();
    }
    
    

}
