package backend.academy.transformations;

import backend.academy.models.Point;

public final class Disk implements Transformation {
    @Override
    public Point apply(Point point) {
        double atan = 1 / Math.PI * Math.atan(point.y() / point.x());
        double hypotenuse = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        return new Point(atan * Math.sin(Math.PI * hypotenuse), atan * Math.cos(Math.PI * hypotenuse));
    }

    @Override
    public TransformationType getType() {
        return TransformationType.DISK;
    }
}
