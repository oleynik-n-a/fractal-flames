package backend.academy.models;

import java.security.SecureRandom;

public record Point(double x, double y) {
    public static Point generateRandom(Rect world) {
        SecureRandom random = new SecureRandom();
        double x = world.x() + world.width() * random.nextDouble();
        double y = world.y() + world.height() * random.nextDouble();
        return new Point(x, y);
    }
}
