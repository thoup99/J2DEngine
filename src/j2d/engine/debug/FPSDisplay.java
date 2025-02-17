package j2d.engine.debug;

import j2d.attributes.Position2D;
import j2d.components.graphics.text.Text;
import j2d.engine.Engine;
import j2d.engine.GameObject;

public class FPSDisplay extends GameObject {
    private static Text fpsText;

    FPSDisplay() {
        fpsText = new Text(this, new Position2D(5, 10), "FPS: ");
    }


    @Override
    public void update(double delta) {
        if (Debug.drawFPS) {
            fpsText.setText("FPS: " + Engine.currentFPS);
        }
    }

    @Override
    public void physics_update(double delta) {

    }
}
