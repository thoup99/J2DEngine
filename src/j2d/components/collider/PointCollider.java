package j2d.components.collider;

import j2d.attributes.Position2D;
import j2d.engine.GameObject;

public class PointCollider extends Collider {
    Position2D position;

    public PointCollider(GameObject gameObject, Position2D position) {
        super(gameObject);
        this.position = position;
    }
}
