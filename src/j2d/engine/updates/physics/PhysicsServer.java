package j2d.engine.updates.physics;

import j2d.components.physics.RigidBody;
import j2d.engine.GameObject;

import java.util.ArrayList;
import java.util.List;

public class PhysicsServer {
    private static List<GameObject> gameObjects = new ArrayList<>();
    private static List<RigidBody> rigidBodies = new ArrayList<RigidBody>();
    public static double timeStep = 0.02;
    public static double currentStepRate;

    //TODO impliment collisions. Can use GameObject Base Class

    public static void registerGameObject(GameObject gameObject) {
        if (!gameObjects.contains(gameObject)) {
            gameObjects.add(gameObject);
        }
    }

    public static void unregisterGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public static void registerRigidBody(RigidBody gameObject) {
        if (!rigidBodies.contains(gameObject)) {
            rigidBodies.add(gameObject);
        }
    }

    public static void unregisterRigidBody(RigidBody gameObject) {
        rigidBodies.remove(gameObject);
    }

    public static void doPhysicsUpdates(double delta) {
        for (GameObject gameObject : gameObjects) {
            gameObject.physicsUpdate(delta);
        }
    }

    public static void tick() {

    }
}


