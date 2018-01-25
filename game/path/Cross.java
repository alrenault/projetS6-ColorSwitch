package game.path;

public abstract class Cross extends Shape {
	
	protected int length;

	
	public Cross(int x, int y, int width, int length) {
		super(x, y, width,true,false,1);
		this.length = length;

	}

	public Cross(int x, int y, int width, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed, int length) {
		super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed);
		this.length = length;
	}

	@Override
	public boolean isOver(int x, int y) {
		//TODO
		return false;
	}
}

