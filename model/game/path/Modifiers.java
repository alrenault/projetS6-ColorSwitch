package model.game.path;

import model.game.path.items.Item;

/**
 */
public abstract class Modifiers {
    /**
     * La forme de l' item
     */
    private Item forme;


    /**
     * Le nombre de points obtenus en attrapant cet item
     */
    private int nbPoints;

    protected Modifiers() {
    }

    public Modifiers(Item forme, int nbPoints) {
        this.forme = forme;
        this.nbPoints = nbPoints;
    }

    /**
     * Assesseur du nombre de points de l'item
     *
     * @return Le nombre de points obtenus en attrapant cet item
     */
    public int getnbPoints() {
        return nbPoints;
    }
}
