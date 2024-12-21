package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import backend.academy.transformations.TransformationType;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public final class TransformationsSettings extends BaseSettings {
    public static final TransformationsSettings INSTANCE = new TransformationsSettings();

    @SuppressWarnings("magicnumber")
    private final Map<Integer, TransformationType> transformationsBySettings = new LinkedHashMap<>() {{
        put(1, TransformationType.SINUSOIDAL);
        put(2, TransformationType.SPHERICAL);
        put(3, TransformationType.POLAR);
        put(4, TransformationType.HEART);
        put(5, TransformationType.DISK);
    }};

    @Override
    public void print() {
        super.print();
        StringBuilder text = new StringBuilder();
        text.append("Choose transformations:").append(System.lineSeparator());

        int i = 1;
        for (var transformation : Settings.INSTANCE.transformations().entrySet()) {
            text.append("  ").append(i).append(". ").append(transformation.getKey().toString())
                .append(" transformation: ").append(transformation.getValue()).append(System.lineSeparator());
            ++i;
        }

        text.append("  ").append(i).append(". Back").append(System.lineSeparator())
            .append(System.lineSeparator())
            .append("Input: ");

        PrintHandler.INSTANCE.printMessage(text.toString());
    }
}
