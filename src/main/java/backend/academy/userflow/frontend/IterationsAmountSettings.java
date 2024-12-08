package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IterationsAmountSettings extends BaseSettings {
    @Getter private static final IterationsAmountSettings INSTANCE = new IterationsAmountSettings();

    private final int MIN_ITERATIONS_AMOUNT = 1000;
    private final int MAX_ITERATIONS_AMOUNT = 100000;

    private IterationsAmountSettings() {
        incorrectInput = false;
    }

    @Override
    public void print() {
        String text = incorrectInput ? "Incorrect input!" + System.lineSeparator() + System.lineSeparator() : "";
        text += "Input iterations amount >= " + MIN_ITERATIONS_AMOUNT + " && <= " + MAX_ITERATIONS_AMOUNT + " (" +
            Settings.INSTANCE().iterations() + "):" + System.lineSeparator() +
            "  1. Default" + System.lineSeparator() +
            "  2. Back" + System.lineSeparator() +
            System.lineSeparator() +
            "Input: ";
        PrintHandler.INSTANCE().printMessageLn(text);
    }
}
