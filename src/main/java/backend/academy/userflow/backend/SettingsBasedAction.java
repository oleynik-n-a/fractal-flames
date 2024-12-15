package backend.academy.userflow.backend;

public abstract class SettingsBasedAction<SettingsType> implements Action {
    protected SettingsType settings;

    public SettingsBasedAction(SettingsType settings) {
        this.settings = settings;
    }
}
