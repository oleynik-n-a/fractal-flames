package backend.academy.render;

import backend.academy.models.Point;
import java.security.SecureRandom;
import java.util.function.Function;

public final class Affine implements Function<Point, Point> {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;

    public Affine() {
        SecureRandom random = new SecureRandom();
        a = random.nextDouble();
        b = random.nextDouble();
        c = random.nextDouble();
        d = random.nextDouble();
        e = random.nextDouble();
        f = random.nextDouble();
    }

    @Override
    public Point apply(Point point) {
        return new Point(a * point.x() + b * point.y() + c, d * point.x() + e * point.y() + f);
    }
}
