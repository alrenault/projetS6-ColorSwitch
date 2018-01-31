package game.path;

import javafx.scene.paint.Color;
import javafx.scene.Scene;
import game.Colorable;
import javafx.scene.Group;
import game.path.Obstacle.ensDifficulty;


public class MultiLinee extends Obstacle {
	/*
	version 0 : 1 segment commençant de la gauche
	version 1 : 1 segement commençant de la droite
	version 2 : un segment commençant de la droite + un segment rapide commençant de la gauche 
	version 3 : 1 ligne faisant des aller-retour
	version 4 : 1 ligne allant de la gauche vers la droite
	version 5 : 1 ligne allant de la gauche vers la droite et 1 ligne allant de la droite vers la gauche
	version 6 : 1 ligne allant de la gauche vers la droite et 1 ligne allant de la droite vers la gauche avec un espace
	*/

	Scene scene;
	
	public MultiLinee(int x, int y,Color[] colors,int version,Scene scene){
		super(x,y, colors,version);
		this.scene = scene;
		obstacle = buildObstacle();
	}
	
	private Group buildObstacle(){
		
		int length = 100;
		int width = 20;
		int nbr_versions = 7;
		Group multiLinee = new Group();
		
		Linee l1;
		Linee l2;
		
		/*public Linee(int x, int y,int length, int width, boolean acceleration, 
				boolean reverse,int _mouvementSpeed, int nbr_seg, Color[] colors, int pos_colors,int goal) {*/
		if(version >= nbr_versions)
			version = 4;

		switch(version){
		case 0:
			l1 = new Linee(-length,y,length,width,false,true,3,1,colors,0,(int)scene.getWidth()+length);
			multiLinee.getChildren().add(l1.getShape());
			difficulty = ensDifficulty.EASY;
			break;
		case 1:
			l1 = new Linee((int)scene.getWidth(),y,length,width,false,true,2,1,colors,1,-((int)scene.getWidth()+length));
			multiLinee.getChildren().add(l1.getShape());
			difficulty = ensDifficulty.EASY;
			break;
		case 2:
			l1 = new Linee((int)scene.getWidth(),y,length,width,false,true,2,1,colors,1,-((int)scene.getWidth()+length));
			l2 = new Linee(-length,y+width,length,width,false,true,3,1,colors,0,(int)scene.getWidth()+length);

			multiLinee.getChildren().add(l1.getShape());
			multiLinee.getChildren().add(l2.getShape());
			difficulty = ensDifficulty.NORMAL;
			break;
		case 3:
			l1 = new Linee(-length*4,y,length,width,false,true,1,(int)scene.getWidth()/length+4,colors,0,length*4);
			multiLinee.getChildren().add(l1.getShape());
			difficulty = ensDifficulty.NORMAL;
			break;
		case 4:
			l1 = new Linee(-length*4,y,length,width,false,false,1,(int)scene.getWidth()/length+4,colors,0,length*4);
			multiLinee.getChildren().add(l1.getShape());
			difficulty = ensDifficulty.EASY;
			
			break;
		case 5:
			l1 = new Linee(-length*4,y,length,width,false,false,1,(int)scene.getWidth()/length+4,colors,0,length*4);
			l2 = new Linee(0,y+width,length,width,false,false,2,(int)scene.getWidth()/length+4,colors,1,-(length*4));

			multiLinee.getChildren().add(l1.getShape());
			multiLinee.getChildren().add(l2.getShape());
			difficulty = ensDifficulty.NORMAL;
			break;
		case 6:
			l1 = new Linee(-length*4,y,length,width,false,false,1,(int)scene.getWidth()/length+4,colors,0,length*4);
			l2 = new Linee(0,y+width+80,length,width,false,false,2,(int)scene.getWidth()/length+4,colors,1,-(length*4));

			multiLinee.getChildren().add(l1.getShape());
			multiLinee.getChildren().add(l2.getShape());
			difficulty = ensDifficulty.NORMAL;
			break;
		default:
			l1 = new Linee(-length*4,y,length,width,false,false,1,(int)scene.getWidth()/length+4,colors,0,length*4);
			multiLinee.getChildren().add(l1.getShape());
			difficulty = ensDifficulty.EASY;
		}
		
		return multiLinee;

	}
	

}
