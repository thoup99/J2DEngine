package j2d.engine.camera;

public class StaticCamera extends Camera {

    public StaticCamera() {
        super();
    }

    @Override
    double getOffsetX() {
        return 0;
    }

    @Override
    double getOffsetY() {
        return 0;
    }
}
