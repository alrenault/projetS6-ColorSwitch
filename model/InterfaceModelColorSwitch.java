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
    void startColorSwitch();

	/**
	 *
 	 */
    void startGame();

	/**
	 *
	 * @param difficulty
	 */
    void startGame(Difficulty difficulty);
	
	void startGame(Difficulty difficulty, boolean infinite, Path path, Universe universe, Player ball);
	
	void startHellCircle();
	
	public void startLvl(int nbr_obs);
	
	
	
	void gameOver();
	
	void jump();
	
	void incItem(ModelItem mi);

	/**
	 *
	 */
    void registerScore();

	/**
	 *
	 * @return
	 */
    Game getGame();

	
	

}
