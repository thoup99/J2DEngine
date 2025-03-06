package demos.window;

import j2d.engine.Engine;
import j2d.engine.debug.Debug;
import j2d.engine.window.Window;

import java.awt.*;

public class BasicWindow {
    public static void main(String[] args) {
        Engine.initialize();
        Engine.setTargetFPS(60);

        Window window = new Window();
        window.setRecommendedDefaults();
        window.setTitle("Basic Window");

        window.setBackgroundColor(Color.BLACK);
        Debug.setDrawFPS(true);

        window.setCloseOnEsc(true);
    }
}
