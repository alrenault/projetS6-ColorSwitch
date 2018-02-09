package game.path;

import game.ennemy.Ennemy;
import game.path.pluri.Obstacle;

import java.util.ArrayList;
import java.util.List;


public class Path {
	private List<Obstacle> obstacles;
	private List<Ennemy> ennemies;


	public Path() {
		obstacles = new ArrayList<Obstacle>();
		ennemies = new ArrayList<Ennemy>();
	}

	public Path(List<Obstacle> _obstacles, List<Ennemy> _ennemies) {
		obstacles = _obstacles;
		ennemies = _ennemies;
	}

	public void add(Obstacle o) {
		obstacles.add(o);
	}

	public void add(Ennemy e) {
		ennemies.add(e);
	}

	public void remove(Obstacle o) {
		obstacles.remove(o);
	}

	public void remove(Ennemy e) {
		ennemies.remove(e);
	}

	public boolean isCorrect() {
		//TODO
		return false;
	}


	/*c'est pas cool !!!*/
	//TODO
	public List<Obstacle> getObstacles() {
		return obstacles;
	}

	//TODO
	public List<Ennemy> getEnnemies() {
		return ennemies;
	}


}
