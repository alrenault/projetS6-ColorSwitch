package model.modelItem;

import javafx.scene.paint.Color;
import model.ItemType;

import java.util.List;

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
