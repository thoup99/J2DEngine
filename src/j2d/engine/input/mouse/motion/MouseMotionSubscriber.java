package j2d.engine.input.mouse.motion;

import j2d.attributes.transform.position.Position2D;

public interface MouseMotionSubscriber {
    void mouseMoved(Position2D position);
    void mouseDragged(Position2D position);
}
