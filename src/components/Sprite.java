package components;


import render.Renderable;
import render.Renderer;
import attributes.Position2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Sprite.java
 * A class to draw images on the screen and move them around.
 *
 * @author Tyler Houp
 */
public class Sprite implements Renderable {
    protected Position2D position;
    protected boolean visible = true;
    protected BufferedImage image;

    /**
     * Constructor for Sprite Class
     * @param pos Position2D Sprite will be linked to
     */
    public Sprite(Position2D pos) {
        position = pos;
    }

    /**
     * Constructor for Sprite Class
     * @param pos Position2D Sprite will be linked to
     * @param path Resource path to PNG for sprite
     */
    public Sprite(Position2D pos, String path) {
        position = pos;
        loadSpriteFromPath(path);
    }

    /**
     * Takes the path to png and loads it as a sprite
     * @param path Resource path to PNG
     */
    public void loadSpriteFromPath(String path) {
        System.out.println("Loading Sprite Texture at path:  " + path);
        try {
            image = ImageIO.read(getClass().getResourceAsStream(path));
            addToRenderer();

        } catch (IOException e) {
            System.out.println(e.getMessage() + "Error Loading Image");
        }
    }

    /**
     * Sets visibility of sprite
     * @param newVisible Visibility of sprite
     */
    public void setVisible(boolean newVisible) {
        visible = newVisible;
    }

    /**
     * Draws Sprite to the screen
     * @param g2 Graphics2D object used to draw images
     */
    @Override
    public void render(Graphics2D g2) {
        if (visible) {
            g2.drawImage(image, position.x, position.y, image.getWidth(), image.getHeight(), null);
        }
    }

    /**
     * Implementation from Renderable
     * Adds object to Renderer
     */
    @Override
    public void addToRenderer() {
        Renderer.add(this);
    }

    /**
     * Implementation from Renderable
     * Removes object from Renderer
     */
    @Override
    public void removeFromRenderer() {
        Renderer.remove(this);
    }
}
