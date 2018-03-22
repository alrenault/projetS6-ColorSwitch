package model;

import view.game.Game;
import view.game.ball.Player;
import view.game.law.Universe;
import view.game.path.Path;
import model.modelItem.ModelItem;
import view.game.Difficulty;

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
	
	void startLvl(int nbr_obs);
	
	
	
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
