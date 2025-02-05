package j2d.engine;


import j2d.engine.keyboard.KeyHandler;
import j2d.engine.window.Window;

import java.util.ArrayList;
import java.util.List;

public class Engine implements Runnable {
    private static Engine engine;
    private static Thread engineThread;
    private static List<GameObject> gameObjects = new ArrayList<>();
    private static Window window;
    private static int targetFPS;
    private static double drawInterval;

    /**
     * Initializes all components of the engine
     */
    public static void initialize() {
        KeyHandler.initialize();
        //audio init
        //physics init?

        setTargetFPS(30);

        engine = new Engine();
        engineThread = new Thread(engine);
        engineThread.start();
    }

    private Engine() {}

    @Override
    public void run() {
        //Order
        //Physics Update
        //Update
        //Physics Tick
        //Render


        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (engineThread.isAlive()) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            while (delta >= 1) {
                double multDelta = delta / drawInterval;
                doPhysicsUpdates(multDelta);
                doUpdates(multDelta);
                delta -= 1;
            }

            if (Window.isCreated) {
                window.repaintPanel();
            }
        }

    }

    public static void registerGameObject(GameObject gameObject) {
        if (!gameObjects.contains(gameObject)) {
            gameObjects.add(gameObject);
        }
    }

    public static void unregisterGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    private void doPhysicsUpdates(double delta) {
        for (GameObject gameObject : gameObjects) {
            gameObject.physics_update(delta);
        }
    }

    private void doUpdates(double delta) {
        for (GameObject gameObject : gameObjects) {
            gameObject.update(delta);
        }
    }

    public static void setTargetFPS(int targetFPS) {
        Engine.targetFPS = targetFPS;
        calculateDrawInterval();
    }

    public static void calculateDrawInterval() {
        drawInterval = 1000000000 / targetFPS;
    }

    public static void registerWindow(Window window) {
        Engine.window = window;
    }
}
