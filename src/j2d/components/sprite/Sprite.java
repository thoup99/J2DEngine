package j2d.components.sprite;


import j2d.components.Component;
import j2d.engine.camera.CameraServer;
import j2d.engine.gameobject.GameObject;
import j2d.engine.render.Renderable;
import j2d.engine.render.Renderer;
import j2d.attributes.transform.position.Position2D;
import j2d.tools.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Represents a drawable 2D sprite component that can be attached to a GameObject.
 * It handles rendering an image to the screen at a specified position and layer,
 * with optional visibility control.
 *
 * The Sprite must be associated with a Position2D attribute and is automatically
 * added to the renderer on creation.
 *
 * @author Tyler Houp
 * @since November 11, 2024
 */
public class Sprite extends Component implements Renderable {
    protected Position2D position;
    protected boolean visible = true;
    protected BufferedImage image;
    private int layer;

    boolean sticky = false;

    /**
     * Constructs a Sprite using a resource path to load the image.
     *
     * @param parent   The GameObject this component is attached to.
     * @param position The position attribute controlling the sprite's location.
     * @param path     The path to the image resource.
     */
    public Sprite(GameObject parent, Position2D position, String path) {
        this(parent, position, ImageLoader.loadResource(path), 0);
    }

    /**
     * Constructs a Sprite using a preloaded BufferedImage.
     *
     * @param parent   The GameObject this component is attached to.
     * @param position The position attribute controlling the sprite's location.
     * @param image    The image to render.
     */
    public Sprite(GameObject parent, Position2D position, BufferedImage image) {
        this(parent, position, image, 0);
    }

    /**
     * Constructs a Sprite with a resource path and a specified render layer.
     *
     * @param parent   The GameObject this component is attached to.
     * @param position The position attribute controlling the sprite's location.
     * @param path     The path to the image resource.
     * @param layer    The rendering layer to draw the sprite on.
     */
    public Sprite(GameObject parent, Position2D position, String path, int layer) {
        this(parent, position, ImageLoader.loadResource(path), layer);
    }

    /**
     * Constructs a Sprite with a preloaded BufferedImage and specified render layer.
     *
     * @param parent   The GameObject this component is attached to.
     * @param position The position attribute controlling the sprite's location.
     * @param image    The image to render.
     * @param layer    The rendering layer to draw the sprite on.
     */
    public Sprite(GameObject parent, Position2D position, BufferedImage image, int layer) {
        super(parent);
        this.position = position;
        this.image = image;
        this.layer = layer;
        addToRenderer();
    }

    /**
     * Sets the rendering layer of the sprite. This causes the sprite
     * to be re-registered with the renderer on the new layer.
     *
     * @param newLayer The new rendering layer.
     */
    public void setLayer(int newLayer) {
        removeFromRenderer();
        layer = newLayer;
        addToRenderer();
    }

    /**
     * Sets the visibility of the sprite.
     * A non-visible sprite will not be rendered.
     *
     * @param visible True to make the sprite visible; false to hide it.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Sets the "Stickyness" of the Sprite
     * Sticky Sprites will not respond to camera movement while nonsticky
     * ones will.
     *
     * @param sticky
     */
    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    /**
     * Deletes the Sprite and removes it from the renderer.
     */
    @Override
    public void delete() {
        super.delete();
        removeFromRenderer();
    }

    /**
     * Renders the sprite to the screen using the provided Graphics2D object,
     * if the sprite is currently marked as visible.
     *
     * @param g2 The Graphics2D context used for rendering.
     */
    @Override
    public void render(Graphics2D g2) {
        if (visible) {
            if (sticky) {
                g2.drawImage(image, position.getIntX(), position.getIntY(), image.getWidth(), image.getHeight(), null);
            } else {
                Position2D drawPosition = position.copy();
                drawPosition.addVector2D(CameraServer.getOffsetVector());

                g2.drawImage(image, drawPosition.getIntX(), drawPosition.getIntY(), image.getWidth(), image.getHeight(), null);
            }
        }
    }

    /**
     * Registers the sprite with the Renderer on its current layer.
     */
    @Override
    public void addToRenderer() {
        Renderer.add(this, layer);
    }

    /**
     * Unregisters the sprite from the Renderer on its current layer.
     */
    @Override
    public void removeFromRenderer() {
        Renderer.remove(this, layer);
    }
}
