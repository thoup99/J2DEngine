package demos.shapes;

import j2d.engine.Engine;
import j2d.engine.debug.Debug;
import j2d.engine.window.Window;

import java.awt.*;

public class ShapeTest {
    public static void main(String[] args) {
        Engine.initialize();
        Engine.setTargetFPS(60);

        Window window = new Window();
        window.setRecommendedDefaults();
        window.setTitle("ShapeTest");

        //Engine.displayFPSCounter(true);
        window.setBackgroundColor(Color.BLACK);
        ShapeMaker gameObject = new ShapeMaker();
        Debug.setDrawFPS(true);

        window.setCloseOnEsc(true);
    }
}
