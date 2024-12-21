package backend.academy.render;

import backend.academy.models.Color;
import backend.academy.models.Point;
import java.util.Random;
import java.util.function.Function;
import lombok.Getter;

public final class Affine implements Function<Point, Point> {
    @Getter private final Color color;
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public Affine(Random random) {
        color = new Color(random.nextInt(Color.COLOR_SPECTRE), random.nextInt(Color.COLOR_SPECTRE),
            random.nextInt(Color.COLOR_SPECTRE));
        do {
            a = random.nextDouble(-1.0, 1.0);
            b = random.nextDouble(-1.0, 1.0);
            c = random.nextDouble(-1.0, 1.0);
            d = random.nextDouble(-1.0, 1.0);
            e = random.nextDouble(-1.0, 1.0);
            f = random.nextDouble(-1.0, 1.0);
        } while (!checkAffine());
    }

    private boolean checkAffine() {
        boolean result = true;
        result &= (Math.pow(a, 2) + Math.pow(d, 2) < 1);
        result &= (Math.pow(b, 2) + Math.pow(e, 2) < 1);
        result &= (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(d, 2) + Math.pow(e, 2) < 1 + Math.pow(a * e - b * d, 2));
        return result;
    }

    @Override
    public Point apply(Point point) {
        return new Point(a * point.x() + b * point.y() + c, d * point.x() + e * point.y() + f);
    }
}
