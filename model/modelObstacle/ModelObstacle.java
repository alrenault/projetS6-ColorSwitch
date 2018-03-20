package model.modelObstacle;

import java.util.ArrayList;
import java.util.List;

import game.Difficulty;
import javafx.scene.paint.Color;
import model.ObstacleType;
import model.modelItem.BuildModelItem;
import model.modelItem.ModelBallColorSwitch;

public abstract class ModelObstacle {
	/**
	 * Coordonnée en x de l'Obstacle
	 */
    protected double x;
	/**
	 * Coordonnée en Y de l'Obstacle
	 */
	protected double y;
	/**
	 *
	 */
    protected List<Color> colors;
	/**
	 *
	 */
	protected int version;
	/**
	 *
	 */
    protected int versionDefault;
	/**
	 *
	 */
	protected int nbr_Versions;
	/**
	 *
	 */
    protected Difficulty difficulty;
	/**
	 *
	 */
	protected List<Color> color_use;
	/**
	 *
	 */
    protected ObstacleType type;
    
    protected ModelBallColorSwitch bcs;

	/**
	 *
	 * @param x
	 * @param y
	 * @param colors
	 * @param version
	 * @param versionDefault
	 * @param obstacleType
	 */
    public ModelObstacle(double x, double y, List<Color> colors, int version, int versionDefault, ObstacleType obstacleType){
    	this.x = x;
        this.y = y;
        this.colors = colors;
        this.versionDefault = versionDefault;
        if (0 > version) {
            this.version = versionDefault;
        } else {
            this.version = version;
        }
        color_use = new ArrayList<>();
        this.type = obstacleType;
    	bcs = buildBCS();
    }
    
    protected ModelBallColorSwitch buildBCS(){
    	ModelBallColorSwitch modelBCS = (ModelBallColorSwitch)BuildModelItem.build(0, x, y + getObstacleHeight()/2 + 150,colors, 0, 0, 0);
        return modelBCS;
    }

	/**
	 *
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		return y;
	}

	/**
	 *
	 * @return
	 */
	public List<Color> getColors() {
		return colors;
	}

	/**
	 *
	 * @return
	 */
	public int getVersion() {
		return version;
	}

	/**
	 *
	 * @param version
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 *
	 * @return
	 */
	public int getVersionDefault() {
		return versionDefault;
	}

	/**
	 *
	 * @return
	 */
	public int getNbr_Versions() {
		return nbr_Versions;
	}

	/**
	 *
	 * @return
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}

	/**
	 *
	 * @param difficulty
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 *
	 * @return
	 */
	public List<Color> getColor_use() {
		return color_use;
	}

	/**
	 *
	 * @return
	 */
	public ObstacleType getType() {
		return type;
	}

	public ModelBallColorSwitch getBcs() {
		return bcs;
	}

	/**
	 *
	 * @return
	 */
	public abstract double getObstacleHeight();
    
	   
}
