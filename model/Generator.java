package model;

import game.Game;
import game.ball.Ball;
import game.law.Universe;
import game.path.Path;


public class Generator {
	
	private Game game;
	
	public Generator(Ball _balle, Path _path, Universe _universe){
		game = new Game(_balle, _path, _universe);
	}
	
	

}
