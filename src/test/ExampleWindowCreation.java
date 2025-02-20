package test;

import j2d.engine.Engine;
import j2d.engine.debug.Debug;
import j2d.engine.window.Window;

import java.awt.*;

public class ExampleWindowCreation {
    public static void main(String[] args) {
        Engine.initialize();
        Engine.setTargetFPS(60);

        Window window = new Window();
        window.setRecommendedDefaults();
        window.setTitle("Example Window");

        //Engine.displayFPSCounter(true);
        window.setBackgroundColor(Color.BLACK);
        TestGameObject gameObject = new TestGameObject();
        Debug.setDrawFPS(true);

        window.setCloseOnEsc(true);
    }
}
