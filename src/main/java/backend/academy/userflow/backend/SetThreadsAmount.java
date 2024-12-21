package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.Settings;
import backend.academy.userflow.frontend.ThreadsAmountSettings;

public final class SetThreadsAmount extends SettingsBasedAction<ThreadsAmountSettings> {
    public SetThreadsAmount(ThreadsAmountSettings settings) {
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
                Settings.INSTANCE.threads(Settings.INSTANCE.baseThreadsAmount());
                return;
            }
            if (input == 2) {
                settings.incorrectInput(false);
                return;
            }
            if (input < settings.minThreadsAmount() || input > settings.maxThreadsAmount()) {
                settings.incorrectInput(true);
                continue;
            }
            settings.incorrectInput(false);
            Settings.INSTANCE.threads(input);
        }
    }
}
