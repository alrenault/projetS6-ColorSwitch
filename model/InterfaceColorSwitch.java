package model;

import game.Game;
import game.ball.Ball;
import game.law.Universe;
import game.path.Path;
import game.Difficulty;

public interface InterfaceColorSwitch {
	
	public void startColorSwitch();

	public void startGame();
	
	public void startGame(Difficulty difficulty, boolean infinite, Path path, Universe universe, Ball ball);
	
	public void gameOver();
	
	public void jump();
	
	public void registerScore();
	

}
