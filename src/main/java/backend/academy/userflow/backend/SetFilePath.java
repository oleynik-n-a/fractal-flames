package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.FilePathSettings;
import backend.academy.userflow.frontend.Settings;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import static backend.academy.save.ImageSaver.SEPARATOR;

public final class SetFilePath extends SettingsBasedAction<FilePathSettings> {
    private static int file_number = 1;

    public SetFilePath(FilePathSettings settings) {
        super(settings);
    }

    @Override
    public void act() {
        String input;
        while (true) {
            settings.print();
            input = InputHandler.INSTANCE.readString();
            if (input == null) {
                settings.incorrectInput(true);
                continue;
            }
            if (input.equals("1")) {
                settings.incorrectInput(false);
                while (true) {
                    try {
                        Settings.INSTANCE
                            .path(Paths.get("results" + SEPARATOR + "Unnamed_" + file_number).toString());
                        break;
                    } catch (InvalidPathException e) {
                        ++file_number;
                    }
                }
                continue;
            }
            if (input.equals("2")) {
                settings.incorrectInput(false);
                return;
            }
            try {
                Settings.INSTANCE.path(Paths.get(input).toString());
                settings.incorrectInput(false);
            } catch (InvalidPathException e) {
                settings.incorrectInput(true);
            }
        }
    }
}
