package backend.academy.userflow.backend;

import backend.academy.stream.handlers.InputHandler;
import backend.academy.userflow.frontend.CorrectionsSettings;
import backend.academy.userflow.frontend.Settings;

public final class ChooseCorrections extends SettingsBasedAction<CorrectionsSettings> {
    public ChooseCorrections(CorrectionsSettings settings) {
        super(settings);
    }

    @Override
    public void act() {
        Integer input;
        while (true) {
            settings.print();
            input = InputHandler.INSTANCE().tryReadInteger();
            if (input == null || input < 1 || input > Settings.INSTANCE().corrections().size() + 1) {
                settings.incorrectInput(true);
                continue;
            }
            if (input == Settings.INSTANCE().corrections().size() + 1) {
                settings.incorrectInput(false);
                return;
            }
            settings.incorrectInput(false);
            if (Settings.INSTANCE().corrections().get(settings.correctionsBySettings().get(input))) {
                Settings.INSTANCE().corrections().put(settings.correctionsBySettings().get(input), false);
            } else {
                Settings.INSTANCE().corrections().put(settings.correctionsBySettings().get(input), true);
            }
        }
    }
}
