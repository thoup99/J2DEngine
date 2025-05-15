package demos.circleCollisionTest;

import j2d.attributes.transform.position.Position2D;
import j2d.engine.Engine;
import j2d.engine.debug.Debug;
import j2d.engine.window.Window;

public class CircleCollisionTest {
    public static void main(String[] args) {
        Engine.initialize();
        Engine.setTargetFPS(60);

        Window window = new Window();
        window.setRecommendedDefaults();
        window.setTitle("Circle Collision Test");

        Debug.setDrawFPS(true);
        window.setCloseOnEsc(true);

        RedCircle redCircle = new RedCircle(new Position2D(0, 0), 20);
        BlueCircle blueCircle = new BlueCircle(new Position2D(400, 400), 40);
        BlueCircle blueCircle1 = new BlueCircle(new Position2D(100, 200), 60);

        Engine.ready();
    }
}
