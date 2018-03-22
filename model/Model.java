package model;

import view.game.Game;
import view.game.ball.Player;
import view.game.law.Universe;
import view.game.path.Path;
import model.modelItem.ModelItem;
import view.game.Difficulty;

/**
 * This class represents the model in the MVC pattern
 * It contains ALL the data needed for the view
 */
public class Model implements InterfaceModelColorSwitch {
	/**
	 *
	 */
	private Game game;

	/**
	 *
	 */
	public Model() {
		
	}

	@Override
	public void startColorSwitch() {
		// TODO Auto-generated method stub
		
		//Charger le Menu
		
	}
	
	

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
		//Lancer une partie
		this.game = new Game();
		
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
		//Perdre la partie
		//appel au controleur et passe le score

		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
		//Faire sauter la balle
		game.jump();
		
	}

	@Override
	public void registerScore() {
		// TODO Auto-generated method stub
		
		//Enregistrer le score

		
	}

	@Override
	public void startGame(Difficulty difficulty, boolean infinite, Path path, Universe universe, Player ball) {
		// TODO Auto-generated method stub
		
		this.game = new Game();
		
	}

	public Game getGame() {
		return game;
	}

	@Override
	public void startGame(Difficulty difficulty) {
		this.game = new Game(difficulty);
		
	}
	
	public void startLvl(int nbr_obs){
		this.game = new Game(nbr_obs);
	}
	
	public void startHellCircle(){
		this.game = new Game();
	}
	
	public void circleHell(){
		
	}
	
	public void incItem(ModelItem mi){

	game.getScore().ramasseItem(mi);
	}
	
}
