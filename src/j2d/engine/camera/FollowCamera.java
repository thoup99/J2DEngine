package j2d.engine.camera;

import j2d.attributes.transform.position.Position2D;
import j2d.engine.window.Window;

public class FollowCamera extends Camera {
    Position2D followPoint;

    public FollowCamera(Position2D followPoint) {
        setFollowPoint(followPoint);
    }

    public void setFollowPoint(Position2D followPoint) {
        this.followPoint = followPoint;
    }

    public Position2D getFollowPoint() {
        return followPoint;
    }

    @Override
    double getOffsetX() {
        return followPoint.getX() - ((double) Window.getWidth() / 2);
    }

    @Override
    double getOffsetY() {
        return followPoint.getIntY() - ((double) Window.getHeight() / 2);
    }
}
