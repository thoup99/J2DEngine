package demos.shapespawning;

import j2d.attributes.position.Position2D;
import j2d.components.graphics.shapes.*;
import j2d.components.graphics.shapes.Shape;
import j2d.engine.GameObject;
import j2d.engine.input.keyboard.KeyHandler;
import j2d.engine.input.keyboard.KeySubscriber;
import j2d.engine.input.mouse.motion.MouseMotionHandler;
import j2d.engine.input.mouse.motion.MouseMotionSubscriber;
import j2d.engine.render.Renderer;
import j2d.engine.window.Window;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapeSpawner extends GameObject implements KeySubscriber, MouseMotionSubscriber {
    List<Shape> shapes;
    Random random;

    ShapeSpawner() {
        shapes = new ArrayList<>();
        random = new Random();

        int[] keys = {KeyEvent.VK_S, KeyEvent.VK_C, KeyEvent.VK_R, KeyEvent.VK_P};
        KeyHandler.subscribe(this, keys);
        MouseMotionHandler.subscribe(this);
    }

    private Color getRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private int getRandomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private void spawnSquare(Position2D position2D) {
        int size = getRandomInt(5, 50);

        Square newSquare = new FillSquare(this, 0,
                new Position2D(position2D.getX() - size, position2D.getY() - size),
                new Position2D(position2D.getX() + size, position2D.getY() + size));

        newSquare.setColor(getRandomColor());
        shapes.add(newSquare);
    }

    private void spawnCircle(Position2D position2D) {
        Circle newCircle = new FillCircle(this, 0, position2D, getRandomInt(10, 55));

        newCircle.setColor(getRandomColor());
        shapes.add(newCircle);
    }


    @Override
    public void update(double delta) {

    }

    @Override
    public void physicsUpdate(double delta) {

    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_S) {
            spawnSquare(Window.getMousePosition());
        }
        if (key == KeyEvent.VK_C) {
            spawnCircle(Window.getMousePosition());
        }

        if (key == KeyEvent.VK_R) {
            for (Shape s : shapes) {
                s.delete();
            }
            shapes.clear();
        }
        if (key == KeyEvent.VK_P) {
            System.out.println(Renderer.getTotalNonDebugObjects() + " Non-Debug Objects Being Drawn.");
        }
    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseMoved(Position2D position) {

    }

    @Override
    public void mouseDragged(Position2D position) {
        if (random.nextBoolean()) {
            spawnCircle(position);
        } else {
            spawnSquare(position);
        }
    }
}
