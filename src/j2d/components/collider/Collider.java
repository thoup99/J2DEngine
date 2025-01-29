package j2d.components.collider;

import j2d.components.GameObject;

public abstract class Collider {
    private GameObject gameObject;

    public Collider(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
