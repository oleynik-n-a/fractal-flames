package backend.academy.userflow.backend;

public abstract class SettingsBasedAction<T> implements Action {
    protected T settings;

    public SettingsBasedAction(T settings) {
        this.settings = settings;
    }
}
