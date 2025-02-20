package test;

import j2d.attributes.position.Position2D;
import j2d.components.graphics.shapes.Line;
import j2d.components.graphics.shapes.Square;
import j2d.engine.GameObject;
import j2d.engine.input.mouse.motion.MouseMotionHandler;
import j2d.engine.input.mouse.motion.MouseMotionSubscriber;
import j2d.engine.window.Window;

import java.awt.*;

public class TestGameObject extends GameObject implements MouseMotionSubscriber {
    Line line;
    Square square;

    public TestGameObject() {
        square = new Square(this, 0, new Position2D(50, 50), new Position2D(550, 550));
        square.setStrokeWidth(5);
        square.setColor(Color.RED);

        line = new Line(this, 0, new Position2D(0, 0), new Position2D(10, 10));
        line.setStrokeWidth(10);
        line.setColor(Color.BLUE);
        MouseMotionHandler.subscribe(this);
    }

    @Override
    public void update(double delta) {
        //System.out.println(Window.getMousePosition());
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
