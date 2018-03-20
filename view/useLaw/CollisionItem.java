package view.useLaw;

import java.util.Random;

import controller.Controller;
import game.ball.BallPlayer;
import game.path.items.BallColorSwitch;
import game.path.items.Item;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import view.ViewPath;
import model.modelItem.ModelBallColorSwitch;

public class CollisionItem implements UseLaw {
	
	BallPlayer ball;
	ViewPath path;
	Controller controller;
	Group jItems;
	
	public CollisionItem(BallPlayer ball, ViewPath path, Controller controller, Group jItems){
		this.ball = ball ;
		this.path = path ;
		this.controller = controller ;
		this.jItems = jItems ;
	}

	@Override
	public void apply() {
		Boolean touch = false;
		for(Shape b : ball.getShapeList()){
			for(Item item : path.getItems()){
				for(Shape i : path.getItemsShapes()){
					Shape intersection = Shape.intersect(b,i);
					
					if (!intersection.getBoundsInParent().isEmpty()) {
						System.out.println("test");
						//System.out.println(shape.getFill().toString());
						//System.out.println(ball.getFill().toString());
						if(item instanceof BallColorSwitch){
							System.out.println("C'EST MA BALLE");
							Random r = new Random();
							ModelBallColorSwitch mBCS = (ModelBallColorSwitch)((BallColorSwitch)item).getModel_item();
							int size = mBCS.getColors_use().size();
							Color c = mBCS.getColors_use().get(r.nextInt(size));
							ball.setColor(c);
							touch = true;
							
							jItems.getChildren().remove(item.getShape());
							for(Shape oui : item.getShapeList()) {
								oui.setFill(Color.TRANSPARENT);
								
							}
							
							path.removeItem(item);
							break;
						}
				
					}
				}
				if(touch){
					touch = false;
					break;
				}
			}
			
			
			
		}
		 
		
			//game.getScore().ramasseItem(i);

		}	

}