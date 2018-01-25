package game.path;

abstract class Movement {


    boolean mouvementDirection;
    boolean acceleration;
    double mouvementSpeed;

    Movement(boolean mouvementDirection, boolean acceleration, int _mouvementSpeed) {
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
