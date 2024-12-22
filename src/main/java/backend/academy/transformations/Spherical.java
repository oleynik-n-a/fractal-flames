package backend.academy.transformations;

import backend.academy.models.Point;

public final class Spherical implements Transformation {
    @Override
    public Point apply(Point point) {
        double squareSum = Math.pow(point.x(), 2) + Math.pow(point.y(), 2);
        if (squareSum == 0.0) {
            return point;
        }
        return new Point(point.x() / squareSum, point.y() / squareSum);
    }
}
