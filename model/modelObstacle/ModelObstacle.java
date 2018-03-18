package model.modelObstacle;

import java.util.ArrayList;
import java.util.List;

import game.Difficulty;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.ObstacleType;

public class ModelObstacle {

    protected double x;
    protected double y;
    protected List<Color> colors;
    protected int version;
    protected int versionDefault;
    protected int nbr_Versions;
    protected Difficulty difficulty;
    protected List<Color> color_use;
    protected ObstacleType type;
    
    protected Group obstacle;

    protected Bounds coord;
    protected List<Shape> shape_list;
    
    public ModelObstacle(double x, double y, List<Color> colors, int version, int versionDefault, ObstacleType obstacleType){
    	this.x = x;
        this.y = y;
        System.out.println("dans construc x "+x);
        System.out.println("dans construc y "+y);

        this.colors = colors;
        this.versionDefault = versionDefault;
        if (0 > version) {
            this.version = versionDefault;
        } else {
            this.version = version;
        }
        color_use = new ArrayList<>();
        this.type = obstacleType;
        
        obstacle = new Group();
    }


	public List<Color> getColors() {
		return colors;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersionDefault() {
		return versionDefault;
	}

	public int getNbr_Versions() {
		return nbr_Versions;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public List<Color> getColor_use() {
		return color_use;
	}

	public ObstacleType getType() {
		return type;
	}

	
    public double getX() {
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
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getHeight();
    }


	public boolean isOver(int x, int y) {
        return this.obstacle.contains(x, y);
    }


	public void setObstacle(Group obstacle) {
		this.obstacle = obstacle;
	}


	public void setCoord(Bounds coord) {
		this.coord = coord;
	}
	
	
	
    
	   
}
