package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Shape implements Touchable {
	int x;
	int y;
	int width;
	boolean mouvementDirection;
    boolean acceleration;
    double mouvementSpeed;
	Group shape;

	Shape(int x, int y, int width, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed) {
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
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	Color coloRand() {
		Random r =new Random();
		return new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1);
	}

	public Group getShape() {
		return shape;
	}
}
