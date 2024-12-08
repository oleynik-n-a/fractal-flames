package backend.academy.userflow.frontend;

import backend.academy.postprocess.CorrectionType;
import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class CorrectionsSettings extends BaseSettings {
    @Getter private static final CorrectionsSettings INSTANCE = new CorrectionsSettings();

    private final Map<Integer, CorrectionType> correctionsBySettings = new LinkedHashMap<>() {{
        put(1, CorrectionType.LOGARITHMIC);
        put(2, CorrectionType.GAMMA);
    }};

    private CorrectionsSettings() {
        incorrectInput = false;
    }

    @Override
    public void print() {
        StringBuilder text = new StringBuilder(
            incorrectInput ? "Incorrect input!" + System.lineSeparator() + System.lineSeparator() : "");
        text.append("Choose corrections:").append(System.lineSeparator());

        int i = 1;
        for (var correction : Settings.INSTANCE().corrections().entrySet()) {
            text.append("  ").append(i).append(". ").append(correction.getKey().toString())
                .append(" correction: ").append(correction.getValue()).append(System.lineSeparator());
            ++i;
        }

        text.append("  ").append(i).append(". Back").append(System.lineSeparator())
            .append(System.lineSeparator())
            .append("Input: ");

        PrintHandler.INSTANCE().printMessageLn(text.toString());
    }
}
