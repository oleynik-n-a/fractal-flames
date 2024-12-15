package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.IterationsAmountSettings;
import backend.academy.userflow.frontend.SamplesAmountSettings;
import backend.academy.userflow.frontend.Settings;

public final class SetSamplesAmount extends SettingsBasedAction<SamplesAmountSettings> {
    public SetSamplesAmount(SamplesAmountSettings settings) {
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
                Settings.INSTANCE().samples(Settings.INSTANCE().BASE_SAMPLES_AMOUNT());
                return;
            }
            if (input == 2) {
                settings.incorrectInput(false);
                return;
            }
            if (input < settings.MIN_SAMPLES_AMOUNT() || input > settings.MAX_SAMPLES_AMOUNT()) {
                settings.incorrectInput(true);
                continue;
            }
            settings.incorrectInput(false);
            Settings.INSTANCE().samples(input);
        }
    }
}
