package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ImageSizeSettings extends BaseSettings {
    @Getter private static final ImageSizeSettings INSTANCE = new ImageSizeSettings();

    private final int MIN_IMAGE_WIDTH = 640;
    private final int MAX_IMAGE_WIDTH = 1920;
    private final int MIN_IMAGE_HEIGHT = 640;
    private final int MAX_IMAGE_HEIGHT = 1080;

    private int step;

    private ImageSizeSettings() {
        incorrectInput = false;
        step = 1;
    }

    @Override
    public void print() {
        String text = incorrectInput ? "Incorrect input!" + System.lineSeparator() + System.lineSeparator() : "";
        if (step == 1) {
            text += "Input image width >= " + MIN_IMAGE_WIDTH + " && <= " + MAX_IMAGE_WIDTH + " (" +
                Settings.INSTANCE().image().width();
        } else {
            text += "Input image height >= " + MIN_IMAGE_HEIGHT + " && <= " + MAX_IMAGE_HEIGHT + " (" +
                Settings.INSTANCE().image().height();
        }
        text += "):" + System.lineSeparator() +
            "  1. Default" + System.lineSeparator() +
            "  2. Choose another" + System.lineSeparator() +
            "  3. Back" + System.lineSeparator() +
            System.lineSeparator() +
            "Input: ";
        PrintHandler.INSTANCE().printMessageLn(text);
    }
}
