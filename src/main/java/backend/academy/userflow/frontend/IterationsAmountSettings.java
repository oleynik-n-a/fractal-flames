package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class IterationsAmountSettings extends BaseSettings {
    public static final IterationsAmountSettings INSTANCE = new IterationsAmountSettings();

    private final int minIterationsAmount = 1000;
    private final int maxIterationsAmount = 100000;

    @Override
    public void print() {
        super.print();
        String text = "";
        text += "Input iterations amount >= " + minIterationsAmount + " && <= " + maxIterationsAmount + " ("
            + Settings.INSTANCE.iterations() + "):" + System.lineSeparator()
            + "  1. Default" + System.lineSeparator()
            + "  2. Back" + System.lineSeparator()
            + System.lineSeparator()
            + "Input: ";
        PrintHandler.INSTANCE.printMessage(text);
    }
}
