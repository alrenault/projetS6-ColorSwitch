package game.path;

public abstract class Movement {


    protected boolean mouvementDirection;
    protected boolean acceleration;
    protected double mouvementSpeed;

    public Movement(boolean mouvementDirection, boolean acceleration, int _mouvementSpeed) {
        this.mouvementDirection = mouvementDirection;
        this.acceleration = acceleration;
        switch (_mouvementSpeed) {
            case 1 :
                mouvementSpeed= 4.5 ;
                break;
            case 2 :
                mouvementSpeed= 3.0 ;
                break;
            case 3 :
                mouvementSpeed= 1.0;
                break;
            default :
                mouvementSpeed= 7.0 ;
                break;
        }
    }

}
