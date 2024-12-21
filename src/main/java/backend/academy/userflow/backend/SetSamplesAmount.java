package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.SamplesAmountSettings;
import backend.academy.userflow.frontend.Settings;

public final class SetSamplesAmount extends SettingsBasedAction<SamplesAmountSettings> {
    public SetSamplesAmount(SamplesAmountSettings settings) {
        super(settings);
    }

    @Override
    @SuppressWarnings("returncount")
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
                Settings.INSTANCE.samples(Settings.INSTANCE.baseSamplesAmount());
                return;
            }
            if (input == 2) {
                settings.incorrectInput(false);
                return;
            }
            if (input < settings.minSamplesAmount() || input > settings.maxSamplesAmount()) {
                settings.incorrectInput(true);
                continue;
            }
            settings.incorrectInput(false);
            Settings.INSTANCE.samples(input);
        }
    }
}
