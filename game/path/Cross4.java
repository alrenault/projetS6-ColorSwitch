package game.path;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cross4 extends Cross{
	
	public Cross4(int x, int y, int width, int length) {
		super(x, y, width,length);
		this.shape = buildCross();
	}

	public Cross4(int x, int y, int width, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed, int length) {
		super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed, _mouvementSpeed);

		this.shape = buildCross();
	}

	int speed = 100;
	int maxwidth = 1000;
	int maxheight = 1000;

	private Group buildCross() {
		
		//Initialisation
		Group croix = new Group();
		int rad = width;
		int len = length;

		
		//Computing hight-left corner of the first rectangle
		int x_pos_1 = high_left_corner_part1_x();
		int y_pos_1 = high_left_corner_part1_y();
	
		//Computing hight-left corner of the second rectangle
		int x_pos_2 = high_left_corner_part2_x();
		int y_pos_2 = high_left_corner_part2_y();
		
		//Computing hight-left corner of the second rectangle
		int x_pos_3 = high_left_corner_part3_x();
		int y_pos_3 = high_left_corner_part3_y();
				
		//Computing hight-left corner of the second rectangle
		int x_pos_4 = high_left_corner_part4_x();
		int y_pos_4 = high_left_corner_part4_y();
		
		
		//Building Cross
		Rectangle part_1 = new Rectangle(x_pos_1,y_pos_1,rad,len);
		Rectangle part_2 = new Rectangle(x_pos_2,y_pos_2,len,rad);
		Rectangle part_3 = new Rectangle(x_pos_3,y_pos_3,rad,len);
		Rectangle part_4 = new Rectangle(x_pos_4,y_pos_4,len,rad);

		part_1.setFill(Color.RED);
		part_2.setFill(Color.BLUE);
		part_3.setFill(Color.GREEN);
		part_4.setFill(Color.YELLOW);
		

		croix.getChildren().add(part_1);
		croix.getChildren().add(part_2);
		croix.getChildren().add(part_3);
		croix.getChildren().add(part_4);

		
		RotateTransition rt1 = new RotateTransition(Duration.seconds(mouvementSpeed),croix);

		rt1.setByAngle(360* ((mouvementDirection)? 1 :-1 ));
		
		if(!acceleration){
			rt1.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
		}
		
		rt1.setCycleCount((int)Double.POSITIVE_INFINITY);


		rt1.play();	
		
		return croix;
	}


	private int high_left_corner_part1_x() {
		int pos = x-width-length/2;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}

	private int high_left_corner_part1_y() {
		int pos = y-length/2;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}

	private int high_left_corner_part2_x() {
		int pos = x-length/2;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}

	private int high_left_corner_part2_y() {
		int pos = y-width;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}
	
	private int high_left_corner_part3_x() {
		int pos = x+length/2;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}

	private int high_left_corner_part3_y() {
		int pos = y-length/2;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}
	private int high_left_corner_part4_x() {
		int pos = x-length/2;
		return (pos>0 || pos<maxwidth) ?	pos : 0 ;
	}

	private int high_left_corner_part4_y() {
		int pos = y;
		return (pos>0 || pos<maxheight) ?	pos : 0 ;
	}

}
