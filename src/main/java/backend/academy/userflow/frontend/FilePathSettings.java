package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;

@Getter
public class FilePathSettings extends BaseSettings {
    public static final FilePathSettings INSTANCE = new FilePathSettings();

    @Override
    public void print() {
        super.print();
        String text =
            "Enter file path without extension (" + Settings.INSTANCE.path() + "):" + System.lineSeparator() +
                "  1. Auto" + System.lineSeparator() +
                "  2. Back" + System.lineSeparator() +
                System.lineSeparator() +
                "Input: ";

        PrintHandler.INSTANCE.printMessage(text);
    }
}
