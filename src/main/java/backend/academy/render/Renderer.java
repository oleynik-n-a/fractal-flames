package backend.academy.render;

import backend.academy.models.FractalImage;
import backend.academy.models.Rect;
import backend.academy.transformations.Transformation;
import java.util.ArrayList;

public abstract class Renderer {
    protected static final int STEPS_FOR_NORMALIZATION = 20;

    protected final ArrayList<Transformation> transformations = new ArrayList<>();
    protected final boolean useGammaCorrection;

    public Renderer(ArrayList<Transformation> transformations, boolean useGammaCorrection) {
        this.transformations.addAll(transformations);
        this.useGammaCorrection = useGammaCorrection;
    }

    abstract public void render(
        FractalImage canvas,
        Rect world,
        ArrayList<Affine> affines,
        int samples,
        int iterations,
        long seed
    );
}
