package test;

import j2d.attributes.position.Position2D;
import j2d.components.graphics.shapes.Line;
import j2d.engine.GameObject;
import j2d.engine.input.mouse.motion.MouseMotionHandler;
import j2d.engine.input.mouse.motion.MouseMotionSubscriber;

import java.awt.*;

public class TestGameObject extends GameObject implements MouseMotionSubscriber {
    Line line;

    public TestGameObject() {
        line = new Line(this, 0, new Position2D(20, 20), new Position2D(200, 70));
        line.setWidth(10);
        line.setColor(Color.BLUE);
        MouseMotionHandler.subscribe(this);
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void physics_update(double delta) {

    }

    @Override
    public void mouseMoved(Position2D position) {
        line.setStart(position);
    }

    @Override
    public void mouseDragged(Position2D position) {
        line.setEnd(position);
    }
}
