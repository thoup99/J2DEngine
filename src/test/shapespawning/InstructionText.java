package test.shapespawning;

import j2d.attributes.position.Position2D;
import j2d.components.graphics.text.CenteredText;
import j2d.engine.GameObject;

public class InstructionText extends GameObject {
    CenteredText line1, line2;

    InstructionText(Position2D position2D){
        line1 = new CenteredText(this, position2D, "S - Square & C - Circle", 1);
        line2 = new CenteredText(this, new Position2D(position2D.getX(), position2D.getY()+ 20) , "R - Reset", 1);

        line1.setFontSize(100);
        line2.setFontSize(100);
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void physics_update(double delta) {

    }
}
