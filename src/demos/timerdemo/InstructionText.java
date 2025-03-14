package demos.timerdemo;

import j2d.attributes.position.Position2D;
import j2d.components.graphics.text.CenteredText;
import j2d.engine.gameobject.GameObject;

import java.awt.*;

public class InstructionText extends GameObject {
    CenteredText text;

    public InstructionText() {
        text = new CenteredText(this, new Position2D(300, 20), "'A' - Start   'S' - Pause   'D' - Stop   'F' - Toggle OneShot");
        text.setColor(Color.BLACK);

        ready();
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void physicsUpdate(double delta) {

    }
}
