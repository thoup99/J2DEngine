package j2d.components.graphics.shapes;

import j2d.attributes.Vector2D;
import j2d.attributes.transform.position.OffsetPosition2D;
import j2d.attributes.transform.position.Position2D;
import j2d.engine.camera.CameraServer;
import j2d.engine.gameobject.GameObject;


import java.awt.*;

public class Rectangle extends Shape {
    Position2D center;
    OffsetPosition2D topLeft, bottomRight;
    double width, height;

    public Rectangle(GameObject parent, Position2D center, double width, double height, int layer) {
        super(parent, layer);
        this.center = center;
        this.width = width;
        this.height = height;

        topLeft = new OffsetPosition2D(center, -width / 2, -height / 2);
        bottomRight = new OffsetPosition2D(center, width / 2, height / 2);
    }

    public Position2D getTopLeft() {
        return topLeft.copy();
    }

    public Position2D getBottomRight() {
        return bottomRight.copy();
    }

    public void setCenterPosition(Position2D center) {
        this.center.setPosition(center);
        topLeft = new OffsetPosition2D(center, -width / 2, -height / 2);
        bottomRight = new OffsetPosition2D(center, width / 2, height / 2);
    }

    public void setCenter(Position2D center) {
        this.center.setPosition(center);
    }

    public void setWidth(double width) {
        this.width = width;
        revalidateOffsets();
    }

    public void setHeight(double height) {
        this.height = height;
        revalidateOffsets();
    }

    private void revalidateOffsets() {
        topLeft.setXOffset(-width / 2);
        topLeft.setYOffset(-height / 2);

        bottomRight.setXOffset(width / 2);
        bottomRight.setYOffset(height / 2);
    }

    public void setTopLeft(Position2D newTopLeft) {
        Vector2D offsetVector = Position2D.subtract(topLeft, newTopLeft);
        center.addVector2D(offsetVector);
    }

    public void setBottomRight(Position2D newBottomRight) {
        Vector2D offsetVector = Position2D.subtract(bottomRight, newBottomRight);
        center.addVector2D(offsetVector);
    }


    @Override
    public void render(Graphics2D g2) {
        Graphics2D g2Copy = (Graphics2D) g2.create() ;
        applyG2Settings(g2Copy);

        if (sticky) {
            //Does not take camera position into consideration when drawing
            g2Copy.drawRect(topLeft.getIntX(), topLeft.getIntY(), (bottomRight.getIntX() - topLeft.getIntX()), (bottomRight.getIntY() - topLeft.getIntY()));
        } else {
            //Uses camera position to draw with an offset
            Position2D drawPositionTopLeft = new Position2D(topLeft.getX(), topLeft.getY());
            drawPositionTopLeft.addVector2D(CameraServer.getOffsetVector());

            g2Copy.drawRect(drawPositionTopLeft.getIntX(), drawPositionTopLeft.getIntY(), (bottomRight.getIntX() - topLeft.getIntX()), (bottomRight.getIntY() - topLeft.getIntY()));
        }

        g2Copy.dispose();
    }
}
