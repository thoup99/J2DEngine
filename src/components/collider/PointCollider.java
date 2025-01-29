package components.collider;

import attributes.Position2D;
import components.GameObject;

public class PointCollider extends Collider {
    Position2D position;

    public PointCollider(GameObject gameObject, Position2D position) {
        super(gameObject);
        this.position = position;
    }
}
