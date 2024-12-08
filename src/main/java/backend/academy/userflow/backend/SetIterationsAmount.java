package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.IterationsAmountSettings;
import backend.academy.userflow.frontend.Settings;

public final class SetIterationsAmount extends BaseAction<IterationsAmountSettings> {
    public SetIterationsAmount(IterationsAmountSettings settings) {
        super(settings);
    }

    @Override
    public void act() {
        Integer input;
        while (true) {
            settings.print();
            input = InputHandler.INSTANCE().tryReadInteger();
            if (input == null || input < settings.MIN_ITERATIONS_AMOUNT() || settings.MAX_ITERATIONS_AMOUNT() < input) {
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
            Settings.INSTANCE().iterations(input);
        }
    }
}
