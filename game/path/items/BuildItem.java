package game.path.items;

import game.path.obstacle.CircleInCircle;
import game.path.obstacle.MultiCircle;
import game.path.obstacle.MultiCross;
import game.path.obstacle.MultiLinee;
import game.path.obstacle.MultiShapes;
import game.path.obstacle.MultiSquare;
import game.path.obstacle.Obstacle;
import model.modelItem.ModelItem;
import model.modelItem.ModelBallColorSwitch;
import model.modelItem.ModelGravityInverser;
import model.modelItem.ModelGravitySwitch;
import model.modelItem.ModelStar;

public class BuildItem {

	public static Item build(ModelItem mi) {
    	Item i;
    	
    	
    	switch (mi.getType()) {
	    	case BallColorSwitch:
	            i = new BallColorSwitch((ModelBallColorSwitch)mi);
	            break;
	
	        case GravityInverser:
	            i = new GravityInverser((ModelGravityInverser)mi);
	            break;
	
	        case GravitySwitch:
	            i = new GravitySwitch((ModelGravitySwitch)mi);
	            break;
	
	        case Star:
	            i = new Star((ModelStar)mi);
	            break;	
	        default:
	            i = new GravityInverser((ModelGravityInverser)mi);
    	}
    	
    	return i;
    }

}