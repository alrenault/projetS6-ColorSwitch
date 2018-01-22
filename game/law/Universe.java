package game.law;

import java.util.HashSet;
import java.util.Set;

import game.Game;

public class Universe {
	Set<Law> laws;
	
	public Universe(){
		laws = new HashSet<Law>();
	}
	
	public void apply(Game game){
		laws.forEach(law->law.apply(game));
	}
}
