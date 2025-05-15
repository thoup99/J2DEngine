package j2d.engine.updates.collisions;

import j2d.components.physics.collider.CircleCollider;

public class CircleCollision {

    protected static boolean check(CircleCollider circle1, CircleCollider circle2) {
        //Use squared length values to avoid using sqrt operation
        double radiusSquared = Math.pow(circle1.getRadius() + circle2.getRadius(), 2);
        double distanceSquared = circle1.getPosition().distance(circle2.getPosition()).getMagnitudeSquared();
        return distanceSquared <= radiusSquared;
    }
}
