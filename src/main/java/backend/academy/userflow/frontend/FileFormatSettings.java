package backend.academy.userflow.frontend;

import backend.academy.save.ImageFormat;
import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;

@Getter
public class FileFormatSettings extends BaseSettings {
    public static final FileFormatSettings INSTANCE = new FileFormatSettings();

    @Override
    public void print() {
        super.print();
        String text = "Choose file format:" + System.lineSeparator() +
            "  1. " + ImageFormat.PNG + (Settings.INSTANCE.format().equals(ImageFormat.PNG) ? " <--" : "") +
            System.lineSeparator() +
            "  2. " + ImageFormat.JPEG + (Settings.INSTANCE.format().equals(ImageFormat.JPEG) ? " <--" : "") +
            System.lineSeparator() +
            "  3. Back" + System.lineSeparator() +
            System.lineSeparator() +
            "Input: ";

        PrintHandler.INSTANCE.printMessage(text);
    }
}
