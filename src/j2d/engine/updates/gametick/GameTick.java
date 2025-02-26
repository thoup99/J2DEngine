package j2d.engine.updates.gametick;

import j2d.engine.GameObject;

import java.util.ArrayList;
import java.util.List;

public class GameTick {
    private static List<GameObject> gameObjects = new ArrayList<>();

    public static void registerGameObject(GameObject gameObject) {
        if (!gameObjects.contains(gameObject)) {
            gameObjects.add(gameObject);
        }
    }

    public static void unregisterGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public static void doUpdates(double delta) {
        for (GameObject gameObject : gameObjects) {
            gameObject.update(delta);
        }
    }
}
