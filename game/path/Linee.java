package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.paint.Paint;

import javafx.animation.TranslateTransition;

import javafx.animation.Interpolator;

public class Linee extends Shape {

	private int x;
	private int y;
	private int width;
	private int length;
	private Color color;
	private Group shape;
	
	public Linee(int x, int y, int length, int width, Color color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
		this.color = color;
		this.shape = buildLine();
	}
	
	
	public Group buildLine(){
		Group line = new Group();
		
		Rectangle rec = new Rectangle(x,y,length,width);
		rec.setFill(color);
		line.getChildren().add(rec);
		
		TranslateTransition tt1 = new TranslateTransition(Duration.seconds(2),line);
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
}
