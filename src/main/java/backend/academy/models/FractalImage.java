package backend.academy.models;

import lombok.Getter;

@Getter
public class FractalImage {
    private int width;
    private int height;
    Pixel[] data;

    public FractalImage(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new Pixel[width * height];
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = new Pixel(new Color(0, 0, 0), 0);
        }
    }

    public boolean contains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void setWidth(int width) {
        this.width = width;
        this.data = new Pixel[width * height];
    }

    public void setHeight(int height) {
        this.height = height;
        this.data = new Pixel[width * height];
    }

    public Pixel getPixel(int x, int y) {
        return data[y * width + x];
    }

    public Pixel getPixel(Rect world, Point point) {
        int x = (int)((point.x() - world.x()) / world.width() * width);
        int y = (int)((point.y() - world.y()) / world.height() * height);
        return getPixel(x, y);
    }

    public void setPixel(int x, int y, Pixel pixel) {
        data[y * width + x] = pixel;
    }
}
