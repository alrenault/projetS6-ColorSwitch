package game.path;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cross2 extends Cross{
	
	
	public Cross2(int x, int y, int width, int length) {
		super(x, y, width,length);
		this.shape = buildCross();
	}

	public Cross2(int x, int y, int width, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed, int length, int speed, int maxwidth, int maxheight) {
		super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed, length);
		this.shape = buildCross();
	}

	int maxwidth = 1000;
	int maxheight = 1000;

	private Group buildCross() {
		
		//Initialisation
		Group croix = new Group();
		int rad = width*2;
		int len = length;

		
		//Computing hight-left corner of the first rectangle
		int x_pos_1 = high_left_corner_part1_x();
		int y_pos_1 = high_left_corner_part1_y();
	
		//Computing hight-left corner of the first rectangle
		int x_pos_2 = high_left_corner_part2_x();
		int y_pos_2 = high_left_corner_part2_y();
		
		
		//Building Cross
		Rectangle part_1 = new Rectangle(x_pos_1,y_pos_1,rad,len);
		Rectangle part_2 = new Rectangle(x_pos_2,y_pos_2,len,rad);

		part_1.setFill(Color.RED);
		part_2.setFill(Color.BLUE);
		

		croix.getChildren().add(part_1);
		croix.getChildren().add(part_2);
		
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
		int pos = x-width/2;
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

}
