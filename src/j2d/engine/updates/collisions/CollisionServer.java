package j2d.engine.updates.collisions;

import j2d.components.physics.collider.BoxCollider;
import j2d.components.physics.collider.CircleCollider;
import j2d.components.physics.collider.Collider;

import java.util.ArrayList;
import java.util.List;

public class CollisionServer {
    private static final List<Collider> colliders = new ArrayList<>();

    public static void registerCollider(Collider collider) {
        if (!colliders.contains(collider)) {
            synchronized (colliders) {
                colliders.add(collider);
            }
        }
    }

    public static void unregisterCollider(Collider collider) {
        synchronized (colliders) {
            colliders.remove(collider);
        }
    }

    public static void checkCollisions() {
        synchronized (colliders) {
            //For every Collider...
            for (int i = 0; i < colliders.size(); i++) {
                //... check every collider that follows
                for (int j = i + 1; j < colliders.size(); j++) {
                    Collider collider1 = colliders.get(i);
                    Collider collider2 = colliders.get(j);

                    if (isColliding(collider1, collider2)) {
                        collider1.getParent().onCollision(collider2.getParent());
                        collider2.getParent().onCollision(collider1.getParent());
                    }
                }
            }
        }
    }

    private static boolean isColliding(Collider collider1, Collider collider2) {
        // Determine Collision Type

        // Box on Box
        if ((collider1 instanceof BoxCollider) && (collider2 instanceof BoxCollider)) {
            return SATBoxCollision.check((BoxCollider) collider1, (BoxCollider) collider2);

        // Circle on Circle
        } else if ((collider1 instanceof CircleCollider) && (collider2 instanceof CircleCollider)) {
            return CircleCollision.check((CircleCollider) collider1, (CircleCollider) collider2);

        // Box on Circle
        } else if ((collider1 instanceof BoxCollider) && (collider2 instanceof CircleCollider)) {
            return SATBoxCircleCollision.check((BoxCollider) collider1, (CircleCollider) collider2);

        // Circle on Box
        } else if ((collider1 instanceof CircleCollider) && (collider2 instanceof BoxCollider)) {
            return SATBoxCircleCollision.check((BoxCollider) collider2, (CircleCollider) collider1);

        }

        return false;
    }
}
