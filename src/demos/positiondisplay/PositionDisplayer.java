package demos.positiondisplay;

import j2d.engine.Engine;
import j2d.engine.debug.Debug;
import j2d.engine.window.Window;

import java.awt.*;

public class PositionDisplayer {
    public static void main(String[] args) {
        Engine.initialize();
        Engine.setTargetFPS(60);

        Window window = new Window();
        window.setRecommendedDefaults();
        window.setTitle("PositionDisplay Demo");

        window.setBackgroundColor(Color.WHITE);
        Debug.setDrawFPS(true);

        MouseTracker mouseTracker = new MouseTracker();

        window.setCloseOnEsc(true);
    }
}
