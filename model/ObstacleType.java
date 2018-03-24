package model;

/**
 *Enums des différents type d'obstacles
 */
public enum ObstacleType {

    No(-1),
    CircleInCircle(0),
    MultiCircle(1),
    MultiCross(2),
    MultiLine(3),
    MultiShapes(4),
    MultiSquare(5);

    /**
     *Le type entier correspondant à l'enum
     */
    private int type;

    //Constructeur

    /**
     * Constructeur
     * @param t L'entier qui correspondra au type
     */
    ObstacleType(int t) {
        this.type = t;
    }

    /**
     * Accesseur de type d'Obstacle
     * @param i l'entier du type
     * @return Un Enum correspondant à i
     */
    public static ObstacleType getEnum(int i) {
        ObstacleType type;
        switch (i) {

            case 0:
                type = CircleInCircle;
                break;
            case 1:
                type = MultiCircle;
                break;
            case 2:
                type = MultiCross;
                break;
            case 3:
                type = MultiLine;
                break;
            case 4:
                type = MultiShapes;
                break;
            case 5:
                type = MultiSquare;
                break;
            default:
                type = No;
                break;
        }
        return type;
    }

    /**
     * Accesseur du type en entier
     * @return l'entier corespondant au type de this
     */
    public int getType() {
        return type;
    }
}

