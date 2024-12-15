package backend.academy.postprocess;

import backend.academy.models.Color;
import backend.academy.models.FractalImage;
import backend.academy.models.Pixel;

public final class GammaCorrection implements Correction {
    private static final double GAMMA = 2.2;
    private static final double MAX_COLOR_STRENGTH = 255.0;

    @Override
    public void process(FractalImage image) {
        for (int i = 0; i < image.data().length; ++i) {
            Pixel pixel = image.data()[i];
            int r = (int)(MAX_COLOR_STRENGTH * Math.pow(pixel.color().r() / MAX_COLOR_STRENGTH, GAMMA));
            int g = (int)(MAX_COLOR_STRENGTH * Math.pow(pixel.color().g() / MAX_COLOR_STRENGTH, GAMMA));
            int b = (int)(MAX_COLOR_STRENGTH * Math.pow(pixel.color().b() / MAX_COLOR_STRENGTH, GAMMA));
            image.data()[i] = new Pixel(new Color(r, g, b), pixel.hitCount());
        }
    }
}
