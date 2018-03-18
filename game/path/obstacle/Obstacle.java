package game.path.obstacle;

import java.util.List;

import game.path.Element;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.Shape;
import model.modelObstacle.ModelObstacle;

/**
 * An Obstacle is a Group of Shapes which contains at least one of it
 * This class is the pattern of all obstacles in the game
 */
public abstract class Obstacle extends Element {

    
    protected ModelObstacle model_obstacle;


    public Obstacle(ModelObstacle mo) {
        super();
        model_obstacle = mo;
        model_obstacle.setObstacle(buildObstacle(model_obstacle));
    	//model_obstacle.setCoord(model_obstacle.getObstacle().localToScene(model_obstacle.getObstacle().getBoundsInLocal()));
    	
        
        //this.obstacle = build();
        //check();
    }
    
    public ModelObstacle getModel_obstacle() {
		return model_obstacle;
	}

    
    protected abstract Group buildObstacle(ModelObstacle mo);

    


	
	


    // public enum Difficulty {EASY, NORMAL, HARD}


}
