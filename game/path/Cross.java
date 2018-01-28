package game.path;

import java.util.ArrayList;
import java.util.List;
import game.Colorable;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cross extends Shape{
	private int nbr_rect = 2;
	private int length;
	private List<Color> colors;
	
	public Cross(int x, int y, int width, int length) {
		super(x, y, width,true,false,1);
		this.length = length;
		this.colors = new ArrayList<Color>();
		this.shape = buildCross();
	}

	public Cross(int x, int y, int width, int length, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed, int nbr_rect) {
		super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed);
		if(nbr_rect != 2)
			this.nbr_rect = 4;

		this.length = length;
		this.colors = new ArrayList<Color>();
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
		int x_pos_1 = x-width-length/2;
		int y_pos_1 = y-length/2;

		//Computing hight-left corner of the second rectangle
		int x_pos_2 = x-length/2;
		int y_pos_2 = y-width;
	
		//Computing hight-left corner of the second rectangle
		int x_pos_3 = x+length/2;
		int y_pos_3 = y-length/2;
			
		//Computing hight-left corner of the second rectangle
		int x_pos_4 = x-length/2;
		int y_pos_4 = y;
		
		//Building Cross
		Rectangle part_1 = new Rectangle(x_pos_1,y_pos_1,rad,len);
		Rectangle part_2 = new Rectangle(x_pos_2,y_pos_2,len,rad);
		Rectangle part_3 = new Rectangle(x_pos_3,y_pos_3,rad,len);
		Rectangle part_4 = new Rectangle(x_pos_4,y_pos_4,len,rad);

		if(nbr_rect == 4){
			part_1.setFill(Color.RED);
			part_2.setFill(Color.BLUE);
			part_3.setFill(Color.GREEN);
			part_4.setFill(Color.YELLOW);
			colors.add(Color.RED);
			colors.add(Color.BLUE);
			colors.add(Color.GREEN);
			colors.add(Color.YELLOW);

		}
		else{
			part_1.setFill(Color.RED);
			part_2.setFill(Color.BLUE);
			part_3.setFill(Color.RED);
			part_4.setFill(Color.BLUE);
			colors.add(Color.RED);
			colors.add(Color.BLUE);
		}
		
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
	
	@Override
	public boolean isOver(int x, int y) {
		//TODO
		return false;
	}

}
