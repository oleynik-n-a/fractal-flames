package backend.academy.postprocess;

import backend.academy.models.FractalImage;

@FunctionalInterface
public interface Correction {
    double maxColorStrength = 255.0;
    void process(FractalImage fractalImage);
}
