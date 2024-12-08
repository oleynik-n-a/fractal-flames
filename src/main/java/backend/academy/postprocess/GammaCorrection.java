package backend.academy.postprocess;

import backend.academy.models.Color;
import backend.academy.models.FractalImage;
import backend.academy.models.Pixel;

public final class GammaCorrection implements Correction {
    private static final double GAMMA = 2.2;

    @Override
    public void process(FractalImage image) {
        for (int i = 0; i < image.data().length; ++i) {
            Pixel pixel = image.data()[i];
            int r = (int)(maxColorStrength * Math.pow(pixel.color().r() / maxColorStrength, GAMMA));
            int g = (int)(maxColorStrength * Math.pow(pixel.color().g() / maxColorStrength, GAMMA));
            int b = (int)(maxColorStrength * Math.pow(pixel.color().b() / maxColorStrength, GAMMA));
            image.data()[i] = new Pixel(new Color(r, g, b), pixel.hitCount());
        }
    }
}
