package j2d.engine;

import j2d.components.Component;
import j2d.components.physics.RigidBody;
import j2d.components.sprite.Sprite;
import j2d.components.sprite.SpriteSheet;
import j2d.engine.keyboard.KeyHandler;
import j2d.engine.keyboard.KeySubscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {
    public List<Component> components = new ArrayList<Component>();

    public GameObject() {
        Engine.registerGameObject(this);
    }

    /**
     *  Removes all references to the GameObject making it
     *  eligible for garbage collection
     */
    protected void delete() {
        Engine.unregisterGameObject(this);

        if (this instanceof KeySubscriber) {
            KeySubscriber ks = (KeySubscriber) this;
            KeyHandler.unsubscribe(ks);
        }

        for (Component c : components) {
            if (c instanceof Sprite) {
                Sprite s = (Sprite) c;
                s.removeFromRenderer();
            }
            else if (c instanceof RigidBody) {
                //TODO Remove Physics body from required places
            }
        }

    }

    public abstract void update(double delta);
    public abstract void physics_update(double delta);
}
