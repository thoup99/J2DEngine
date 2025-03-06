package demos.positiondisplay;

import j2d.attributes.position.Position2D;
import j2d.engine.GameObject;
import j2d.engine.debug.PositionDisplay;
import j2d.engine.input.mouse.motion.MouseMotionHandler;
import j2d.engine.input.mouse.motion.MouseMotionSubscriber;

public class MouseTracker extends GameObject implements MouseMotionSubscriber {
    Position2D mousePosition = new Position2D();
    PositionDisplay positionDisplay;

    public MouseTracker() {
        positionDisplay = new PositionDisplay(mousePosition);
        MouseMotionHandler.subscribe(this);
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void physicsUpdate(double delta) {

    }

    @Override
    public void mouseMoved(Position2D position) {
        mousePosition.setPosition(position);
    }

    @Override
    public void mouseDragged(Position2D position) {
        mousePosition.setPosition(position);
    }
}
