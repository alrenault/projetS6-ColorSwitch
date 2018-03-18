package model;

public enum ItemType {
	No(-1),
	BallColorSwitch(0),
	GravityInverser(1),
	GravitySwitch(2),
	Star(3);
	/**
	 *
	 */
	private int type = -1;
	   
	  //Constructeur

	/**
	 *
	 * @param t
	 */
	ItemType(int t){
	    this.type = t;
	  }

	/**
	 *
	 * @return
	 */
	public int getType() {
		  return type;
	  }

	/**
	 *
	 * @param i
	 * @return
	 */
	public static ItemType getEnum(int i) {
		ItemType type;
		switch(i) {
		
			case 0:
				type = BallColorSwitch; break;
			case 1:
				type = GravityInverser; break;
			case 2:
				type = GravitySwitch; break;
			case 3:
				type = Star; break;
			default:
				type = No; break;	
		}
		return type;
	}
}
