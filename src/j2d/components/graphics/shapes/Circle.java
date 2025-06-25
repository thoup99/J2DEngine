package j2d.components.graphics.shapes;

import j2d.attributes.transform.position.OffsetPosition2D;
import j2d.attributes.transform.position.Position2D;
import j2d.engine.camera.CameraServer;
import j2d.engine.gameobject.GameObject;
import j2d.engine.render.Renderer;

import java.awt.*;

public class Circle extends Shape {
    int radius;
    final Position2D centerPosition;
    final OffsetPosition2D topLeftPosition;

    public Circle(GameObject parentGameObject) {
        this(parentGameObject, Renderer.getTopLayer(), new Position2D(0, 0), 10);
    }

    public Circle(GameObject parentGameObject, Position2D position, int radius) {
        this(parentGameObject, Renderer.getTopLayer(), position, radius);
    }

    public Circle(GameObject parentGameObject, int layer, Position2D position, int radius) {
        super(parentGameObject, layer);
        this.radius = radius;
        this.centerPosition = position;
        this.topLeftPosition = new OffsetPosition2D(position, -radius, -radius );
    }

    public Position2D getPosition() {
        return topLeftPosition;
    }

    public Position2D getCenterPosition() {
        return centerPosition;
    }

    @Override
    public void render(Graphics2D g2) {
        Graphics2D g2Copy = (Graphics2D) g2.create() ;
        applyG2Settings(g2Copy);

        int diameter = radius * 2;

        if (sticky) {
            //Does not take camera position into consideration when drawing
            g2Copy.drawOval(topLeftPosition.getIntX(), topLeftPosition.getIntY(), diameter, diameter);
        } else {
            //Uses camera position to draw with an offset
            Position2D drawPosition = topLeftPosition.getBasePosition().copy();
            drawPosition.addVector2D(CameraServer.getOffsetVector());

            g2Copy.drawOval(drawPosition.getIntX(), drawPosition.getIntY(), diameter, diameter);
        }

        g2Copy.dispose();
    }
}
