package game.path;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Linee extends Shape {


	private int length;
	private double speed;
	private int nbr_seg;
	
	
	public Linee(int x, int y, int length, int width/*, Color color*/){
super(x, y, width);
		this.length = length;

		speed = 4.5;
		nbr_seg = 1;
		this.shape = buildLine();
	}
	
	public Linee(int x, int y, int length, int width,int speed, int nbr_seg){
		super(x, y, width);
		this.length = length;

		this.nbr_seg = nbr_seg;
		
		switch (speed) {
		case 1 :
			this.speed = 4.5 ;
			break;
		case 2 :
			this.speed = 3.0 ;
			break;
		case 3 :
			this.speed = 1.0;
			break;
		default :
			this.speed = 7.0 ;
			break;
		}	
		this.shape = buildLine();
	}
	
	
	public Group buildLine(){
		Group line = new Group();
		
		for(int i=0; i<nbr_seg; i++){
			Rectangle rec = new Rectangle(x+length*i,y,length,width);
			rec.setFill(coloRand());
			line.getChildren().add(rec);
		}
		
		
		TranslateTransition tt1 = new TranslateTransition(Duration.seconds(speed),line);
		tt1.setByX(400f);		
		tt1.setCycleCount((int)Double.POSITIVE_INFINITY);
		tt1.setAutoReverse(true);
		tt1.setInterpolator(Interpolator.LINEAR);
		tt1.play();
		
		return line;
		
	}
	

	@Override
	public boolean isOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
