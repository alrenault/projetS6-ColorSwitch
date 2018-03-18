package model.modelItem;

import java.util.List;

import javafx.scene.paint.Color;
import model.ItemType;


public class BuildModelItem {

	public static ModelItem build(int obs, double posX, double posY, List<Color> colors, double coefForce, double radius, int nbPoint) {
        ModelItem mi;
        ItemType type = ItemType.getEnum(obs);

        switch (type) {
            case BallColorSwitch:
                mi = new ModelBallColorSwitch(posX, posY, colors, type);
                break;

            case GravityInverser:
                mi = new ModelGravityInverser(posX, posY, type);
                break;

            case GravitySwitch:
                mi = new ModelGravitySwitch(posX, posY,coefForce, type);
                break;

            case Star:
                mi = new ModelStar(posX, posY,radius, colors, nbPoint, type);
                break;

            default:
                mi = new ModelGravityInverser(posX, posY, type);
        }
        
        return mi;
	}
}
