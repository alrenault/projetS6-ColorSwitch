package game.path;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cross extends Shapes{
	private int nbr_rect = 2;
	private int length;
	
	public Cross(int x, int y, int width, int length,Color[] colors) {
		super(x, y, width,true,false,1,colors,1);
		this.length = length;
		this.shape = buildCross();
	}

	public Cross(int x, int y, int width, int length, boolean mouvementDirection, boolean acceleration, 
			int _mouvementSpeed, int nbr_rect,Color[] colors,int pos_color) {
		
		super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed,colors,pos_color);
		if(nbr_rect != 2)
			this.nbr_rect = 4;

		this.length = length;
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
		int y_pos_2 = y-width-length/2;
	
		//Computing hight-left corner of the second rectangle
		int x_pos_3 = x+length/2;
		int y_pos_3 = y-length/2;
			
		//Computing hight-left corner of the second rectangle
		int x_pos_4 = x-length/2;
		int y_pos_4 = y+length/2;
		
		int x_middle = x-length/2;
		int y_middle = y-length/2;
		
		//Building Cross
		Rectangle part_1 = new Rectangle(x_pos_1,y_pos_1,rad,len);
		Rectangle part_2 = new Rectangle(x_pos_2,y_pos_2,len,rad);
		Rectangle part_3 = new Rectangle(x_pos_3,y_pos_3,rad,len);
		Rectangle part_4 = new Rectangle(x_pos_4,y_pos_4,len,rad);
		Rectangle middle = new Rectangle(x_middle,y_middle,len,len);
		middle.setFill(Color.WHITE);

		if(nbr_rect == 4){
			color(part_1);
			verifPosColor();

			color(part_2);
			verifPosColor();

			color(part_3);
			verifPosColor();

			color(part_4);
			verifPosColor();

		}
		else{
			color(part_1);
			color(part_3);
			verifPosColor();
			
			color(part_2);
			color(part_4);
			verifPosColor();
		}
		
		croix.getChildren().add(part_1);
		croix.getChildren().add(part_2);
		croix.getChildren().add(part_3);
		croix.getChildren().add(part_4);
		croix.getChildren().add(middle);

		
		RotateTransition rt1 = new RotateTransition(Duration.seconds(mouvementSpeed),croix);

		rt1.setByAngle(360* ((mouvementDirection)? 1 :-1 ));
		
		if(!acceleration){
			rt1.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
		}
		
		rt1.setCycleCount((int)Double.POSITIVE_INFINITY);


		rt1.play();	
		
		return croix;
	}
	


}
