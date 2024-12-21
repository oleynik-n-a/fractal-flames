package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class SeedSettings extends BaseSettings {
    public static final SeedSettings INSTANCE = new SeedSettings();

    @Override
    public void print() {
        super.print();
        String text = "";
        text += "Input seed (" + Settings.INSTANCE.seed() + "):" + System.lineSeparator()
            + "  1. Default" + System.lineSeparator()
            + "  2. Generate random" + System.lineSeparator()
            + "  3. Back" + System.lineSeparator()
            + System.lineSeparator()
            + "Input: ";
        PrintHandler.INSTANCE.printMessage(text);
    }
}
