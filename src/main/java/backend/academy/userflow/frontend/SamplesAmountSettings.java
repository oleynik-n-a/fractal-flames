package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SamplesAmountSettings extends BaseSettings {
    @Getter private static final SamplesAmountSettings INSTANCE = new SamplesAmountSettings();

    private final int MIN_SAMPLES_AMOUNT = 1000;
    private final int MAX_SAMPLES_AMOUNT = 100000;

    @Override
    public void print() {
        super.print();
        String text = "";
        text += "Input samples amount >= " + MIN_SAMPLES_AMOUNT + " && <= " + MAX_SAMPLES_AMOUNT + " (" +
            Settings.INSTANCE().samples() + "):" + System.lineSeparator() +
            "  1. Default" + System.lineSeparator() +
            "  2. Back" + System.lineSeparator() +
            System.lineSeparator() +
            "Input: ";
        PrintHandler.INSTANCE().printMessage(text);
    }
}
