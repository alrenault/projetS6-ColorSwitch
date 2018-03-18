package model.modelItem;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.ItemType;

public class ModelItem {
	
	/**
     * coordonnée x de l'objet
     */
    protected double x;
    /**
     * coordonnée Y de l'objet
     */
    protected double y;
    
    /**
     * Le nombre de points gagné
     */
    protected int nbPoints;
    
    protected List<Color> colors;
    
    protected ItemType type;


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
    

    public List<Color> getColors() {
		return colors;
	}


	public void setColors(List<Color> colors) {
		this.colors = colors;
	}


	public double getX() {
		return x;
	}


	public double getY() {
		return y;
	}


	public int getNbPoints() {
        return nbPoints;
    }


	public ItemType getType() {
		return type;
	}
	
	

}
