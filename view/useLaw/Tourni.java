package view.useLaw;

import javafx.scene.Scene;

public class Tourni implements UseLaw {

    private Scene scene;
    private int i = 0;

    public Tourni(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void apply() {
        i++;
        scene.getCamera().setRotate(i);

    }

}
