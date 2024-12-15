package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.Settings;
import backend.academy.userflow.frontend.ThreadsAmountSettings;

public final class SetThreadsAmount extends SettingsBasedAction<ThreadsAmountSettings> {
    public SetThreadsAmount(ThreadsAmountSettings settings) {
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
                Settings.INSTANCE().threads(Settings.INSTANCE().BASE_THREADS_AMOUNT());
                return;
            }
            if (input == 2) {
                settings.incorrectInput(false);
                return;
            }
            if (input < settings.MIN_THREADS_AMOUNT() || input > settings.MAX_THREADS_AMOUNT()) {
                settings.incorrectInput(true);
                continue;
            }
            settings.incorrectInput(false);
            Settings.INSTANCE().threads(input);
        }
    }
}
