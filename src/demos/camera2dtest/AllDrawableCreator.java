package demos.camera2dtest;

import j2d.attributes.transform.position.Position2D;
import j2d.components.graphics.shapes.*;
import j2d.components.graphics.shapes.Rectangle;
import j2d.components.graphics.text.CenteredText;
import j2d.components.graphics.text.Text;
import j2d.engine.gameobject.GameObject;

import java.awt.*;

public class AllDrawableCreator extends GameObject {
    Circle circle;
    Circle fillCircle;
    Rectangle rectangle;
    Rectangle fillRectangle;
    Line line;
    Text text;
    CenteredText centeredText;

    public AllDrawableCreator() {
        super();

        circle = new Circle(this, new Position2D(50, 50), 30);
        circle.setColor(Color.RED);

        fillCircle = new FillCircle(this, new Position2D(200, 50), 30);
        fillCircle.setColor(Color.RED);

        rectangle = new Rectangle(this, new Position2D(85, 200), 100, 50, 0);
        rectangle.setColor(Color.ORANGE);

        fillRectangle = new FillRectangle(this, new Position2D(250, 200), 100, 50, 0);
        fillRectangle.setColor(Color.ORANGE);

        line = new Line(this, new Position2D(300, 50), new Position2D(350, 150), 0);
        line.setStrokeWidth(5);

        text = new Text(this, new Position2D(100, 300), "Normal Text");

        centeredText = new CenteredText(this, new Position2D(250, 300), "Centered Text");

        ready();
    }

    public void setAllSticky() {
        circle.setSticky(true);
        fillCircle.setSticky(true);
        rectangle.setSticky(true);
        fillRectangle.setSticky(true);
        line.setSticky(true);
        text.setSticky(true);
        centeredText.setSticky(true);
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void physicsUpdate(double delta) {

    }
}
