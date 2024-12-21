package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.AffinesAmountSettings;
import backend.academy.userflow.frontend.Settings;

public final class SetAffinesAmount extends SettingsBasedAction<AffinesAmountSettings> {
    public SetAffinesAmount(AffinesAmountSettings settings) {
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
                Settings.INSTANCE.affines(Settings.INSTANCE.BASE_AFFINES_AMOUNT());
                return;
            }
            if (input == 2) {
                settings.incorrectInput(false);
                return;
            }
            if (input < settings.MIN_AFFINES_AMOUNT() || input > settings.MAX_AFFINES_AMOUNT()) {
                settings.incorrectInput(true);
                continue;
            }
            settings.incorrectInput(false);
            Settings.INSTANCE.affines(input);
        }
    }
}
