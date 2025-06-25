package j2d.components.graphics.text;

import j2d.attributes.transform.position.OffsetPosition2D;
import j2d.attributes.transform.position.Position2D;
import j2d.engine.camera.CameraServer;
import j2d.engine.gameobject.GameObject;

import java.awt.*;

public class CenteredText extends Text{
    OffsetPosition2D offsetPosition;
    private boolean needsRecached = false;


    public CenteredText(GameObject parentGameObject, Position2D position, String text) {
        this(parentGameObject, position, text, 0);
    }

    public CenteredText(GameObject parentGameObject, Position2D position, String text, int layer) {
        super(parentGameObject, position, text, layer);
        offsetPosition = new OffsetPosition2D(position, 0, 0);
        needsRecached = true;
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        needsRecached = true;
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
        needsRecached = true;
    }

    @Override
    public void setFontSize(int fontSize) {
        super.setFontSize(fontSize);
        needsRecached = true;
    }

    @Override
    public void setFontStyle(int style) {
        super.setFontStyle(style);
        needsRecached = true;
    }

    private void calculateOffset(Graphics2D g2) {
        FontMetrics metrics = g2.getFontMetrics(font);
        double new_x_offset = -((double) metrics.stringWidth(text) / 2);
        double new_y_offset = ((double) metrics.getHeight() / 2);
        offsetPosition.setXOffset(new_x_offset);
        offsetPosition.setYOffset(new_y_offset);
    }

    @Override
    public void render(Graphics2D g2) {
        if (offsetPosition == null) {
            return;
        }
        if (needsRecached) {
            calculateOffset(g2);
            needsRecached = false;
        }
        Graphics2D g2Copy = (Graphics2D) g2.create();

        g2Copy.setFont(font);
        g2Copy.setColor(textColor);

        if (sticky) {
            //Does not take camera position into consideration when drawing
            g2Copy.drawString(text, offsetPosition.getIntX(), offsetPosition.getIntY());
        } else {
            //Uses camera position to draw with an offset
            Position2D drawPosition = offsetPosition.copyCurrentPosition();
            drawPosition.addVector2D(CameraServer.getOffsetVector());
            g2Copy.drawString(text, drawPosition.getIntX(), drawPosition.getIntY());
        }

        g2Copy.dispose();
    }
}
