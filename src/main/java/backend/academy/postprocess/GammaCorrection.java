package backend.academy.postprocess;

import backend.academy.models.Color;
import backend.academy.models.FractalImage;
import backend.academy.models.Pixel;

public final class GammaCorrection implements Correction {
    private static final double GAMMA = 2.2;
    private static final double MAX_BRIGHTNESS = 255.0;

    @Override
    public void process(FractalImage image) {
        for (int i = 0; i < image.data().length; ++i) {
            Pixel pixel = image.data()[i];
            double normalized = (double) pixel.hitCount() / Color.COLOR_SPECTRE;
            double corrected = Math.log10(normalized * (Math.exp(GAMMA) - 1)) / GAMMA;
            int r = (int) Math.max(0, Math.min(MAX_BRIGHTNESS,
                (pixel.color().r() / (double) Color.COLOR_SPECTRE) * corrected * MAX_BRIGHTNESS));
            int g = (int) Math.max(0, Math.min(MAX_BRIGHTNESS,
                (pixel.color().g() / (double) Color.COLOR_SPECTRE) * corrected * MAX_BRIGHTNESS));
            int b = (int) Math.max(0, Math.min(MAX_BRIGHTNESS,
                (pixel.color().b() / (double) Color.COLOR_SPECTRE) * corrected * MAX_BRIGHTNESS));
            image.data()[i] = new Pixel(new Color(r, g, b), pixel.hitCount());
        }
    }
}
