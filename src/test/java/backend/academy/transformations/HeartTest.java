package backend.academy.transformations;

import backend.academy.models.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HeartTest {
    private static Heart heart;

    @BeforeAll
    static void setUp() {
        heart = new Heart();
    }

    Point roundPoint(Point point) {
        return new Point(Math.round(point.x() * 1000.0) / 1000.0, Math.round(point.y() * 1000.0) / 1000.0);
    }

    @Test
    void testCorrectPoints() {
        Point point1 = new Point(1.0, 1.0);
        Point result1 = roundPoint(heart.apply(point1));
        Point expected1 = new Point(1.267, -0.628);
        assert (result1.equals(expected1));

        Point point2 = new Point(-3.0, -3.0);
        Point result2 = roundPoint(heart.apply(point2));
        Point expected2 = new Point(-0.804, 4.166);
        assert (result2.equals(expected2));

        Point point3 = new Point(0.0, 4.99);
        Point result3 = roundPoint(heart.apply(point3));
        Point expected3 = new Point(0.0, -4.99);
        assert (result3.equals(expected3));
    }

    @Test
    void testIncorrectPoints() {
        Point point1 = new Point(0.0, 0.0);
        Point result1 = roundPoint(heart.apply(point1));
        Point expected1 = new Point(0.0, 0.0);
        assert (result1.equals(expected1));

        Point point2 = new Point(-2.67, 0.0);
        Point result2 = roundPoint(heart.apply(point2));
        Point expected2 = new Point(-2.67, 0.0);
        assert (result2.equals(expected2));
    }
}
