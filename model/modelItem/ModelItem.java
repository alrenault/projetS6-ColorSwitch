package model.modelItem;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.ItemType;

/**
 *
 */
public class ModelItem {
	
	/**
     * coordonnée X de l'Item
     */
    protected double x;
    /**
     * coordonnée Y de l'Item
     */
    protected double y;
    
    /**
     * Le nombre de points gagnés en rammassant l'Item
     */
    protected int nbPoints;
    /**
     *La liste de couleurs que l'on peut utiliser pour cet Item
     */
    protected List<Color> colors;
    /**
     *
     */
    protected ItemType type;

    /**
     *
     * @param x coordonnée x de l'Item
     * @param y coordonnée y de l'Item
     * @param colors L'ensemble de couleurs que l'on peut utiliser pour cet Item (Liste)
     * @param nbPoints nombre de points gagnés en rammassant l'Item
     * @param type
     */
    public ModelItem(double x, double y, List<Color> colors,int nbPoints, ItemType type) {
        assert (x>=0);
        assert (y>=0);
        assert (nbPoints>=0);
        this.x = x;
        this.y = y;
        this.nbPoints=nbPoints;
        if (colors==null) {
            List<Color> c = new ArrayList<>();
            c.add(Color.WHITE);
            this.colors = c;
        }else {
            this.colors = colors;
        }
        
        this.type = type;
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
     * @param colors
     */
	public void setColors(List<Color> colors) {
		this.colors = colors;
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
	public int getNbPoints() {
        return nbPoints;
    }

    /**
     *
     * @return
     */
	public ItemType getType() {
		return type;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	

}
