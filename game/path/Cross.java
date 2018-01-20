package game.path;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cross extends Shape {
	
	private int x;
	private int y;
	private int radial;
	private int length;
	private Group shape;
	
	public Cross(int x, int y, int radial, int length) {
		this.x = x;
		this.y = y;
		this.radial = radial;
		this.length = length;
		this.shape = buildCross();
	}
	
	
	int speed = 100;
	int maxwidth = 1000;
	int maxheight = 1000;
	
	public Group buildCross() {
		
		//Initialisation
		Group croix = new Group();
		int rad = radial*2;
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
		
		RotateTransition rt1 = new RotateTransition(Duration.seconds(4.5),croix);

		rt1.setByAngle(-360);
		
		rt1.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
		
		rt1.setCycleCount((int)Double.POSITIVE_INFINITY);


		rt1.play();	
		
		return croix;
	}
	
	
	
	
	public Group getShape() {
		return shape;
	}
	
	
	public int high_left_corner_part1_x(int x) {
		int pos = x-radial;
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
		int pos = y-radial;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}




	@Override
	public boolean isOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}

