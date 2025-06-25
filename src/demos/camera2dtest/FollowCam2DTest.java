package demos.camera2dtest;

import j2d.engine.Engine;
import j2d.engine.camera.Camera;
import j2d.engine.camera.CameraServer;
import j2d.engine.camera.FollowCamera;
import j2d.engine.camera.StaticCamera;
import j2d.engine.debug.Debug;
import j2d.engine.window.Window;

public class FollowCam2DTest {
    public static void main(String[] args) {
        Engine.initialize();
        Engine.setTargetFPS(60);

        Window window = new Window(600, 600);
        window.setRecommendedDefaults();
        window.setTitle("Draw Test Follow Camera");
        window.setCloseOnEsc(true);

        Debug.setDrawFPS(true);

        AllDrawableCreator creator = new AllDrawableCreator();
        MoveablePlayer player = new MoveablePlayer();

        //creator.setAllSticky();

        FollowCamera followCamera = new FollowCamera(player.getPosition2D());
        CameraServer.setCamera(followCamera);

        Engine.ready();
    }
}
