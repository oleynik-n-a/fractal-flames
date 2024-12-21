package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class SamplesAmountSettings extends BaseSettings {
    public static final SamplesAmountSettings INSTANCE = new SamplesAmountSettings();

    private final int minSamplesAmount = 1000;
    private final int maxSamplesAmount = 100000;

    @Override
    public void print() {
        super.print();
        String text = "";
        text += "Input samples amount >= " + minSamplesAmount + " && <= " + maxSamplesAmount + " ("
            + Settings.INSTANCE.samples() + "):" + System.lineSeparator()
            + "  1. Default" + System.lineSeparator()
            + "  2. Back" + System.lineSeparator()
            + System.lineSeparator()
            + "Input: ";
        PrintHandler.INSTANCE.printMessage(text);
    }
}
