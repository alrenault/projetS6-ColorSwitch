package game.path;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Linee extends Shape {

	private int x;
	private int y;
	private int width;
	private int length;
	//private Color color;
	private double speed;
	private int nbr_seg;
	private Group shape;
	
	public Linee(int x, int y, int length, int width/*, Color color*/){
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
		//this.color = color;
		speed = 4.5;
		nbr_seg = 1;
		this.shape = buildLine();
	}
	
	public Linee(int x, int y, int length, int width/*, Color color*/,int speed, int nbr_seg){
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
		//this.color = color;
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
		tt1.setByX(400f);		//tt.setCycleCount(4);
		tt1.setCycleCount((int)Double.POSITIVE_INFINITY);//mouvement a l'infini
		tt1.setAutoReverse(true);
		tt1.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca

		tt1.play();
		
		return line;
		
	}
	
	public Group getShape() {
		return shape;
	}
	
	@Override
	public boolean isOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Color coloRand() {
		Random r =new Random();
		return new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1);
	}
}
