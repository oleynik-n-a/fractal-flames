package backend.academy.postprocess;

import backend.academy.models.Color;
import backend.academy.models.FractalImage;
import backend.academy.models.Pixel;

public final class LogarithmicCorrection implements Correction {
    @Override
    public void process(FractalImage image) {
        int maxHitCount = 0;
        for (Pixel pixel : image.data()) {
            maxHitCount = Math.max(maxHitCount, pixel.hitCount());
        }

        for (int i = 0; i < image.data().length; ++i) {
            Pixel pixel = image.data()[i];

            double normalized = Math.log(1 + pixel.hitCount()) / Math.log(1 + maxHitCount);
            int r = (int)(maxColorStrength * normalized);
            int g = (int)(maxColorStrength * normalized);
            int b = (int)(maxColorStrength * normalized);

            image.data()[i] = new Pixel(new Color(r, g, b), pixel.hitCount());
        }
    }
}
