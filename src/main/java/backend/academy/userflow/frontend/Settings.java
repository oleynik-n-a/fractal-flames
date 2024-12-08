package backend.academy.userflow.frontend;

import backend.academy.models.FractalImage;
import backend.academy.postprocess.CorrectionType;
import backend.academy.stream.handlers.PrintHandler;
import backend.academy.transformations.TransformationType;
import lombok.Getter;
import lombok.Setter;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class Settings extends BaseSettings {
    @Getter static final Settings INSTANCE = new Settings();

    private final int BASE_THREADS_AMOUNT = 1;
    private final int BASE_ITERATIONS_AMOUNT = 20000;
    private final int BASE_IMAGE_WIDTH = 640;
    private final int BASE_IMAGE_HEIGHT = 640;

    @Setter private int threads;
    @Setter private int iterations;
    private final FractalImage image;
    private final Map<TransformationType, Boolean> transformations;
    private final Map<CorrectionType, Boolean> corrections;

    private Settings() {
        threads = BASE_THREADS_AMOUNT;
        iterations = BASE_ITERATIONS_AMOUNT;
        image = new FractalImage(BASE_IMAGE_WIDTH, BASE_IMAGE_HEIGHT);
        transformations = new LinkedHashMap<>() {{
            put(TransformationType.SINUSOIDAL, false);
            put(TransformationType.SPHERICAL, false);
            put(TransformationType.POLAR, false);
            put(TransformationType.HEART, false);
            put(TransformationType.DISK, false);
        }};
        corrections = new LinkedHashMap<>() {{
            put(CorrectionType.LOGARITHMIC, false);
            put(CorrectionType.GAMMA, false);
        }};
    }

    @Override
    public void print() {
        String text = "Settings:" + System.lineSeparator() +
            "  1. Render image" + System.lineSeparator() +
            "  2. Set render threads amount (" + threads + ")" + System.lineSeparator() +
            "  3. Set iterations amount (" + iterations + ")" + System.lineSeparator() +
            "  4. Set image size (" + image.width() + "x" + image.height() + ")" + System.lineSeparator() +
            "  5. Choose transformations" + System.lineSeparator() +
            "  6. Choose corrections" + System.lineSeparator() +
            "  7. Exit" + System.lineSeparator() +
            System.lineSeparator() +
            "Input: ";
        PrintHandler.INSTANCE().printMessageLn(text);
    }
}
