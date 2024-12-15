package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.IterationsAmountSettings;
import backend.academy.userflow.frontend.Settings;

public final class SetIterationsAmount extends SettingsBasedAction<IterationsAmountSettings> {
    public SetIterationsAmount(IterationsAmountSettings settings) {
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
            if (input == 1) {
                settings.incorrectInput(false);
                Settings.INSTANCE().iterations(Settings.INSTANCE().BASE_ITERATIONS_AMOUNT());
                return;
            }
            if (input == 2) {
                settings.incorrectInput(false);
                return;
            }
            if (input < settings.MIN_ITERATIONS_AMOUNT() || input > settings.MAX_ITERATIONS_AMOUNT()) {
                settings.incorrectInput(true);
                continue;
            }
            settings.incorrectInput(false);
            Settings.INSTANCE().iterations(input);
        }
    }
}
