package j2d.components.graphics.shapes;

import j2d.attributes.transform.position.Position2D;
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

        g2Copy.fillRect(topLeft.getIntX(), topLeft.getIntY(), (bottomRight.getIntX() - topLeft.getIntX()), (bottomRight.getIntY() - topLeft.getIntY()));
    }
}
