package test.shapespawning;

import j2d.attributes.position.Position2D;
import j2d.components.graphics.shapes.*;
import j2d.components.graphics.shapes.Shape;
import j2d.engine.GameObject;
import j2d.engine.input.keyboard.KeyHandler;
import j2d.engine.input.keyboard.KeySubscriber;
import j2d.engine.render.Renderer;
import j2d.engine.window.Window;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapeSpawner extends GameObject implements KeySubscriber {
    List<Shape> shapes;
    Random random;

    ShapeSpawner() {
        shapes = new ArrayList<>();
        random = new Random();

        int[] keys = {KeyEvent.VK_S, KeyEvent.VK_C, KeyEvent.VK_R, KeyEvent.VK_P};
        KeyHandler.subscribe(this, keys);
    }

    private Color getRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public int getRandomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void physics_update(double delta) {

    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_S) {
            Position2D mousePos = Window.getMousePosition();
            int size = getRandomInt(5, 50);

            Square newSquare = new FillSquare(this, 0,
                    new Position2D(mousePos.getX() - size, mousePos.getY() - size),
                    new Position2D(mousePos.getX() + size, mousePos.getY() + size));

            newSquare.setColor(getRandomColor());
            shapes.add(newSquare);
        }
        if (key == KeyEvent.VK_C) {
            Position2D mousePos = Window.getMousePosition();

            Circle newCircle = new FillCircle(this, 0, mousePos, getRandomInt(5, 50));

            newCircle.setColor(getRandomColor());
            shapes.add(newCircle);
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
}
