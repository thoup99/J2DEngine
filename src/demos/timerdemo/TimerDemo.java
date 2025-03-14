package demos.timerdemo;

import j2d.engine.Engine;
import j2d.engine.debug.Debug;
import j2d.engine.window.Window;

import java.awt.*;

public class TimerDemo {
    public static void main(String[] args) {
        Engine.initialize();
        Engine.setTargetFPS(60);

        Window window = new Window();
        window.setRecommendedDefaults();
        window.setTitle("Timer Demo");

        window.setBackgroundColor(Color.WHITE);
        Debug.setDrawFPS(true);
        Debug.setDrawPhysicsTick(true);

        window.setCloseOnEsc(true);

        InstructionText instructionText = new InstructionText();
        TimerUser timerUser = new TimerUser();

    }
}
