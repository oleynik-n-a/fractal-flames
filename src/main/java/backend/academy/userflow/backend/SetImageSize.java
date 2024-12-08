package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.ImageSizeSettings;
import backend.academy.userflow.frontend.Settings;

public final class SetImageSize extends BaseAction<ImageSizeSettings> {
    public SetImageSize(ImageSizeSettings settings) {
        super(settings);
    }

    @Override
    public void act() {
        Integer input;
        while (true) {
            settings.print();
            input = InputHandler.INSTANCE().tryReadInteger();
            if (input == null) {
                settings.incorrectInput(true);
                continue;
            }
            if (settings.step() == 1 && (input < settings.MIN_IMAGE_WIDTH() || input > settings.MAX_IMAGE_WIDTH())) {
                settings.incorrectInput(true);
                continue;
            }
            if (settings.step() == 2 && (input < settings.MIN_IMAGE_HEIGHT() || input > settings.MAX_IMAGE_HEIGHT())) {
                settings.incorrectInput(true);
                continue;
            }
            if (input == 1) {
                settings.incorrectInput(false);
                if (settings.step() == 1) {
                    Settings.INSTANCE().image().setWidth(Settings.INSTANCE().BASE_IMAGE_WIDTH());
                } else {
                    Settings.INSTANCE().image().setHeight(Settings.INSTANCE().BASE_IMAGE_HEIGHT());
                }
                return;
            }
            if (input == 2) {
                settings.incorrectInput(false);
                if (settings.step() == 1) {
                    settings.step(2);
                } else {
                    settings.step(1);
                }
                continue;
            }
            if (input == 3) {
                settings.incorrectInput(false);
                return;
            }
            if (settings.step() == 1) {
                Settings.INSTANCE().image().setWidth(input);
            } else {
                Settings.INSTANCE().image().setHeight(input);
            }
        }
    }
}
