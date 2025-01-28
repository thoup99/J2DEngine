package render;

import java.awt.*;
import java.util.ArrayList;

/**
 * Renderer.java
 * A class to allow Rendering of all objects to happen in one place.
 * This is to reduce redundancy and creation of long blocks of code
 * calling .render on objects
 *
 * @author Tyler Houp
 */
public class Renderer {
    private static ArrayList<Renderable> toRender = new ArrayList<>();

    /**
     * Adds Object to Array of items to be rendered every frame
     * @param r Object that implements Renderable
     */
    public static void add(Renderable r) {
        if (!toRender.contains(r)) {
            toRender.add(r);
        }
    }

    /**
     * Removes Object from being rendered every frame
     * @param r Object that implements Renderable
     */
    public static void remove(Renderable r) {
        toRender.remove(r);
    }

    /**
     * Calls "render" on all Objects added to Renderer
     * @param g2 Graphics2D Object passed to all added Objects
     */
    public static void renderAll(Graphics2D g2) {
        for (Renderable r : toRender) {
            r.render(g2);
        }
    }
}
