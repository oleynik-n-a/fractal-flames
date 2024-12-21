package backend.academy.userflow.backend;

import backend.academy.save.ImageFormat;
import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.FileFormatSettings;
import backend.academy.userflow.frontend.Settings;

public final class SetFileFormat extends SettingsBasedAction<FileFormatSettings> {
    public SetFileFormat(FileFormatSettings settings) {
        super(settings);
    }

    @Override
    public void act() {
        Integer input;
        while (true) {
            settings.print();
            input = InputHandler.INSTANCE.tryReadInteger();
            if (input == null) {
                settings.incorrectInput(true);
                continue;
            }
            if (input == 1) {
                settings.incorrectInput(false);
                Settings.INSTANCE.format(ImageFormat.PNG);
                continue;
            }
            if (input == 2) {
                settings.incorrectInput(false);
                Settings.INSTANCE.format(ImageFormat.JPEG);
                continue;
            }
            if (input == 3) {
                settings.incorrectInput(false);
                return;
            }
            settings.incorrectInput(true);
        }
    }
}
