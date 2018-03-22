package model.modelItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import view.game.Colorable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.ItemType;

/**
 *
 */
public class ModelBallColorSwitch extends ModelItem implements Colorable{
	/**
	 *
	 */
	private double size;
	/**
	 *
	 */
	private int pos_color = 0;
	/**
	 *
	 */
	private List<Color> colors_use;

	/**
	 *
	 * @param x
	 * @param y
	 * @param colors
	 * @param type
	 */
	public ModelBallColorSwitch(double x, double y, List<Color> colors, ItemType type) {
		super(x,y,colors,10,type);
		this.size = 12;

		this.colors_use = new ArrayList<>();
	}

	/**
	 *
	 * @return
	 */
	public int getPos_color() {
		return pos_color;
	}

	/**
	 *
	 * @param pos_color
	 */
	public void setPos_color(int pos_color) {
		this.pos_color = pos_color;
	}

	/**
	 *
	 * @return
	 */
	public double getSize() {
		return size;
	}

	/**
	 *
	 * @return
	 */
	public List<Color> getColors_use() {
		return colors_use;
	}
	
	

	/**
	 *
	 */
	public void verifPosColor() {
		pos_color++;
		//System.out.println("position " + pos_color);
		if (pos_color == colors.size())
			pos_color = 0;
	}

	/**
	 *
	 * @param s
	 */
	public void color(Shape s) {
		Iterator<Color> it = colors.iterator();
		Color c = null;
		for(int i = 0;it.hasNext() && i <= pos_color;i++){
			c = it.next();
		}

		if(c == null)
			c = Color.WHITE;
		s.setFill(c);
		//colors_use.add(c);
	}

	public void setColors_use(List<Color> colors_use) {
		this.colors_use = colors_use;
	}
	
	

}
