package backend.academy.transformations;

import backend.academy.models.Point;

public final class Heart implements Transformation {
    @Override
    public Point apply(Point point) {
        if (point.y() == 0.0) {
            return point;
        }
        double atan = Math.atan(point.x() / point.y());
        double hypotenuse = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        return new Point(hypotenuse * Math.sin(hypotenuse * atan), -hypotenuse * Math.cos(hypotenuse * atan));
    }
}
