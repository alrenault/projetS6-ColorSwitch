package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;


public class CircleInCircle extends Obstacle {
	//version 0 : petit cercle tournant dans le sens horraire
	//version 1 : petit cercle tournant dans le sens contre horraire
	//version 2 : cercle moyen tournant dans le sens horraire
	//version 3 : cercle moyen tournant dans le sens contre horraire
	//version 4 : grand cercle tournant dans le sens horraire
	//version 5 : grand cercle tournant dans le sens contre horraire
	//version 6 : 2 cercles imbriqués 
	//version 7 : 2 cercles imbriqués dans autre sens 
	//version 8 : 3 cercles imbriqués
	//version 9 : 3 cercles imbriqués dans l'autre sens
	//default : grand cercle tournant dans le sens horraire

	public CircleInCircle(int x, int y,Color[] colors,int version){
		super(x,y, colors,version);
		obstacle = buildObstacle();
	}
	
	private Group buildObstacle(){
		Group circleInCircle = new Group();
		Circle cer1;
		Circle cer2;
		Circle cer3;
		
		switch(version){
		case 0:
			cer1 =new Circle(280, 150, 40, 15 ,4,true,false,1,colors,1);
			circleInCircle.getChildren().add(cer1.getShape());
			break;
		case 1:
			cer1 =new Circle(280, 150, 40, 15 ,4,false,false,1,colors,1);
			circleInCircle.getChildren().add(cer1.getShape());			
			break;
			
		case 2:
			cer1 =new Circle(280, 150, 70, 15 ,4,true,false,1,colors,1);
			circleInCircle.getChildren().add(cer1.getShape());
			break;
			
		case 3 :
			cer1 =new Circle(280, 150, 70, 15 ,4,false,false,1,colors,1);
			circleInCircle.getChildren().add(cer1.getShape());			
			break;
			
		case 4 :
			cer1 =new Circle(280, 150, 100, 15 ,4,true,false,1,colors,1);
			circleInCircle.getChildren().add(cer1.getShape());
			break;
		case 5 :
			cer1 =new Circle(280, 150, 100, 15 ,4,false,false,1,colors,1);
			circleInCircle.getChildren().add(cer1.getShape());
			break;
		case 6 :
			cer1 =new Circle(280, 150, 100, 15 ,4,true,false,1,colors,1);
			cer2 =new Circle(280, 150, 85, 15 ,4,false,false,2,colors,3);

			circleInCircle.getChildren().add(cer1.getShape());
			circleInCircle.getChildren().add(cer2.getShape());
			break;
		case 7 :
			cer1 =new Circle(280, 150, 100, 15 ,4,false,false,1,colors,1);
			cer2 =new Circle(280, 150, 85, 15 ,4,true,false,2,colors,3);

			circleInCircle.getChildren().add(cer1.getShape());
			circleInCircle.getChildren().add(cer2.getShape());
			break;
		case 8 :
			cer1 =new Circle(280, 150, 100, 15 ,4,false,false,1,colors,1);
			cer2 =new Circle(280, 150, 85, 15 ,4,true,false,2,colors,3);
			cer3 =new Circle(280, 150, 70, 15 ,4,false,false,1,colors,1);

			circleInCircle.getChildren().add(cer1.getShape());
			circleInCircle.getChildren().add(cer2.getShape());
			circleInCircle.getChildren().add(cer3.getShape());
			break;
		case 9 :
			cer1 =new Circle(280, 150, 100, 15 ,4,true,false,1,colors,1);
			cer2 =new Circle(280, 150, 85, 15 ,4,false,false,2,colors,3);
			cer3 =new Circle(280, 150, 70, 15 ,4,true,false,1,colors,1);

			circleInCircle.getChildren().add(cer1.getShape());
			circleInCircle.getChildren().add(cer2.getShape());
			circleInCircle.getChildren().add(cer3.getShape());
			break;
			
		default:
			cer1 =new Circle(280, 150, 100, 15 ,4,true,false,1,colors,1);
			circleInCircle.getChildren().add(cer1.getShape());
				
		}

		
		
		return circleInCircle;

	}
	
	public Group getObstacle(){
		return obstacle;
	}
}
