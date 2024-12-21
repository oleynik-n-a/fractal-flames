package backend.academy.userflow.frontend;

import backend.academy.stream.handlers.PrintHandler;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class ImageSizeSettings extends BaseSettings {
    public static final ImageSizeSettings INSTANCE = new ImageSizeSettings();

    private final int minImageWidth = 640;
    private final int maxImageWidth = 2048;
    private final int minImageHeight = 640;
    private final int maxImageHeight = 2048;

    private int step;

    private ImageSizeSettings() {
        step = 1;
    }

    @Override
    @SuppressWarnings("multiplestringliterals")
    public void print() {
        String text = "";
        if (step == 1) {
            text += "Input image width >= " + minImageWidth + " && <= " + maxImageWidth + " ("
                + Settings.INSTANCE.image().width();
        } else {
            text += "Input image height >= " + minImageHeight + " && <= " + maxImageHeight + " ("
                + Settings.INSTANCE.image().height();
        }
        text += "):" + System.lineSeparator()
            + "  1. Default" + System.lineSeparator()
            + "  2. Choose another" + System.lineSeparator()
            + "  3. Back" + System.lineSeparator()
            + System.lineSeparator()
            + "Input: ";
        PrintHandler.INSTANCE.printMessage(text);
    }
}
