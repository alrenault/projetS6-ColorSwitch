package view.useLaw;

import controller.Controller;
import view.game.ball.BallPlayer;
import view.game.path.items.Item;
import javafx.scene.Group;
import javafx.scene.shape.Shape;
import view.ViewPath;

public class CollisionItem implements UseLaw {
	
	private BallPlayer ball;
	private ViewPath path;
	private Controller controller;
	private Group jItems;
	private int nbrColliStar = 0;

	/**
	 *
	 * @param ball
	 * @param path
	 * @param controller
	 * @param jItems
	 */
	public CollisionItem(BallPlayer ball, ViewPath path, Controller controller, Group jItems){
		this.ball = ball ;
		this.path = path ;
		this.controller = controller ;
		this.jItems = jItems ;
		this.nbrColliStar=0;
	}

	/**
	 *
	 */
	@Override
	public void apply() {
		Boolean touch = false;
		for(Shape b : ball.getShapeList()){
			for(Item item : path.getItems()){
				for(Shape i : path.getItemsShapes()){
					Shape intersection = Shape.intersect(b,i);
					
					if (!intersection.getBoundsInParent().isEmpty()) {

						//System.out.println(shape.getFill().toString());
						//System.out.println(ball.getFill().toString());
						//if(item instanceof BallColorSwitch){
							//System.out.println("C'EST MA BALLE");
							//Random r = new Random();
							//ModelBallColorSwitch mBCS = (ModelBallColorSwitch)((BallColorSwitch)item).getModel_item();
							//int size = mBCS.getColors_use().size();
							//Color c = mBCS.getColors_use().get(r.nextInt(size));
							//ball.setColor(c);
							touch = true;

							item.get(path, controller, ball);

							jItems.getChildren().remove(item.getShape());


							path.removeItem(item);
							//break;
						//}
						//else{
							//touch = true;
							//System.err.println("COUCOU");
							//path.removeItem(item);
							break;
						//}
				
					}
				}
				if(touch){
					touch = false;
					break;
				}
			}
			
			
			
		}
		 
		
			//view.game.getScore().ramasseItem(i);

		}




}
