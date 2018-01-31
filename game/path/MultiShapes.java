package game.path;

import javafx.scene.paint.Color;
import javafx.scene.Group;


public class MultiShapes extends Obstacle {
	/*
	 version 0 : 
	 version 1 :
	 version 2 :
	 version 3 :
	 version 4 :
	 version 5 :
	 */

	public MultiShapes(int x, int y,Color[] colors,int version){
		super(x,y, colors,version);
		obstacle = buildObstacle();
	}
	
	public Group buildObstacle(){
		Group multiShapes = new Group();
		
		int length = 100;
		int tinyRadial = 40;
		int mediumRadial = 70;
		int internRadial = 85;
		int bigRadial = 100;
		int width = 15;
		int nb_arc = 4;
		int nbr_versions = 6;
		
		switch(version){
		case 0 :
			break;
		case 1 :
			break;
		case 2 :
			break;
		case 3 :
			break;
		case 4 :
			break;
		case 5 :
			break;
		}
		
		return multiShapes;
	}
}
