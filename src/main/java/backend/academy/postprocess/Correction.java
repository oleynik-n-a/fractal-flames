package backend.academy.postprocess;

import backend.academy.models.FractalImage;

@FunctionalInterface
public interface Correction {
    void process(FractalImage fractalImage);
}
