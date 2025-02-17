package j2d.attributes.position;

public class OffsetPosition2D extends Position2D {
    double x_offset, y_offset;
    Position2D basePosition;

    public OffsetPosition2D(Position2D basePosition, double x_offset, double y_offset) {
        super();
        this.basePosition = basePosition;
        this.x_offset = x_offset;
        this.y_offset = y_offset;
    }

    @Override
    public double getX() {
        return basePosition.getX() + x_offset;
    }

    @Override
    public double getY() {
        return basePosition.getY() + y_offset;
    }

    @Override
    public int getIntX() {
        return (int) getX();
    }

    @Override
    public int getIntY() {
        return (int) getY();
    }
}
