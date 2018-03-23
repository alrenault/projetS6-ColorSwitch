package view.game.path.items;

import model.modelItem.*;


public class BuildItem {

    public static Item build(ModelItem mi) {
        Item i;


        switch (mi.getType()) {
            case BallColorSwitch:
                i = new BallColorSwitch((ModelBallColorSwitch) mi);
                break;

            case GravityInverser:
                i = new GravityInverser((ModelGravityInverser) mi);
                break;

            case GravitySwitch:
                i = new GravitySwitch((ModelGravitySwitch) mi);
                break;

            case Star:
                i = new Star((ModelStar) mi);
                break;

            case InvisibleLine:
                i = new InvisibleLine((ModelInvisibleLine) mi);
                break;

            default:
                i = new GravityInverser((ModelGravityInverser) mi);
        }

        return i;
    }

}
