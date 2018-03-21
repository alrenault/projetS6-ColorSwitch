package model;

import game.Game;
import game.ball.Player;
import game.law.Universe;
import game.path.Path;
import model.modelItem.ModelItem;
import game.Difficulty;

/**
 *
 */
public interface InterfaceModelColorSwitch {
	/**
	 *
	 */
	public void startColorSwitch();

	/**
	 *
 	 */
	public void startGame();

	/**
	 *
	 * @param difficulty
	 */
	public void startGame(Difficulty difficulty);
	
	public void startGame(Difficulty difficulty, boolean infinite, Path path, Universe universe, Player ball);
	
	
	
	
	
	
	public void gameOver();
	
	public void jump();
	
	public void incItem(ModelItem mi);

	/**
	 *
	 */
	public void registerScore();

	/**
	 *
	 * @return
	 */
	public Game getGame();

	
	

}
