package demos.camera2dtest;

import j2d.attributes.transform.position.Position2D;
import j2d.components.graphics.shapes.Circle;
import j2d.components.graphics.shapes.FillCircle;
import j2d.engine.gameobject.GameObject;
import j2d.engine.input.keyboard.KeyHandler;
import j2d.engine.input.keyboard.KeySubscriber;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MoveablePlayer extends GameObject implements KeySubscriber {
    final int movementSpeed = 300;
    Position2D position2D = new Position2D(300, 300);
    Circle circle;

    public MoveablePlayer() {
        circle = new FillCircle(this, position2D, 15);
        circle.setColor(Color.BLUE);

        int[] keys = {KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D};
        KeyHandler.subscribe(this, keys);

        ready();
    }

    public Position2D getPosition2D() {
        return position2D;
    }

    @Override
    public void update(double delta) {
        if (KeyHandler.isKeyPressed(KeyEvent.VK_W)) {
            position2D.addY(-movementSpeed * delta);
        } else if (KeyHandler.isKeyPressed(KeyEvent.VK_S)) {
            position2D.addY(movementSpeed * delta);
        }

        if (KeyHandler.isKeyPressed(KeyEvent.VK_A)) {
            position2D.addX(-movementSpeed * delta);
        } else if (KeyHandler.isKeyPressed(KeyEvent.VK_D)) {
            position2D.addX(movementSpeed * delta);
        }
    }

    @Override
    public void physicsUpdate(double delta) {

    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }
}
