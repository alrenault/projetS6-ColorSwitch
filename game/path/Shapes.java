package game.path;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Shapes implements Touchable {
	int x;
	int y;
	int width;
	boolean mouvementDirection;
    boolean acceleration;
    double mouvementSpeed;
	int pos_color;
	Group shape;
	Color colors[];
	List<Color> colors_use;


	Shapes(int x, int y, int width, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed, Color[] colors, int pos_color) {
		this.x = x;
		this.y = y;
		this.width = width;
		
		this.mouvementDirection = mouvementDirection;
        this.acceleration = acceleration;
        switch (_mouvementSpeed) {
            case 1 :
                mouvementSpeed= 4.5 ;
                break;
            case 2 :
                mouvementSpeed= 3.0 ;
                break;
            case 3 :
                mouvementSpeed= 1.0;
                break;
            default :
                mouvementSpeed= 7.0 ;
                break;
        }
        
        this.colors = colors;
		if(pos_color <= 0)
			this.pos_color = 0;
		else
			this.pos_color = pos_color%colors.length;
		this.colors_use = new ArrayList<Color>();

	}
	
	public void verifPosColor(){
		pos_color++;
		if(pos_color == colors.length)
			pos_color = 0;
	}
	
	public void color(Shape s){
		s.setFill(colors[pos_color]);
		colors_use.add(colors[pos_color]);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public List<Color> getColors_use() {
		return colors_use;
	}

	Color coloRand() {
		Random r =new Random();
		return new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1);
	}

	public Group getShape() {
		return shape;
	}
}
