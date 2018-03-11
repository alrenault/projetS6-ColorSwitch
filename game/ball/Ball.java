package game.ball;

import java.util.List;

import game.path.Element;
import javafx.scene.Group;

/**
 * This is a generic ball which represents the player in the game
 * To create a ball, you have to extend this class
 */
public abstract class Ball extends Element {

    public abstract void applyGravity();

    public abstract void jump();
    

	@Override
	protected Group build() {
		// TODO Auto-generated method stub
		return null;
	}


}
