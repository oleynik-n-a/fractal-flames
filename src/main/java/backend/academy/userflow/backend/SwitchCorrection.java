package backend.academy.userflow.backend;

import backend.academy.userflow.frontend.DummySetting;
import backend.academy.userflow.frontend.Settings;

public final class SwitchCorrection extends SettingsBasedAction<DummySetting> {
    public SwitchCorrection(DummySetting settings) {
        super(settings);
    }

    @Override
    public void act() {
        Settings.INSTANCE.correction(!Settings.INSTANCE.correction());
    }
}
