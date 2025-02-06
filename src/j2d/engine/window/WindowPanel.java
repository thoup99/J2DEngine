package j2d.engine.window;

import j2d.engine.input.keyboard.KeyHandler;
import j2d.engine.input.mouse.MouseHandler;
import j2d.engine.render.Renderer;

import javax.swing.*;
import java.awt.*;

class WindowPanel extends JPanel {

    WindowPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);

        this.addKeyListener(KeyHandler.keyHandler);
        this.addMouseListener(MouseHandler.mouseHandler);
        this.setFocusable(true); //Panel Can be focused for key input
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Renderer.renderAll(g2d);

        g2d.dispose();
    }
}
