package j2d.components.graphics.shapes;

import j2d.components.Component;
import j2d.engine.GameObject;
import j2d.engine.render.Renderable;
import j2d.engine.render.Renderer;

import java.awt.*;

public abstract class Shape extends Component implements Renderable {
    int layer;
    protected Color color;

    public Shape(GameObject parentGameObject) {
        this(parentGameObject, Renderer.getTopLayer());
    }

    public Shape(GameObject parentGameObject, int layer) {
        super(parentGameObject);
        this.layer = layer;
        addToRenderer();
    }

    public void setLayer(int layer) {
        this.layer = layer;
        removeFromRenderer();
        addToRenderer();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void addToRenderer() {
        Renderer.add(this, layer);
    }

    @Override
    public void removeFromRenderer() {
        Renderer.remove(this, layer);
    }

    @Override
    public void render(Graphics2D g2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}