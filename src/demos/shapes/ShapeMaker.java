package demos.shapes;

import j2d.attributes.transform.position.Position2D;
import j2d.components.graphics.shapes.Circle;
import j2d.components.graphics.shapes.Line;
import j2d.components.graphics.shapes.Rectangle;
import j2d.engine.gameobject.GameObject;
import j2d.engine.input.keyboard.KeyHandler;
import j2d.engine.input.keyboard.KeySubscriber;
import j2d.engine.input.mouse.motion.MouseMotionHandler;
import j2d.engine.input.mouse.motion.MouseMotionSubscriber;
import j2d.engine.window.Window;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ShapeMaker extends GameObject implements MouseMotionSubscriber, KeySubscriber {
    Line line;
    Rectangle rectangle;
    Circle circle;

    public ShapeMaker() {
        circle = new Circle(this, 0, new Position2D(300, 300), 300);
        circle.setStrokeWidth(5);
        circle.setColor(Color.YELLOW);

        rectangle = new Rectangle(this, new Position2D(300, 300), 500, 500, 0);
        rectangle.setStrokeWidth(5);
        rectangle.setColor(Color.RED);

        line = new Line(this, 0, new Position2D(0, 0), new Position2D(300, 300));
        line.setStrokeWidth(10);
        line.setColor(Color.BLUE);
        MouseMotionHandler.subscribe(this);

        int[] keys = {KeyEvent.VK_T, KeyEvent.VK_Y, KeyEvent.VK_U};
        KeyHandler.subscribe(this, keys);

        ready();
    }

    @Override
    public void update(double delta) {
        //System.out.println(Window.getMousePosition());
    }

    @Override
    public void physicsUpdate(double delta) {

    }

    @Override
    public void mouseMoved(Position2D position) {
        line.setStart(position);
    }

    @Override
    public void mouseDragged(Position2D position) {
        line.setEnd(position);
    }

    @Override
    public void keyPressed(int key) {
        switch (key) {
            case KeyEvent.VK_T:
                rectangle.setTopLeft(Window.getMousePosition());
                break;
            case KeyEvent.VK_Y:
                rectangle.setBottomRight(Window.getMousePosition());
                break;
            case KeyEvent.VK_U:
                System.out.println("Top Left: " + rectangle.getTopLeft() + " Bottom Right: " + rectangle.getBottomRight());
        }
    }

    @Override
    public void keyReleased(int key) {

    }
}
