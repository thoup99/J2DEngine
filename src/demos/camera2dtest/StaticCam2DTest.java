package demos.camera2dtest;

import j2d.engine.Engine;
import j2d.engine.camera.Camera;
import j2d.engine.camera.CameraServer;
import j2d.engine.camera.StaticCamera;
import j2d.engine.debug.Debug;
import j2d.engine.window.Window;

public class StaticCam2DTest {
    public static void main(String[] args) {
        Engine.initialize();
        Engine.setTargetFPS(60);

        Window window = new Window(600, 600);
        window.setRecommendedDefaults();
        window.setTitle("Draw Test Static Camera");
        window.setCloseOnEsc(true);

        Debug.setDrawFPS(true);

        AllDrawableCreator creator = new AllDrawableCreator();
        MoveablePlayer player = new MoveablePlayer();

        //creator.setAllSticky();

        Camera staticCamera = new StaticCamera();
        CameraServer.setCamera(staticCamera);

        Engine.ready();
    }
}
