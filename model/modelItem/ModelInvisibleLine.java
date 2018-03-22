package model.modelItem;

import java.util.List;

import javafx.scene.paint.Color;
import model.ItemType;

public class ModelInvisibleLine extends ModelItem {
	
	private double length;

	public ModelInvisibleLine(double x, double y, List<Color> colors, int nbPoints, ItemType type, double length) {
		super(x, y, colors, nbPoints, type);
		this.length = length;
	}

	public double getLength() {
		return length;
	}
	
	

}
