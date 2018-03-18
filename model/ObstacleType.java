package model;


public enum ObstacleType {
	No(-1),
	CircleInCircle(0),
	MultiCircle(1),
	MultiCross(2),
	MultiLine(3),
	MultiShapes(4),
	MultiSquare(5);
	
	private int type = -1;
	   
	  //Constructeur
	  ObstacleType(int t){
	    this.type = t;
	  }
	  
	  public int getType() {
		  return type;
	  }

	public static ObstacleType getEnum(int i) {
		ObstacleType type;
		switch(i) {
		
			case 0:
				type = CircleInCircle; break;
			case 1:
				type = MultiCircle; break;
			case 2:
				type = MultiCross; break;
			case 3:
				type = MultiLine; break;
			case 4:
				type = MultiShapes; break;
			case 5:
				type = MultiSquare; break;
			default:
				type = No; break;	
		}
		return type;
	}
}

