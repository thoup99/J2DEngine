package j2d.components.sprite;

import j2d.attributes.Position2D;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * SpriteSheet.java
 * A class to load and j2d.render sprite sheets
 *
 * @author Tyler Houp
 */
public class SpriteSheet extends Sprite {
    private final int individualSpriteHeight;
    private final int individualSpriteWidth;


    private final int numCols;

    BufferedImage spriteImage;


    /**
     * Constructor for SpriteSheet Class
     * @param pos Position2D SpriteSheet will be linked to
     * @param loadedSheet BufferedImage that is the sprite sheet image
     * @param numRows Number of rows in the sprite sheet
     * @param numCols Number of columns in the sprite sheet
     */
    public SpriteSheet(Position2D pos, BufferedImage loadedSheet, int numRows, int numCols) {
        super(pos);
        this.image = loadedSheet;

        this.numCols = numCols;

        this.individualSpriteHeight = image.getHeight() / numRows;
        this.individualSpriteWidth = image.getWidth() / numCols;

        setSprite(0,0);
        addToRenderer();
    }

    /**
     * Sets Sprite based off its number. Starts at zero.
     * @param spriteNum Number of the sprite to set.
     */
    public void setSprite(int spriteNum) {
        int x = (spriteNum % numCols) * individualSpriteWidth;
        int y = (spriteNum / numCols) * individualSpriteHeight;
        spriteImage = image.getSubimage(x, y, individualSpriteWidth, individualSpriteHeight);
    }

    /**
     * Sets sprite based off row and column. Both start at zero.
     * @param row Row of desired sprite.
     * @param col Column of desired sprite.
     */
    public void setSprite(int row, int col) {
        int x = individualSpriteWidth * col;
        int y = individualSpriteHeight * row;
        spriteImage = image.getSubimage(x, y, individualSpriteWidth, individualSpriteHeight);
    }

    /**
     * Implementation of Renderable
     * Rendering uses spriteSheet variables to draw the desired sprite.
     * @param g2 Graphics2D object used to draw images
     */
    @Override
    public void render(Graphics2D g2) {
        if (visible) {
            g2.drawImage(spriteImage, position.x, position.y, individualSpriteWidth, individualSpriteHeight, null);
        }
    }
}
