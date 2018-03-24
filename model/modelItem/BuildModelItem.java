package model.modelItem;

import javafx.scene.paint.Color;
import model.ItemType;

import java.util.List;

/**
 * Générateur de Modeles d'Items
 */
public class BuildModelItem {
    /**
     * Constructeur de Modèles
     *
     * @param obs       Represente le type d'Item à générer
     * @param posX      La posiion en x de l'Item à générer
     * @param posY      La posiion en y de l'Item à générer
     * @param colors    La liste des couleurs de l'Item à générer
     * @param coefForce La valeur de gravité à appliquer ( cas GravitySwitch)
     * @param radius    la taille de  l'Item à générer
     * @param nbPoint   le nomnre de points gagnés lors du rammassage de l'Item
     * @return un Model d'Item corespondant au paramètres
     */
    public static ModelItem build(int obs, double posX, double posY, List<Color> colors, double coefForce, double radius, int nbPoint, double scWidth) {
        ModelItem mi;
        ItemType type = ItemType.getEnum(obs);

        switch (type) {
            case BallColorSwitch:
                mi = new ModelBallColorSwitch(posX, posY, colors, type);
                break;

            case GravityInverser:
                mi = new ModelGravityInverser(posX, posY, type);
                break;

            case GravitySwitch:
                mi = new ModelGravitySwitch(posX, posY, coefForce, type);
                break;

            case Star:
                mi = new ModelStar(posX, posY, radius, colors, nbPoint, type);
                break;

            case InvisibleLine:
                mi = new ModelInvisibleLine(posX, posY, colors, nbPoint, type, scWidth);
                break;

            default:
                mi = new ModelGravityInverser(posX, posY, type);
        }

        return mi;
    }
}
