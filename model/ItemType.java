package model;

/**
 * Enum des differents types d'Items
 */
public enum ItemType {
    No(-1),
    BallColorSwitch(0),
    GravityInverser(1),
    GravitySwitch(2),
    Star(3),
    InvisibleLine(4);

    /**
     * Le type entier correspondant à l'enum
     */
    private int type;

    //Constructeur

    /**
     * Constructeur
     *
     * @param t L'entier qui correspondra au type
     */
    ItemType(int t) {
        this.type = t;
    }

    /**
     * Accesseur de type d'Item
     *
     * @param i l'entier du type
     * @return Un Enum correspondant à i
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
     * Accesseur du type en entier
     *
     * @return l'entier corespondant au type de this
     */
    public int getType() {
        return type;
    }
}


