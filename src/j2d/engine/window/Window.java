package j2d.engine.window;

import j2d.engine.Engine;

import javax.swing.*;
import java.awt.*;

public class Window {
    public static boolean isCreated = false;
    int width, height;

    JFrame frame;
    WindowPanel panel;

    public Window() {
        this(600, 600);
    }

    public Window(int width, int height) {
        if (isCreated) {
            //Ensures only one window can exist at a time
            throw new IllegalStateException("Window is already created");
        }

        this.width = width;
        this.height = height;

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new WindowPanel(width, height);
        frame.add(panel);
        frame.pack();

        frame.setLayout(null);
        setSize(width, height);

        Engine.registerWindow(this);
        isCreated = true;
        setVisible(true);
    }

    public void repaintPanel() {
        panel.repaint();
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

    /**
     * TODO - Doees not seems to resize panel after it has been created. Needs fixed before being made public again.
     * @param width
     * @param height
     */
    private void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        frame.setSize(width, height);
        panel.setPreferredSize(new Dimension(width, height));
    }

    public void centerWindow() {
        frame.setLocationRelativeTo(null);
    }

    public void setResizable(boolean resizable) {
        frame.setResizable(resizable);
    }

    public void setVisible(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public void setRecommendedDefaults() {
        centerWindow();
        setResizable(false);
        setVisible(true);
    }
}
