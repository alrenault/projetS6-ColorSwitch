package game;

import game.ball.Ball;
import game.law.Universe;
import game.path.Path;

public class Game {
	
	Ball balle;
	Path path;
	Universe universe;


	public Game(Ball _balle, Path _path, Universe _universe){
		this.balle = _balle;
		this.path = _path;
		this.universe = _universe;
	}
	
	public Game(){
		
	}
}
