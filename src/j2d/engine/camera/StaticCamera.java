package j2d.engine.camera;

public class StaticCamera extends Camera {

    public StaticCamera() {
        super();
    }

    @Override
    int getOffsetX() {
        return 0;
    }

    @Override
    int getOffsetY() {
        return 0;
    }
}
