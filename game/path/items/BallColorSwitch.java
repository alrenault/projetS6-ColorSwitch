package game.path.items;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import model.modelItem.ModelBallColorSwitch;
import model.modelItem.ModelItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    
    

}
