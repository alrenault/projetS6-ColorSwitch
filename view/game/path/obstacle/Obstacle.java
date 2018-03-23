package view.game.path.obstacle;

import java.util.ArrayList;
import java.util.List;

import view.game.path.Element;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.modelObstacle.ModelObstacle;

/**
 * An Obstacle is a Group of Shapes which contains at least one of it
 * This class is the pattern of all obstacles in the view.game
 */
public abstract class Obstacle extends Element {

    private Group obstacle;

    private Bounds coord;
    protected ModelObstacle mo;
    List<Color> color_passable;


    Obstacle(ModelObstacle mo) {
        super();
        this.mo = mo;
        color_passable = new ArrayList<>();

        obstacle = buildObstacle();
        
        //this.obstacle = build();
        //check();
    }
 

	public ModelObstacle getModel_obstacle() {
		return mo;
	}

	protected Group build() {
    	return buildObstacle();
    }
    
    protected abstract Group buildObstacle();


    private double getX() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    public double getY() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }

    public Group getObstacle() {
        return obstacle;
    }

    public double getObstacleWidth() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getWidth();
    }

    public double getObstacleHeight() {
    	System.out.println(obstacle == null);
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getHeight();
    }


	public boolean isOver(int x, int y) {
        return this.obstacle.contains(x, y);
    }
	

	@Override
	public Group getShape() {
		// TODO Auto-generated method stub
		return obstacle;
	}


	public List<Color> getColor_passable() {
		return color_passable;
	}


    // public enum Difficulty {EASY, NORMAL, HARD}


}
