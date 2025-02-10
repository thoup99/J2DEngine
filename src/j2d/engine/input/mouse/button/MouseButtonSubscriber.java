package j2d.engine.input.mouse.button;

import j2d.attributes.Position2D;

public interface MouseButtonSubscriber {
    void mousePressed(int awtMouseButton, Position2D mousePosition);
    void mouseReleased(int awtMouseButton, Position2D mousePosition);
    void mouseClicked(int awtMouseButton, Position2D mousePosition);
}
