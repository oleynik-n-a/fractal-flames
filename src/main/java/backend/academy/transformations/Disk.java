package backend.academy.transformations;

import backend.academy.models.Point;

public final class Disk implements Transformation {
    @Override
    public Point apply(Point point) {
        if (point.y() == 0.0) {
            return point;
        }
        double atan = 1.0 / Math.PI * Math.atan(point.x() / point.y());
        double hypotenuse = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        return new Point(atan * Math.sin(Math.PI * hypotenuse), atan * Math.cos(Math.PI * hypotenuse));
    }
}
