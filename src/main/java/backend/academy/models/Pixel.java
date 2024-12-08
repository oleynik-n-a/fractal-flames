package backend.academy.models;

import lombok.Getter;

@Getter
public class Pixel {
    private Color color;
    int hitCount;

    public Pixel(Color color, int hitCount) {
        this.color = color;
        this.hitCount = hitCount;
    }

    public void setColor(Color color) {
        synchronized (this) {
            this.color = color;
        }
    }

    public void increaseHitCount() {
        synchronized (this) {
            ++hitCount;
        }
    }
}
