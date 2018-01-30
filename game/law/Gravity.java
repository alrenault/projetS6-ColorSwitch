package game.law;

import game.Game;
import game.ball.Ball;

public class Gravity extends Law {
	int vectorX;
	int vectorY;
	
	public Gravity(int x, int y){
		vectorX = x;
		vectorY = y;
	}

	
	public void multiplyX(int x){
		vectorX*=x;
	}
	public void multiplyY(int y){
		vectorY*=y;
	}
	
	
	public void changeDirection(int degre){
		//TODO Changer la direction
	}
	
	
	public int getVectorX() {
		return vectorX;
	}

	public int getVectorY() {
		return vectorY;
	}


	@Override
	public void apply(Game game) {
		System.out.println("Gravity");
		game.applyGravity(); //Do Something
		
	}
	
	
}
