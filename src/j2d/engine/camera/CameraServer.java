package j2d.engine.camera;

import j2d.attributes.Vector2D;

public class CameraServer {
    private static Camera camera;
    private static Vector2D offsetVector = new Vector2D(0, 0);

    public static void initialize() {
        camera = new StaticCamera();
    }

    public static void recalculateOffsets() {
        offsetVector = new Vector2D(camera.getOffsetX(), camera.getOffsetY()).flip();
    }

    public static void setCamera(Camera camera) {
        CameraServer.camera = camera;
    }

    public static Vector2D getOffsetVector() {
        return offsetVector;
    }
}
