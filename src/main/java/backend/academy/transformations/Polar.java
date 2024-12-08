package backend.academy.transformations;

import backend.academy.models.Point;

public final class Polar implements Transformation {
    @Override
    public Point apply(Point point) {
        double atan = Math.atan(point.y() / point.x());
        double squareSum = Math.pow(point.x(), 2) + Math.pow(point.y(), 2);
        return new Point(atan / Math.PI , Math.sqrt(squareSum) - 1);
    }

    @Override
    public TransformationType GetType() {
        return TransformationType.POLAR;
    }
}
