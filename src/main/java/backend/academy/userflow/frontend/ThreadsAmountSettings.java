package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ThreadsAmountSettings extends BaseSettings {
    public static final ThreadsAmountSettings INSTANCE = new ThreadsAmountSettings();

    private final int MIN_THREADS_AMOUNT = 1;
    private final int MAX_THREADS_AMOUNT = 100;

    @Override
    public void print() {
        super.print();
        String text = "";
        text += "Input threads amount >= " + MIN_THREADS_AMOUNT + " && <= " + MAX_THREADS_AMOUNT + " (" +
            Settings.INSTANCE.threads() + "):" + System.lineSeparator() +
            "  1. Default" + System.lineSeparator() +
            "  2. Back" + System.lineSeparator() +
            System.lineSeparator() +
            "Input: ";
        PrintHandler.INSTANCE.printMessage(text);
    }
}
