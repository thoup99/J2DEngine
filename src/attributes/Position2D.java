package attributes;

/**
 * Position2D.java
 * A wrapper class using two ints to represent x and y positions
 * can be used to have objects share a common position.
 *
 * @author Tyler Houp
 */
public class Position2D {
    public int x;
    public int y;

    /**
     * Constructor for Position2D
     * @param x X position
     * @param y Y position
     */
    public Position2D(int x, int y) {
        setPosition(x, y);
    }

    /**
     * Constructor for Position2D
     * Sets position at (0,0)
     */
    public Position2D() {
        setPosition(0, 0);
    }

    /**
     * Sets the x and y components of the Position2D
     * @param x X position
     * @param y Y position
     */
    public void setPosition(int x , int y) {
        this.x = x;
        this.y = y;
    }

}
