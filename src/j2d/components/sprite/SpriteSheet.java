package j2d.components.sprite;

import j2d.attributes.transform.position.Position2D;
import j2d.engine.camera.CameraServer;
import j2d.engine.gameobject.GameObject;
import j2d.tools.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Represents a sprite sheet, which is a grid of individual sprites packed into a single image.
 * Provides functionality to select sprites based on row/column or an index position.
 * Also allows control over padding and spacing between sprites.
 *
 * Useful for managing multiple sprite variations from a single image source.
 *
 * @author Tyler Houp
 * @since November 24, 2024
 */
public class SpriteSheet extends Sprite {
    private int individualSpriteHeight;
    private int individualSpriteWidth;
    private int xPadding, yPadding = 0;
    private int xSpacing, ySpacing = 0;

    private final int numRows;
    private final int numCols;

    private int spriteNumber = 0;

    BufferedImage spriteImage;

    /**
     * Constructs a SpriteSheet from an image resource path.
     *
     * @param parent   The GameObject this component is attached to.
     * @param position The position of the sprite sheet.
     * @param path     The path to the sprite sheet image resource.
     * @param numRows  Number of rows in the sheet.
     * @param numCols  Number of columns in the sheet.
     */
    public SpriteSheet(GameObject parent, Position2D position, String path, int numRows, int numCols) {
        this(parent, position, ImageLoader.loadResource(path), numRows, numCols, 0);
    }

    /**
     * Constructs a SpriteSheet from a preloaded BufferedImage.
     *
     * @param parent       The GameObject this component is attached to.
     * @param position     The position of the sprite sheet.
     * @param loadedSheet  The BufferedImage to use as the sprite sheet.
     * @param numRows      Number of rows in the sheet.
     * @param numCols      Number of columns in the sheet.
     */
    public SpriteSheet(GameObject parent, Position2D position, BufferedImage loadedSheet, int numRows, int numCols) {
        this(parent, position, loadedSheet, numRows, numCols, 0);
    }

    /**
     * Constructs a SpriteSheet with a specified rendering layer from a resource path.
     *
     * @param parent   The GameObject this component is attached to.
     * @param position The position of the sprite sheet.
     * @param path     The path to the sprite sheet image resource.
     * @param numRows  Number of rows in the sheet.
     * @param numCols  Number of columns in the sheet.
     * @param layer    Rendering layer for drawing order.
     */
    public SpriteSheet(GameObject parent, Position2D position, String path, int numRows, int numCols, int layer) {
        this(parent, position, ImageLoader.loadResource(path), numRows, numCols, layer);
    }

    /**
     * Constructs a SpriteSheet with a specified rendering layer from a BufferedImage.
     *
     * @param parent       The GameObject this component is attached to.
     * @param position     The position of the sprite sheet.
     * @param loadedSheet  The BufferedImage to use as the sprite sheet.
     * @param numRows      Number of rows in the sheet.
     * @param numCols      Number of columns in the sheet.
     * @param layer        Rendering layer for drawing order.
     */
    public SpriteSheet(GameObject parent, Position2D position, BufferedImage loadedSheet, int numRows, int numCols, int layer) {
        super(parent, position, loadedSheet);

        this.numRows = numRows;
        this.numCols = numCols;

        recalculateSpriteDimensions();

        setSprite(0,0);
        setLayer(layer);
        addToRenderer();
    }

    /**
     * Sets both x and y padding for the sprites.
     *
     * @param padding The padding to apply to the x and y axes.
     */
    public void setPadding(int padding) {
        setPadding(padding, padding);
    }

    /**
     * Sets individual x and y padding for the sprites.
     *
     * @param xPadding Horizontal padding.
     * @param yPadding Vertical padding.
     */
    public void setPadding(int xPadding, int yPadding) {
        this.xPadding = xPadding;
        this.yPadding = yPadding;
        recalculateSpriteDimensions();
    }

    /**
     * Sets both x and y spacing between sprites.
     *
     * @param spacing The spacing to apply to the x and y axes.
     */
    public void setSpacing(int spacing) {
        setSpacing(spacing, spacing);
    }

    /**
     * Sets individual x and y spacing between sprites.
     *
     * @param xSpacing Horizontal spacing between sprites.
     * @param ySpacing Vertical spacing between sprites.
     */
    public void setSpacing(int xSpacing, int ySpacing) {
        this.xSpacing = xSpacing;
        this.ySpacing = ySpacing;
        recalculateSpriteDimensions();
    }

    /**
     * Recalculates the width and height of each individual sprite based on
     * current padding, spacing, and total dimensions of the sheet.
     * Required after changing padding, spacing, or the total dimensions
     * of the sheet.
     */
    private void recalculateSpriteDimensions() {
        this.individualSpriteWidth = (image.getWidth() - (2 * xPadding) - ((numCols - 1) * xSpacing)) / numCols;
        this.individualSpriteHeight = (image.getHeight() - (2 * yPadding) - ((numRows - 1) * ySpacing)) / numRows;
    }

    /**
     * Sets the current sprite to display based on a linear index.
     *
     * @param spriteNum The index of the sprite (starting from 0).
     */
    public void setSprite(int spriteNum) {
        int col = (spriteNum % numCols);
        int row = (spriteNum / numCols);
        setSprite(row, col);
    }

    /**
     * Sets the current sprite to display based on row and column.
     *
     * @param row The row of the desired sprite (starting from 0).
     * @param col The column of the desired sprite (starting from 0).
     */
    public void setSprite(int row, int col) {
        int x = xPadding + ( (individualSpriteWidth + xSpacing) * col );
        int y = yPadding + ( (individualSpriteHeight + ySpacing) * row );
        spriteNumber = calculateSpriteNumber(row, col);
        spriteImage = image.getSubimage(x, y, individualSpriteWidth, individualSpriteHeight);
    }

    /**
     * Calculates the linear sprite index based on inputted row and column.
     *
     * @param row The row index (starting from 0).
     * @param col The column index (starting from 0).
     * @return The sprite's linear index.
     */
    public int calculateSpriteNumber(int row, int col) {
        return row * numCols + col;
    }

    /**
     * Returns the current sprite's linear index.
     *
     * @return The current sprite index.
     */
    public int getSpriteNumber() {
        return spriteNumber;
    }

    /**
     * Renders the currently selected sprite image at its position.
     *
     * @param g2 The Graphics2D context used for rendering.
     */
    @Override
    public void render(Graphics2D g2) {
        if (visible) {
            if (sticky) {
                g2.drawImage(spriteImage, position.getIntX(), position.getIntY(), individualSpriteWidth, individualSpriteHeight, null);
            } else {
                Position2D drawPosition = position.copy();
                drawPosition.addVector2D(CameraServer.getOffsetVector());

                g2.drawImage(spriteImage, drawPosition.getIntX(), drawPosition.getIntY(), individualSpriteWidth, individualSpriteHeight, null);
            }
        }
    }
}
