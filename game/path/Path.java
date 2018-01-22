package game.path;

import java.util.List;

import game.ennemy.Ennemy;



public class Path {
	List<Obstacle> obstacles;
	List<Ennemy> ennemies;
	
	public Path(List<Obstacle> _obstacles, List<Ennemy> _ennemies){
		obstacles = _obstacles;
		ennemies = _ennemies;
	}
}
