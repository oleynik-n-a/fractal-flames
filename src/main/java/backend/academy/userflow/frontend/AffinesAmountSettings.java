package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class AffinesAmountSettings extends BaseSettings {
    public static final AffinesAmountSettings INSTANCE = new AffinesAmountSettings();

    private final int minAffinesAmount = 3;
    private final int maxAffinesAmount = 20;

    @Override
    public void print() {
        super.print();
        String text = "";
        text += "Input affines amount >= " + minAffinesAmount + " && <= " + maxAffinesAmount + " ("
            + Settings.INSTANCE.affines() + "):" + System.lineSeparator()
            + "  1. Default" + System.lineSeparator()
            + "  2. Back" + System.lineSeparator()
            + System.lineSeparator()
            + "Input: ";
        PrintHandler.INSTANCE.printMessage(text);
    }
}
