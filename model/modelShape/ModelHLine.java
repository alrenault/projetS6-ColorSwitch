package model.modelShape;

import java.util.List;

import game.Speed;
import javafx.scene.paint.Color;

public class ModelHLine extends ModelShape {
	
	private double length;
	
	private boolean reverse;
	
	private int nbr_seg;
	
	private double goal;

	public ModelHLine(double x, double y, double length, double width, boolean acceleration
            , boolean reverse, Speed mouvementSpeed, int nbr_seg, List<Color> colors, int pos_color, double goal) {
		super(x, y, width, true, acceleration, mouvementSpeed, colors, pos_color);
		
		this.length = length;
		this.reverse = reverse;
		this.nbr_seg = nbr_seg;
		this.goal = goal;
	}

	public double getLength() {
		return length;
	}

	public boolean isReverse() {
		return reverse;
	}

	public int getNbr_seg() {
		return nbr_seg;
	}

	public double getGoal() {
		return goal;
	}
	
	

}
