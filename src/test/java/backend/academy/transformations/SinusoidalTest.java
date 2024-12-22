package backend.academy.transformations;

import backend.academy.models.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SinusoidalTest {
    private static Sinusoidal sinusoidal;

    @BeforeAll
    static void setUp() {
        sinusoidal = new Sinusoidal();
    }

    Point roundPoint(Point point) {
        return new Point(Math.round(point.x() * 1000.0) / 1000.0, Math.round(point.y() * 1000.0) / 1000.0);
    }

    @Test
    void testSinusoidal() {
        Point point1 = new Point(1.0, 1.0);
        Point result1 = roundPoint(sinusoidal.apply(point1));
        Point expected1 = new Point(0.841, 0.841);
        assert (result1.equals(expected1));

        Point point2 = new Point(-3.0, -3.0);
        Point result2 = roundPoint(sinusoidal.apply(point2));
        Point expected2 = new Point(-0.141, -0.141);
        assert (result2.equals(expected2));

        Point point3 = new Point(0.0, 4.99);
        Point result3 = roundPoint(sinusoidal.apply(point3));
        Point expected3 = new Point(0.0, -0.962);
        assert (result3.equals(expected3));
    }
}
