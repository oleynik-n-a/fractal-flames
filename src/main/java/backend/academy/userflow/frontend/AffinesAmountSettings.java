package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AffinesAmountSettings extends BaseSettings {
    public static final AffinesAmountSettings INSTANCE = new AffinesAmountSettings();

    private final int MIN_AFFINES_AMOUNT = 3;
    private final int MAX_AFFINES_AMOUNT = 20;

    @Override
    public void print() {
        super.print();
        String text = "";
        text += "Input affines amount >= " + MIN_AFFINES_AMOUNT + " && <= " + MAX_AFFINES_AMOUNT + " (" +
            Settings.INSTANCE.affines() + "):" + System.lineSeparator() +
            "  1. Default" + System.lineSeparator() +
            "  2. Back" + System.lineSeparator() +
            System.lineSeparator() +
            "Input: ";
        PrintHandler.INSTANCE.printMessage(text);
    }
}
