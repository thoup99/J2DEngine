package components.collider;

import components.GameObject;

public abstract class Collider {
    private GameObject gameObject;

    public Collider(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
