package backend.academy.userflow.backend;

import backend.academy.userflow.frontend.DummySettings;
import backend.academy.userflow.frontend.Settings;

public final class SwitchCorrection extends SettingsBasedAction<DummySettings> {
    public SwitchCorrection(DummySettings settings) {
        super(settings);
    }

    @Override
    public void act() {
        Settings.INSTANCE.correction(!Settings.INSTANCE.correction());
    }
}
