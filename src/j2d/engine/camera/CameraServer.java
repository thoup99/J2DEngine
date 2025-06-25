package j2d.engine.camera;

import j2d.attributes.Vector2D;

public class CameraServer {
    private static Camera camera;
    private static int xOffset, yOffset = 0;
    private static Vector2D offsetVector = new Vector2D(0, 0);

    public static void initialize() {
        camera = new StaticCamera();
    }

    public static void recalculateOffsets() {
        xOffset = camera.getOffsetX();
        yOffset = camera.getOffsetY();
        offsetVector = new Vector2D(xOffset, yOffset).flip();
    }

    public static void setCamera(Camera camera) {
        CameraServer.camera = camera;
    }

    public static int getOffsetX() {
        return xOffset;
    }

    public static int getOffsetY() {
        return yOffset;
    }

    public static Vector2D getOffsetVector() {
        return offsetVector;
    }
}
