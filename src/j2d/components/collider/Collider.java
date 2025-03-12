package j2d.components.collider;

import j2d.components.Component;
import j2d.engine.GameObject;

public abstract class Collider extends Component {
    public Collider(GameObject parentGameObject) {
        super(parentGameObject);
    }
}
