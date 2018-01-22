package game.path;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cross extends Shape {
	
	private int length;
	private boolean rotationDirection;
	private boolean acceleration;
	private double rotationSpeed;
	
	public Cross(int x, int y, int width, int length) {
		super(x, y, width);
		this.length = length;
		rotationDirection = true;
		acceleration = false;
		rotationSpeed = 4.5;
		this.shape = buildCross();
	}
	
	public Cross(int x, int y, int width, int length, boolean rotationDirection,
			boolean acceleration, int vitesseRotation) {

		super(x, y, width);
		this.length = length;
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
		this.shape = buildCross();
		
	
	}
	
	
	int speed = 100;
	int maxwidth = 1000;
	int maxheight = 1000;
	
	public Group buildCross() {
		
		//Initialisation
		Group croix = new Group();
		int rad = width*2;
		int len = length;

		
		//Computing hight-left corner of the first rectangle
		int x_pos_1 = high_left_corner_part1_x(x);
		int y_pos_1 = high_left_corner_part1_y(y);
	
		//Computing hight-left corner of the first rectangle
		int x_pos_2 = high_left_corner_part2_x(x);
		int y_pos_2 = high_left_corner_part2_y(y);
		
		
		//Building Cross
		Rectangle part_1 = new Rectangle(x_pos_1,y_pos_1,rad,len);
		Rectangle part_2 = new Rectangle(x_pos_2,y_pos_2,len,rad);

		part_1.setFill(Color.RED);
		part_2.setFill(Color.BLUE);
		

		croix.getChildren().add(part_1);
		croix.getChildren().add(part_2);
		
		RotateTransition rt1 = new RotateTransition(Duration.seconds(rotationSpeed),croix);

		rt1.setByAngle(360* ((rotationDirection)? 1 :-1 ));
		
		if(!acceleration){
			rt1.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
		}
		
		rt1.setCycleCount((int)Double.POSITIVE_INFINITY);


		rt1.play();	
		
		return croix;
	}
	
	
	
	

	
	
	public int high_left_corner_part1_x(int x) {
		int pos = x-width;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}
	
	public int high_left_corner_part1_y(int x) {
		int pos = y-length/2;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}
	
	public int high_left_corner_part2_x(int x) {
		int pos = x-length/2;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}
	
	public int high_left_corner_part2_y(int x) {
		int pos = y-width;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}


	@Override
	public boolean isOver(int x, int y) {
		//TODO
		return false;
	}
}

