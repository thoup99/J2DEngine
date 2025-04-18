package demos.shapespawning;

import j2d.attributes.position.Position2D;
import j2d.engine.Engine;
import j2d.engine.debug.Debug;
import j2d.engine.render.Renderer;
import j2d.engine.window.Window;

public class ShapeSpawn {
    public static void main(String[] args) {
        Engine.initialize();
        Engine.setTargetFPS(60);

        Window window = new Window(600, 600);
        window.setRecommendedDefaults();
        window.setTitle("Shape Spawner");

        Debug.setDrawFPS(true);
        Debug.setDrawPhysicsTick(true);

        Renderer.createLayer(0); //Shape Layer
        Renderer.createLayer(1); //Text Layer

        InstructionText it = new InstructionText(new Position2D(300, 20));
        ShapeSpawner ss = new ShapeSpawner();

        window.setCloseOnEsc(true);

        Engine.ready();
    }
}
