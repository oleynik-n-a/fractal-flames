package backend.academy.transformations;

import backend.academy.models.Point;

public final class Sinusoidal implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(Math.sin(point.x()), Math.cos(point.y()));
    }

    @Override
    public TransformationType getType() {
        return TransformationType.SINUSOIDAL;
    }
}
