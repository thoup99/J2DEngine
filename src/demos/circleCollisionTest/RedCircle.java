package demos.circleCollisionTest;

import j2d.attributes.transform.position.Position2D;
import j2d.components.graphics.shapes.FillCircle;
import j2d.components.physics.collider.CircleCollider;
import j2d.components.physics.collider.Collider;
import j2d.engine.gameobject.GameObject;
import j2d.engine.input.mouse.motion.MouseMotionHandler;
import j2d.engine.input.mouse.motion.MouseMotionSubscriber;

import java.awt.*;

public class RedCircle extends GameObject implements MouseMotionSubscriber {
    Position2D position;
    FillCircle fillCircle;
    Collider collider;
    int timeouts = 0;

    public RedCircle(Position2D position, int radius) {
        this.position = position;
        fillCircle = new FillCircle(this, 0, position, radius);
        collider = new CircleCollider(this, position, radius);

        fillCircle.setColor(Color.RED);

        MouseMotionHandler.subscribe(this);
        ready();
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void physicsUpdate(double delta) {

    }

    @Override
    public void onCollision(GameObject other) {
        System.out.println("Colliding");
    }

    @Override
    public void mouseMoved(Position2D position) {
        this.position.setPosition(position);
    }

    @Override
    public void mouseDragged(Position2D position) {

    }
}
