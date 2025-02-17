package j2d.components.graphics.text;

import j2d.attributes.Position2D;
import j2d.components.Component;
import j2d.engine.GameObject;
import j2d.engine.render.Renderable;
import j2d.engine.render.Renderer;

import java.awt.*;


public class Text extends Component implements Renderable {
    protected static final Color defaultColor = Color.WHITE;
    private Color textColor;
    private String text;
    private Position2D position;

    public Text(GameObject parentGameObject, Position2D position, String text) {
        super(parentGameObject);
        this.text = text;
        this.position = position;
        //Temporary
        this.textColor = Color.red;

        addToRenderer();
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(Color textColor) {
        this.textColor = textColor;
    }

    @Override
    public void addToRenderer() {
        Renderer.add(this);
    }

    @Override
    public void removeFromRenderer() {
        Renderer.remove(this);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(textColor);
        g2.drawString(text, position.getIntX(), position.getIntY()); //Position is bottom left of Text
        g2.setColor(defaultColor);
    }
}
