package demos.circleCollisionTest;

import j2d.attributes.position.Position2D;
import j2d.components.graphics.shapes.FillCircle;
import j2d.components.physics.collider.CircleCollider;
import j2d.components.physics.collider.Collider;
import j2d.engine.gameobject.GameObject;

import java.awt.*;

public class BlueCircle extends GameObject {
    Position2D position;
    FillCircle fillCircle;
    Collider collider;

    public BlueCircle(Position2D position, int radius) {
        this.position = position;
        fillCircle = new FillCircle(this, 0, position, radius);
        collider = new CircleCollider(this, position, radius);

        fillCircle.setColor(Color.BLUE);

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
        if (other instanceof RedCircle) {
            queueDelete();
        }
    }
}
