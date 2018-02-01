package game.law;

import game.Game;

public class Gravity extends Law {
    double vectorX;
    double vectorY;

    public Gravity(double x, double y) {
        vectorX = x;
        vectorY = y;
    }


    public void multiplyX(double x) {
        vectorX *= x;
    }

    public void multiplyY(double y) {
        vectorY *= y;
    }


    public void changeDirection(double degre) {
        //TODO Changer la direction
    }


    public double getVectorX() {
        return vectorX;
    }

    public double getVectorY() {
        return vectorY;
    }


    @Override
    public void apply(Game game) {
        System.out.println("Gravity");
        game.applyGravity(); //Do Something

    }


}
