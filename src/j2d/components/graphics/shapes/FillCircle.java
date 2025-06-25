package j2d.components.graphics.shapes;

import j2d.attributes.transform.position.Position2D;
import j2d.engine.camera.CameraServer;
import j2d.engine.gameobject.GameObject;

import java.awt.*;

public class FillCircle extends Circle{
    public FillCircle(GameObject parentGameObject) {
        super(parentGameObject);
    }

    public FillCircle(GameObject parentGameObject, Position2D position, int radius) {
        super(parentGameObject, position, radius);
    }

    public FillCircle(GameObject parentGameObject, int layer, Position2D position, int radius) {
        super(parentGameObject, layer, position, radius);
    }

    @Override
    public void render(Graphics2D g2) {
        Graphics2D g2Copy = (Graphics2D) g2.create() ;
        applyG2Settings(g2Copy);

        int diameter = radius * 2;

        if (sticky) {
            //Does not take camera position into consideration when drawing
            g2Copy.fillOval(topLeftPosition.getIntX(), topLeftPosition.getIntY(), diameter, diameter);
        } else {
            //Uses camera position to draw with an offset
            Position2D drawPosition = topLeftPosition.getBasePosition().copy();
            drawPosition.addVector2D(CameraServer.getOffsetVector());

            g2Copy.fillOval(drawPosition.getIntX(), drawPosition.getIntY(), diameter, diameter);
        }

        g2Copy.dispose();
    }
}
