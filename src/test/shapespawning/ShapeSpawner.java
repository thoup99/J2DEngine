package test.shapespawning;

import j2d.attributes.position.Position2D;
import j2d.components.graphics.shapes.*;
import j2d.engine.GameObject;
import j2d.engine.input.keyboard.KeyHandler;
import j2d.engine.input.keyboard.KeySubscriber;
import j2d.engine.render.Renderer;
import j2d.engine.window.Window;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ShapeSpawner extends GameObject implements KeySubscriber {
    List<Shape> shapes;

    ShapeSpawner() {
        shapes = new ArrayList<>();

        int[] keys = {KeyEvent.VK_S, KeyEvent.VK_C, KeyEvent.VK_R, KeyEvent.VK_P};
        KeyHandler.subscribe(this, keys);
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void physics_update(double delta) {

    }

    @Override
    public void keyPressed(int key) {
        Position2D mousePos = Window.getMousePosition();
        if (key == KeyEvent.VK_S) {
            Square newSquare = new FillSquare(this, 0,
                    new Position2D(mousePos.getX() - 10, mousePos.getY() - 10),
                    new Position2D(mousePos.getX() + 10, mousePos.getY() + 10));
            shapes.add(newSquare);
        }
        if (key == KeyEvent.VK_C) {
            Circle newCircle = new FillCircle(this, 0, mousePos, 10);
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
