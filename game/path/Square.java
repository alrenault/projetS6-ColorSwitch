package game.path;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Square extends Shape {
	private int x;
	private int y;
	private int length;
	private int width;
	private boolean rotationDirection;
	private boolean acceleration;
	private double rotationSpeed;
	private Group shape;
	
	public Square(int x, int y, int length, int width){
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
		rotationDirection = true;
		acceleration = false;
		rotationSpeed = 4.5;
		this.shape = buildSquare();
	}
	
	public Square(int x, int y, int length, int width, boolean rotationDirection,
			boolean acceleration, int vitesseRotation) {

		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
		this.rotationDirection = rotationDirection;
		this.acceleration = acceleration;
		switch (vitesseRotation) {
			case 1 :
				rotationSpeed= 4.5 ;
				break;
			case 2 :
				rotationSpeed= 3.0 ;
				break;
			case 3 :
				rotationSpeed= 1.0;
				break;
			default :
				rotationSpeed= 7.0 ;
				break;
		}
		this.shape = buildSquare();
		
	
	}
	
	int maxwidth = 1000;
	int maxheight = 1000;
	
	
	public Group buildSquare(){
		Group squaire = new Group();
		
		int pos1_x = high_left_corner_part1_x();
		int pos1_y = high_left_corner_part1_y();
		
		int pos2_x = high_left_corner_part2_x();
		int pos2_y = high_left_corner_part2_y();
		
		int pos3_x = high_left_corner_part3_x();
		int pos3_y = high_left_corner_part3_y();
		
		int pos4_x = high_left_corner_part4_x();
		int pos4_y = high_left_corner_part4_y();
		
		Rectangle rec1 = new Rectangle(pos1_x,pos1_y,length-width,width);
		Rectangle rec2 = new Rectangle(pos2_x,pos2_y,width,length-width);
		Rectangle rec3 = new Rectangle(pos3_x,pos3_y,length-width,width);
		Rectangle rec4 = new Rectangle(pos4_x,pos4_y,width,length-width);
		
		rec1.setFill(Color.RED);
		rec2.setFill(Color.BLUE);
		rec3.setFill(Color.GREEN);
		rec4.setFill(Color.YELLOW);
		
		squaire.getChildren().add(rec1);
		squaire.getChildren().add(rec2);
		squaire.getChildren().add(rec3);
		squaire.getChildren().add(rec4);
		
		
		RotateTransition rt = new RotateTransition(Duration.seconds(rotationSpeed),squaire);

		rt.setByAngle(360* ((rotationDirection)? 1 :-1 ));
		
		if(!acceleration){
			rt.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
		}


		rt.setCycleCount((int)Double.POSITIVE_INFINITY);

		rt.play();

		return squaire;


	}
	
	public Group getShape() {
		return shape;
	}
	
	public int high_left_corner_part1_x() {
		int pos = x-(length+width)/2;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}
	
	public int high_left_corner_part1_y() {
		int pos = y-(length+width)/2;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}
	
	public int high_left_corner_part2_x() {
		int pos = x-(length-width)/2-width;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}
	
	public int high_left_corner_part2_y() {
		int pos = y-(length+width)/2+width;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}
	
	public int high_left_corner_part3_x() {
		int pos = x-(length+width)/2+width;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}
	
	public int high_left_corner_part3_y() {
		int pos = y+(length+width)/2-2*width;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}
	
	public int high_left_corner_part4_x() {
		int pos = x+(length+width)/2-2*width;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}
	
	public int high_left_corner_part4_y() {
		int pos = y-(length+width)/2;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}
	
	@Override
	public boolean isOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
