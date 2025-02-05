package j2d.components;

import j2d.engine.Engine;
import j2d.engine.keyboard.KeyHandler;
import j2d.engine.keyboard.KeySubscriber;

public abstract class GameObject {

    public GameObject() {
        Engine.registerGameObject(this);
    }

    protected void delete() {
        Engine.unregisterGameObject(this);

        if (this instanceof KeySubscriber) {
            KeySubscriber ks = (KeySubscriber) this;
            KeyHandler.unsubscribe(ks);
        }

        //TODO Find a way to remove sprites / spritesheets from renderer

    }

    public abstract void update(double delta);
    public abstract void physics_update(double delta);
}
