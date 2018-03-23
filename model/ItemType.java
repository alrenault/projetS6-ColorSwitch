package model;

public enum ItemType {
    No(-1),
    BallColorSwitch(0),
    GravityInverser(1),
    GravitySwitch(2),
    Star(3),
    InvisibleLine(4);
    /**
     *
     */
    private int type = -1;

    //Constructeur

    /**
     * @param t
     */
    ItemType(int t) {
        this.type = t;
    }

    /**
     * @param i
     * @return
     */
    public static ItemType getEnum(int i) {
        ItemType type;
        switch (i) {

            case 0:
                type = BallColorSwitch;
                break;
            case 1:
                type = GravityInverser;
                break;
            case 2:
                type = GravitySwitch;
                break;
            case 3:
                type = Star;
                break;
            case 4:
                type = InvisibleLine;
                break;
            default:
                type = No;
                break;
        }
        return type;
    }

    /**
     * @return
     */
    public int getType() {
        return type;
    }
}
