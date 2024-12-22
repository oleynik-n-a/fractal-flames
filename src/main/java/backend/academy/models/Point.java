package backend.academy.models;

import java.util.Random;

public record Point(double x, double y) {
    public static Point generateRandom(Rect world, long seed) {
        Random random = new Random(seed);
        double x = world.x() + world.width() * random.nextDouble();
        double y = world.y() + world.height() * random.nextDouble();
        return new Point(x, y);
    }
}
