package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.SeedSettings;
import backend.academy.userflow.frontend.Settings;
import java.security.SecureRandom;

public final class SetSeed extends SettingsBasedAction<SeedSettings> {
    public SetSeed(SeedSettings settings) {
        super(settings);
    }

    @Override
    public void act() {
        Long input;
        while (true) {
            settings.print();
            input = InputHandler.INSTANCE.tryReadLong();
            if (input == null) {
                settings.incorrectInput(true);
                continue;
            }
            if (input == 1) {
                settings.incorrectInput(false);
                Settings.INSTANCE.seed(Settings.INSTANCE.BASE_SEED());
                return;
            }
            if (input == 2) {
                settings.incorrectInput(false);
                SecureRandom random = new SecureRandom();
                Settings.INSTANCE.seed(random.nextLong());
                continue;
            }
            if (input == 3) {
                settings.incorrectInput(false);
                return;
            }
            settings.incorrectInput(false);
            Settings.INSTANCE.seed(input);
        }
    }
}
