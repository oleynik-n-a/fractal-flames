package backend.academy.userflow.frontend;

import backend.academy.models.FractalImage;
import backend.academy.postprocess.CorrectionType;
import backend.academy.save.ImageFormat;
import backend.academy.stream.handlers.PrintHandler;
import backend.academy.transformations.TransformationType;
import lombok.Getter;
import lombok.Setter;
import java.util.LinkedHashMap;
import java.util.Map;
import static backend.academy.save.ImageSaver.SEPARATOR;

@Getter
public class Settings extends BaseSettings {
    @Getter private static final Settings INSTANCE = new Settings();

    private final String BASE_FILE_PATH = "results" + SEPARATOR + "base_file_path";
    private final ImageFormat BASE_IMAGE_FORMAT = ImageFormat.PNG;
    private final int BASE_THREADS_AMOUNT = 1;
    private final int BASE_ITERATIONS_AMOUNT = 1000;
    private final int BASE_SAMPLES_AMOUNT = 10000;
    private final int BASE_AFFINES_AMOUNT = 10;
    private final int BASE_IMAGE_WIDTH = 640;
    private final int BASE_IMAGE_HEIGHT = 640;
    private final long BASE_SEED = 2024L;

    @Setter private String path;
    @Setter private ImageFormat format;
    @Setter private int threads;
    @Setter private int iterations;
    @Setter private int samples;
    @Setter private int affines;
    @Setter private Long seed;
    private final FractalImage image;
    private final Map<TransformationType, Boolean> transformations;
    private final Map<CorrectionType, Boolean> corrections;

    private Settings() {
        super();
        path = BASE_FILE_PATH;
        format = BASE_IMAGE_FORMAT;
        threads = BASE_THREADS_AMOUNT;
        iterations = BASE_ITERATIONS_AMOUNT;
        samples = BASE_SAMPLES_AMOUNT;
        affines = BASE_AFFINES_AMOUNT;
        seed = BASE_SEED;
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
        super.print();
        String text = "Settings:" + System.lineSeparator() +
            "  1. Render image" + System.lineSeparator() +
            "  2. Set file path (" + path + ")" + System.lineSeparator() +
            "  3. Set file format (." + format.toString() + ")" + System.lineSeparator() +
            "  4. Set render threads amount (" + threads + ")" + System.lineSeparator() +
            "  5. Set iterations amount (" + iterations + ")" + System.lineSeparator() +
            "  6. Set samples amount (" + samples + ")" + System.lineSeparator() +
            "  7. Set affines amount (" + affines + ")" + System.lineSeparator() +
            "  8. Set image size (" + image.width() + "x" + image.height() + ")" + System.lineSeparator() +
            "  9. Set seed (" + seed + ")" + System.lineSeparator() +
            "  10. Choose transformations" + System.lineSeparator() +
            "  11. Choose corrections" + System.lineSeparator() +
            "  12. Exit" + System.lineSeparator() +
            System.lineSeparator() +
            "Input: ";
        PrintHandler.INSTANCE().printMessage(text);
    }
}
