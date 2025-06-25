package j2d.components.graphics.shapes;

import j2d.attributes.transform.position.Position2D;
import j2d.engine.camera.CameraServer;
import j2d.engine.gameobject.GameObject;

import java.awt.*;

public class FillRectangle extends Rectangle {
    public FillRectangle(GameObject parent, Position2D center, double width, double height, int layer) {
        super(parent, center, width, height, layer);
    }

    @Override
    public void render(Graphics2D g2) {
        Graphics2D g2Copy = (Graphics2D) g2.create() ;
        applyG2Settings(g2Copy);

        if (sticky) {
            //Does not take camera position into consideration when drawing
            g2Copy.fillRect(topLeft.getIntX(), topLeft.getIntY(), (bottomRight.getIntX() - topLeft.getIntX()), (bottomRight.getIntY() - topLeft.getIntY()));
        } else {
            //Uses camera position to draw with an offset
            Position2D drawPositionTopLeft = new Position2D(topLeft.getX(), topLeft.getY());
            drawPositionTopLeft.addVector2D(CameraServer.getOffsetVector());

            g2Copy.fillRect(drawPositionTopLeft.getIntX(), drawPositionTopLeft.getIntY(), (bottomRight.getIntX() - topLeft.getIntX()), (bottomRight.getIntY() - topLeft.getIntY()));
        }

        g2Copy.dispose();
    }
}
