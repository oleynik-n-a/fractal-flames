package backend.academy.postprocess;

import backend.academy.models.Color;
import backend.academy.models.FractalImage;
import backend.academy.models.Pixel;

public final class GammaCorrection implements Correction {
    private static final double GAMMA = 2.2;

    @Override
    public void process(FractalImage image) {
        int maxHitCount = 0;
        for (Pixel pixel : image.data()) {
            maxHitCount = Math.max(maxHitCount, pixel.hitCount());
        }
        for (int i = 0; i < image.data().length; ++i) {
            Pixel pixel = image.data()[i];
            double normalized = Math.log(1 + pixel.hitCount()) / (1 + maxHitCount);
            int r = (int) (pixel.color().r() * Math.pow(normalized, 1 / GAMMA));
            int g = (int) (pixel.color().g() * Math.pow(normalized, 1 / GAMMA));
            int b = (int) (pixel.color().b() * Math.pow(normalized, 1 / GAMMA));
            image.data()[i] = new Pixel(new Color(r, g, b), pixel.hitCount());
        }
    }
}
