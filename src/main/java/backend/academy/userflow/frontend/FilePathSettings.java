package backend.academy.userflow.frontend;

import backend.academy.save.ImageFormat;
import backend.academy.stream.handlers.PrintHandler;
import backend.academy.userflow.backend.SetIterationsAmount;
import lombok.Getter;

@Getter
public class FilePathSettings extends BaseSettings {
    @Getter private static final FilePathSettings INSTANCE = new FilePathSettings();

    @Override
    public void print() {
        super.print();
        String text =
            "Enter file path without extension (" + Settings.INSTANCE().path() + "):" + System.lineSeparator() +
                "  1. Auto" + System.lineSeparator() +
                "  2. Back" + System.lineSeparator() +
                System.lineSeparator() +
                "Input: ";

        PrintHandler.INSTANCE().printMessage(text);
    }
}
