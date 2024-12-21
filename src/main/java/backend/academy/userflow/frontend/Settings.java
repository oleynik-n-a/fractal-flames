package backend.academy.userflow.frontend;

import backend.academy.models.FractalImage;
import backend.academy.save.ImageFormat;
import backend.academy.stream.handlers.PrintHandler;
import backend.academy.transformations.TransformationType;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
public final class Settings extends BaseSettings {
    public static final Settings INSTANCE = new Settings();

    private final String baseFilePath = "base_file_path";
    private final ImageFormat baseImageFormat = ImageFormat.PNG;
    private final int baseThreadsAmount = 20;
    private final int baseIterationsAmount = 4000;
    private final int baseSamplesAmount = 20000;
    private final int baseAffinesAmount = 5;
    private final int baseImageWidth = 1024;
    private final int baseImageHeight = 1024;
    private final long baseSeed = 2024L;
    private final boolean baseCorrection = true;

    @Setter private String path;
    @Setter private ImageFormat format;
    @Setter private int threads;
    @Setter private int iterations;
    @Setter private int samples;
    @Setter private int affines;
    @Setter private Long seed;
    @Setter private boolean correction;
    private final FractalImage image;
    private final Map<TransformationType, Boolean> transformations;

    private Settings() {
        path = baseFilePath;
        format = baseImageFormat;
        threads = baseThreadsAmount;
        iterations = baseIterationsAmount;
        samples = baseSamplesAmount;
        affines = baseAffinesAmount;
        seed = baseSeed;
        correction = baseCorrection;
        image = new FractalImage(baseImageWidth, baseImageHeight);
        transformations = new LinkedHashMap<>() {{
            put(TransformationType.SINUSOIDAL, false);
            put(TransformationType.SPHERICAL, false);
            put(TransformationType.POLAR, false);
            put(TransformationType.HEART, false);
            put(TransformationType.DISK, false);
        }};
    }

    @Override
    public void print() {
        super.print();
        String text = "Settings:" + System.lineSeparator()
            + "  1. Render image" + System.lineSeparator()
            + "  2. Set file path (" + path + ")" + System.lineSeparator()
            + "  3. Set file format (." + format.toString() + ")" + System.lineSeparator()
            + "  4. Set render threads amount (" + threads + ")" + System.lineSeparator()
            + "  5. Set iterations amount (" + iterations + ")" + System.lineSeparator()
            + "  6. Set samples amount (" + samples + ")" + System.lineSeparator()
            + "  7. Set affines amount (" + affines + ")" + System.lineSeparator()
            + "  8. Set image size (" + image.width() + "x" + image.height() + ")" + System.lineSeparator()
            + "  9. Set seed (" + seed + ")" + System.lineSeparator()
            + "  10. Enable gamma correction (" + correction + ")" + System.lineSeparator()
            + "  11. Choose transformations" + System.lineSeparator()
            + "  12. Exit" + System.lineSeparator()
            + System.lineSeparator()
            + "Input: ";
        PrintHandler.INSTANCE.printMessage(text);
    }
}
